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

  public static boolean stageOneEnabled = true;

  // Carriage Elevator
  public static int carriageLimitTop = 1;
  public static int carriageLimitBottom = 2;
  public static int carriageElevatorMotor = 5;

  // Carraige Elevator PID Values
  public static double carriageElevatorP = 1;
  public static double carriageElevatorI = 0;
  public static double carriageElevatorD = 0;

  // Main Elevator
  public static int elevatorLimitTop = 3;
  public static int elevatorLimitBottom = 4;
  public static int elevatorMotor = 6;

  // Main Elevator PID Values
  public static double mainElevatorP = 1;
  public static double mainElevatorI = 0;
  public static double mainElevatorD = 0;
}
