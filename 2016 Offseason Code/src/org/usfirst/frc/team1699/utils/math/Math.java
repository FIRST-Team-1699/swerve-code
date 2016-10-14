/**
 * A class containing some math-based utilities.
 * 
 * @author squirlemaster42, FIRST Team 1699
 */
package org.usfirst.frc.team1699.utils.math;

public class Math {

  // May not be needed

  public double joystickMagnitude(double x, double y) {
    // Write method to take x and y produced by xbox joystick and transform it into a single value
    // that is the magnitude of the joystick.
    return java.lang.Math.sqrt(java.lang.Math.pow(x, 2) + java.lang.Math.pow(y, 2));
  }

  public double joystickDirection(double x, double y) {
    // Write method to determine direction of joystick, should return value between 0 and 360.
    return 0.0;
  }
}
