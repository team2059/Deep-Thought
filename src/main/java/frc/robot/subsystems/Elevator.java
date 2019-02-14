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
        if (s > 0 && getElevatorLimitTop() || s < 0 && getElevatorLimitBottom()){
          elevatorMotor.set(ControlMode.PercentOutput, -s);
        } else {
          elevatorMotor.set(ControlMode.PercentOutput, 0);
        }
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
        if (s > 0 && getCarriageLimitTop() || s < 0 && getCarriageLimitBottom()){
          carriageMotor.set(ControlMode.PercentOutput, -s);
        } else {
          carriageMotor.set(ControlMode.PercentOutput, 0);
        }

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
