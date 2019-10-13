package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Arm.PIDArm;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;


public class AutoClimbPrePosition extends CommandGroup {
    public AutoClimbPrePosition() {
        addParallel(new PIDElevate(0));
        addParallel(new LevelClimbSelector(new PIDCarriageElevate(12), new PIDCarriageElevate(26)));
        addSequential(new PIDArm(40, 6));
    }
}
