/**
 * FIRST Team 1699
 * 
 * This class is supposed to be a PID Loop.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot.pid;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class PIDLoop {

	private double Pk;
	private double Ik;
	private double Dk;

	private Potentiometer pot;
	private Encoder enc;
	private double curValue;
	private double oldValue;
	private double goalValue;

	private BetterTimer timer;
	private long iterations = 0;
	private double integralOut = 0;

	private String name;

	private boolean useRate = false;

	/**
	 * Creates a PID loop that automatically gets the value from a source.
	 * 
	 * @param _name name of the PID loop, used for debugging
	 * @param _Pk P constant
	 * @param _Ik I constant
	 * @param _Dk D constant
	 * @param _pot Potentiometer to read from
	 */
	public PIDLoop(String _name, double _Pk, double _Ik, double _Dk, Potentiometer _pot) {
		this.name = _name;
		this.Pk = _Pk;
		this.Ik = _Ik;
		this.Dk = _Dk;
		this.pot = _pot;
		this.updateValues();
		this.timer = new BetterTimer();
	}

	/**
	 * Creates a PID loop that automatically gets the value from a source.
	 * 
	 * @param _name name of the PID loop, used for debugging
	 * @param _Pk P constant
	 * @param _Ik I constant
	 * @param _Dk D constant
	 * @param _enc Encoder to read from
	 */
	public PIDLoop(String _name, double _Pk, double _Ik, double _Dk, Encoder _enc) {
		this.name = _name;
		this.Pk = _Pk;
		this.Ik = _Ik;
		this.Dk = _Dk;
		this.enc = _enc;
		this.updateValues();
		this.timer = new BetterTimer();
	}

	/**
	 * Get the value of the P constant
	 * 
	 * @return the value of the P constant
	 */
	public double getPk() {
		return this.Pk;
	}
	
	/**
	 * Set a new value for the P constant
	 * 
	 * @param _Pk new value for the P constant
	 */
	public void setPk(double _Pk) {
		this.Pk = _Pk;
	}

	/**
	 * Get the value of the I constant
	 * 
	 * @return the value of the I constant
	 */
	public double getIk() {
		return this.Ik;
	}
	
	/**
	 * Set a new value for the I constant
	 * 
	 * @param _Ik new value for the I constant
	 */
	public void setIk(double _Ik) {
		this.Ik = _Ik;
	}

	/**
	 * Get the value of the D constant
	 * 
	 * @return the value of the D constant
	 */
	public double getDk() {
		return this.Dk;
	}
	
	/**
	 * Set a new value for the D constant
	 * 
	 * @param _Dk new value for the D constant
	 */
	public void setDk(double _Dk) {
		this.Dk = _Dk;
	}

	/**
	 * Get the name of the PID loop
	 * 
	 * @return the name of the PID loop
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get if the PID loop is using the rate over the position of an Encoder
	 * 
	 * @see edu.wpi.first.wpilibj.Encoder
	 * 
	 * @return true if the rate is used
	 */
	public boolean getUseRate() {
		return this.useRate;
	}
	
	/**
	 * Set the loop to use (or not use) the rate over the position of an Encoder
	 * 
	 * @param _useRate true if the rate should be used
	 */
	public void setUseRate(boolean _useRate) {
		this.useRate = _useRate;
	}

	/**
	 * Set the goal of the PID loop
	 * 
	 * @param _goalValue new goal value
	 */
	public void setGoal(double _goalValue) {
		this.goalValue = _goalValue;
	}
	
	public double getCurValue() {
		return curValue;
	}

	public void setCurValue(double curValue) {
		this.curValue = curValue;
	}

	/**
	 * Private method that gets a value from the Encoder or Potentiometer
	 */
	private void updateValues() {
		// Put save old value
		this.oldValue = curValue;

		// Checks for null sensor
		if (this.enc == null) {
			curValue = pot.get();
		} else if (useRate == true) {
			curValue = enc.getRate();
		} else if (useRate == false) {
			curValue = enc.get();
		} else {
			throw new NullPointerException("Null Potentiometer and Encoder links in PIDLoop: " + name);
		}
	}
	
	/**
	 * Does the math to figure out what the PID output should be. 
	 * 
	 * @return the output value of the loop
	 * 
	 * @see {@link http://www.csimn.com/CSI_pages/PIDforDummies.html}
	 */
	public double getPIDValue() {
		this.updateValues();
		timer.stop();
		if (iterations == 0) {
			return 0.0;
		}

		// Time for math.
		// Calculating P
		double Pvalue = this.Pk * (goalValue - curValue);

		// short circuit if the goal and current value are the same
		if (Pvalue == 0.0) {
			return 0.0;
		}
		
		// Calculating I
		double Ivalue = this.Ik * ((goalValue - this.curValue) * timer.getElapsed());

		// Calculating D
		double Dvalue = this.Dk * ((this.curValue - this.oldValue) / (timer.getElapsed()));

		timer.reset();
		timer.start();
		iterations += 1;
		double output = Pvalue + Ivalue + Dvalue;
		
		if (output > 1.0) {
			return 1.0;
		} else if (output < -1.0) {
			return -1.0;
		} else {
			return output;
		}
	}
	
	/**
	 * Gets an integrated value of getPIDValue(). This is good for situations where the goal is in rotations but you want the output to be a rate.
	 * 
	 * @return the a rate of the PID values
	 */
	public double getIntegratedPIDValue() {
		// Get the rate from above
		double rateValue = this.getPIDValue();

		// Add it to the previous value (integrating essentially)
		integralOut += rateValue;

		// Make sure it's in bounds
		if (Math.abs(integralOut) > 1.0) {
			if (integralOut > 1.0) {
				System.out.println("Hitting max in PIDLoop " + this.name);
				integralOut = 1.0;
			} else if (integralOut < -1.0) {
				System.out.println("Hitting min in PIDLoop " + this.name);
			}
		}

		return integralOut;
	}

}
