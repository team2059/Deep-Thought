package frc.robot.commands.Arm;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends PIDCommand {

    double timeout;
    boolean checkForTimeOut = false;

    public ToggleIntake(double timeout) {
        super(RobotMap.intakeP, RobotMap.intakeI, RobotMap.intakeD);
        System.out.println("Running Toggle Intake");
        setSetpoint(RobotMap.ballAngle);
//        if (Intake.isHatchMode){
//            System.out.println("Seeting Ball Angle");
//           setSetpoint(RobotMap.ballAngle);
//        } else {
//            System.out.println("Seeting Hatch Angle");
//            setSetpoint(RobotMap.hatchAngle);
//        }
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
        Intake.isHatchMode = !Intake.isHatchMode;
        return isTimedOut() || Math.abs(getSetpoint() - getPosition()) < 2.5;
    }

    protected void end() {
        setTimeout(0);
    }

    protected void interrupted() {
        end();
    }
}
