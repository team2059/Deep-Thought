package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;


public class HatchSetLevelOne extends CommandGroup {

    public HatchSetLevelOne() {
        addParallel(new PIDElevate(0));
        addSequential(new PIDCarriageElevate(6.5544));
    }
}
