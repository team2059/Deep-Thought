package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.TargetInfo;

import static frc.robot.commands.CommandBase.driveBase;

public class PositionTracking extends Command {

    private TargetInfo target = null;
    private Odometer odometer = new Odometer();

    /**
     * getRobotX() returns the x position of the robot in inches.
     * @return robot x position
     */
    private double getRobotX() {
        return target.distance * Math.sin(Math.toRadians(target.angle2));
    }

    /**
     * getRobotY() returns y positions of the robot in inches.
     * @return robot y position
     */
    private double getRobotY() {
        return target.distance * Math.sin(Math.toRadians(90 - Math.abs(target.angle2)));
    }

    /**
     * getRobotTheta() returns the angle of the robot in degrees.
     * @return robot angle
     */
    private double getRobotTheta() { return target.angle1 - target.angle2; }

    @Override
    protected void initialize() {
        if(Robot.targets.isEmpty()) {
            interrupted();
        }
        target = Robot.targets.get(0);
        odometer.set(getRobotX(), getRobotY(),
                driveBase.getLeftEncoder(), driveBase.getRightEncoder());
        driveBase.setGyro(getRobotTheta());
    }

    @Override
    protected void execute() {
        odometer.update(driveBase.getLeftEncoder(), driveBase.getRightEncoder(),
                driveBase.getGyro()-90);
        System.out.printf("X: %.2f Y: %.2f\n", odometer.getX(), odometer.getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
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
