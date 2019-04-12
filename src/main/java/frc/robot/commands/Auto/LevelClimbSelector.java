package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;
import frc.robot.OI;

public class LevelClimbSelector extends ConditionalCommand {

    public LevelClimbSelector(Command onTrue) {
        super(onTrue);
    }

    public LevelClimbSelector(Command onTrue, Command onFalse) {
        super(onTrue, onFalse);
    }

    public LevelClimbSelector(String name, Command onTrue) {
        super(name, onTrue);
    }

    public LevelClimbSelector(String name, Command onTrue, Command onFalse) {
        super(name, onTrue, onFalse);
    }

    @Override
    protected boolean condition() {
        return OI.getButtonBoxJoystick().getRawButton(14);
    }
}
