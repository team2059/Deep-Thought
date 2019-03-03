/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MoveArm;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Arm extends Subsystem {
  WPI_TalonSRX armMotor = new WPI_TalonSRX(RobotMap.armMotor);
  AnalogInput armPot = new AnalogInput(RobotMap.armPotPort);

  final double armZeroDegree = 2.9;
  final double armNinetyDegree = 1.67;

  @Override
  public void initDefaultCommand() {
  }

  public void moveArm(double speed) {
    armMotor.set(.08*Math.cos(Math.toRadians(getArmAngle())) + (0.3*speed));
  }

  public double getArmAngle() {
//    return armPot.getVoltage();
    return -21 +((-armPot.getVoltage() + armZeroDegree) / ((armZeroDegree - armNinetyDegree) / 90));
  }
}
