package frc.robot.commands.Jack;

import frc.robot.commands.CommandBase;

public class Jack extends CommandBase {

    double motorSpeed;
    public Jack(double mS) {
        requires(CommandBase.jack);
        motorSpeed = mS;
    }


    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        jack.moveJack(motorSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        jack.moveJack(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
