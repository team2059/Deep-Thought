package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDHatchArm extends PIDCommand {

    public PIDHatchArm(double angle) {
        super(RobotMap.hatchArmP, RobotMap.hatchArmI, RobotMap.hatchArmD);

        setTimeout(3000);
        setSetpoint(angle);
    }

    protected void initialize() {
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.hatchArm.getHatchAngle();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.hatchArm.moveHatchArm(speed);
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
