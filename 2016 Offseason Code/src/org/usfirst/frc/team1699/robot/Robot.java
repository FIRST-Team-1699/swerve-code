/*
 * FIRST Team 1699
 * 
 * Robot.java
 * 
 * @author thatging3rkid, FIRST Team 1699
 * @author squirlemaster42, FIRST Team 1699
 *
 */
package org.usfirst.frc.team1699.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;

public class Robot extends IterativeRobot {
	
	TalonSRX mod1Spin;
	TalonSRX mod1Drive;
	
	TalonSRX mod2Spin;
	TalonSRX mod2Drive;
	
	TalonSRX mod3Spin;
	TalonSRX mod3Drive;
	
	TalonSRX mod4Spin;
	TalonSRX mod4Drive;
	
	Joystick xboxDrive;
	
    public void robotInit() {
    	mod1Spin = new TalonSRX(Constants.MOD1SPIN);
    	mod1Drive = new TalonSRX(Constants.MOD1DRIVE);
    	
    	mod1Spin = new TalonSRX(Constants.MOD2SPIN);
    	mod1Drive = new TalonSRX(Constants.MOD2DRIVE);
    	
    	mod1Spin = new TalonSRX(Constants.MOD3SPIN);
    	mod1Drive = new TalonSRX(Constants.MOD3DRIVE);
    	
    	mod1Spin = new TalonSRX(Constants.MOD4SPIN);
    	mod1Drive = new TalonSRX(Constants.MOD4DRIVE);
    	
    	xboxDrive = new Joystick(Constants.XBOXDRIVEPORT);
    }
    
    public void autonomousInit() {
    
    }
    
    public void autonomousPeriodic() {
    	
    }

    public void teleopInit() {
    	
    }
    
    public void teleopPeriodic() {
    	
    }
}
