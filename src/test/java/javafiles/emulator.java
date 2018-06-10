package javafiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class emulator {
	
	public static synchronized void robot() throws InterruptedException, AWTException
	{
	Robot robot = new Robot();
	
	//Taptoplay
	robot.mouseMove(900,345);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	robot.delay(30000);
	
	//MockEvent
	robot.mouseMove(830,300);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	robot.delay(5000);
				
	//ConfigureSettings
	robot.mouseMove(956,300);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	
	//ConfigureSettings_Display_Name
	robot.mouseMove(840,300);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	//ClickinTextBox
	robot.mouseMove(975,312);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Type Display name
	robot.keyPress(KeyEvent.VK_A);
	robot.keyRelease(KeyEvent.VK_A);
	Thread.sleep(3000);
	//Click_Ok
	robot.mouseMove(976,413);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	
	
	//Click_Email
	robot.mouseMove(840,375);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Clickonthatfield
	robot.mouseMove(913,362);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Click_Ok
	robot.mouseMove(980,409);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	
	
	//Phone
	robot.mouseMove(862,433);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Phoneupdate
	robot.mouseMove(875,375);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Click_Ok
	robot.mouseMove(980,409);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	
	
	//Address
	robot.mouseMove(855,484);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Addresseditclick
	robot.mouseMove(942,360);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Click_Ok
	robot.mouseMove(977,415);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	
	
	//Organisation
	robot.mouseMove(858,537);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Organisationeditclick
	robot.mouseMove(974,412);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Click_Ok
	robot.mouseMove(980,409);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	
	
	//ConfigureSettingssaveButton
	robot.mouseMove(1005,268);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);	
	
	
	//Backbutton
	robot.mouseMove(778,272);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	
	
	//UpdateEmail
	robot.mouseMove(843,407);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(10000);
	
	
	//EnterMailid
	robot.mouseMove(802,458);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	//Type Mail ID
	robot.keyPress(KeyEvent.VK_J);
	robot.keyRelease(KeyEvent.VK_J);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_PERIOD);
	robot.keyRelease(KeyEvent.VK_PERIOD);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_T);
	robot.keyRelease(KeyEvent.VK_T);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_I);
	robot.keyRelease(KeyEvent.VK_I);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_R);
	robot.keyRelease(KeyEvent.VK_R);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_U);
	robot.keyRelease(KeyEvent.VK_U);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_P);
	robot.keyRelease(KeyEvent.VK_P);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_A);
	robot.keyRelease(KeyEvent.VK_A);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_T);
	robot.keyRelease(KeyEvent.VK_T);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_H);
	robot.keyRelease(KeyEvent.VK_H);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_I);
	robot.keyRelease(KeyEvent.VK_I);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_SHIFT);
	robot.keyPress(KeyEvent.VK_2);
	robot.keyRelease(KeyEvent.VK_2);
	robot.keyRelease(KeyEvent.VK_SHIFT);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_L);
	robot.keyRelease(KeyEvent.VK_L);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_A);
	robot.keyRelease(KeyEvent.VK_A);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_K);
	robot.keyRelease(KeyEvent.VK_K);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_E);
	robot.keyRelease(KeyEvent.VK_E);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_B);
	robot.keyRelease(KeyEvent.VK_B);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_A);
	robot.keyRelease(KeyEvent.VK_A);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_PERIOD);
	robot.keyRelease(KeyEvent.VK_PERIOD);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_C);
	robot.keyRelease(KeyEvent.VK_C);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_O);
	robot.keyRelease(KeyEvent.VK_O);
	Thread.sleep(1000);
	robot.keyPress(KeyEvent.VK_M);
	robot.keyRelease(KeyEvent.VK_M);
	Thread.sleep(1000);
	//UpdateButton
	robot.mouseMove(930,398);
	Thread.sleep(3000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(3000);
	
	
	//MenuButton
	robot.mouseMove(779,271);
	Thread.sleep(10000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	
	
	//Troubleshooting
	robot.mouseMove(854,482);
	Thread.sleep(10000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	
	
	//Mock error
	robot.mouseMove(834,334);
	Thread.sleep(10000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	
	
	//continue Button
	robot.mouseMove(966,492);
	Thread.sleep(10000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	
	
	//arrow
	robot.mouseMove(893,596);
	Thread.sleep(10000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(5000);
	
	
	}
}
