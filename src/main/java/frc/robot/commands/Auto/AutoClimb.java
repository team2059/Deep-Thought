package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import frc.robot.commands.Jack.PIDJack;
import frc.robot.commands.Elevator.PIDCarriageElevate;


public class AutoClimb extends CommandGroup {
    public AutoClimb() {
        addParallel(new LevelClimbSelector(new PIDJack(12, 6), new PIDJack(21, 18)));
        addParallel(new PIDCarriageElevate(0, .35));
        RobotMap.isJackBottom = true;
    }
}
