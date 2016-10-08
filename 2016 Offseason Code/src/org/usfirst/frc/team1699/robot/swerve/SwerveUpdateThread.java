/**
 * FIRST Team 1699
 * 
 * This class updates all the PIDLoops and does it as a thread, instead of on the main robot thread.
 * 
 * @author thatging3rkid, FIRST Team 1699
 * @author squirlemaster42, FIRST Team 1699
 *
 * @see http://www.tutorialspoint.com/java/java_multithreading.htm
 * 
 */
package org.usfirst.frc.team1699.robot.swerve;

import edu.wpi.first.wpilibj.DriverStation;

@Deprecated 
public class SwerveUpdateThread extends Thread {

  // Initializers
  private SwerveModule module1;
  private SwerveModule module2;
  private SwerveModule module3;
  private SwerveModule module4;

  private Thread thread;

  private DriverStation ds = DriverStation.getInstance();

  // Constructor
  public SwerveUpdateThread(SwerveModule _module1, SwerveModule _module2, SwerveModule _module3,
      SwerveModule _module4) {
    this.module1 = _module1;
    this.module2 = _module2;
    this.module3 = _module3;
    this.module4 = _module4;
  }

  // Thread methods
  public void start() {
    // A start-up debugging check
    System.out.println("|--------------------------------------------------------|");
    System.out.println("| Team 1699 SwerveUpdateThread Starting                  |");
    System.out.println("|--------------------------------------------------------|");

    // Thread this object
    if (thread == null) {
      this.thread = new Thread(this, "SwerveUpdateThread");
      thread.start();
    }
  }

  public void run() {
    // This infinite while loop keeps the thread from dying. It might need to be changed so that the
    // run() method is called when the robot is enabled.
    while (true) {

      // Right now, this updates all the modules in one order. This should be tested, to make sure
      // one module does not "lead" the others
      while (ds.isEnabled()) {
        module1.updateSpinPID();
        module1.updateDrivePID();

        module2.updateSpinPID();
        module2.updateDrivePID();

        module3.updateSpinPID();
        module3.updateDrivePID();

        module4.updateSpinPID();
        module4.updateDrivePID();

        // Sleepy time
        try {
          Thread.sleep(50); // again, this value should be adjusted so that that the robot isn't
                            // trying to update PID 1000s of times per second
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      // To keep the thread from checking if the robot is enabled 1000s of times per second
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }
}
