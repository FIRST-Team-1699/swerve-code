/**
 * FIRST Team 1699
 * 
 * This class represents a Swerve module and all associated functions.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot.swerve;

import org.usfirst.frc.team1699.robot.pid.PIDLoop;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class SwerveModule {
	
	// Initializers
	private String name;
	
	private SpeedController spinController;
	private SpeedController driveController;
	private boolean reverseSpin;
	private boolean reverseDrive;	
	
	private Encoder spinEncoder;
	private Encoder driveEncoder;
	
	private PIDLoop spinLoop;
	private PIDLoop driveLoop;
	
	// Constructors
	public SwerveModule(SpeedController _driveController, SpeedController _spinController, Encoder _spinEncoder, Encoder _driveEncoder) {
		this.name = "";
		this.spinController = _spinController;
		this.driveController = _driveController;
		this.spinEncoder = _spinEncoder;
		this.driveEncoder = _driveEncoder;
		spinLoop = new PIDLoop("" + "spin", .1, .1, 0, this.spinEncoder); // generic PID values in here, they need to be tuned or input
		driveLoop = new PIDLoop("" + "drive", .1, 0, .1, this.driveEncoder);
		driveLoop.setUseRate(true);
	}
	
	public SwerveModule(String _name, SpeedController _driveController, SpeedController _spinController, Encoder _spinEncoder, Encoder _driveEncoder) {
		this.name = _name;
		this.spinController = _spinController;
		this.driveController = _driveController;
		this.spinEncoder = _spinEncoder;
		this.driveEncoder = _driveEncoder;
		spinLoop = new PIDLoop(this.name + "spin", .1, .1, 0, this.spinEncoder); // again, needs to be tuned
		driveLoop = new PIDLoop(this.name + "drive", .1, 0, .1, this.driveEncoder);
		driveLoop.setUseRate(true);
	}
	
	// Getters and Setters
	public String getName() {
		return this.name;
	}
	
	public void setName(String _name) {
		this.name = _name;
	}
	
	public SpeedController getSpinController() {
		return this.spinController;
	}
	
	public SpeedController getDriveController() {
		return this.driveController;
	}
	
	public Encoder getDriveEncoder() {
		return this.driveEncoder;
	}
	
	public double getDriveEncoderValue() {
		return this.driveEncoder.get();
	}
	
	public boolean getReverseSpin() {
		return reverseSpin;
	}
	
	public boolean getReverseDrive() {
		return reverseDrive;
	}
	
	public void reverseSpinMotor() {
		reverseSpin = !reverseSpin;
	}
	
	public void reverseDriveMotor() {
		reverseDrive = !reverseDrive;
	}
	
	public void setReverseSpin (boolean _spin) {
		this.reverseSpin = _spin;
	}
	
	public void setReverseDrive (boolean _drive) {
		this.reverseDrive = _drive;
	}

	
	// Methods
	protected void updatePID() {
		this.updateSpinPID();
		this.updateDrivePID();
	}

	protected void updateSpinPID() {
		spinController.set(spinLoop.getPIDValue());
	}
	
	protected void updateDrivePID() {
		driveController.set(driveLoop.getIntegratedPIDValue());
	}
	
	public void setAngle(double _goal) {
		if (reverseSpin == true) {
			spinLoop.setGoal(-1 * _goal); // don't know if this will work
		} else if (reverseSpin == false) {
			spinLoop.setGoal(_goal);
		}
	}
	
	public void setSpeed(double _speed) {
		if (reverseDrive == true) {
			driveLoop.setGoal(-1 * _speed);
		} else if (reverseDrive == false) {
			driveLoop.setGoal(_speed);
		}
	}
	
	public void setSpeedAngle(Vector setting) {
		this.setAngle(setting.getAngle());
		this.setSpeed(setting.getValue());
	}
	
	public String toString() {
		if (name.equals("")) {
			return "Swerve Module at: " + spinController.toString() + " " + driveController.toString();
		} else {
			return "Swerve Module named: " + name;
		}
	}

}
