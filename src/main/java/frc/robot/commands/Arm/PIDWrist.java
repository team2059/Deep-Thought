package frc.robot.commands.Arm;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDWrist extends PIDCommand {

    public PIDWrist(double angle) {
        super(RobotMap.wristP, RobotMap.wristI, RobotMap.wristD);

        setTimeout(3000);
        setSetpoint(angle);
    }

    protected void initialize() {
    }

    @Override
    protected double returnPIDInput() {
        // return CommandBase.intake.getWristAngle();
        return 0;
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.intake.moveWrist(speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut() || Math.abs(getSetpoint() - getPosition()) < .5;
    }

    protected void end() {
        setTimeout(0);
    }

    protected void interrupted() {
        end();
    }
}
