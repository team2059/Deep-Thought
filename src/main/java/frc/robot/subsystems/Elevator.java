package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Elevator extends Subsystem {

    WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(RobotMap.elevatorMotor);
    WPI_TalonSRX carriageMotor = new WPI_TalonSRX(RobotMap.carriageMotor);

    DigitalInput elevatorLimitTop = new DigitalInput(RobotMap.elevatorLimitTop);
    DigitalInput elevatorLimitBottom = new DigitalInput(RobotMap.elevatorLimitBottom);

    DigitalInput carriageLimitTop = new DigitalInput(RobotMap.carriageLimitTop);
    DigitalInput carriageLimitBottom = new DigitalInput(RobotMap.carriageLimitBottom);

    /*
     *  Main Elevator Stage
     */
    public void mainElevate(double s) {
        // if (getElevatorLimitBottom() == true && s < 0) {
        //     elevatorMotor.set(ControlMode.PercentOutput, 0);
        // } else if (getElevatorLimitTop() == true && s > 0) {
        //     elevatorMotor.set(ControlMode.PercentOutput, 0);
        // } else {
        elevatorMotor.set(ControlMode.PercentOutput, s);
        // }
    }

    public boolean getElevatorLimitBottom() {
        return elevatorLimitTop.get();
    }

    public boolean getElevatorLimitTop() {
        return elevatorLimitBottom.get();
    }

    public double getElevatorEncoder() {
        return elevatorMotor.getSelectedSensorPosition(0) / 1;
    }

    /*
     *  Carriage Elevator Stage
     */
    public void carriageElevator(double s) {
        // if (getCarriageLimitBottom() == true && s < 0) {
        //     carriageMotor.set(ControlMode.PercentOutput, 0);
        // } else if (getCarriageLimitTop() == true && s > 0) {
        //     carriageMotor.set(ControlMode.PercentOutput, 0);
        // } else {
        carriageMotor.set(ControlMode.PercentOutput, s);
        // }
    }

    public boolean getCarriageLimitBottom() {
        return carriageLimitBottom.get();
    }

    public boolean getCarriageLimitTop() {
        return carriageLimitTop.get();
    }

    public double getCarriageEncoder() {
        return carriageMotor.getSelectedSensorPosition(0) / 1;
    }

    @Override
    protected void initDefaultCommand() {}
}
