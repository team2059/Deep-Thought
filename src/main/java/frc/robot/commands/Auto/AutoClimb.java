package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.Jack.PIDJack;
import frc.robot.commands.Elevator.PIDCarriageElevate;


public class AutoClimb extends CommandGroup {
    public AutoClimb() {
        if(OI.getButtonBoxJoystick().getY() > 0) {
            addParallel(new PIDJack(12, 6));
            addParallel(new PIDCarriageElevate(0));
            RobotMap.isJackBottom = true;
        } else {
            addParallel(new PIDJack(21, 18));
            addParallel(new PIDCarriageElevate(0));
            RobotMap.isJackBottom = true;
        }
    }
}
