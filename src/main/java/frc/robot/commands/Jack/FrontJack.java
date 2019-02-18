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
        jack.setFrontJack(motorSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        System.out.println("Ended Front Jack");
        jack.setFrontJack(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
