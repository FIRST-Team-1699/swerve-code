/**
 * FIRST Team 1699
 * 
 * Robot.java
 * 
 * @author thatging3rkid, FIRST Team 1699
 * @author squirlemaster42, FIRST Team 1699
 *
 */
package org.usfirst.frc.team1699.robot;

import org.usfirst.frc.team1699.robot.commands.CrabDrive;
import org.usfirst.frc.team1699.robot.swerve.SwerveDrive;
import org.usfirst.frc.team1699.robot.swerve.SwerveModule;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;

public class Robot extends IterativeRobot { // should this be Command based?
	
	// should these be private?
	TalonSRX mod1Spin;
	TalonSRX mod1Drive;
	
	TalonSRX mod2Spin;
	TalonSRX mod2Drive;
	
	TalonSRX mod3Spin;
	TalonSRX mod3Drive;
	
	TalonSRX mod4Spin;
	TalonSRX mod4Drive;
	
	Joystick xboxDrive;
	
	SwerveModule frontLeft;
	SwerveModule frontRight;
	SwerveModule backLeft;
	SwerveModule backRight;
	
	SwerveDrive swerveDrive;
	
	CrabDrive crab;
	
    public void robotInit() {
    	this.mod1Spin = new TalonSRX(Constants.MOD1SPIN);
    	this.mod1Drive = new TalonSRX(Constants.MOD1DRIVE);
    	
    	this.mod2Spin = new TalonSRX(Constants.MOD2SPIN);
    	this.mod2Drive = new TalonSRX(Constants.MOD2DRIVE);
    	
    	this.mod3Spin = new TalonSRX(Constants.MOD3SPIN);
    	this.mod3Drive = new TalonSRX(Constants.MOD3DRIVE);
    	
    	this.mod4Spin = new TalonSRX(Constants.MOD4SPIN);
    	this.mod4Drive = new TalonSRX(Constants.MOD4DRIVE);
    	
    	this.xboxDrive = new Joystick(Constants.XBOXDRIVEPORT);
    	
    	this.frontLeft = new SwerveModule("frontLeft", mod1Drive, mod1Spin, null, null); //needs completion
    	this.backLeft = new SwerveModule("backLeft", mod2Drive, mod2Spin, null, null);
    	this.frontRight = new SwerveModule("frontRight", mod3Drive, mod3Spin, null, null);
    	this.backRight = new SwerveModule("backRight", mod4Drive, mod4Spin, null, null);
    	
    	this.swerveDrive = new SwerveDrive(this.frontLeft, this.backLeft, this.frontRight, this.backRight, 25, 25);
    	
    	crab = new CrabDrive(swerveDrive, xboxDrive, "crabDrive", 1);
    }
    
    public void autonomousInit() {
    
    }
    
    public void autonomousPeriodic() {
    	
    }

    public void teleopInit() {
    	
    }
    
    public void teleopPeriodic() {
    	//crab.execute();
    }
}
