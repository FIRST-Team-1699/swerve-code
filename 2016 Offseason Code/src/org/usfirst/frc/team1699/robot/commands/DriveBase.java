package org.usfirst.frc.team1699.robot.commands;

public class DriveBase extends org.usfirst.frc.team1699.utils.command.Command{
  
  private CrabDrive crab;
  private SpinDrive spin;
  private UnicornDrive unicorn;

  public DriveBase(CrabDrive crab, SpinDrive spin, UnicornDrive unicorn, String name, int id) {
    super(name, id);
    this.crab = crab;
    this.spin = spin;
    this.unicorn = unicorn;
  }

  @Override
  public void init() {
    crab.init();
    spin.init();
    unicorn.init();
  }

  @Override
  public void run() {   
    crab.run();
    spin.run();
    unicorn.run();
  }

  @Override
  public void zeroAllSensors() {
    crab.zeroAllSensors();
    spin.zeroAllSensors();
    unicorn.zeroAllSensors();
  }

  @Override
  public boolean isFinished() {
    
    return false;
  }

}
