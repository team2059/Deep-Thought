package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;


public class HatchSetLevelTwo extends CommandGroup {

    public HatchSetLevelTwo() {
        addParallel(new PIDElevate(30));
        addSequential(new PIDCarriageElevate(4.5544));
    }
}
