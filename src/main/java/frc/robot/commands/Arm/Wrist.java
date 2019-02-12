package frc.robot.commands.Arm;

import frc.robot.commands.CommandBase;

public class Wrist extends CommandBase {
    double speed;
    public Wrist(double s) {
        speed = s;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        intake.moveWrist(speed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
      intake.moveWrist(0);
    }

    @Override
    protected void interrupted() {
      end();
    }
}
