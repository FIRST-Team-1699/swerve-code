/**
 * FIRST Team 1699
 * 
 * A command for Unicorn Drive
 * 
 * @author squirlemaster42, FIRST Team 1699
 */
package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.robot.main.Constants;
import org.usfirst.frc.team1699.robot.swerve.SwerveDrive;

import edu.wpi.first.wpilibj.Joystick;

public class UnicornDrive extends org.usfirst.frc.team1699.utils.command.Command {
	
	// Needs to string
	private SwerveDrive swerveDrive;
	private Joystick stick;

	public UnicornDrive(SwerveDrive swerveDrive, Joystick stick, String name, int id) {
		super(name, id);

		this.swerveDrive = swerveDrive;
		this.stick = stick;

		// May change in the future
		if (!stick.getIsXbox()) {
			System.out.println(
					"Controller must be an Xbox controller. This will need to be remade or this class will not work.");
		}
	}

	@Override
	public void init() {

	}

	@Override
	public void run() {
		swerveDrive.UnicornDrive(stick.getX(), stick.getY(), stick.getRawAxis(Constants.XBOXTRIGGERAXIS));
	}

	@Override
	public void zeroAllSensors() {

	}

	@Override
	public boolean isFinished() {

		return false;
	}
}
