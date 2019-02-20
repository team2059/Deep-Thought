package frc.robot.commands.Jack;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import javax.sound.midi.SysexMessage;


public class PIDJack extends PIDCommand {

    private double x = 6;

    public PIDJack(double inches) {
        super(RobotMap.mainElevatorP, RobotMap.mainElevatorI, RobotMap.mainElevatorD);
        setSetpoint(inches);
    }

    @Override
    protected void initialize() {
        setTimeout(12);
    }

    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return isTimedOut(); //|| Math.abs(getSetpoint() - getPosition()) < .5;
    }

    @Override
    protected void end() {
        CommandBase.jack.moveJack(0);
        setTimeout(0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void execute(){
        setSetpoint(calculateOffset());
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.jack.getJackEncoder();
    }

    @Override
    protected void usePIDOutput(double output) {
        System.out.println(output);
        CommandBase.jack.moveJack(-output);
    }

    private double calculateOffset() {
        return (x - CommandBase.elevator.getCarriageEncoder() + 2.08);
    }
}
