/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*---------------------------------------------------------------\-------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.commands.Elevator.CarriageElevate;
import frc.robot.commands.Elevator.PIDCarriageLower;
import frc.robot.commands.Elevator.Elevate;
import frc.robot.commands.Elevator.PIDElevate;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Auto.HatchPickup;
import frc.robot.commands.Arm.Arm;
import frc.robot.commands.Arm.ArmDeploy;
import frc.robot.commands.Arm.Collector;
import frc.robot.commands.Arm.Wrist;
import frc.robot.commands.Arm.PIDWrist;
import frc.robot.commands.Jack.*;
import frc.robot.commands.Auto.HatchSetLevel;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private static Joystick driveJoystick = new Joystick(0);
    private static Joystick sideJoystick = new Joystick(1);

    JoystickButton driveButton7 = new JoystickButton(driveJoystick, 7);
    JoystickButton driveButton8 = new JoystickButton(driveJoystick, 8);
    JoystickButton driveButton9 = new JoystickButton(driveJoystick, 9);
    JoystickButton driveButton10 = new JoystickButton(driveJoystick, 10);
    JoystickButton driveButton11 = new JoystickButton(driveJoystick, 11);
    JoystickButton driveButton12 = new JoystickButton(driveJoystick, 12);
    JoystickButton driveButton5 = new JoystickButton(driveJoystick, 5);
    JoystickButton driveButton6 = new JoystickButton(driveJoystick, 6);
    JoystickButton driveButton4 = new JoystickButton(driveJoystick, 4);
    JoystickButton driveButton3 = new JoystickButton(driveJoystick, 3);
    JoystickButton driveButton1 = new JoystickButton(driveJoystick, 1);

    JoystickButton sideButton5 = new JoystickButton(sideJoystick, 5);
    JoystickButton sideButton3 = new JoystickButton(sideJoystick, 3);
    JoystickButton sideButton6 = new JoystickButton(sideJoystick, 6);
    JoystickButton sideButton4 = new JoystickButton(sideJoystick, 4);
    JoystickButton sideButton7 = new JoystickButton(sideJoystick, 7);
    JoystickButton sideButton8 = new JoystickButton(sideJoystick, 8);
    JoystickButton sideButton12 = new JoystickButton(sideJoystick, 12);
    JoystickButton sideButton1 = new JoystickButton(sideJoystick, 1);
    JoystickButton sideButton2 = new JoystickButton(sideJoystick, 2);

    // JoystickButton[] driveButtons = new JoystickButton[14];
    // JoystickButton[] sideButtons = new JoystickButton[13];


    // for (int i = 0; i < 12; i++) {
    //     driveButtons[i] = new JoystickButton(driveJoystick, i + 1);
    //     sideButtons[i] = new JoystickButton(sideJoystick, i + 1);
    // }

    public static Joystick getDriveJoystick() {
        return driveJoystick;
    }

    public static Joystick getSideJoystick() {
        return sideJoystick;
    }

    public OI() {
        driveButton7.whileHeld(new Elevate(1));
        driveButton8.whileHeld(new Elevate(-.3));
        driveButton9.whileHeld(new CarriageElevate(-.3));
        driveButton10.whileHeld(new CarriageElevate(.3));
        driveButton11.whileHeld(new Arm(-.2));
        driveButton12.whileHeld(new Arm(.3));
        driveButton4.whileHeld(new Wrist(.4));
        driveButton6.whileHeld(new Wrist(-.2));
        driveButton1.whileHeld(new Collector(.5));
        driveButton3.whileHeld(new Collector(-.5));
        // driveButton5.whileHeld(new PIDWrist(45));
        // driveButton3.whileHeld(new PIDWrist(-25));
        // 8.7 carriage collector

        sideButton3.whileHeld(new FrontJack(-1));
        sideButton5.whileHeld(new FrontJack(.3));
        //sideButton6.whenPressed(new PIDCarriageElevate(RobotMap.carriageStart));
        //sideButton4.whenPressed(new ArmDeploy());
        sideButton6.whileHeld(new Jack(.3));
        sideButton4.whileHeld(new Jack(-3));
        sideButton1.whileHeld(new JackWheel(.7));
        sideButton2.whileHeld(new JackWheel(-.5));
        sideButton12.whenPressed(new PIDCarriageLower());

    }
}
