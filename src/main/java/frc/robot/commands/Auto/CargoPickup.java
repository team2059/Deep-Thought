package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;
import frc.robot.commands.Arm.PIDArm;


public class CargoPickup extends CommandGroup {

    public CargoPickup() {
        addParallel(new PIDArm(0));
        addParallel(new PIDElevate(0));
        addSequential(new PIDCarriageElevate(0));
    }
}
