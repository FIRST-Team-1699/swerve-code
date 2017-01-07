/**
 * FIRST Team 1699
 * 
 * This class represents a Swerve module and all associated functions.
 * 
 * @author thatging3rkid, FIRST Team 1699
 */
package org.usfirst.frc.team1699.robot.swerve;

import org.usfirst.frc.team1699.robot.pid.PIDLoop;
import org.usfirst.frc.team1699.robot.pid.sensors.PIDEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * A class that represents a swerve module.  
 */
public class SwerveModule {

	private String name = null;

	private SpeedController spinController;
	private SpeedController driveController;

	private boolean reverseSpin;
	private boolean reverseDrive;

	private Encoder spinEncoder;
	private Encoder driveEncoder;

	private PIDLoop spinLoop;
	private PIDLoop driveLoop;
	
	private double oldPIDout;

	/**
	 * Swerve Module basic constructor without drive PID
	 * 
	 * @param _spinController
	 * @param _driveController
	 * @param _spinEncoder
	 */
	public SwerveModule(SpeedController _spinController, SpeedController _driveController, Encoder _spinEncoder) {
		this.name = "";
		this.spinController = _spinController;
		this.driveController = _driveController;
		this.spinEncoder = _spinEncoder;
		this.driveEncoder = null;
		spinLoop = new PIDLoop("" + this.spinController.toString(), .1, .1, 0, new PIDEncoder(this.spinEncoder)); // generic PID values in here, they need to be tuned or input
	}
	
	/**
	 * Swerve Module basic constructor
	 * 
	 * @param _spinController SpeedController of the spin motor
	 * @param _driveController SpeedController of the drive motor
	 * @param _spinEncoder Encoder to tell the angle of the drive wheel (may be changed to a Potentiometer)
	 * @param _driveEncoder Encoder to tell the position of the drive wheel (may be changed to a Potentiometer)
	 */
	public SwerveModule(SpeedController _spinController, SpeedController _driveController, Encoder _spinEncoder, Encoder _driveEncoder) {
		this.name = "";
		this.spinController = _spinController;
		this.driveController = _driveController;
		this.spinEncoder = _spinEncoder;
		this.driveEncoder = _driveEncoder;
		spinLoop = new PIDLoop("" + this.spinController.toString(), .1, .1, 0, new PIDEncoder(this.spinEncoder)); // generic PID values in here, they need to be tuned or input
		driveLoop = new PIDLoop("" + this.driveController.toString(), .1, 0, .1, new PIDEncoder(this.driveEncoder));
	}

	/**
	 * Swerve Module constructor with a name
	 * 
	 * @param _name the name of the module
	 * @param _spinController SpeedController of the spin motor
	 * @param _driveController SpeedController of the drive motor
	 * @param _spinEncoder Encoder to tell the angle of the drive wheel (may be changed to a Potentiometer)
	 * @param _driveEncoder Encoder to tell the position of the drive wheel (may be changed to a Potentiometer)
	 */
	public SwerveModule(String _name, SpeedController _spinController, SpeedController _driveController, Encoder _spinEncoder, Encoder _driveEncoder) {
		this.name = _name;
		this.spinController = _spinController;
		this.driveController = _driveController;
		this.spinEncoder = _spinEncoder;
		this.driveEncoder = _driveEncoder;
		spinLoop = new PIDLoop(this.name + "spin", .1, .1, 0, new PIDEncoder(this.spinEncoder)); // generic PID values in here, they need to be tuned or input
		driveLoop = new PIDLoop(this.name + "drive", .1, 0, .1, new PIDEncoder(this.driveEncoder));
	}
	
	/**
	 * 
	 * Advanced Swerve Module constructor with adjustable PID values
	 * 
	 * @param _name the name of the module
	 * @param _spinController SpeedController of the spin motor
	 * @param _driveController SpeedController of the drive motor
	 * @param _spinEncoder Encoder to tell the angle of the drive wheel (may be changed to a Potentiometer)
	 * @param _driveEncoder Encoder to tell the position of the drive wheel (may be changed to a Potentiometer)
	 * @param _Pk P constant for PID for both loops
	 * @param _Ik I constant for PID for both loops
	 * @param _Dk D constant for PID for both loops
	 */
	public SwerveModule(String _name, SpeedController _driveController, SpeedController _spinController,
			Encoder _spinEncoder, Encoder _driveEncoder, double _Pk, double _Ik, double _Dk) {
		this.name = _name;
		this.spinController = _spinController;
		this.driveController = _driveController;
		this.spinEncoder = _spinEncoder;
		this.driveEncoder = _driveEncoder;
		spinLoop = new PIDLoop(this.name + "spin", _Pk, _Dk, _Ik, new PIDEncoder(this.spinEncoder)); // no tuning required :)
		driveLoop = new PIDLoop(this.name + "drive", _Pk, _Dk, _Ik, new PIDEncoder(this.driveEncoder));
	}
	
	/**
	 * Gets the name of the module
	 * 
	 * @return the name of the module
	 */
	public String getName() {
		if (this.name == null) {
			return "";
		} else {
			return this.name;
		}
	}
	
	/**
	 * Set a new name for the module
	 * 
	 * @param _name the new name
	 */
	public void setName(String _name) {
		this.name = _name;
	}
	
	/**
	 * Get a reference to the spin motor SpeedController
	 * 
	 * @return a reference to the spin motor SpeedController
	 */
	public SpeedController getSpinController() {
		return this.spinController;
	}
	
	/**
	 * Get a reference to the drive motor SpeedController
	 * 
	 * @return a reference to the drive motor SpeedController
	 */
	public SpeedController getDriveController() {
		return this.driveController;
	}
	
	/**
	 * Get a reference to the drive Encoder
	 * 
	 * @return a reference to the drive Encoder
	 */
	public Encoder getDriveEncoder() {
		if (this.driveEncoder == null) {
			return null;
		} else {
			return this.driveEncoder;
		}
	}
	
	/**
	 * Get the value of the drive Encoder
	 * 
	 * @return the value of the drive Encoder
	 */
	public double getDriveEncoderValue() {
		if (this.driveEncoder == null) {
			return 0.0;
		} else {
			return this.driveEncoder.get();
		}
	}
	
	/**
	 * Get a reference to the spin Encoder
	 * 
	 * @return a reference to the spin Encoder
	 */
	public Encoder getSpinEncoder() {
		if (this.spinEncoder == null) {
			return null;
		} else {
			return this.spinEncoder;
		}	
	}
	
	/**
	 * Get the value of the spin Encoder
	 * 
	 * @return the value of the spin Encoder
	 */
	public double getSpinEncoderValue() {
		return this.spinEncoder.get();
	}

	/**
	 * The depreciated way to get if the spin motor is reversed.
	 * 
	 * Use isReverseSpin().
	 * 
	 * @return true if the spin motor is reversed
	 */
	@Deprecated
	public boolean getReverseSpin() {
		return this.reverseSpin;
	}
	
	/**
	 * The depreciated way to get if the drive motor is reversed.
	 * 
	 * Use isReverseDrive().
	 * 
	 * @return true if the drive motor is reversed
	 */
	@Deprecated
	public boolean getReverseDrive() {
		return this.reverseSpin;
	}
	
	/**
	 * Tell if the spin motor reversed
	 * 
	 * @return true if the spin motor is reversed
	 */
	public boolean isReverseSpin() {
		return reverseSpin;
	}

	/**
	 * Tell if the drive motor is reversed
	 * 
	 * @return true if the drive motor is reversed
	 */
	public boolean isReverseDrive() {
		return reverseDrive;
	}

	/**
	 * Reverse the spin motor
	 */
	public void reverseSpin() {
		this.reverseSpin = !this.reverseSpin;
	}

	/**
	 * Reverse the drive motor
	 */
	public void reverseDrive() {
		this.reverseDrive = !this.reverseDrive;
	}

	/**
	 * Specify if the spin motor is reversed
	 * 
	 * @param _spin true if the spin motor should be reversed
	 */
	public void setReverseSpin(boolean _spin) {
		this.reverseSpin = _spin;
	}

	/**
	 * Specify if the drive motor is reversed
	 * 
	 * @param _drive true if the drive motor should be reversed
	 */
	public void setReverseDrive(boolean _drive) {
		this.reverseDrive = _drive;
	}
	
	/**
	 * Updates the drive PID loop's values
	 * 
	 * @param _Pk new P constant
	 * @param _Ik new I constant
	 * @param _Dk new D constant
	 */
	public void setDrivePIDValues(double _Pk, double _Ik, double _Dk) {
		driveLoop.setPk(_Pk);
		driveLoop.setIk(_Ik);
		driveLoop.setDk(_Dk);
	}

	/**
	 * Updates the spin PID loop's values
	 * @param _Pk new P constant
	 * @param _Ik new I constant
	 * @param _Dk new D constant
	 */
	public void setSpinPIDValues(double _Pk, double _Ik, double _Dk) {
		spinLoop.setPk(_Pk);
		spinLoop.setIk(_Ik);
		spinLoop.setDk(_Dk);
	}
	
	/**
	 * Updates the Drive and Spin PID loops
	 */
	public synchronized void updatePID() {
		this.updateSpinPID();
		this.updateDrivePID();
	}

	/**
	 * Updates only the Spin PID loop
	 */
	public synchronized void updateSpinPID() {
		spinController.set(spinLoop.output());
	}

	/**
	 * Updates only the Drive PID loop
	 */
	public synchronized void updateDrivePID() {
		double curPIDout = driveLoop.output();
		driveController.set(curPIDout - this.oldPIDout);
		this.oldPIDout = curPIDout;
	}

	/**
	 * Sets the desired angle
	 * 
	 * @param goal the new desired angle
	 */
	public void setAngle(double goal) {
		if (reverseSpin == true) {
			spinLoop.setGoal(360 - goal); // don't know if this will work
		} else if (reverseSpin == false) {
			spinLoop.setGoal(goal);
		}
	}

	/**
	 * Sets the desired speed
	 * 
	 * @param speed the new desired speed
	 */
	public void setSpeed(double speed) {
		if (speed > 1.0) {
			System.err.println("Input speed is too high!");
			speed = 1.0;
		}
		if (speed < -1.0) {
			System.err.println("Input speed is too low!");
			speed = -1.0;
		}
		if (reverseDrive == true) {
			driveLoop.setGoal(-1 * speed);
		} else if (reverseDrive == false) {
			driveLoop.setGoal(speed);
		}
	}

	/**
	 * Uses a Vector to set the speed and angle
	 * 
	 * @param setting a Vector that you want this module to emulate
	 */
	public void setSpeedAngle(Vector setting) {
		this.setAngle(setting.getAngle());
		this.setSpeed(setting.getValue());
	}

	/**
	 * A toString, mostly for debugging reasons
	 * 
	 * @return a String representing the module
	 */
	@Override
	public String toString() {
		if (name.equals("")) {
			return "Swerve Module at: " + spinController.toString() + " " + driveController.toString();
		} else {
			return "Swerve Module named: " + name;
		}
	}

}
