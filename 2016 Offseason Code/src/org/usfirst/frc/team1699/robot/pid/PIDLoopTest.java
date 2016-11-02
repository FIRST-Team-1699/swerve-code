package org.usfirst.frc.team1699.robot.pid;

public class PIDLoopTest {
  
	public static void main(String[] args) {
		// code to test pid loop with graphing here
		// i will work on this -> @thatging3rkid
    
		/* general code overview:
		 * 
		 * make a encoder simulator that outputs a value from a source on command
		 * 
		 * graph the output from the pid loop
		 * 
		 * make adjustments until it works, hopefully
		 *  
		 */
	  
		double currentTestValue = 0.0;
	    
		EncoderEmulator enc = new EncoderEmulator(currentTestValue);
	  	PIDLoop pid = null;
	  
	  	pid = new PIDLoop(null, 0, 0, 0);
	  	runLoop(enc, pid);
	}
	  
	  public static void runLoop(EncoderEmulator enc, PIDLoop pid){
		  pid.setCurValue(enc.getCurrentPos());
		  for(int i = 0; i <= 360; i++){
			  pid.setGoal(i);
			  System.out.println(pid.getPIDValue());
		  }
	  }
}
