package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.robot.Constants;
import org.usfirst.frc.team1699.robot.swerve.SwerveDrive;

import edu.wpi.first.wpilibj.Joystick;

/**
 *@author squirlemaster42 
 */
public class SpinDrive extends org.usfirst.frc.team1699.command.Command{

	private SwerveDrive swerveDrive;
	private Joystick stick;
	
    public SpinDrive(SwerveDrive swerveDrive, Joystick stick, String name, int id) {
    	super(name, id);
    	this.swerveDrive = swerveDrive;
		this.stick = stick;
    	
    	//May change in the future
    	if(!stick.getIsXbox()){
    		System.out.println("Controller must be an Xbox controller. This will need to be remade or this class will not work.");
    	}
    }

	@Override
	public void init() {
		
	}

	@Override
	public void run() {
		swerveDrive.RotateDrive(stick.getRawAxis(Constants.XBOXTRIGGERAXIS));
	}

	@Override
	public boolean isFinished() {
		
		return false;
	}
}
