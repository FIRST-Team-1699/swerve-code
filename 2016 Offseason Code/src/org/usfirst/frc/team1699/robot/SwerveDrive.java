package org.usfirst.frc.team1699.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.RobotDrive;

public class SwerveDrive extends RobotDrive {
	
	// Initializers
	private SwerveModule frontLeft;
	private SwerveModule backLeft;
	private SwerveModule frontRight;
	private SwerveModule backRight;	
	
	private iniReader config = new iniReader("1699-swerve-config.ini");
	
	// Rotation stuff
	final double FRAME_LENGTH = config.getValue("frameLength");
	final double FRAME_WIDTH = config.getValue("frameWidth");	
	
	final double ROTATE_ANGLE = Math.toDegrees(Math.atan(FRAME_LENGTH/FRAME_WIDTH));	
	
	final double X_DEADZONE = .07;
	final double Y_DEADZONE = .07;
	final double ROTATE_DEADZONE = .07;
	
	double speed = 0;
	double angle = 0;
	
	// Constructors
	public SwerveDrive(SwerveModule _frontLeft, SwerveModule _backLeft, SwerveModule _frontRight, SwerveModule _backRight)
	{
		super(_frontLeft.getDriveController(), _backLeft.getDriveController(), _frontRight.getDriveController(), _backRight.getDriveController());
		this.frontLeft = _frontLeft;
		this.backLeft = _backLeft;
		this.frontRight = _frontRight;
		this.backRight = _backRight;
	}
	
	// Methods
	// Crab Drive method
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
		
		Vector output = new Vector(speed, angle);
		
		frontLeft.setSpeedAngle(output);
		backLeft.setSpeedAngle(output);
		frontRight.setSpeedAngle(output);
		backRight.setSpeedAngle(output);
	}
	
	// Crab Drive method that returns an ArrayList containing four vectors
	public ArrayList<Vector> CrabDriveVectors(double xStick, double yStick)
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
				
		Vector output = new Vector(speed, angle);
		
		ArrayList<Vector> returned = new ArrayList<Vector>();
		returned.add(output); // frontLeft
		returned.add(output); // backLeft
		returned.add(output); // frontRight
		returned.add(output); // backRight
		
		return returned;
	}
	
	// Rotate Drive method
	public void RotateDrive(double ammount)
	{
		if (Math.abs(ammount) > ROTATE_DEADZONE)
		{
			Vector frontLeftVector = new Vector(ammount, 1 * ROTATE_ANGLE);
			Vector backLeftVector = new Vector(ammount, -1 * ROTATE_ANGLE);
			Vector frontRightVector = new Vector(ammount, -1 * ROTATE_ANGLE);
			Vector backRightVector = new Vector(ammount, 1 * ROTATE_ANGLE);
			
			frontLeft.setSpeedAngle(frontLeftVector);
			backLeft.setSpeedAngle(backLeftVector);
			frontRight.setSpeedAngle(frontRightVector);
			backRight.setSpeedAngle(backRightVector);
		}
	}
	
	// Rotate Drive method that returns an ArrayList containing four vectors
	public ArrayList<Vector> RotateDriveVectors(double ammount)
	{
		ArrayList<Vector> returned = new ArrayList<Vector>();
		
		if (Math.abs(ammount) > ROTATE_DEADZONE)
		{
			Vector frontLeftVector = new Vector(ammount, 1 * ROTATE_ANGLE);
			Vector backLeftVector = new Vector(ammount, -1 * ROTATE_ANGLE);
			Vector frontRightVector = new Vector(ammount, -1 * ROTATE_ANGLE);
			Vector backRightVector = new Vector(ammount, 1 * ROTATE_ANGLE);
			
			returned.add(frontLeftVector); // frontLeft
			returned.add(backLeftVector); // backLeft
			returned.add(frontRightVector); // frontRight
			returned.add(backRightVector); // backRight
		}
		else 
		{
			returned.add(new Vector());
			returned.add(new Vector());
			returned.add(new Vector());
			returned.add(new Vector());
		}
		
		return returned;
	}
	
	// Unicorn Drive method
	public void UnicornDrive(double xStick, double yStick, double rotateStick)
	{
		ArrayList<Vector> crabVectors = this.CrabDriveVectors(xStick, yStick);
		ArrayList<Vector> rotateVectors = this.RotateDriveVectors(rotateStick);
		
		frontLeft.setSpeedAngle(Vector.getResultantVector(crabVectors.get(0), rotateVectors.get(0)));
		backLeft.setSpeedAngle(Vector.getResultantVector(crabVectors.get(1), rotateVectors.get(1)));
		frontRight.setSpeedAngle(Vector.getResultantVector(crabVectors.get(2), rotateVectors.get(2)));
		backRight.setSpeedAngle(Vector.getResultantVector(crabVectors.get(3), rotateVectors.get(3)));
	}

}
