/*
 * FIRST Team 1699
 * 
 * This class represents a Swerve module and all associated functions.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot.swerve;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class SwerveModule {
	
	// Initializers
	private String name;
	
	private SpeedController spinController;
	private SpeedController driveController;
	
	private Encoder spinEncoder;
	private Encoder driveEncoder;

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
	public String getName() {return this.name;}
	public void setName(String _name) {this.name = _name;}
	public SpeedController getSpinController() {return this.spinController;}
	public SpeedController getDriveController() {return this.driveController;}
	
	// Methods	
	public void setAngle(double goal)
	{
		// needs to use PID
		// ask me on Tuesday for my thoughts about this
	}
	
	public void setSpeed(double speed)
	{
		// for now
		driveController.set(speed);
		// maybe PID; might need to use some calculus, talk to Connor 
		
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
