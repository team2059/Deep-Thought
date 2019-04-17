package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.CommandBase;


public class Hatch extends Command {
    double speed;
    public Hatch(double s) {
        speed = s;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        CommandBase.intake.setHatchMotor(speed);
    }

    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    protected void end() {
        CommandBase.intake.setHatchMotor(0);
    }

    @Override
    protected void interrupted() {
        end();
        super.interrupted();
    }
}
