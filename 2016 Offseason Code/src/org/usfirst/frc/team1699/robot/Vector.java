/*
 * FIRST Team 1699
 * 
 * This class stores a vector quantity, instead of a scalar.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot;

public class Vector
{

	private double angle;
	private double value;
	
	public Vector(double _value, double _angle)
	{
		this.angle = _angle;
		this.value = _value;
	}
	
	public void setAngle(int _angle) {this.angle = _angle;}
	public void setValue(int _value) {this.value = _value;}
	

	public double getAngle() {return angle;}
	public double getValue() {return value;}
	
	public String toString()
	{
		return "" + value + " at " + angle;
	}
}
