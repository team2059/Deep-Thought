package frc.robot.commands.Arm;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.subsystems.Intake;

public class ToggleJaw extends PIDCommand {

    double timeout;
    boolean checkForTimeOut = false;

    public ToggleJaw(double timeout) {
        super(RobotMap.intakeP, RobotMap.intakeI, RobotMap.intakeD);
        this.timeout = timeout;

        if (RobotMap.isHatchMode){
          System.out.println("Seeting Ball Angle");
          setSetpoint(RobotMap.ballAngle);
        } else {
          System.out.println("Seeting Hatch Angle");
          setSetpoint(RobotMap.hatchAngle);
        }

        RobotMap.isHatchMode = !RobotMap.isHatchMode;
    }

    protected void initialize() {
        setTimeout(timeout);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.intake.getJawAngle();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.intake.setJawMotor(speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut() || Math.abs(getSetpoint() - getPosition()) < 2.5;
    }

    protected void end() {
        setTimeout(0);
    }

    protected void interrupted() {
        end();
    }
}
