package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;

import hhCore.subsystems.drive.HHSensorDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveBase extends HHSensorDrive {

  WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(RobotMap.leftMotor1);
  WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(RobotMap.leftMotor2);
  WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(RobotMap.rightMotor1);
  WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(RobotMap.rightMotor2);

  Encoder leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
  Encoder rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);

  ADXRS450_Gyro gyro = new ADXRS450_Gyro(Port.kOnboardCS0);

  SpeedControllerGroup left = new SpeedControllerGroup(leftMotor1, leftMotor2);
  SpeedControllerGroup right = new SpeedControllerGroup(rightMotor1, rightMotor2);

  DifferentialDrive robotDrive = new DifferentialDrive(left, right);

  public DriveBase() {
    gyro.calibrate();
    leftMotor1.setSafetyEnabled(false);
    leftMotor2.setSafetyEnabled(false);
    rightMotor1.setSafetyEnabled(false);
    rightMotor2.setSafetyEnabled(false);
  }

  @Override
  public ADXRS450_Gyro gyro() {
    return gyro;
  }

  @Override
  public Encoder leftEncoder() {
    return leftEncoder;
  }

  @Override
  public Encoder rightEncoder() {
    return rightEncoder;
  }

  @Override
  public double getLeftEncoder() {
    return leftEncoder.get() / 6.3847;
  }

  @Override
  public double getRightEncoder() {
    return -rightEncoder.get() / 6.2625;
  }

  public int getLeftEncoderRaw() {
    return leftEncoder.get();
  }

  public int getRightEncoderRaw() {
    return -rightEncoder.get();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }

  public void driveBase(double x, double y) {
    robotDrive.arcadeDrive(y, x);
  }

  public void arcade(double x, double y) {
    robotDrive.arcadeDrive(-y, x);
  }

  public void tank(double l, double r) {
    robotDrive.tankDrive(-r, -l);
  }
}
