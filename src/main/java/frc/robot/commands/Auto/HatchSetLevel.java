package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;

public class HatchSetLevel extends CommandGroup {
    public HatchSetLevel(double level) {
        System.out.println(level);

        if (level == 1) {
            addParallel(new PIDElevate(0));
            addSequential(new PIDCarriageElevate(11.5544));
        } else if (level == 2) {
            addParallel(new PIDElevate(20));
            addSequential(new PIDCarriageElevate(18.5544));
        } else if (level == 3) {
            addParallel(new PIDElevate(32));
            addSequential(new PIDCarriageElevate(28.5));
        }
    }
}
