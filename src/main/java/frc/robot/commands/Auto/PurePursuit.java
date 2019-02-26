package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.TargetInfo;

import static frc.robot.commands.CommandBase.driveBase;


public class PurePursuit extends Command {
    private TargetInfo target = null;
    private Odometer odometer = new Odometer();
    private double ROBOTWIDTH = 30;
    private double MAX_VEL_CHANGE = 50;
    private double LOOK_AHEAD_CONT = 10;
    private double MAX_VELOCITY = 10;
    private double lastLeftVelocity, lastRightVelocity, leftVelocity, rightVelocity;
    private double lastTime;
    private double avgX, avgY, avgA;
    private int visionCount = 1;

    private double lookAhead(double lookAheadValue) {
        return Math.sqrt(Math.pow(lookAheadValue, 2) - Math.pow(getX(),2)) + getY();
    }

    private double curvature(double lookahead, double lookAheadValue) {
        double side = Math.signum(Math.sin(Math.toRadians(90) - getA()) *
                -getX()-Math.cos(Math.toRadians(90- getA()))*(lookahead-getY()));
        double a = -Math.tan(Math.toRadians(90 - getA()));
        double c = Math.tan(Math.toRadians(90 - getA()))*getX()-getY();
        double x = Math.abs(lookahead+c)/Math.sqrt(Math.pow(a,2)+1);
        return side * (2*x/Math.pow(lookAheadValue,2));
    }

    private double velocityToMotor(double velocity) {
        return 0.0115 * velocity + 0.323;
    }

    private double leftVelocityCurv(double curv, double vel) {
        return vel*(2+curv*ROBOTWIDTH)/2;
    }
    private double rightVelocityCurv(double curv, double vel) {
        return vel*(2-curv*ROBOTWIDTH)/2;
    }

    private void getVelocity(double curv, double vel) {
        double dt = Timer.getFPGATimestamp() - lastTime;
        lastTime = lastTime + dt;
        lastLeftVelocity = leftVelocity;
        lastRightVelocity = rightVelocity;
        leftVelocity = leftVelocityCurv(curv, vel);
        rightVelocity = rightVelocityCurv(curv, vel);
//        System.out.printf("dt: %.3f lV: %.2f rV: %.2f llV: %.2f lrV: %.2f\n",
//                dt, leftVelocity, rightVelocity, lastLeftVelocity, lastRightVelocity);
        leftVelocity = lastLeftVelocity + Math.min(MAX_VEL_CHANGE*dt, Math.max(-MAX_VEL_CHANGE*dt, leftVelocity-lastLeftVelocity));
        rightVelocity = lastRightVelocity + Math.min(MAX_VEL_CHANGE*dt, Math.max(-MAX_VEL_CHANGE*dt, rightVelocity-lastRightVelocity));
//        System.out.printf("2dt: %.3f lV: %.2f rV: %.2f llV: %.2f lrV: %.2f\n",
//                dt, leftVelocity, rightVelocity, lastLeftVelocity, lastRightVelocity);
    }

    /**
     * getVisionRobotX() returns the x position of the robot in inches.
     *
     * @return robot x position
     */
    private double getVisionRobotX() {
        return -target.distance * Math.cos(Math.toRadians(-90 + target.angle2));
    }

    /**
     * getVisionRobotY() returns y positions of the robot in inches.
     *
     * @return robot y position
     */
    private double getVisionRobotY() {
        return -target.distance * Math.sin(Math.toRadians(90 - Math.abs(target.angle2)));
    }

    /**
     * getVisionRobotTheta() returns the angle of the robot in degrees.
     *
     * @return robot angle
     */
    private double getVisionRobotTheta() {
        return -target.angle1 - target.angle2;
    }

    private double getX() {
        return odometer.getX() + avgX;
    }

    private double getY() {
        return odometer.getY() + avgY;
    }

    private double getA() {
        return driveBase.getGyro() + avgA;
    }

    @Override
    protected void initialize() {
        lastTime = Timer.getFPGATimestamp();
        if (Robot.targets == null) {
            interrupted();
        }
        lastLeftVelocity = 0.0;
        lastRightVelocity = 0.0;
        target = Robot.targets.get(0);
        avgX = 0;
        avgX = 0;
        avgA = 0;
        odometer.set(getVisionRobotX(), getVisionRobotY(),
                driveBase.getLeftEncoder(), driveBase.getRightEncoder());
        driveBase.setGyro(getVisionRobotTheta());

    }

    @Override
    protected void execute() {
        odometer.update(driveBase.getLeftEncoder(), driveBase.getRightEncoder(),
                -driveBase.getGyro() + 90);
        if(Robot.targets != null) {
            target = Robot.targets.get(0);
            if(target.angle1 < 30.0 && target.angle1 > -30) {
                avgX = ((visionCount * avgX) + (odometer.getX() - getVisionRobotX())) / (visionCount);
                avgY = ((visionCount * avgY) + (odometer.getY() - getVisionRobotY())) / (visionCount);
                avgA = ((visionCount * avgA) + (driveBase.getGyro() - getVisionRobotTheta())) / (visionCount);
                visionCount++;
            }
        }
        double lookAheadValue = LOOK_AHEAD_CONT + Math.abs(getVisionRobotX());
        double look = lookAhead(lookAheadValue);
        double curv;
        if (Math.abs(getY()) > LOOK_AHEAD_CONT) {
            curv = curvature(look, lookAheadValue);
        } else {
            curv = 0.00001;
        }
        getVelocity(curv, MAX_VELOCITY);
        System.out.printf("Angle1: %.2f Angle2: %.2f\n", target.angle1, target.angle2);
        //System.out.printf("Curv: %.2f Look: %.2f Angle: %.2f Theta: %.2f\n", curv, look, driveBase.getGyro(), getVisionRobotTheta());
        System.out.printf("X: %.2f Y: %.2f L: %.2f R: %.2f\n",
                getX(), getY(), leftVelocity, rightVelocity);
        driveBase.tank(velocityToMotor(leftVelocity), velocityToMotor(rightVelocity));
    }

    @Override
    protected boolean isFinished() {
        return getY() > -10;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        super.interrupted();
        end();
    }
}