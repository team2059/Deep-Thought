package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveBase;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static DriveBase driveBase;
	public static Arm arm;
	public static void init() {
	    driveBase = new DriveBase();
	    arm = new Arm();
	}
}