package frc.robot.commands.Arm;

import frc.robot.commands.CommandBase;

public class Jaws extends CommandBase {

    double speed;
    public Jaws(double s) {
        speed = s;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        intake.setJawMotor(speed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        intake.setJawMotor(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
