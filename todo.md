# ToDo List

1. ~~Finish code and get ready to test.~~
 ~~- 10/10 would todo again~~
 
 ~~But on a more serious note, what needs to be done in the code?~~

2. ~~Make everything work together~~
 ~~- Finish all commands~~
 ~~- Implement all commands~~

3. ~~Update all formatting and syntax to Google Style~~

4. ~~Add drive base command~~ -- talk to Jakob about what it should include

5. Add more witty comments 

6. ~~Fix swerve update thread class~~ -- Should be done (needs to be tested in simulation before being used on robot)

7. ~~Move dead zone constants to Constants class~~

8. In version 1.0, remove the SwerveUpdateThread

9. Make the code more dynamic
 - Work on values near 360 degrees
 - Make is to when past 180 degrees it will finish a circle (I can't english)

10. Work more on Javadocs

### When testing: 
1. If Robot.java is not found, it needs to be moved up a directory and [6746c70](https://github.com/FIRST-Team-1699/2016-offseason-code/commit/6746c70e8035c67caea27f189c6aaa782f46231f) needs to be undone.
2. Know that the code thinks linearly (360 degrees is different than 0 degrees), and operating near 0 degrees *may* have some unexpected consequences.
