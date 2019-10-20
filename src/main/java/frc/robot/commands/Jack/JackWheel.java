package frc.robot.commands.Jack;

import frc.robot.commands.CommandBase;
import frc.robot.OI;

public class JackWheel extends CommandBase {

    public JackWheel() {  }

    @Override
    protected void initialize() {  }

    @Override
    protected void execute() {
        jack.moveWheel(OI.getDriveJoystick().getY()*3);
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
        end();
    }
}
