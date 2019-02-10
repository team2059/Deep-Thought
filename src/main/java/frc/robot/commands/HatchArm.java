package frc.robot.commands;

import frc.robot.commands.CommandBase;

public class HatchArm extends CommandBase {
    double speed;
    public HatchArm(double s) {
        speed = s;
    }


    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        hatchArm.moveHatchArm(speed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
