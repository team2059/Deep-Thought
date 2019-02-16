package frc.robot.commands.Elevator;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDElevate extends PIDCommand {

    public PIDElevate(double inches) {
        super(RobotMap.mainElevatorP, RobotMap.mainElevatorI, RobotMap.mainElevatorD);

        setSetpoint(inches);
    }

    protected void initialize() {
        setTimeout(6);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.elevator.getElevatorEncoder();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.elevator.mainElevate(speed);
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
