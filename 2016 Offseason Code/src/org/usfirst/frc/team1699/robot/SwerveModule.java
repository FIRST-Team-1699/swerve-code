/*
 * FIRST Team 1699
 * 
 * This class represents a Swerve module and all associated functions.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class SwerveModule {
	
	// Initializers
	String name;
	
	SpeedController spinController;
	SpeedController driveController;
	
	Encoder spinEncoder;
	Encoder driveEncoder;

	// Constructors
	public SwerveModule(SpeedController _driveController, SpeedController _spinController, Encoder _spinEncoder, Encoder _driveEncoder) 
	{
		this.name = "untitled";
		this.spinController = _spinController;
		this.driveController = _driveController;
		this.spinEncoder = _spinEncoder;
		this.driveEncoder = _driveEncoder;
	}
	
	public SwerveModule(String _name, SpeedController _driveController, SpeedController _spinController, Encoder _spinEncoder, Encoder _driveEncoder) 
	{
		this.name = _name;
		this.spinController = _spinController;
		this.driveController = _driveController;
		this.spinEncoder = _spinEncoder;
		this.driveEncoder = _driveEncoder;
	}
	
	// Access methods
	public void setName(String _name) {this.name = _name;}
	
	
	// Methods	
	public void setAngle(int goal)
	{
		// PID loop dis
	}
	
	public void setSpeed(double speed)
	{
		// for now, 
		driveController.set(speed);
		// maybe PID. might need to use some calculus, talk to Connor 
	}
	
	public void setSpeedAngle(Vector setting)
	{
		this.setAngle(setting.getAngle());
		this.setSpeed(setting.getValue());
	}
	
	public String toString()
	{
		if (name.equals("untitled")){return "Swerve Module at: " + spinController.toString() + " " + driveController.toString();}
		else {return "Swerve Module named: " + name;}
	}

}
