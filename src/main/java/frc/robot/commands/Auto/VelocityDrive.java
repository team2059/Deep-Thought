package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import hhCore.utils.SynchronousPID;

import static frc.robot.commands.CommandBase.driveBase;

public class VelocityDrive extends Command {
    private double p = 0.05;
    private double i = 0.0;
    private double d = 0.0;
    private SynchronousPID lDriveVelocity = new SynchronousPID(p, i, d);
    private SynchronousPID rDriveVelocity = new SynchronousPID(p, i, d);


    @Override
    protected void initialize() {
        lDriveVelocity.setOutputRange(0.0, 1.0);
        rDriveVelocity.setOutputRange(0.0, 1.0);

        lDriveVelocity.setSetpoint(5.0);
        rDriveVelocity.setSetpoint(5.0);
        setTimeout(10.0);
    }

    @Override
    protected void execute() {
        if(timeSinceInitialized() > 5.0){
            lDriveVelocity.setSetpoint(10.0);
            rDriveVelocity.setSetpoint(10.0);
        }

        lDriveVelocity.calculate(driveBase.getLeftVelocity());
        rDriveVelocity.calculate(driveBase.getRightVelocity());
        driveBase.tank(lDriveVelocity.get(), rDriveVelocity.get());
        System.out.printf("L: %.2f R: %.2f", driveBase.getLeftAcceleration(), driveBase.getRightVelocity());
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
        end();
    }
}
