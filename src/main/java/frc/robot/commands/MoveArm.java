package frc.robot.commands;

import frc.robot.OI;

public class MoveArm extends CommandBase {
    public MoveArm() {
    }

    @Override
    protected void execute() {
        arm.moveArm(OI.getSecondJoystick().getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        arm.moveArm(0);
    }

    @Override
    protected void interrupted() {
        super.interrupted();
        end();
    }
}
