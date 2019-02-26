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

  // Line Following
  public static double photoForward = .4;
  public static double photoAddCorrection = .1;
  public static double photoSubCorrection = .07;

  // Drive Train
  public static int leftMotor1 = 4;
  public static int leftMotor2 = 2;
  public static int rightMotor1 = 3;
  public static int rightMotor2 = 1;

  // Drive Train Sensors
  public static int leftEncoder1 = 1;
  public static int leftEncoder2 = 2;
  public static int rightEncoder1 = 3;
  public static int rightEncoder2 = 4;

  // Arm
  public static int armMotor = 5;
  public static int armPotPort = 3;

  public static int spike =  0;
}
