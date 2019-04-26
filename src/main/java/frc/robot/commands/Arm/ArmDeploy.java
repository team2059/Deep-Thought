package frc.robot.commands.Arm;

import frc.robot.commands.CommandBase;

public class ArmDeploy extends CommandBase {
    public ArmDeploy() {
    }

    @Override
    protected void initialize() {
        setTimeout(1);
    }

    @Override
    protected void execute() {
        intake.moveArm(-.1);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        intake.moveArm(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
