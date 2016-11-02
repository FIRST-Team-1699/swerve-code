package org.usfirst.frc.team1699.robot.pid;

public class EncoderEmulator {
	private double currentPos;
	
	public EncoderEmulator(double currentPos){
		this.currentPos = currentPos;
	}
	
	public void setCurrentPos(double currentPos){
		this.currentPos = currentPos;
	}
	
	public double getCurrentPos(){
		return this.currentPos;
	}
}
