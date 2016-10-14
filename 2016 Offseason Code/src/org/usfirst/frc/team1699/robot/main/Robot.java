/**
 * FIRST Team 1699
 * 
 * Robot.java
 * 
 * @author thatging3rkid, FIRST Team 1699
 * @author squirlemaster42, FIRST Team 1699
 *
 */
package org.usfirst.frc.team1699.robot.main;

import org.usfirst.frc.team1699.robot.commands.CrabDrive;
import org.usfirst.frc.team1699.robot.commands.DriveBase;
import org.usfirst.frc.team1699.robot.commands.SpinDrive;
import org.usfirst.frc.team1699.robot.commands.UnicornDrive;
import org.usfirst.frc.team1699.robot.swerve.SwerveDrive;
import org.usfirst.frc.team1699.robot.swerve.SwerveModule;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;

public class Robot extends IterativeRobot {

  private TalonSRX mod1Spin;
  private TalonSRX mod1Drive;

  private TalonSRX mod2Spin;
  private TalonSRX mod2Drive;

  private TalonSRX mod3Spin;
  private TalonSRX mod3Drive;

  private TalonSRX mod4Spin;
  private  TalonSRX mod4Drive;

  private Joystick xboxDrive;

  private SwerveModule frontLeft;
  private SwerveModule frontRight;
  private SwerveModule backLeft;
  private SwerveModule backRight;

  private SwerveDrive swerveDrive;

  private CrabDrive crab;
  private SpinDrive spin;
  private UnicornDrive unicorn;
  private DriveBase drive;

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

    this.frontLeft = new SwerveModule("frontLeft", mod1Drive, mod1Spin, null, null); // needs
                                                                                     // completion0
    this.backLeft = new SwerveModule("backLeft", mod2Drive, mod2Spin, null, null);
    this.frontRight = new SwerveModule("frontRight", mod3Drive, mod3Spin, null, null);
    this.backRight = new SwerveModule("backRight", mod4Drive, mod4Spin, null, null);

    this.swerveDrive =
        new SwerveDrive(this.frontLeft, this.backLeft, this.frontRight, this.backRight, 25, 25);

    crab = new CrabDrive(swerveDrive, xboxDrive, "crabDrive", 1);
    spin = new SpinDrive(swerveDrive, xboxDrive, "spinDrive", 2);
    unicorn = new UnicornDrive(swerveDrive, xboxDrive, "unicornDrive", 3);
    drive = new DriveBase(crab, spin, unicorn, "driveBase", 0);
    drive.init();
  }

  public void autonomousInit() {

  }

  public void autonomousPeriodic() {
    
  }

  public void teleopInit() {
    
  }

  public void teleopPeriodic() {
    drive.run();
  }
}
