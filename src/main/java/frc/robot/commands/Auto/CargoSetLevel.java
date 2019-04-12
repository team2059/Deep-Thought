package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;
import frc.robot.commands.Arm.PIDArm;
import frc.robot.commands.Arm.PIDWrist;

public class CargoSetLevel extends CommandGroup {
    public CargoSetLevel(double level) {
        if (level == 1) {
            addParallel(new PIDWrist(40, 3));
            addParallel(new PIDElevate(0));
            addSequential(new PIDCarriageElevate(16.24));
        } else if (level == 2) {
            addParallel(new PIDWrist(40, 3));
            addParallel(new PIDElevate(16.5));
            addSequential(new PIDCarriageElevate(28));
        } else if (level == 3) {
            addParallel(new PIDArm(55, 4));
            addParallel(new PIDElevate(32));
            addSequential(new PIDCarriageElevate(28.5));
        } else if (level == 4) { // actually the cargo ship
            addParallel(new PIDElevate(6));
            addSequential(new PIDCarriageElevate(28));
        }
    }
}
