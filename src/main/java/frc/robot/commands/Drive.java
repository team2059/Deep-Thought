package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.commands.CommandBase;

public class Drive extends CommandBase {

    public Drive() {
        requires(driveBase);
    }

    protected void initialize() {
    }

    public void execute() {
        driveBase.driveBase(OI.getDriveJoystick().getRawAxis(0), OI.getDriveJoystick().getRawAxis(1), OI.getDriveJoystick().getRawAxis(2));
    }
    @Override
    protected boolean isFinished() {
        return false;
    }
}
