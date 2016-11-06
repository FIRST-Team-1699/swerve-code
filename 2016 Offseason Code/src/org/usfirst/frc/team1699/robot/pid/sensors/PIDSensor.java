/**
 * An interface for the requirements to work with our PIDLoop. Not much here.
 * 
 * @author thatging3rkid, FIRST Team 1699
 */
package org.usfirst.frc.team1699.robot.pid.sensors;

/**
 * Requirements to be a PIDSensor.
 */
public interface PIDSensor {
	
	/**
	 * Read the value off of the sensor
	 * 
	 * @return value of the sensor
	 */
	public double get();

}
