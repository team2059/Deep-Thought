package frc.robot.commands.Jack;

import frc.robot.commands.CommandBase;

public class FrontJack extends CommandBase {

    double motorSpeed;
    public FrontJack(double mS) {
        motorSpeed = mS;
    }


    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        jack.moveFrontJack(motorSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        jack.moveFrontJack(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
