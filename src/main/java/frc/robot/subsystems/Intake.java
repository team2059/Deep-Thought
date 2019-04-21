package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Intake extends Subsystem {

    WPI_VictorSPX armMotor = new WPI_VictorSPX(RobotMap.armMotorPort);
    WPI_VictorSPX wristMotor = new WPI_VictorSPX(RobotMap.wristMotorPort);
    WPI_VictorSPX collectorMotor = new WPI_VictorSPX(RobotMap.collectorMotorPort);
 //   WPI_VictorSPX hatchMotor = new WPI_VictorSPX(RobotMap.hatchMotorPort);


    //TODO subtract 6 degrees
    final double armZeroDegree = 4.6969;
    final double armNinetyDegree = 3.338;
    final double wristZeroDegree = 1.13;
    final double wristMaxDegree = 1.795;

    AnalogInput armPot = new AnalogInput(RobotMap.armPotPort);
    AnalogInput wristPot = new AnalogInput(RobotMap.wristPotPort);

    DigitalInput armLimit = new DigitalInput(RobotMap.armLimitPort);

    double minArmAngle;
    double maxArmAngle;
    double minWristAngle;
    double maxWristAngle;

    public void moveArm(double s) {
        if ((s < 0 && getArmAngle() >= -15) || (s > 0 && getArmAngle() <= 85)) { //Padded Limits by 5 for "safety"
            System.out.println(.08 * Math.cos(Math.toRadians(getArmAngle())) + (0.3 * s));
            armMotor.set(.08 * Math.cos(Math.toRadians(getArmAngle())) + (0.3 * s));
        } else {
            armMotor.set(0);
        }
    }

    public void moveWrist(double s) {
        if ((s < 0 && getWristAngle() >= -25) || (s > 0 && getWristAngle() <= 45)) { //Padded Limits by 5 for "safety"
            wristMotor.set(-.5 * Math.cos(Math.toRadians(getWristAngle())) - (0.25 * s));
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
        return (((-armPot.getVoltage() + armZeroDegree) / ((armZeroDegree - armNinetyDegree) / 90)) - 12);
        //return armPot.getVoltage();
    }

    /**
     * @return the wristAngle
     */
    public double getWristAngle() {
        return ((-wristPot.getVoltage() + wristZeroDegree) / ((wristZeroDegree - wristMaxDegree) / 50) + 12);
    }

    public boolean getArmLimit() {
        return armLimit.get();
    }

    //public void setHatchMotor(double speed){
    //    hatchMotor.set(speed);
    //}

    @Override
    protected void initDefaultCommand() {}

}
