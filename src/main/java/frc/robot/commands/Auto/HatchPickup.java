package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Auto.HatchSetLevel;
import frc.robot.commands.Elevator.PIDCarriageLower;

public class HatchPickup extends CommandGroup {
    public HatchPickup() {
        addParallel(new HatchSetLevel(1));
        addParallel(new PIDCarriageElevate(12));
        addParallel(new PIDCarriageLower());
    }
}