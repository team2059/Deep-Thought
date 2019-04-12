package frc.robot.commands.Arm;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDWrist extends PIDCommand {

    double timeout;
    public PIDWrist(double angle, double timeout) {
        super(RobotMap.wristP, RobotMap.wristI, RobotMap.wristD);
        setInputRange(-30, 50);
        setSetpoint(angle);
        this.timeout = timeout;
    }

    protected void initialize() {
        // setTimeout(6);
        setTimeout(timeout);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.intake.getWristAngle();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.intake.moveWrist(speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut(); // || Math.abs(getSetpoint() - getPosition()) < .5;
    }

    protected void end() {
        System.out.println("ENDED");
        setTimeout(0);
    }

    protected void interrupted() {
        end();
    }
}
