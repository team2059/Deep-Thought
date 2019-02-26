package frc.robot.commands;

import frc.robot.OI;

public class Drive extends CommandBase {

	public Drive() {
		requires(driveBase);
	}
	
	protected void initialize() {
	}
	
	public void execute() {
        driveBase.driveBase(OI.getDriveJoystick().getRawAxis(0), OI.getDriveJoystick().getRawAxis(1));
	}
	@Override
	protected boolean isFinished() {
		return false;
	}
}