/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import frc.robot.commands.Auto.*;
import frc.robot.commands.DriveTrain.LineFollow;
import frc.robot.commands.DriveTrain.Spike;
import frc.robot.commands.MoveArm;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private static Joystick driveJoystick = new Joystick(0);
  private static Joystick secondJoystick = new Joystick(1);

  JoystickButton button5 = new JoystickButton(driveJoystick, 5);
  JoystickButton button6 = new JoystickButton(driveJoystick, 6);
  JoystickButton button7 = new JoystickButton(driveJoystick, 7);

  JoystickButton button1 = new JoystickButton(secondJoystick, 1);

  public static Joystick getDriveJoystick() {
		return driveJoystick;
  }

  public static Joystick getSecondJoystick() {
      return  secondJoystick;
  }
  
  public OI() {
    button5.whenPressed(new LineFollow(20));
    button6.whenPressed(new Spike(false));
    button7.whenPressed(new Spike(true));
    button1.whileHeld(new MoveArm());
  }
}
