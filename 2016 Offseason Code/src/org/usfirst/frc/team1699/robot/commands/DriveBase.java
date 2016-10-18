/**
 * FIRST Team 1699
 * 
 * This class is the command for the drive base.
 * 
 * @author squirlemaster42, FIRST Team 1699
 * 
 * @version v0.2-norobot
 */
package org.usfirst.frc.team1699.robot.commands;

/**
 * Command for drive base
 */
public class DriveBase extends org.usfirst.frc.team1699.utils.command.Command {

	private CrabDrive crab;
	private SpinDrive spin;
	private UnicornDrive unicorn;

	/**
	 * Constructor for Drive Base
	 * @param crab
	 * 			reference to the crab drive
	 * @param spin
	 * 			reference to the spin drive
	 * @param unicorn
	 * 			reference to the unicorn drive
	 * @param name
	 * 			name for command
	 * @param id
	 * 			id for command
	 */
	public DriveBase(CrabDrive crab, SpinDrive spin, UnicornDrive unicorn, String name, int id) {
		super(name, id);
		this.crab = crab;
		this.spin = spin;
		this.unicorn = unicorn;
	}

	@Override
	public void init() {
		crab.init();
		spin.init();
		unicorn.init();
	}

	@Override
	public void run() {
		crab.run();
		spin.run();
		unicorn.run();
	}

	@Override
	public void zeroAllSensors() {
		crab.zeroAllSensors();
		spin.zeroAllSensors();
		unicorn.zeroAllSensors();
	}
	
	@Override
	public String toString() {
		return "DriveBase [crab=" + crab + ", spin=" + spin + ", unicorn=" + unicorn + "]";
	}
}
