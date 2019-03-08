package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;

public class CargoSetLevel extends CommandGroup{
    public CargoSetLevel(double level){
        if (level == 1){
            addParallel(new PIDElevate(0));
            addSequential(new PIDCarriageElevate(12.74));
        } else if (level == 2){
            addParallel(new PIDElevate(20));
            addSequential(new PIDCarriageElevate(23.25));
        } else if (level == 3){
            addParallel(new PIDElevate(30));
            addSequential(new PIDCarriageElevate(28));
        }
    }
}