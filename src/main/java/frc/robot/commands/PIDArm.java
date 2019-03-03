package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDArm extends PIDCommand {

    public PIDArm(double angle) {
        super(RobotMap.armP, RobotMap.armI, RobotMap.armD);

        setSetpoint(angle);
    }

    protected void initialize() {
        setTimeout(4);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.arm.getArmAngle();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.arm.moveArm(speed);
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
