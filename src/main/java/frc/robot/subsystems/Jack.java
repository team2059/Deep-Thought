package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Jack extends Subsystem {

    WPI_VictorSPX jackMotor = new WPI_VictorSPX(RobotMap.jackMotorPort);
    WPI_VictorSPX jackWheel = new WPI_VictorSPX(RobotMap.jackWheelPort);

    public void moveJack(double motorSpeed) {
        jackMotor.set(motorSpeed);
    }

    public void moveWheel(double wheelSpeed) {
        jackWheel.set(wheelSpeed);
    }

    @Override
    protected void initDefaultCommand() {}

}
