package org.usfirst.frc.team1699.robot;

import edu.wpi.first.wpilibj.RobotDrive;

public class SwerveDrive extends RobotDrive {

	private SwerveModule frontLeft;
	private SwerveModule backLeft;
	private SwerveModule frontRight;
	private SwerveModule backRight;	
	
	final double X_DEADZONE = .07;
	final double Y_DEADZONE = .07;
	
	double speed = 0;
	double angle = 0;
	
	public SwerveDrive(SwerveModule _frontLeft, SwerveModule _backLeft, SwerveModule _frontRight, SwerveModule _backRight)
	{
		super(_frontLeft.getDriveController(), _backLeft.getDriveController(), _frontRight.getDriveController(), _backRight.getDriveController());
		this.frontLeft = _frontLeft;
		this.backLeft = _backLeft;
		this.frontRight = _frontRight;
		this.backRight = _backRight;
	}
	
	public void CrabDrive(double xStick, double yStick)
	{		
		// Check if in deadzone
		if (((xStick + X_DEADZONE) >= 0) && ((yStick + Y_DEADZONE) >= 0) && ((xStick - X_DEADZONE) < 0) && ((yStick + Y_DEADZONE) < 0))
		{
			speed = 0;
		}
		else
		{			
			speed = Math.hypot(xStick, yStick);
			angle = Math.atan(yStick / xStick);
			// angle needs conversion to meet the output from the encoder
			angle = Math.toDegrees(angle);
		}
		
		frontLeft.setAngle(angle);
		backLeft.setAngle(angle);
		frontRight.setAngle(angle);
		backRight.setAngle(angle);
		
		frontLeft.setSpeed(speed);
		backLeft.setSpeed(speed);
		frontRight.setSpeed(speed);
		backRight.setSpeed(speed);
	}

}
