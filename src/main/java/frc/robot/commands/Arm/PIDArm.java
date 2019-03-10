package frc.robot.commands.Arm;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDArm extends PIDCommand {

    public PIDArm(double angle) {
        super(RobotMap.armP, RobotMap.armI, RobotMap.armD);

        setSetpoint(angle);
    }

    protected void initialize() {
        setTimeout(4);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.intake.getArmAngle();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.intake.moveArm(speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
      setTimeout(0);
    }

    protected void interrupted() {
        end();
    }
}
