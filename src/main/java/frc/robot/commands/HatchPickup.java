package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;

public class HatchPickup extends CommandGroup {
    public HatchPickup() {
        addParallel(new PIDElevate(0));
        addSequential(new PIDCarriageElevate(12));
    }
}