package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Arm.PIDArm;
import frc.robot.commands.Elevator.PIDElevate;

public class HatchPickup extends CommandGroup {
    public HatchPickup() {
        addParallel(new PIDArm(1, 2));
        addParallel(new PIDElevate(0));
        addParallel(new PIDCarriageElevate(11));
    }
}
