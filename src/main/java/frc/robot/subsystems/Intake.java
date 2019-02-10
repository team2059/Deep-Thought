package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Intake extends Subsystem {

    WPI_TalonSRX armMotor = new WPI_TalonSRX(RobotMap.armMotorPort);
    WPI_TalonSRX wristMotor = new WPI_TalonSRX(RobotMap.wristMotorPort);
    WPI_TalonSRX collectorMotor = new WPI_TalonSRX(RobotMap.collectorMotorPort);

    AnalogInput armPot = new AnalogInput(RobotMap.armPotPort);
    AnalogInput wristPot = new AnalogInput(RobotMap.wristPotPort);

    double armAngle = armPot.getVoltage() / 360;
    double wristAngle = wristPot.getVoltage() / 360;

    double minArmAngle;
    double maxArmAngle;
    double minWristAngle;
    double maxWristAngle;

    public void moveArm(double s) {
        if (armAngle <= minArmAngle || armAngle >= maxArmAngle) {
            armMotor.set(0);
        } else {
            armMotor.set(s);
        }
    }

    public void moveWrist(double s) {
        if (wristAngle <= minWristAngle || wristAngle >= maxWristAngle) {
            wristMotor.set(0);
        } else {
            wristMotor.set(s);
        }
    }

    public void collector(double s) {
        collectorMotor.set(s);
    }

    /**
     * @return the armAngle
     */
    public double getArmAngle() {
        return armAngle;
    }

    /**
     * @return the wristAngle
     */
    public double getWristAngle() {
        return wristAngle;
    }

    @Override
    protected void initDefaultCommand() {}

}
