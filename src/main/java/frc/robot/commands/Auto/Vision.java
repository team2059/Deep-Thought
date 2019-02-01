/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Auto;
//import Java.lang.Math;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

/**
 * An example command.  You can replace me with your own command.
 */
public class Vision extends CommandBase {

  public Vision() {
    //requires(Robot.m_subsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if (Robot.targets.isEmpty()) {
      System.out.println("Empty"); 
    } else {
      //System.out.println("distance" + Robot.targets.get(0).distance);
      //System.out.println("angle 2" + Robot.targets.get(0).angle2);
      System.out.println("x coor: " + Robot.targets.get(0).distance   *   Math.sin(Math.toRadians(Robot.targets.get(0).angle2)));
      /*System.out.println(Robot.targets.get(0).angle1); 
      if (Robot.targets.get(0).angle1<0){
        driveBase.driveBase(RobotMap.photoForward - (RobotMap.photoSubCorrection*2), RobotMap.photoForward + (RobotMap.photoAddCorrection*2));
      }
      else if (Robot.targets.get(0).angle1>0){
        driveBase.driveBase(RobotMap.photoForward + (RobotMap.photoAddCorrection*2), RobotMap.photoForward - (RobotMap.photoSubCorrection*2));

      }else {
        driveBase.driveBase(RobotMap.photoForward, RobotMap.photoForward);        
      }*/

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
