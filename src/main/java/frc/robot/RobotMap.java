/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
    //Cameras
    public static int Camera1 = 0;
    public static int Camera2 = 1;

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
    public static double carriageStart = 9.35091;

    // Hall Effect Sensors
    public static int carriageLimitTop = 6;
    public static int carriageLimitBottom = 4;
    public static int elevatorLimitTop = 5;
    public static int elevatorLimitBottom = 7;

    // Carraige Elevator PID
    public static double carriageElevatorP = .7;
    public static double carriageElevatorI = 0;
    public static double carriageElevatorD = 0;

    // Main Elevator PID
    public static double mainElevatorP = .7;
    public static double mainElevatorI = 0;
    public static double mainElevatorD = .02;

    // Jack PID
    public static double jackP = .7;
    public static double jackI = 0;
    public static double jackD = .02;

    /*
     * Intake Arm and Wrist collector
     */
    public static int armMotorPort = 10;
    public static int wristMotorPort = 8;
    public static int armPotPort = 1;
    public static int wristPotPort = 0;
    public static int collectorMotorPort = 7;

    // Arm Limit
    public static int armLimitPort = 22;

    // Arm PID
    public static double armP = 0.3;
    public static double armI = 0;
    public static double armD = 0.08;

    // Wrist PID
    public static double wristP = .14;
    public static double wristI = 0;
    public static double wristD = 0.04;

    // PID
    public static double hatchArmP = 1;
    public static double hatchArmI = 0;
    public static double hatchArmD = 0;

    //Jack
    public static int jackMotorPort = 9;
    public static int jackWheelPort = 11;
    public static int frontJackPort = 4;
    public static int frontJackPotPort = 2;
    public static int jackEncoderPort1 = 9;
    public static int jackEncoderPort2 = 8;
    public static int jackTopLimitPort = 23;
    public static int spikePort = 0;


    //Static Elevator Heights
    public static double hatchLevelOneHeight = 6.5544;
    public static double hatchLevelTwoHeight = 34.5543;
    public static double hatchLevelThreeHeight = 62.5543;
}
