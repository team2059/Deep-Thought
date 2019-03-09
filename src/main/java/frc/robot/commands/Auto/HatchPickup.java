package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Arm.PIDArm;

public class HatchPickup extends CommandGroup {
    public HatchPickup() {
        addParallel(new PIDArm(0));
        addParallel(new PIDCarriageElevate(8));
    }
}
