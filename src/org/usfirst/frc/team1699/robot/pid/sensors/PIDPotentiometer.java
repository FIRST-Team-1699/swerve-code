/**
 * A PIDSensor implementation of a Potentiometer
 * 
 * @author thatging3rkid, FIRST Team 1699
 */
package org.usfirst.frc.team1699.robot.pid.sensors;

import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * An implementation of the PIDSensor for Potentiometers
 */
public class PIDPotentiometer implements PIDSensor {

	private Potentiometer sens;
	
	/**
	 * Create a PIDPotentiometer, for use with a 1699 PIDLoop
	 * 
	 * @param p a potentiometer
	 */
	public PIDPotentiometer(Potentiometer p) {
		this.sens = p;
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public double get() {
		return sens.get();
	}

}
