package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import hhCore.subsystems.drive.HHDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveBase extends HHDrive {

    WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(4);
    WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(2);
    WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(3);
    WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(1);

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

  public void driveForward(double speed){
    leftMotor1.set(speed);
    leftMotor2.set(speed);
    rightMotor1.set(speed);
    rightMotor2.set(speed);
  }



}
