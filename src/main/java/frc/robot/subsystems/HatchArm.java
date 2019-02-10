package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class HatchArm extends Subsystem {

    WPI_TalonSRX hatchArmMotor = new WPI_TalonSRX(RobotMap.hatchArmMotor);
    AnalogInput hatchPot = new AnalogInput(RobotMap.hatchArmPot);

    double hatchAngle = hatchPot.getVoltage() / 360;

    double minHatchAngle;
    double maxHatchAngle;

    public void moveHatchArm(double s) {
        if (getHatchAngle() <= minHatchAngle || getHatchAngle() >= maxHatchAngle) {
            hatchArmMotor.set(0);
        } else {
            hatchArmMotor.set(s);
        }
    }


    public double getHatchAngle() {
        return hatchAngle;
    }


    @Override
    protected void initDefaultCommand() {}

}
