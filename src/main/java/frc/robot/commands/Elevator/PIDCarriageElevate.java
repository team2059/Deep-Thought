package frc.robot.commands.Elevator;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDCarriageElevate extends PIDCommand {

    double slowDown = 1;

    public PIDCarriageElevate(double inches) {
        super(RobotMap.carriageElevatorP, RobotMap.carriageElevatorI, RobotMap.carriageElevatorD);

        setSetpoint(inches);
    }

    public PIDCarriageElevate(double inches, double speed){
        super(RobotMap.carriageElevatorP, RobotMap.carriageElevatorI, RobotMap.carriageElevatorD);

        setSetpoint(inches);
        this.slowDown = speed;
    }

    protected void initialize() {
        setTimeout(3);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.elevator.getCarriageEncoder();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.elevator.carriageElevator(speed * slowDown);
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
