package frc.robot.commands;

import frc.robot.OI;

public class Drive extends CommandBase {

	public Drive() {
		requires(driveBase);
	}
	
	protected void initialize() {
	}
	
	public void execute() {
        driveBase.drive(OI.getDriveJoystick().getRawAxis(0), OI.getDriveJoystick().getRawAxis(1),
				OI.getDriveJoystick().getRawAxis(2), !OI.getDriveJoystick().getRawButton(1));
	}
	@Override
	protected boolean isFinished() {
		return false;
	}
}