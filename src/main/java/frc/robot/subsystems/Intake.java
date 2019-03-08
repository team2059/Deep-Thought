package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Intake extends Subsystem {

    WPI_VictorSPX armMotor = new WPI_VictorSPX(RobotMap.armMotorPort);
    WPI_VictorSPX wristMotor = new WPI_VictorSPX(RobotMap.wristMotorPort);
    WPI_VictorSPX collectorMotor = new WPI_VictorSPX(RobotMap.collectorMotorPort);


    //TODO subtract 6 degrees
    final double armZeroDegree = 4.6969;
    final double armNinetyDegree = 3.338;
    final double wristZeroDegree = 1.13;
    final double wristMaxDegree = 1.795;

    AnalogInput armPot = new AnalogInput(RobotMap.armPotPort);
    AnalogInput wristPot = new AnalogInput(RobotMap.wristPotPort);

    double minArmAngle;
    double maxArmAngle;
    double minWristAngle;
    double maxWristAngle;

    public void moveArm(double s) {
        if ((s < 0 && getArmAngle() >= -15) || (s > 0 && getArmAngle() <= 85)) { //Padded Limits by 5 for "safety"
            armMotor.set(-.08*Math.cos(Math.toRadians(getArmAngle())) + (0.3*s));
        } else {
            armMotor.set(0);
        }
    }

    public void moveWrist(double s) {
        if ((s < 0 && getWristAngle() >= -25) || (s > 0 && getWristAngle() <= 45)) { //Padded Limits by 5 for "safety"
            wristMotor.set(-.5*Math.cos(Math.toRadians(getWristAngle())) - (0.25*s));
        } else {
            wristMotor.set(0);
        }
    }

    public void collector(double s) {
        collectorMotor.set(-s);
    }

    /**
     * @return the armAngle
     */
    public double getArmAngle() {
        return ((-armPot.getVoltage() + armZeroDegree) / ((armZeroDegree - armNinetyDegree) / 90));
    }

    /**
     * @return the wristAngle
     */
    public double getWristAngle() {
        return ((-wristPot.getVoltage() + wristZeroDegree) / ((wristZeroDegree - wristMaxDegree) / 50));
    }

    @Override
    protected void initDefaultCommand() {}

}
