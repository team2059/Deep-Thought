package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import hhCore.subsystems.drive.HHDrive;
import frc.robot.commands.Drive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveBase extends HHDrive {

    Talon leftMotor1 = new Talon(1);
    Talon leftMotor2 = new Talon(2);
    Talon rightMotor1 = new Talon(3);
    Talon rightMotor2 = new Talon(4);

    SpeedControllerGroup left = new SpeedControllerGroup(leftMotor1, leftMotor2);
	SpeedControllerGroup right = new SpeedControllerGroup(rightMotor1, rightMotor2);

	DifferentialDrive robotDrive = new DifferentialDrive(left, right);
    
    public DriveBase(){
        leftMotor1.setSafetyEnabled(false);
		leftMotor2.setSafetyEnabled(false);
		rightMotor1.setSafetyEnabled(false);
		rightMotor2.setSafetyEnabled(false);
    }

  @Override
  public void initDefaultCommand() {
        setDefaultCommand(new Drive());
  }

  public void driveBase(double x, double y) {
		robotDrive.arcadeDrive(y, x);
  }
}
