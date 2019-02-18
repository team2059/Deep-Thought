package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import hhCore.sensors.ElevatorEncoder;

public class Jack extends Subsystem {

    WPI_VictorSPX jackMotor = new WPI_VictorSPX(RobotMap.jackMotorPort);
    WPI_VictorSPX jackWheel = new WPI_VictorSPX(RobotMap.jackWheelPort);

    Encoder jackEncoder = new Encoder(RobotMap.jackEncoderPort1, RobotMap.jackEncoderPort2);
    DigitalInput jackTopLimit = new DigitalInput(RobotMap.jackTopLimitPort);

    private double jackTicks = 624;
    private int jackInches = 22;

    WPI_VictorSPX frontJack = new WPI_VictorSPX(RobotMap.frontJackPort);

    AnalogInput frontJackPot = new AnalogInput(RobotMap.frontJackPotPort);

    final double fJZeroDegree = 2.6684;
    final double fJFinalDegree = 1.66;

    public void moveJack(double motorSpeed) {
        jackMotor.set(-motorSpeed);
    }

    public void moveWheel(double wheelSpeed) {
        jackWheel.set(-wheelSpeed);
    }

    public void moveFrontJack(double jackSpeed){
        System.out.println(jackSpeed);
        if (jackSpeed < 0){
            frontJack.set(Math.cos(Math.toRadians(getJackAngle())) * -.4 + jackSpeed);
        } else {
            frontJack.set(jackSpeed);
        }
    }

    public double getJackAngle(){
        return ((-frontJackPot.getVoltage() + fJZeroDegree) / ((fJZeroDegree - fJFinalDegree) / 90));
    }

    public double getJackEncoder(){
        return (jackEncoder.get() * jackInches / jackTicks);
    }

    public void resetJackEncoder(){
        jackEncoder.reset();
    }

    @Override
    protected void initDefaultCommand() {}

}
