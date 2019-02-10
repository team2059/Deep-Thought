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
    public static int rightMotor1 = 0;
    public static int rightMotor2 = 1;

    // Drive Train Sensors
    public static int leftEncoder1 = 1;
    public static int leftEncoder2 = 2;
    public static int rightEncoder1 = 3;
    public static int rightEncoder2 = 4;

    /*
     * Carriage Elevator and Main Elevator
     */
    public static int elevatorMotor = 5;
    public static int carriageMotor = 6;

    // Hall Effect Sensors
    public static int carriageLimitTop = 1;
    public static int carriageLimitBottom = 2;
    public static int elevatorLimitTop = 3;
    public static int elevatorLimitBottom = 4;

    // Carraige Elevator PID
    public static double carriageElevatorP = 1;
    public static double carriageElevatorI = 0;
    public static double carriageElevatorD = 0;

    // Main Elevator PID
    public static double mainElevatorP = 1;
    public static double mainElevatorI = 0;
    public static double mainElevatorD = 0;

    /*
     * Intake Arm and Wrist collector
     */
    public static int armMotorPort = 10;
    public static int wristMotorPort = 8;
    public static int armPotPort = 69;
    public static int wristPotPort = 69;
    public static int collectorMotorPort = 7;

    // Arm PID
    public static double armP = 1;
    public static double armI = 0;
    public static double armD = 0;

    // Wrist PID
    public static double wristP = 1;
    public static double wristI = 0;
    public static double wristD = 0;

    /*
     * Hatch Arm and Collector
     */
    public static int hatchArmPot = 69;
    public static int hatchArmMotor = 4;

    // PID
    public static double hatchArmP = 1;
    public static double hatchArmI = 0;
    public static double hatchArmD = 0;
}
