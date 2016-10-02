package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.robot.swerve.SwerveDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UnicornDrive extends Command {

	private SwerveDrive swerveDrive;
	private Joystick stick;
	
    public UnicornDrive(SwerveDrive swerveDrive, Joystick stick) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	this.swerveDrive = swerveDrive;
		this.stick = stick;
    	
    	//May change in the future
    	if(!stick.getIsXbox()){
    		System.out.println("Controller must be an Xbox controller. This will need to be remade or this class will not work.");
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int amount = 0;
    	swerveDrive.UnicornDrive(stick.getX(), stick.getY(), amount);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
