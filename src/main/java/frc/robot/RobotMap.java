/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // Drive Train
    public static int leftMotor1 = 3;
    public static int leftMotor2 = 2;
    public static int rightMotor1 = 12;
    public static int rightMotor2 = 1;

    // Drive Train Sensors
    public static int leftEncoder1 = 2;
    public static int leftEncoder2 = 3;
    public static int rightEncoder1 = 0;
    public static int rightEncoder2 = 1;

    /*
     * Carriage Elevator and Main Elevator
     */
    public static int elevatorMotor = 5;
    public static int carriageMotor = 6;

    // Hall Effect Sensors
    public static int carriageLimitTop = 7;
    public static int carriageLimitBottom = 5;
    public static int elevatorLimitTop = 6;
    public static int elevatorLimitBottom = 8;

    // Carraige Elevator PID
    public static double carriageElevatorP = .7;
    public static double carriageElevatorI = 0;
    public static double carriageElevatorD = 0;

    // Main Elevator PID
    public static double mainElevatorP = .7;
    public static double mainElevatorI = 0;
    public static double mainElevatorD = .02;

    /*
     * Intake Arm and Wrist collector
     */
    public static int armMotorPort = 10;
    public static int wristMotorPort = 8;
    public static int armPotPort = 1;
    public static int wristPotPort = 0;
    public static int collectorMotorPort = 7;

    // Arm PID
    public static double armP = 1;
    public static double armI = 0;
    public static double armD = 0;

    // Wrist PID
    public static double wristP = .2;
    public static double wristI = 0;
    public static double wristD = 0;

    /*
     * Hatch Arm and Collector
     */
    public static int hatchArmPot = 3;
    public static int hatchArmMotor = 4;

    // PID
    public static double hatchArmP = 1;
    public static double hatchArmI = 0;
    public static double hatchArmD = 0;

    //Jack
    public static int jackMotorPort = 9;
    public static int jackWheelPort = 11;
}
