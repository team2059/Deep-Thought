package frc.robot.commands;


import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.HatchArm;
import frc.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

    public static Elevator elevator;
    public static Intake intake;
    public static HatchArm hatchArm;
    public static DriveBase driveBase;

    public static void init() {
        elevator = new Elevator();
        intake = new Intake();
        hatchArm = new HatchArm();
        driveBase = new DriveBase();
    }
}
