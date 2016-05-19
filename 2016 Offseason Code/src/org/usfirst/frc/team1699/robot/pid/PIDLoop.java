/*
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

public class PIDLoop
{

	// Initializers
	double Pk;
	double Ik;
	double Dk;
	double Pvalue;
	double Ivalue;
	double Dvalue;
	
	Potentiometer pot;
	Encoder enc;
	double curValue;
	double oldValue;
	double goalValue;
	
	BetterTimer timer = new BetterTimer();
	long iterations = 0;
	double integralOut = 0;
	
	String name;
	
	boolean useRate = false;
	
	
	// Constructors
	public PIDLoop(String _name, double _Pk, double _Ik, double _Dk, Potentiometer _pot)
	{
		this.name = _name;
		this.Pk = _Pk;
		this.Ik = _Ik;
		this.Dk = _Dk;
		this.pot = _pot;
		this.updateValues();
	}
	
	public PIDLoop(String _name, double _Pk, double _Ik, double _Dk, Encoder _enc)
	{
		this.name = _name;
		this.Pk = _Pk;
		this.Ik = _Ik;
		this.Dk = _Dk;
		this.enc = _enc;
		this.updateValues();
	}
	
	
	// Getters and Setters
	public boolean getUseRate() {return this.useRate;}
	public void setUseRate(boolean _useRate) {this.useRate = _useRate;}
	public void setGoal(double _goalValue) {this.goalValue = _goalValue;}

	// Methods
	private void updateValues()
	{
		// Put save old value
		this.oldValue = curValue;
		
		// Checks for null sensor
		if (this.enc == null) {curValue = pot.get();}
		else if (useRate == true) {curValue = enc.getRate();}
		else if (useRate == false) {curValue = enc.get();}
		else {throw new NullPointerException("Null Potentiometer and Encoder links in PIDLoop: " + name);}
	}
	
	public double getPIDValue()
	{
		this.updateValues();
		timer.stop();
		if (iterations == 0) {return 0.0;}
		
		// Time for math.
		// Calculating P
		this.Pvalue = this.Pk * (goalValue - curValue);
		
		// Calculating I
		this.Ivalue = this.Ik * (((this.oldValue + this.curValue) * timer.getElapsed()) / 2); 
		
		// Calculating D
		this.Dvalue = this.Dk * ((this.curValue - this.oldValue) / (timer.getElapsed()));
		
		timer.start();
		iterations += 1;
		return Pvalue + Ivalue+ Dvalue;
		
	}
	
	public double getIntegratedPIDValue()
	{
		// Get the rate from above
		double rateValue = this.getPIDValue();
		
		// Add it to the previous value (integrating essentially)
		integralOut += rateValue;
		
		// Make sure it's in bounds
		
		if (Math.abs(integralOut) > 1.0)
		{
			if(integralOut > 1.0)
			{
				System.out.println("Hitting max in PIDLoop " + this.name);
				integralOut = 1.0;
			}
			else if (integralOut < -1.0)
			{
				System.out.println("Hitting min in PIDLoop " + this.name);
			}
		}
		
		return integralOut;
	}
	
}
