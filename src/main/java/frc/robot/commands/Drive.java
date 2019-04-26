package frc.robot.commands;

import frc.robot.OI;
import frc.robot.commands.CommandBase;

public class Drive extends CommandBase {

    public Drive() {
        requires(driveBase);
    }

    protected void initialize() {
    }

    public void execute() {
	if(OI.getDriveJoystick().getRawAxis(0) != 0 || OI.getDriveJoystick().getRawAxis(1) != 0 || OI.getDriveJoystick().getRawAxis(2) != 0) {
        	driveBase.drive(OI.getDriveJoystick().getRawAxis(0), OI.getDriveJoystick().getRawAxis(1), OI.getDriveJoystick().getRawAxis(2), OI.getDriveJoystick().getRawButton(4));
    	}
    }
    @Override
    protected boolean isFinished() {
        return false;
    }
}
