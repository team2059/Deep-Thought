package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import hhCore.utils.Dampener;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Elevator extends Subsystem {

    WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(RobotMap.elevatorMotor);
    WPI_TalonSRX carriageMotor = new WPI_TalonSRX(RobotMap.carriageMotor);

    DigitalInput elevatorLimitTop = new DigitalInput(RobotMap.elevatorLimitTop);
    DigitalInput elevatorLimitBottom = new DigitalInput(RobotMap.elevatorLimitBottom);

    DigitalInput carriageLimitTop = new DigitalInput(RobotMap.carriageLimitTop);
    DigitalInput carriageLimitBottom = new DigitalInput(RobotMap.carriageLimitBottom);


    // private double elevatorTicks = -3275546;
    private double elevatorTicks = -32755;
    private double elevatorInches = 32;
    // private double carriageTicks = -1357172;
    private double carriageTicks = -27697;
    private double carriageInches = 28.5;

    public void configElevatorMotor() {
        this.elevatorMotor.configContinuousCurrentLimit(30);
        this.elevatorMotor.enableCurrentLimit(true);
    }

    /*
     *  Main Elevator Stage
     */
    public void mainElevate(double s) {
        if (s > 0 && !getElevatorLimitTop()) {
            setElevatorEncoder(elevatorInches);
            elevatorMotor.set(ControlMode.PercentOutput, 0);
        } else if (s < 0 && !getElevatorLimitBottom()) {
            setElevatorEncoder(0);
            elevatorMotor.set(ControlMode.PercentOutput, 0);
        } else {
            elevatorMotor.set(ControlMode.PercentOutput, Dampener.bidirectional(-s, getElevatorEncoder(), 7, 0, 31, 32));
            // elevatorMotor.set(ControlMode.PercentOutput, -s);
        }
    }

    public boolean getElevatorLimitBottom() {
        return elevatorLimitTop.get();
    }

    public boolean getElevatorLimitTop() {
        return elevatorLimitBottom.get();
    }

    public double getElevatorEncoder() {
        return elevatorMotor.getSelectedSensorPosition(0) * elevatorInches / elevatorTicks;
    }

    public void setElevatorEncoder(double d) {
        System.out.println("set elevator encoder");
        elevatorMotor.setSelectedSensorPosition( (int) (d * elevatorTicks / elevatorInches), 0, 0);
    }

    /*
     *  Carriage Elevator Stage
     */
    public void carriageElevator(double s) {
        if (s > 0 && !getCarriageLimitTop()) {
            setCarrigeEncoder(carriageInches);
            carriageMotor.set(ControlMode.PercentOutput, 0);
        } else if (s < 0 && !getCarriageLimitBottom()) {
            setCarrigeEncoder(0);
            carriageMotor.set(ControlMode.PercentOutput, 0);
        } else {
            carriageMotor.set(ControlMode.PercentOutput, -s);
        }

    }


    public boolean getCarriageLimitBottom() {
        return carriageLimitBottom.get();
    }

    public boolean getCarriageLimitTop() {
        return carriageLimitTop.get();
    }

    public double getCarriageEncoder() {
        return carriageMotor.getSelectedSensorPosition(0) * carriageInches / carriageTicks;
        //return carriageMotor.getSelectedSensorPosition(0);
    }

    public void setCarrigeEncoder(double d) {
        System.out.println("set carriage encoder");
        carriageMotor.setSelectedSensorPosition( (int) (d * carriageTicks / carriageInches), 0, 0);
    }

    @Override
    protected void initDefaultCommand() {}
}
