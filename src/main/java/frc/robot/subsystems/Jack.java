package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
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

    Relay spike = new Relay(RobotMap.spikePort);

    AnalogInput frontJackPot = new AnalogInput(RobotMap.frontJackPotPort);

    final double fJZeroDegree = 4.206;
    final double fJFinalDegree = 2.15;

    public void moveJack(double motorSpeed) {
        if (getJackEncoder() < 21 && motorSpeed <= 0){
            jackMotor.set(-motorSpeed);
        } else if (getjackTopLimit() && motorSpeed >= 0){
            jackMotor.set(-motorSpeed);
        } else {
            if (!getjackTopLimit()){
                jackEncoder.reset();
            }
            jackMotor.set(0);
        }
    }

    public void moveWheel(double wheelSpeed) {
        jackWheel.set(-wheelSpeed);
    }

    public void setSpike(boolean state){
        if(state){
            spike.set(Relay.Value.kOn);
        }  else {
            spike.set(Relay.Value.kOff);
        }
    }

    public void setFrontJack(double s){
        frontJack.set(s);
    }

    public void moveFrontJack(double jackSpeed){
        System.out.println(-.75*Math.cos(Math.toRadians(getJackAngle())) + jackSpeed + " " + getJackAngle());
        frontJack.set(-.85*Math.cos(Math.toRadians(getJackAngle())) + jackSpeed);
    }

    public double getJackAngle(){
        //return frontJackPot.getVoltage();
        return ((-frontJackPot.getVoltage() + fJZeroDegree) / ((fJZeroDegree - fJFinalDegree) / 90));
    }

    public double getJackEncoder(){
        return (jackEncoder.get() * jackInches / jackTicks);
    }

    public void resetJackEncoder(){
        jackEncoder.reset();
    }

    public boolean getjackTopLimit(){
        return jackTopLimit.get();
    }

    @Override
    protected void initDefaultCommand() {}

}
