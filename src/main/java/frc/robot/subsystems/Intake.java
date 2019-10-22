package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Intake extends Subsystem {

    WPI_VictorSPX armMotor = new WPI_VictorSPX(RobotMap.armMotorPort);
    WPI_VictorSPX collectorMotor = new WPI_VictorSPX(RobotMap.collectorMotorPort);
    WPI_VictorSPX jawMotor = new WPI_VictorSPX(RobotMap.jawMotorPort);


    final double armZeroDegree = 4.6969;
    final double armNinetyDegree = 3.338;
    final double intakeHatchPosition = 4.561;
    final double intakeBallPosition = 4.0295;

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

    public double getJawAngle() {
        return ((-intakePot.getVoltage() + intakeHatchPosition) / ((intakeBallPosition - intakeHatchPosition) / 45));
        // return intakePot.getVoltage();
    }

    public void setJawMotor(double speed) {
        jawMotor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {}

}
