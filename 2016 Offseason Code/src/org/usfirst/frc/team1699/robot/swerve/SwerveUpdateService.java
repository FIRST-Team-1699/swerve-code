/**
 * FIRST Team 1699
 * 
 * This class updates all the PIDLoops and does it as a service, instead of on the main robot
 * thread.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * 
 * @see {@link https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledExecutorService.html}
 * 
 */
package org.usfirst.frc.team1699.robot.swerve;

import java.util.ArrayList;
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

	private ArrayList<SwerveModule> modules;

	private DriverStation ds = DriverStation.getInstance();

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	/**
	 * Constructor for a SwerveUpdateService
	 * 
	 * @param _modules an ArrayList of modules
	 */
	public SwerveUpdateService(ArrayList<SwerveModule> _modules) {
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
		ArrayList<SwerveModule> singleModule = new ArrayList<>();
		singleModule.add(module);
		final SwerveUpdateRunnable run = new SwerveUpdateRunnable(this.ds, singleModule);
		@SuppressWarnings("unused")
		final ScheduledFuture<?> future = scheduler.schedule(run, 0, TimeUnit.MILLISECONDS);
	}

	/**
	 * A method that starts updating all the modules provided
	 */
	public void updateModules() {
		final SwerveUpdateRunnable run = new SwerveUpdateRunnable(this.ds, this.modules);
		// scheduler.scheduleWithFixedDelay(reference to Runnable class, 
		// initial delay, time between executions, unit);
		@SuppressWarnings("unused")
		final ScheduledFuture<?> future = scheduler.scheduleWithFixedDelay(run, 100, 100, TimeUnit.MILLISECONDS);
	}

}
