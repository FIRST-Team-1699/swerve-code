/**
 * FIRST Team 1699
 * 
 * A command for Rotate/Spin Drive
 * 
 * @author squirlemaster42, FIRST Team 1699
 */
package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.robot.main.Constants;
import org.usfirst.frc.team1699.robot.swerve.SwerveDrive;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Command for spin drive
 */
public class SpinDrive extends org.usfirst.frc.team1699.utils.command.Command {

	private SwerveDrive swerveDrive;
	private Joystick stick;
	private boolean altControls = false;
	
	/**
	 * Constructor for Crab Drive
	 * 
	 * @param swerveDrive
	 * 			reference to the swerve drive
	 * @param stick
	 * 			reference to a joy stick
	 * @param name
	 * 			name for command
	 * @param id
	 * 			id for command
	 */
	public SpinDrive(SwerveDrive swerveDrive, Joystick stick, String name, int id) {
		super(name, id);
		this.swerveDrive = swerveDrive;
		this.stick = stick;

		// May change in the future
		if (!stick.getIsXbox()) {
			altControls = true;
		}
	}

	@Override
	public void init() {

	}

	@Override
	public void run() {
		if(altControls){
			swerveDrive.RotateDrive(stick.getTwist());
		}else{
			swerveDrive.RotateDrive(stick.getRawAxis(Constants.XBOXTRIGGERAXIS));
		}
	}

	@Override
	public void zeroAllSensors() {

	}
	
	public boolean getAltControls(){
		return altControls;
	}
	
	@Override
	public void outputToDashBoard() {
		
	}

	@Override
	public String toString() {
		return "SpinDrive [swerveDrive=" + swerveDrive + ", stick=" + stick + "]";
	}

}
