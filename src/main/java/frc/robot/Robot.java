/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.CommandBase;
import frc.robot.commands.Auto.DriveStraight;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI m_oi;

  static final String PI_ADDRESS = "10.20.59.6";
  static final int PORT = 8081;
  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table = inst.getTable("SmartDashboard");
  NetworkTableEntry distance = table.getEntry("visionDistance");
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  private Gson gson = new Gson();
  public static ArrayList<TargetInfo> targets = new ArrayList<TargetInfo>();
  private int velocityCount = 0;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    CommandBase.init();
    NetworkTableInstance.getDefault()
      .getEntry("/CameraPublisher/PiCamera/streams")
      .setStringArray(new String[]{"mjpeg:http://" + PI_ADDRESS + ":" + PORT + "/?action=stream"});
    
    CommandBase.driveBase.resetLeftEncoder();
    CommandBase.driveBase.resetRightEncoder();
    CommandBase.driveBase.init();
    CommandBase.driveBase.gyro().calibrate();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Arm Pot", CommandBase.arm.getArmAngle());
    if(velocityCount == 2) {
      CommandBase.driveBase.update();
      velocityCount = 0;
    }

    velocityCount++;
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    CommandBase.driveBase.resetLeftEncoder();
    CommandBase.driveBase.resetRightEncoder();
    CommandBase.driveBase.resetGyro();
    CommandBase.driveBase.init();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    String gsonString = NetworkTableInstance.getDefault().getEntry("/SmartDashboard/visionJSON").getString("");
    // double visionMode = Network640TableInstance.getDefault().getEntry("/SmartDashboard/visionMode").getDouble(-1);
    // SmartDashboard.putBoolean("Left", photoElectricleft.get());
    // SmartDashboard.putBoolean("Right", photoElectricright.get());
    // SmartDashboard.putBoolean("Back", photoElectricback.get());

    SmartDashboard.putNumber("Left Encoder", CommandBase.driveBase.getLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", CommandBase.driveBase.getRightEncoder());
    SmartDashboard.putNumber("Gyro", CommandBase.driveBase.getGyro());

    targets = gson.fromJson(gsonString, new TypeToken<ArrayList<TargetInfo>>(){}.getType());

    //System.out.printf("LV: %.2f RV: %.2f LA: %.2f RA: %.2f",
//            CommandBase.driveBase.getLeftVelocity(),
//            CommandBase.driveBase.getRightVelocity(),
//            CommandBase.driveBase.getLeftAcceleration(),
//            CommandBase.driveBase.getRightAcceleration());
    // for(TargetInfo target : targets){
    //   System.out.println(target.distance + " - " + target.number);
    // }

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
