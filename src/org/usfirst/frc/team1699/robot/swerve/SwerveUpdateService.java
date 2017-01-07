/**
 * FIRST Team 1699
 * 
 * This class updates all the PIDLoops and does it as a service, instead of on the main robot thread.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 * @see {@link https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledExecutorService.html}
 * 
 */
package org.usfirst.frc.team1699.robot.swerve;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * A service that updates SwerveModule objects at a set interval or individually
 * 
 * @see {@link java.util.concurrent.SchdeuledExecutorService}
 */
public class SwerveUpdateService {
	
	public static final int INITIAL_DELAY = 100;
	public static final int EXECUTION_DELAY = 100;

	private List<SwerveModule> modules;

	private DriverStation ds = DriverStation.getInstance();

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2); 
	// ^ 2 threads not be enough if you start doing individual module updates

	/**
	 * Constructor for a SwerveUpdateService
	 * 
	 * @param _modules an ArrayList of modules
	 */
	public SwerveUpdateService(List<SwerveModule> _modules) {
		this.modules = _modules;

		// A start-up debugging check
		System.out.println("|--------------------------------------------------------|");
		System.out.println("| Team 1699 SwerveUpdateService Starting                 |");
		System.out.println("|--------------------------------------------------------|");

		// Also, a debugging check
		if (this.modules.size() != 4) {
			System.err.println("Starting with " + this.modules.size() + " SwerveModules");
		}
	}

	/**
	 * A single module update, should only be used in special situations
	 * 
	 * @param module a single module to update
	 */
	public void updateModule(SwerveModule module) {
		@SuppressWarnings("unused")
		final ScheduledFuture<?> future = scheduler.schedule(new Thread(() -> {
			// Also a lambda, see the comment in the start method
			try {
				// Check if the robot is enabled
				if (ds.isEnabled()) {
					module.updateSpinPID();
					module.updateDrivePID();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}), 0, TimeUnit.MILLISECONDS);
	}

	/**
	 * A method that starts updating all the modules provided
	 */
	public void start() {
		// scheduler.scheduleWithFixedDelay(reference to Runnable class, 
		// initial delay, time between executions, unit);
		@SuppressWarnings("unused")
		final ScheduledFuture<?> future = scheduler.scheduleWithFixedDelay(new Thread(() -> {
			// This is a lambda, the Thread is written here instead of in it's own file. 
			// I (thatging3rkid) chose to use a lambda here (because they're cool),
			// but also because they are extremely powerful once understood.
			// link to help: http://www.developer.com/java/start-using-java-lambda-expressions.html
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
		}), SwerveUpdateService.INITIAL_DELAY, SwerveUpdateService.EXECUTION_DELAY, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Old method for starts updateing all the modules. It is functionally the same as the start() method.
	 * 
	 * It was renamed to make it clearer that the method only needs to be called once.
	 */
	@Deprecated
	public void updateModules() {
		// updateModules sounds like it should be repeated, while start implies that it is a one time thing
		this.start();
	}

}
