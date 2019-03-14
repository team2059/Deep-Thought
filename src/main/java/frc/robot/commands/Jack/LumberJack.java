package frc.robot.commands.Jack;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class LumberJack extends PIDCommand {

    public LumberJack(double inches) {
        super(RobotMap.jackP, RobotMap.jackI, RobotMap.jackD);
        setSetpoint(inches);
    }

    protected void initialize() {
        setTimeout(6);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.jack.getJackEncoder();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.jack.moveJack(speed);
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
