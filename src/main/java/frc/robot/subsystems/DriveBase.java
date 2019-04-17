package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;

import hhCore.subsystems.drive.HHSensorDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveBase extends HHSensorDrive {

    CANSparkMax leftMotor1 = new CANSparkMax(RobotMap.leftMotor1, MotorType.kBrushless);
    CANSparkMax leftMotor2 = new CANSparkMax(RobotMap.leftMotor2, MotorType.kBrushless);
    CANSparkMax leftMotor3 = new CANSparkMax(RobotMap.leftMotor3, MotorType.kBrushless);
    CANSparkMax rightMotor1 = new CANSparkMax(RobotMap.rightMotor1, MotorType.kBrushless);
    CANSparkMax rightMotor2 = new CANSparkMax(RobotMap.rightMotor2, MotorType.kBrushless);
    CANSparkMax rightMotor3 = new CANSparkMax(RobotMap.rightMotor3, MotorType.kBrushless);


    Encoder leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
    Encoder rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);

    ADXRS450_Gyro gyro = new ADXRS450_Gyro(Port.kOnboardCS0);

    SpeedControllerGroup left = new SpeedControllerGroup(leftMotor1, leftMotor2, leftMotor3);
    SpeedControllerGroup right = new SpeedControllerGroup(rightMotor1, rightMotor2, rightMotor3);

    DifferentialDrive robotDrive = new DifferentialDrive(left, right);

    public DriveBase() {
        rightMotor1.restoreFactoryDefaults();
        rightMotor2.restoreFactoryDefaults();
        rightMotor3.restoreFactoryDefaults();
        leftMotor1.restoreFactoryDefaults();
        leftMotor2.restoreFactoryDefaults();
        leftMotor3.restoreFactoryDefaults();

        gyro.calibrate();
        // setzSensitivity(0.6);
        setDeadzone(0);
        setxSensitivity(.4);
        setySensitivity(.4);
        setzSensitivity(.4);
        setxLowSpeed(1.0);
        setyLowSpeed(1.0);
        setzLowSpeed(0.8);
        setxHighSpeed(1.0);
        setyHighSpeed(1.0);
        setzHighSpeed(1.0);
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
        return -leftEncoder.get() / 5.2195122; //ticks per inch
    }

    @Override
    public double getRightEncoder() {
        return -rightEncoder.get() / 5.18563686;  //inches per tick
    }

    public int getLeftEncoderRaw() {
        return -leftEncoder.get();
    }

    public int getRightEncoderRaw() {
        return -rightEncoder.get();
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    public void driveBase(double x, double y) {
        System.out.println("X Value: " + x + " Y Value: " + y);
        robotDrive.arcadeDrive(y, x);
    }

    // public void arcade(double x, double y) {
    //     robotDrive.arcadeDrive(-y, x);
    // }

    // public void tank(double l, double r) {
    //     robotDrive.tankDrive(l, r);
    // }
}
