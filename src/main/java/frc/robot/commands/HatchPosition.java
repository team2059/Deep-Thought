package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;

public class HatchPosition extends CommandGroup{
    public HatchPosition(){
        addParallel(new PIDElevate(0));
        addSequential(new PIDCarriageElevate(6.5544));
    }
}