package frc.robot.commands;

public class Collector extends CommandBase {

    double speed;
    public Collector(double s) {
        speed = s;
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        intake.collector(speed);
    }

    @Override
    protected void interrupted() {
        end();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        elevator.carriageElevator(0);
    }
}
