/*
 * FIRST Team 1699
 * 
 * This class stores a vector quantity, instead of a scalar.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot.swerve;


public class Vector
{
	// Initializers
	private double angle;
	private double value;
	
	
	// Constructors
	public Vector()
	{
		this.angle = 0;
		this.value = 0;
	}
	
	public Vector(double _value, double _angle)
	{
		this.angle = _angle;
		this.value = _value;
	}
	
	
	// Get and set methods
	public void setAngle(double _angle) {this.angle = _angle;}
	public void setValue(double _value) {this.value = _value;}
	
	public double getAngle() {return angle;}
	public double getValue() {return value;}
	
	
	// Methods
	// Adds two vectors and sets the current vector to the resultant
	public void setToResultantVector(Vector v1, Vector v2)
	{
		double v1x = v1.getValue() * Math.cos(Math.toRadians(v1.getAngle()));
		double v1y = v1.getValue() * Math.sin(Math.toRadians(v1.getAngle()));
		
		double v2x = v2.getValue() * Math.cos(Math.toRadians(v2.getAngle()));
		double v2y = v2.getValue() * Math.sin(Math.toRadians(v2.getAngle()));
		
		try {this.angle = Math.toDegrees(Math.atan((v1y + v2y)/(v1x + v2x)));}
		catch (ArithmeticException e) {this.angle = 0;} // Divide-by-zero catch
		this.value = Math.hypot((v1x + v2x), (v1y + v2y));
	}
	
	// Returns the resultant of two vectors
	static public Vector getResultantVector(Vector v1, Vector v2)
	{
		Vector resultant = new Vector(0, 0);
		
		double v1x = v1.getValue() * Math.cos(Math.toRadians(v1.getAngle()));
		double v1y = v1.getValue() * Math.sin(Math.toRadians(v1.getAngle()));
		
		double v2x = v2.getValue() * Math.cos(Math.toRadians(v2.getAngle()));
		double v2y = v2.getValue() * Math.sin(Math.toRadians(v2.getAngle()));
		
		try {resultant.setAngle(Math.toDegrees(Math.atan((v1y + v2y)/(v1x + v2x))));}
		catch (ArithmeticException e) {resultant.setAngle(0);} // Divide-by-zero catch
		resultant.setValue(Math.hypot((v1x + v2x), (v1y + v2y)));
		
		return resultant;
	}
	
	// toString() method
	public String toString()
	{
		return "" + value + " at " + angle + "°";
	}
}
