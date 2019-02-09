package frc.robot.commands.Elevator;

import frc.robot.commands.CommandBase;

public class CarriageElevate extends CommandBase {

    double speed;
    public CarriageElevate(double s){
      speed = s;
    }

    @Override
    protected void initialize(){}

    @Override
    protected void execute(){
      elevator.carriageElevator(speed);
    }

    @Override
    protected void interrupted(){
      end();
    }

    protected boolean isFinished() {
      return isTimedOut();
    }

    @Override
    protected void end(){
        elevator.carriageElevator(0);
    }
}
