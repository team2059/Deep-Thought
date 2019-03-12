package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;
import frc.robot.commands.Arm.PIDArm;

public class CargoSetLevel extends CommandGroup {
    public CargoSetLevel(double level) {
        if (level == 1) {
            addParallel(new PIDElevate(0));
            addSequential(new PIDCarriageElevate(18.24));
            // addSequential(new PIDArm(45));
        } else if (level == 2) {
            addParallel(new PIDElevate(5));
            addSequential(new PIDCarriageElevate(28));
        } else if (level == 3) {
            addParallel(new PIDElevate(30));
            addSequential(new PIDCarriageElevate(28));
        }
    }
}
