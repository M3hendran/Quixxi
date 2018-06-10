package javafiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotClass {
	 
	public static  Robot robot; 

	public void chooseImageFromDesktop() throws AWTException, InterruptedException
	{
		  robot = new Robot();
		  
		  Robot robot = new Robot();
		  StringSelection selection=new StringSelection("/home/lakeba/Desktop/profile.png");      
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);  
		  robot.keyPress(KeyEvent.VK_CONTROL );
		  robot.keyPress(KeyEvent.VK_V);   
		  robot.keyRelease(KeyEvent.VK_CONTROL);  
		  robot.keyRelease(KeyEvent.VK_V);   
		  Thread.sleep(5000);     
		  robot.keyPress(KeyEvent.VK_ENTER); 
		  robot.keyRelease(KeyEvent.VK_ENTER);   
	}
	
	public void cardDetails() throws AWTException
	{
		robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_4);
		robot.keyRelease(KeyEvent.VK_4);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);

		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);

		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);

		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);

		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);

		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);

		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);

		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);

		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);

		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_1);
		
		
	}

}
