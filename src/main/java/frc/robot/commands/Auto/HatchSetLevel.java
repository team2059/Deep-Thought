package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;

public class HatchSetLevel extends CommandGroup{
    public HatchSetLevel(double level){
        if (level == 1){
            addParallel(new PIDElevate(0));
            addSequential(new PIDCarriageElevate(6.5544));
        } else if (level == 2){
            addParallel(new PIDElevate(30));
            addSequential(new PIDCarriageElevate(4.5544));
        } else if (level == 3){
            addParallel(new PIDElevate(30));
            addSequential(new PIDCarriageElevate(28));
        }
    }
}