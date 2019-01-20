package frc.robot.commands.DriveTrain;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;


public class LineFollow extends CommandBase {

    public static DigitalInput photoElectricleft = new DigitalInput(11);
    public static DigitalInput photoElectricright = new DigitalInput(12);
    public static DigitalInput photoElectricback = new DigitalInput(13);

    double setTime;
	public LineFollow(double time) {
        setTime = time;
	}

	protected void initialize() {
        setTimeout(setTime);
	}

	public void execute() {
        if(photoElectricleft.get()){
            driveBase.driveBase(RobotMap.photoForward - RobotMap.photoSubCorrection, RobotMap.photoForward + RobotMap.photoAddCorrection);
        } else if(photoElectricright.get()) {
            driveBase.driveBase(RobotMap.photoForward + RobotMap.photoAddCorrection, RobotMap.photoForward - RobotMap.photoSubCorrection);
        } else {
            driveBase.driveBase(RobotMap.photoForward, RobotMap.photoForward);        
        }
	}
	@Override
	protected boolean isFinished() {        
		return isTimedOut() || photoElectricback.get();
    }

    @Override
    protected void end() {
        setTimeout(0);
    }

    @Override
    protected void interrupted(){
        setTimeout(0);
    }
}
