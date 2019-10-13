package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Intake extends Subsystem {

    WPI_VictorSPX armMotor = new WPI_VictorSPX(RobotMap.armMotorPort);
    WPI_VictorSPX collectorMotor = new WPI_VictorSPX(RobotMap.collectorMotorPort);
    WPI_VictorSPX intakeMotor = new WPI_VictorSPX(RobotMap.hatchMotorPort);


    final double armZeroDegree = 4.6969;
    final double armNinetyDegree = 3.338;

    public static Boolean isHatchMode = false;

    AnalogInput armPot = new AnalogInput(RobotMap.armPotPort);
    AnalogInput intakePot = new AnalogInput(RobotMap.intakePotPort);

    DigitalInput armLimit = new DigitalInput(RobotMap.armLimitPort);

    public void moveArm(double s) {
        if ((s < 0 && getArmAngle() >= -15) || (s > 0 && getArmAngle() <= 85)) { //Padded Limits by 5 for "safety"
            System.out.println(.08 * Math.cos(Math.toRadians(getArmAngle())) + (0.3 * s));
            armMotor.set(.08 * Math.cos(Math.toRadians(getArmAngle())) + (0.3 * s));
        } else {
            armMotor.set(0);
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

    public boolean getArmLimit() {
        return armLimit.get();
    }

    public double getIntakeAngle() {
        return intakePot.getVoltage();
    }

    public void setIntakeMotor(double speed) {
        intakeMotor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {}

}
