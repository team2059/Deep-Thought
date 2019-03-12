package frc.robot.commands.Jack;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

public class PIDJack extends PIDCommand {

    private double x;

    public PIDJack(double inches, double x) {
        super(RobotMap.jackP, RobotMap.jackI, RobotMap.jackD);
        requires(CommandBase.jack);
        this.x = x;
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
        System.out.println("JACK END");
        CommandBase.jack.moveJack(0);
        setTimeout(0);
    }

    @Override
    protected void interrupted() {
        System.out.println("JACK INT");
        end();
    }

    @Override
    protected void execute() {
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
        return (x - CommandBase.elevator.getCarriageEncoder() + 3.08);
    }
}
