package frc.robot.commands;

import frc.robot.OI;
import frc.robot.RobotMap;

public class Elevate extends CommandBase{

    public Elevate(){
        requires(elevator);
        RobotMap.stageOneEnabled = !RobotMap.stageOneEnabled;
    }

    @Override   
    protected void initialize(){

    }

    @Override
    protected void execute(){
        if(RobotMap.stageOneEnabled){
            elevator.elevateFirst(-OI.getSecondJoyStick.getRawAxis(0));
        }
        else{
            elevator.elevateSecond(-OI.getSecondJoyStick.getRawAxis(0));
        }
    }

    @Override
    protected void interrupted(){

    }  

    @Override
    protected void isFinished(){
        
    }

    @Override
    protected void end(){
        elevator.elevate(0);
    }

}



