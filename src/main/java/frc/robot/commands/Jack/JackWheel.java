package frc.robot.commands.Jack;

import frc.robot.commands.CommandBase;

public class JackWheel extends CommandBase {

    double wheelSpeed;
    public JackWheel(double jS) {
        wheelSpeed = jS;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        jack.moveWheel(wheelSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        jack.moveWheel(0);
    }

    @Override
    protected void interrupted() {
    }
}
