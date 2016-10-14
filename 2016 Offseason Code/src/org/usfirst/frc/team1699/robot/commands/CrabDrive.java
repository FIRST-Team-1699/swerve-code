/**
 * FIRST Team 1699
 * 
 * A command for Crab Drive
 * 
 * @author squirlemaster42, FIRST Team 1699
 */
package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.robot.swerve.SwerveDrive;

import edu.wpi.first.wpilibj.Joystick;

public class CrabDrive extends org.usfirst.frc.team1699.utils.command.Command {
	
	private SwerveDrive swerveDrive;
	private Joystick stick;

	public CrabDrive(SwerveDrive swerveDrive, Joystick stick, String name, int id) {
		super(name, id);

		this.swerveDrive = swerveDrive;
		this.stick = stick;

		// May change in the future
		if (!stick.getIsXbox()) {
			System.err.println(
					"Controller must be an Xbox controller. This will need to be remade or this class will not work.");
		}
	}

	@Override
	public void init() {

	}

	@Override
	public void run() {
		swerveDrive.CrabDrive(stick.getX(), stick.getY());
	}

	@Override
	public void zeroAllSensors() {

	}
	
	@Override
	public String toString() {
		return "UnicornDrive [swerveDrive=" + swerveDrive + ", stick=" + stick + "]";
	}
}
