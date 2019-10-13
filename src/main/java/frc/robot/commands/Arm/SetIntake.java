package frc.robot.commands.Arm;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class SetIntake extends PIDCommand {

    double timeout;
    boolean checkForTimeOut = false;

    public SetIntake(double angle, double timeout) {
        super(RobotMap.intakeP, RobotMap.intakeI, RobotMap.intakeD);

        setSetpoint(angle);
        this.timeout = timeout;
    }

    public SetIntake(double angle, double timeout, boolean checkForTimeOut) {
        super(RobotMap.intakeP, RobotMap.intakeI, RobotMap.intakeD);

        setSetpoint(angle);
        this.timeout = timeout;
        this.checkForTimeOut = checkForTimeOut;
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
