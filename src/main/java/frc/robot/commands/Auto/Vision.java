/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class Vision extends Command {

  public Vision() {
    requires(Robot.m_subsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if (Robot.targets.isEmpty()) {
      System.out.println("Empty"); 
    } else {
      System.out.println(Robot.targets.get(0).distance); 
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
