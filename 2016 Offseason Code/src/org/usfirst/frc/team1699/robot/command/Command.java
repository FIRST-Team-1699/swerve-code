package org.usfirst.frc.team1699.robot.command;

public abstract class Command {

  private String name;
  private int id;

  // id is used for commands run in auto. It should be set to and integer value that corresponds to
  // the value used when wanting to call the command from the autonomous file.
  public Command(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public abstract void init();

  public abstract void run();

  public abstract void zeroAllSensors(); // zeroAllSensors may need to be looked at and changed

  public abstract boolean isFinished();

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Command [name=" + name + ", id=" + id + "]";
  }
}
