package org.usfirst.frc.team1699.test.pid;

import org.junit.Test;
import org.usfirst.frc.team1699.robot.pid.PIDLoop;

import edu.wpi.first.wpilibj.Encoder;

public class PIDTest {
	Encoder enc = new Encoder(null, null);
	
	@Test
	public void pidTest(){
		PIDLoop pid = new PIDLoop("pid", .1, .1, .1, enc);
	}
}
