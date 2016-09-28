package org.usfirst.frc.team1699.Utils;

public class Math{
	
	public double joystickMagnitude(double x, double y){
		//Write method to take x and y produced by xbox joystick and transform it into a single value that is the magnitude of the joystick.
		return java.lang.Math.sqrt(java.lang.Math.pow(x, 2) + java.lang.Math.pow(y, 2));
	}
	
	public double joystickDirection(double x, double y){
		//Write method to determine direction of joystick, should return value between 0 and 360.
		return 0.0;
	}
}
