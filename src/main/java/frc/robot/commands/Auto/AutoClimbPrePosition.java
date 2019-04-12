package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;
import frc.robot.commands.Arm.PIDWrist;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;


public class AutoClimbPrePosition extends CommandGroup {
  addParallel(new PIDElevate(0));
  addParallel(new LevelClimbSelector(new PIDCarriageElevate(12), new PIDCarriageElevate(26)));
  addSequential(new PIDWrist(40, 6));
}
