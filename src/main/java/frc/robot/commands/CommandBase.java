package frc.robot.commands;


import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Jack;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

    public static Elevator elevator;
    public static Intake intake;
    public static DriveBase driveBase;
    public static Jack jack;

    public static void init() {
        elevator = new Elevator();
        intake = new Intake();
        driveBase = new DriveBase();
        jack = new Jack();
    }
}
