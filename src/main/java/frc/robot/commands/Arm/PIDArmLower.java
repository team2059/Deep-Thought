package frc.robot.commands.Arm;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDArmLower extends PIDCommand {

    private double targetAngle = 0;
    private double decrement = .1;

    public PIDArmLower(double angle, double decrement) {
        super(RobotMap.armP, RobotMap.armI, RobotMap.armD);
        this.targetAngle = angle;
        this.decrement = decrement;
        setSetpoint(CommandBase.intake.getArmAngle() - decrement);
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
        if (CommandBase.intake.getArmAngle() > targetAngle){
            setSetpoint(CommandBase.intake.getArmAngle() - decrement);
        }
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut() || Math.abs(getPosition()) < 2.5;
    }

    protected void end() {
        setTimeout(0);
    }

    protected void interrupted() {
        end();
    }
}
