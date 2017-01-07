/**
 * FIRST Team 1699
 * 
 * This class stores a vector quantity, instead of a scalar.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot.swerve;

/**
 * A number that has a magnitude (value) and direction (angle). 
 */
public class Vector {
	
	private double angle;
	private double value;

	/**
	 * Constructor where the variables are added later
	 */
	public Vector() {
		this.angle = 0.0;
		this.value = 0.0;
	}

	/**
	 * The suggested constructor
	 * 
	 * @param value magnitude
	 * @param angle angle
	 */
	public Vector(double value, double angle) {
		this.angle = angle;
		this.value = value;
	}

	/**
	 * Set the angle
	 * 
	 * @param angle new angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * Set the value
	 * 
	 * @param value new value
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * Get the angle
	 * 
	 * @return the angle
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * Get the value
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Adds two vectors and sets the current vector to the resultant
	 * 
	 * @param v1 Vector 1
	 * @param v2 Vector 2
	 */
	public void setToResultantVector(Vector v1, Vector v2) {
		double v1x = v1.getValue() * Math.cos(Math.toRadians(v1.getAngle()));
		double v1y = v1.getValue() * Math.sin(Math.toRadians(v1.getAngle()));

		double v2x = v2.getValue() * Math.cos(Math.toRadians(v2.getAngle()));
		double v2y = v2.getValue() * Math.sin(Math.toRadians(v2.getAngle()));

		try {
			this.angle = Math.toDegrees(Math.atan((v1y + v2y) / (v1x + v2x)));
		} catch (ArithmeticException e) {
			this.angle = 0; // Divide-by-zero catch
		}
		this.value = Math.hypot((v1x + v2x), (v1y + v2y));
	}

	/**
	 * Returns the resultant of two vectors
	 * 
	 * @param v1 Vector 1
	 * @param v2 Vector 2
	 * @return the vector addition of v1 and v2
	 */
	public static Vector getResultantVector(Vector v1, Vector v2) {
		Vector resultant = new Vector(0, 0);

		double v1x = v1.getValue() * Math.cos(Math.toRadians(v1.getAngle()));
		double v1y = v1.getValue() * Math.sin(Math.toRadians(v1.getAngle()));

		double v2x = v2.getValue() * Math.cos(Math.toRadians(v2.getAngle()));
		double v2y = v2.getValue() * Math.sin(Math.toRadians(v2.getAngle()));

		try {
			resultant.setAngle(Math.toDegrees(Math.atan((v1y + v2y) / (v1x + v2x))));
		} catch (ArithmeticException e) {
			resultant.setAngle(0); // Divide-by-zero catch
		}
		resultant.setValue(Math.hypot((v1x + v2x), (v1y + v2y)));

		return resultant;
	}

	/**
	 * toString() method
	 * 
	 * @return a String representing the vector
	 */
	@Override
	public String toString() {
		return "" + value + " at " + angle + "°";
	}

	/**
	 * Generates a hash code for the Vector
	 * 
	 * @return a hash code
	 */
	@Override
	public int hashCode() {
		return Integer.parseInt("" + ((Double) value).hashCode() + ((Double) angle).hashCode());
	}

	/**
	 * Tells if two objects are equal
	 * 
	 * @param o an Object to compare to
	 * @return true if the objects have the same angle and value
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Vector) {
			return (angle == ((Vector) o).getAngle()) && (value == ((Vector) o).getValue());
		}
		return false;
	}
}
