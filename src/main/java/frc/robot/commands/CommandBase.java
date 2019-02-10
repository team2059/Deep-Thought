package frc.robot.commands;


import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

    public static Elevator elevator;
    public static Intake intake;

    public static void init() {
        elevator = new Elevator();
        intake = new Intake();
    }
}
