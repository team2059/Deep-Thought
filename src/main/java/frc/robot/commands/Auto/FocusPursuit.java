package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;
import frc.robot.TargetInfo;

import static frc.robot.commands.CommandBase.driveBase;

public class FocusPursuit extends PIDCommand {

    private double LOOKAHEAD = 6.0;
    private double STOPDISTANCE = 20.0;
    private double LEFTANGLELIMIT = -20.0;
    private double RIGHTANGLELIMIT = 20.0;
    private double DRIVEFORWARDSPEED = 0.6;
    private double TURNMAXSPEED = .4;
    private TargetInfo target;

    public FocusPursuit() {
        super("FocusPursuit", 0.05, 0.0, 0.0);
        setInputRange(-TURNMAXSPEED, TURNMAXSPEED);
    }

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

    private double getPathAngle() {
        return -Math.toDegrees(Math.asin(getRobotX()/(Math.sqrt(Math.pow(getRobotX(),2) + Math.pow(LOOKAHEAD, 2)))));
    }

    @Override
    protected void initialize() {
        if (!Robot.targets.isEmpty()) {
            target = Robot.targets.get(0);
            setSetpoint(getPathAngle());
            System.out.println("Running Focus Pursuit");
            //System.out.printf("X: %.1f Y: %.1f Theta: %.1f Path Angle: %.1f\n", getRobotX() , getRobotY(), getRobotTheta(), getPathAngle());
        }
    }

    @Override
    protected void execute() {
        System.out.println("Execute");
        if (Robot.targets.isEmpty()) {
            System.out.println("Empty");
        } else {
            target = Robot.targets.get(0);
            setSetpoint(getPathAngle());
            System.out.printf("X: %.1f Y: %.1f Theta: %.1f Path Angle: %.1f Angle1: %.1f Angle2: %.1f\n",
                    getRobotX() , getRobotY(), getRobotTheta(), getPathAngle(), target.angle1, target.angle2);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
        //System.out.println(target != null && getRobotY() > STOPDISTANCE);
        //return target != null && getRobotY() < STOPDISTANCE;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected double returnPIDInput() {
        return getRobotTheta();
    }

    @Override
    protected void usePIDOutput(double output) {
        System.out.printf("%.2f %.2f",-output, DRIVEFORWARDSPEED);
//        // Going too far left
//        if (target.angle1 > RIGHTANGLELIMIT) {
//            driveBase.arcade(0.1, DRIVEFORWARDSPEED);
//        }
//        // Going too far right
//        else if (target.angle1 < LEFTANGLELIMIT) {
//            driveBase.arcade(-0.1, DRIVEFORWARDSPEED);
//        } else {
            driveBase.arcade(-output, DRIVEFORWARDSPEED);
//        }

    }
}
