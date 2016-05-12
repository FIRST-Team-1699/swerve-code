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
	
	String name;
	
	
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
	public void setGoal(double _goalValue) {this.goalValue = _goalValue;}

	
	// Methods
	private void updateValues()
	{
		// Put save old value
		this.oldValue = curValue;
		
		// Checks for null sensor
		if (this.pot == null) {curValue = enc.get();}
		else if (this.enc == null) {curValue = pot.get();}
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
}
