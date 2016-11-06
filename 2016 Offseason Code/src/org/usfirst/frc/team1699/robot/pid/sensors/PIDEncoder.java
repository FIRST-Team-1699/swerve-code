/**
 * A PIDSensor implementation of an Encoder
 * 
 * @author thatging3rkid, FIRST Team 1699
 */
package org.usfirst.frc.team1699.robot.pid.sensors;

import edu.wpi.first.wpilibj.Encoder;

/**
 * An implementation of the PIDSensor for Encoders
 */
public class PIDEncoder implements PIDSensor {

	private Encoder sens;
	
	/**
	 * Create a PIDEncoder, for use with a 1699 PIDLoop
	 * 
	 * @param e an encoder
	 */
	public PIDEncoder(Encoder e) {
		this.sens = e;
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public double get() {
		return sens.get();
	}

}
