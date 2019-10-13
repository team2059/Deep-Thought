package frc.robot.commands.Arm;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends PIDCommand {

    double timeout;
    boolean checkForTimeOut = false;

    public ToggleIntake(double timeout) {
        super(RobotMap.intakeP, RobotMap.intakeI, RobotMap.intakeD);

        if (Intake.isHatchMode){
           setSetpoint(RobotMap.ballAngle);
        } else {
            setSetpoint(RobotMap.hatchAngle);
        }
        this.timeout = timeout;
    }

    protected void initialize() {
        setTimeout(timeout);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.intake.getIntakeAngle();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.intake.setIntakeMotor(speed);
    }

    @Override
    protected boolean isFinished() {
        if (checkForTimeOut) {
            return isTimedOut();
        } else {
            return isTimedOut() || Math.abs(getSetpoint() - getPosition()) < 2.5;
        }
    }

    protected void end() {
        setTimeout(0);
    }

    protected void interrupted() {
        end();
    }
}
