package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class Elevator extends Subsysem{
    WPI_TalonSRX elevator1Motor = new WPI_TalonSRX(RobotMap.elevator1MotorPort);
    WPI_TalonSRX elevator2Motor = new WPI_TalonSRX(RobotMap.elevator2MotorPort);

    DigitalInput limit1Top = new DigitalInput(RobotMap.limitTopPort);
    DigitalInput limit1Bottom = new DigitalInput(RobotMap.limitBottomPort);


    public void elevateFirst(double speed){
        /*if((limit1Top && speed<0) || (limit1Bottom && speed>0)){  //  if (top limiter has detected something and the speed is less than zero(going down) or (bottom limiter has detected something and the speed is greater than zero(going up))
            elevator1Motor.set(speed);
        }else{
            elevator1Motor.set(0);
        }*/
        elevator1Motor.set(speed);

    }

    public void elevateSecond(double speed){
        /*if((limit1Top && speed<0) || (limit1Bottom && speed>0)){  //  if (top limiter has detected something and the speed is less than zero(going down) or (bottom limiter has detected something and the speed is greater than zero(going up))
            elevator2Motor.set(speed);
        }else{
            elevator2Motor.set(0);
        }*/
        elevator2Motor.set(speed);
    }





    @Override
	protected void initDefaultCommand() {}

}