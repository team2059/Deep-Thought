package frc.robot.commands;

import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static DriveBase driveBase;
	
	public static void init() {
	    driveBase = new DriveBase();
	  }
}