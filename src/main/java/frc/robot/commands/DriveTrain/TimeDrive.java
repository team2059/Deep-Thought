package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.commands.CommandBase;

public class TimeDrive extends CommandBase {

	public TimeDrive(double time) {
        requires(driveBase);
        setTimeout(time);
	}
	
	protected void initialize() {
	}
	
	public void execute() {
        driveBase.driveForward(.1);
	}
	@Override
	protected boolean isFinished() {
		return isTimedOut();
    }
    
    protected void end() {
        setTimeout(0);
    }
}