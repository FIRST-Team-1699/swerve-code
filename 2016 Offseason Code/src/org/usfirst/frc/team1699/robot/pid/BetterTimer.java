/*
 * FIRST Team 1699
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 * A timer object that actually times.
 */
package org.usfirst.frc.team1699.robot.pid;

public class BetterTimer extends edu.wpi.first.wpilibj.Timer 
{

	// Initializers
	private Double startTime;
	private Double endTime;
	private Double timePassed;
	
	
	// Constructor
	public BetterTimer()
	{
		super();
		this.timePassed = (double) 0;
	}
	
	
	// Methods
	public void start()
	{
		if (this.startTime == null) {System.out.println("User tried to start a started timer.");}
		else {this.startTime = super.getFPGATimestamp();}
	}

	public void stop()
	{
		if (this.endTime == null) {System.out.println("User tried to end a finished timer.");}
		else {this.endTime = super.getFPGATimestamp();}
		this.timePassed = Math.abs(startTime - endTime);
	}
	
	public void reset()
	{
		this.startTime = null;
		this.endTime = null;
	}
	
	public double getElapsed()
	{
		if ((startTime == null) || (endTime == null)) {throw new NullPointerException("Bad startTime or endTime in BetterTimer");}
		return this.timePassed;
	}

}
