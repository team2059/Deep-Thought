/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

import frc.robot.commands.Elevator.CarriageElevate;
import frc.robot.commands.Elevator.Elevate;
import frc.robot.commands.Arm.Arm;
import frc.robot.commands.Arm.Wrist;
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
        driveButton7.whileHeld(new Elevate(.3));
        driveButton8.whileHeld(new Elevate(-.3));
        driveButton9.whileHeld(new CarriageElevate(-.3));
        driveButton10.whileHeld(new CarriageElevate(.3));
        driveButton11.whileHeld(new Arm(.2));
        driveButton12.whileHeld(new Wrist(.2));
    }
}
