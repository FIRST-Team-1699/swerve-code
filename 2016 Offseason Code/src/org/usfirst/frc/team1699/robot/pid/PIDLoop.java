/**
 * FIRST Team 1699
 * 
 * This class is a PID Loop.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot.pid;

import org.usfirst.frc.team1699.robot.pid.sensors.PIDSensor;

/**
 * A PID Loop that is less restrictive than WPILib's. 
 * 
 * @author thatging3rkid, FIRST Team 1699
 */
public class PIDLoop {
	
	private String name;
	private double Pk;
	private double Ik;
	private double Dk;

	private double Istore = 0;
	private double Dtemp = 0;
	
	private double goal;
	
	private PIDSensor sens;
	
	/**
	 * Creates a PID loop that automatically gets the value from a source.
	 * 
	 * @param _name name of the PID loop, used for debugging
	 * @param _Pk P constant
	 * @param _Ik I constant
	 * @param _Dk D constant
	 * @param _pot Potentiometer to read from
	 */
	public PIDLoop(String name, double Pk, double Ik, double Dk, PIDSensor sens) {
		this.name = name;
		this.Pk = Pk;
		this.Ik = Ik;
		this.Dk = Dk;
		this.sens = sens;
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
	public void setPk(double Pk) {
		this.Pk = Pk;
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
	public void setIk(double Ik) {
		this.Ik = Ik;
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
	public void setDk(double Dk) {
		this.Dk = Dk;
	}

	/**
	 * Set the goal of the PID loop
	 * 
	 * @param _goalValue new goal value
	 */
	public void setGoal(double goal) {
		this.goal = goal;
	}
	
	/**
	 * Does the math to figure out what the PID output should be. 
	 * 
	 * @return the output value of the loop
	 * 
	 * @see <a url=http://www.csimn.com/CSI_pages/PIDforDummies.html>http://www.csimn.com/CSI_pages/PIDforDummies.html</a>
	 */
	public double output() {
		
		// Time for math.
		// Calculating P
		double err = (goal - sens.get());
		
		double Pvalue = this.Pk * err;

		this.Istore += err;
		
		// short circuit if the goal and current value are the same
		if ((Pvalue == 0.0) && (this.Pk != 0)) {
			return 0.0;
		}
		
		// Calculating I
		double Ivalue = this.Ik * Istore;

		// Calculating D
		double Dvalue = this.Dk * (Dtemp - err);

		this.Dtemp = err;
		
		double output = Pvalue + Ivalue + Dvalue;
		
		return output;
		
	}
	
	/**
	 * Legacy 
	 */
	@Deprecated
	public double getPIDValue() {
		return this.output();
	}
}
