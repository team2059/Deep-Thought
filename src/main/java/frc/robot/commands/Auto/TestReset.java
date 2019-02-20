package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;


public class TestReset extends CommandGroup {

    public TestReset() {
        addParallel(new PIDElevate(0));
        addSequential(new PIDCarriageElevate(11.35091));
    }
}
