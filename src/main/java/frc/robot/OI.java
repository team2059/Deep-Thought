/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*---------------------------------------------------------------\-------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.commands.Auto.*;
import frc.robot.commands.Elevator.CarriageElevate;
import frc.robot.commands.Elevator.PIDCarriageLower;
import frc.robot.commands.Elevator.Elevate;
import frc.robot.commands.Elevator.PIDElevate;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Arm.Arm;
import frc.robot.commands.Arm.PIDArm;
import frc.robot.commands.Arm.ArmDeploy;
import frc.robot.commands.Arm.Collector;
import frc.robot.commands.Arm.Wrist;
import frc.robot.commands.Arm.PIDWrist;
import frc.robot.commands.Jack.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private static Joystick driveJoystick = new Joystick(0);
    private static Joystick sideJoystick = new Joystick(1);
    private static Joystick buttonBox = new Joystick(2);

    JoystickButton driveButton7 = new JoystickButton(driveJoystick, 7);
    JoystickButton driveButton8 = new JoystickButton(driveJoystick, 8);
    JoystickButton driveButton9 = new JoystickButton(driveJoystick, 9);
    JoystickButton driveButton10 = new JoystickButton(driveJoystick, 10);
    JoystickButton driveButton11 = new JoystickButton(driveJoystick, 11);
    JoystickButton driveButton12 = new JoystickButton(driveJoystick, 12);
    JoystickButton driveButton5 = new JoystickButton(driveJoystick, 5);
    JoystickButton driveButton6 = new JoystickButton(driveJoystick, 6);
    JoystickButton driveButton4 = new JoystickButton(driveJoystick, 4);
    JoystickButton driveButton2 = new JoystickButton(driveJoystick, 2);
    JoystickButton driveButton1 = new JoystickButton(driveJoystick, 1);
    JoystickButton driveButton3 = new JoystickButton(driveJoystick, 3);

    JoystickButton sideButton5 = new JoystickButton(sideJoystick, 5);
    JoystickButton sideButton3 = new JoystickButton(sideJoystick, 3);
    JoystickButton sideButton6 = new JoystickButton(sideJoystick, 6);
    JoystickButton sideButton4 = new JoystickButton(sideJoystick, 4);
    JoystickButton sideButton7 = new JoystickButton(sideJoystick, 7);
    JoystickButton sideButton8 = new JoystickButton(sideJoystick, 8);
    JoystickButton sideButton12 = new JoystickButton(sideJoystick, 12);
    JoystickButton sideButton1 = new JoystickButton(sideJoystick, 1);
    JoystickButton sideButton2 = new JoystickButton(sideJoystick, 2);

    JoystickButton boxButton1 = new JoystickButton(buttonBox, 1);
    JoystickButton boxButton2 = new JoystickButton(buttonBox, 2);
    JoystickButton boxButton3 = new JoystickButton(buttonBox, 3);
    JoystickButton boxButton4 = new JoystickButton(buttonBox, 4);
    JoystickButton boxButton5 = new JoystickButton(buttonBox, 5);
    JoystickButton boxButton6 = new JoystickButton(buttonBox, 6);
    JoystickButton boxButton7 = new JoystickButton(buttonBox, 7);
    JoystickButton boxButton8 = new JoystickButton(buttonBox, 8);
    JoystickButton boxButton9 = new JoystickButton(buttonBox, 9);
    JoystickButton boxButton10 = new JoystickButton(buttonBox, 10);
    JoystickButton boxButton11 = new JoystickButton(buttonBox, 11);
    JoystickButton boxButton12 = new JoystickButton(buttonBox, 12);

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

    public static Joystick getButtonBoxJoystick(){
        return buttonBox;
    }

    public OI() {
        /*
         * Drive Joystick - First Joystick
         */
        driveButton7.whileHeld(new Elevate(.3));
        driveButton8.whileHeld(new Elevate(-.3));
        driveButton9.whileHeld(new CarriageElevate(-.8));
        driveButton10.whileHeld(new CarriageElevate(.8));
        driveButton11.whenPressed(new PIDArm(75));
        driveButton12.whenPressed(new PIDArm(0));
        // driveButton4.whenPressed(new PIDWrist(15));
        // driveButton6.whileHeld(new Jack(.25));
        driveButton1.whileHeld(new Collector(.5));
        driveButton2.whileHeld(new Collector(-.7));
        driveButton6.whileHeld(new JackWheel());
        driveButton5.whenPressed(new LumberJack(4));
        driveButton3.whenPressed(new LumberJack(10));
        // 8.7 carriage collector

        /*
         * Side Joystick - Second Joystick
         */
        sideButton1.whileHeld(new Jack(-.7));
        sideButton2.whileHeld(new Jack(.7));
        sideButton6.whenPressed(new AutoClimbPrePosition());
        sideButton4.whenPressed(new AutoClimb());
        sideButton5.whenPressed(new AutoClimbPrePosition());
        sideButton3.whenPressed(new AutoClimb());

        //sideButton6.whileHeld(new Jack(.3));
        //sideButton4.whileHeld(new Jack(-.3));
        //sideButton12.whenPressed(new PIDArm(45));
        //sideButton8.whileHeld(new Arm(-.7));
        //sideButton7.whenPressed(new PIDJack(5));
        //sideButton2.whenPressed(new PIDJack(0));

        /*
         * Button Box - Third Joystick
         */
        boxButton1.whenPressed(new CargoSetLevel(1));
        boxButton2.whenPressed(new CargoSetLevel(2));
        boxButton3.whenPressed(new CargoSetLevel(3));
        boxButton4.whenPressed(new HatchSetLevel(1));
        boxButton5.whenPressed(new HatchSetLevel(2));
        boxButton6.whenPressed(new HatchSetLevel(3));
        boxButton7.whenPressed(new HatchPickup());
        boxButton8.whenPressed(new CargoPickup());
        boxButton9.whenPressed(new CargoSetLevel(4)); // cargo ship
        boxButton10.whenPressed(new AutoClimbPrePosition());
        boxButton11.whenPressed(new AutoClimb());
        boxButton12.whenPressed(new Jack(.7));

    }
}
