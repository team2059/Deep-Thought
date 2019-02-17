package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Jack extends Subsystem {

    WPI_VictorSPX jackMotor = new WPI_VictorSPX(RobotMap.jackMotorPort);
    WPI_VictorSPX jackWheel = new WPI_VictorSPX(RobotMap.jackWheelPort);

    WPI_VictorSPX frontJack = new WPI_VictorSPX(RobotMap.frontJackPort);

    AnalogInput frontJackPot = new AnalogInput(RobotMap.frontJackPotPort);

    final double fJZeroDegree = 0;
    final double fJFinalDegree = 1;

    public void moveJack(double motorSpeed) {
        jackMotor.set(motorSpeed);
    }

    public void moveWheel(double wheelSpeed) {
        jackWheel.set(-wheelSpeed);
    }

    public void moveFrontJack(double jackSpeed){
        frontJack.set(jackSpeed);
    }

    public double getJackAngle(){
        return frontJackPot.getVoltage();
    }

    @Override
    protected void initDefaultCommand() {}

}
