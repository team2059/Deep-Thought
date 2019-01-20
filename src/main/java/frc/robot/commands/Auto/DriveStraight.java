/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.DriveTrain.LineFollow;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveStraight extends CommandGroup {
  public DriveStraight() {
    addSequential(new LineFollow(60));
  }
}
