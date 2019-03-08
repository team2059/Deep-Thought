package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;

public class CargoSetLevel extends CommandGroup{
    public CargoSetLevel(double level){
        if (level == 1){
            addParallel(new PIDElevate(0));
            addSequential(new PIDCarriageElevate(18.24));
        } else if (level == 2){
            addParallel(new PIDElevate(24));
            addSequential(new PIDCarriageElevate(23.25));
        } else if (level == 3){
            addParallel(new PIDElevate(30));
            addSequential(new PIDCarriageElevate(28));
        }
    }
}