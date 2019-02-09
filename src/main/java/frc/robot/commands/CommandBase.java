package frc.robot.commands;


import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

    public static Elevator elevator;

    public static void init(){
        elevator = new Elevator();
    }
}
