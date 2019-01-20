/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.DriveTrain.LineFollow;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private static Joystick driveJoystick = new Joystick(0);

  JoystickButton button5 = new JoystickButton(driveJoystick, 5);

  public static Joystick getDriveJoystick() {
		return driveJoystick;
  }
  
  public OI() {
    button5.whenPressed(new LineFollow(20));
  }
}
