package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.Command;
import hhCore.utils.SynchronousPID;

import static frc.robot.commands.CommandBase.driveBase;

public class VelocityDrive extends Command {
//    private double p = 0.03;
//    private double i = 0.0;
//    private double d = 0.002;
    private double p = 0.065;
    private double i = 0.0;
    private double d = 0.0001;
    private SynchronousPID lDriveVelocity = new SynchronousPID(p, i, d);
    private SynchronousPID rDriveVelocity = new SynchronousPID(p, i, d);


    @Override
    protected void initialize() {
        lDriveVelocity.setOutputRange(0.3, 0.7);
        rDriveVelocity.setOutputRange(0.3, 0.7);

        lDriveVelocity.setSetpoint(10.0);
        rDriveVelocity.setSetpoint(10.0);
        setTimeout(5.0);
    }

    @Override
    protected void execute() {
        if(timeSinceInitialized() > 2.0){
            lDriveVelocity.setSetpoint(10.0);
            rDriveVelocity.setSetpoint(10.0);
        }

        lDriveVelocity.calculate(driveBase.getLeftVelocity());
        rDriveVelocity.calculate(driveBase.getRightVelocity());
//        driveBase.tank(lDriveVelocity.get(), rDriveVelocity.get());
//        driveBase.tank(.30,.0);
        System.out.printf("L: %.2f R: %.2f ML: %.2f MR: %.2f\n",
                driveBase.getLeftVelocity(), driveBase.getRightVelocity(),lDriveVelocity.get(), rDriveVelocity.get());
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
