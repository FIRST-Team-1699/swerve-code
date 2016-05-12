package org.usfirst.frc.team1699.robot.inireader;

public class ConfigTest {

	public static void main(String[] args) 
	{
		ConfigFile file = new ConfigFile("C:\\Users\\Connor\\c-test.ini");
		ConfigSection global = file.findSection("global");
		ConfigSection johno = file.findSection("johno");
		ConfigSection thread = file.findSection("thread");
		
		System.out.println(global.findString("goat"));
		System.out.println(Float.parseFloat(johno.findString("api")) + "f");
		System.out.println(thread.findListString("blarg"));
	}

}
