/**
 * FIRST Team 1699
 * 
 * This is a class that, when executed, updates all the SwerveModules given to it.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 */
package org.usfirst.frc.team1699.robot.swerve;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Updates the PID loops of some SwerveModule objects.
 * 
 * @inheritDoc
 */
public class SwerveUpdateRunnable implements Runnable {

	private DriverStation ds;

	private ArrayList<SwerveModule> modules;

	/**
	 * Constructor for the SwerveUpdateRunnable
	 * 
	 * @param _ds reference to the DriverStation instance
	 * @param _modules an ArrayList of SwerveModules
	 */
	public SwerveUpdateRunnable(DriverStation _ds, ArrayList<SwerveModule> _modules) {
		this.ds = _ds;
		this.modules = _modules;
	}

	/**
	 * Overridden run method, updates all the spin and drive PID loops in the ArrayList of SwerveModule objects.
	 */
	@Override
	public void run() {
		/* Note: it is surrounded in a try/catch to catch any stray 
		 * Exceptions that rise
	 	 */
		try {
			// Check if the robot is enabled
			if (ds.isEnabled()) {
				for (SwerveModule module : modules) {
					module.updateSpinPID();
					module.updateDrivePID();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
