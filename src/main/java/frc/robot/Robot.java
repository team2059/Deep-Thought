package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.CommandBase;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    public static OI m_oi;
    private static UsbCamera camera1;
    private static UsbCamera camera2;
    private static boolean isTeleopInit = false;

    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser = new SendableChooser<>();


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        CommandBase.init();
        CommandBase.elevator.configElevatorMotor();
        camera1 = CameraServer.getInstance().startAutomaticCapture("Camera 1", RobotMap.Camera1);
        camera2 = CameraServer.getInstance().startAutomaticCapture("Camera 2", RobotMap.Camera2);
        camera1.setResolution(160, 120);
        camera2.setResolution(160, 120);
        camera1.setFPS(15);
        camera2.setFPS(15);
        m_oi = new OI();
        // chooser.addOption("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", m_chooser);
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
        SmartDashboard.putNumber("Arm Pot", CommandBase.intake.getArmAngle());
        //System.out.println("Arm Pot: " + CommandBase.intake.getArmAngle());
        SmartDashboard.putNumber("Wrist Pot", CommandBase.intake.getWristAngle());
        SmartDashboard.putBoolean("Carriage Top", CommandBase.elevator.getCarriageLimitTop());
        SmartDashboard.putBoolean("Carriage Bottom", CommandBase.elevator.getCarriageLimitBottom());
        SmartDashboard.putBoolean("Elevator Top", CommandBase.elevator.getElevatorLimitTop());
        SmartDashboard.putBoolean("Elevator Bottom", CommandBase.elevator.getElevatorLimitBottom());
        SmartDashboard.putNumber("Carriage Encoder", CommandBase.elevator.getCarriageEncoder());
        SmartDashboard.putNumber("Elevator Encoder", CommandBase.elevator.getElevatorEncoder());
        SmartDashboard.putNumber("Left Drive Encoder", CommandBase.driveBase.getLeftEncoder());
        SmartDashboard.putNumber("Right Drive Encoder", CommandBase.driveBase.getRightEncoder());
        SmartDashboard.putNumber("Front Jack Pot", CommandBase.jack.getJackAngle());
        SmartDashboard.putNumber("Jack Encoder", CommandBase.jack.getJackEncoder());
        SmartDashboard.putBoolean("Jack Top Limit", CommandBase.jack.getjackTopLimit());
        SmartDashboard.putBoolean("Arm Limit", CommandBase.intake.getArmLimit());
        SmartDashboard.putBoolean("Jack Down Limit", RobotMap.isJackBottom);
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
        teleopInit();
        isTeleopInit = true;
        // m_autonomousCommand = m_chooser.getSelected();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        // if (m_autonomousCommand != null) {
        //     m_autonomousCommand.start();
        // }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        teleopPeriodic();
    }

    @Override
    public void teleopInit() {
        if(!isTeleopInit) {
            CommandBase.elevator.setCarrigeEncoder(RobotMap.carriageStart);
            CommandBase.elevator.setElevatorEncoder(0);
            CommandBase.driveBase.resetLeftEncoder();
            CommandBase.driveBase.resetRightEncoder();
            CommandBase.jack.resetJackEncoder();
        }

        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
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
    }

    /**
     * This function is called periodically during test mode.
     */

    @Override
    public void testInit() {
        System.out.println("Test Mode Enabled");
    }

    @Override
    public void testPeriodic() {

    }
}
