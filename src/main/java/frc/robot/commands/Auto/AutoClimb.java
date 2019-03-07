package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Jack.PIDJack;
import frc.robot.commands.Elevator.PIDCarriageElevate;


public class AutoClimb extends CommandGroup {
  public AutoClimb(int level) {
    if(level == 1) {
      addParallel(new PIDJack(8));
      addParallel(new PIDCarriageElevate(0));
    } else {
      addParallel(new PIDJack(20));
      addParallel(new PIDCarriageElevate(3));
    }
  }
}
