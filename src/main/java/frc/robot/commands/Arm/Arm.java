package frc.robot.commands.Arm;

import frc.robot.commands.CommandBase;

public class Arm extends CommandBase {
    double speed;
    public Arm(double s) {
        speed = s;
    }


    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        intake.moveArm(speed);
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
