package javafiles;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Action {

	private static final String Priority = null;
	public static WebDriver driver;
	public static Properties prop;
	public static  String URL;

	//Function to click PageUpandDown
	//Input : Element value
	//Output : Page should Move Up
	public static synchronized void PageDown() throws IOException{
		
	try
	{
	    Robot robot=new Robot();

	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}
	catch(Exception e)
	{
		Reporter.log("Exception occured" +e.toString());
	}
	}
	
	//Function to click PageUpandDown
	//Input : Element value
	//Output : Page should Move Up
	public static synchronized void PageUp() throws IOException{
		try
		{
		    Robot robot=new Robot();

		    robot.keyPress(KeyEvent.VK_PAGE_UP);
		    robot.keyRelease(KeyEvent.VK_PAGE_UP);

		}
		catch(Exception e)
		{
			Reporter.log("Exception occured" +e.toString());
		}
		}
	
	//Function to click an element
	//Input : Element value
	//Output : Element must be clicked
	public static synchronized void click(WebElement element) {
		try {
			element.click();
		}
		catch(Exception e) {
			Reporter.log("Exception occured" +e.toString());
		}
	}
	
	//Function to read property file
	//Input : Property file
	//Output : Values must be read
	public static synchronized void readProperty() throws IOException{
	    prop = new Properties(); 
	    FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir") + "/DataProperties/Dataproperties.properties");
//	    FileInputStream fileInputStream=new FileInputStream("C://Users//Guest//workspace//PeopleDesk_Upgraded_New//DataProperties//data.properties");
	    prop.load(fileInputStream);        
	}
	
	//Function to get values from property file
	//Input : Name of the String to be return
	//Output : Values must be return
	public static synchronized String getProperty(String key){
        return prop.getProperty(key);
    }
	
	//Function to Send values 
	//Input : Element and String 
	//Output : Value must be entered into that element
	public static synchronized void sendKeys(WebElement element,String key) {
		try {
			element.sendKeys(key);
		}
		catch(Exception e) {
		Reporter.log("Exception occured" +e.toString());
		}
	}
	
	//Function to wait
	//Input : 
	//Output : 
	public static synchronized void wait(int timeout) throws InterruptedException{
		
		Thread.sleep(timeout);
	}
	
	public static synchronized void selectMultiple(By element,int index) {
		try {
			new Select(driver.findElement(element)).selectByIndex(index);
		}
		catch(Exception e) {
			Reporter.log("Exception occured" +e.toString());
		}
		}
	
	public static synchronized void selectFromDropDown(WebElement element,int value) {
		try {
		new Select((WebElement) driver);
		}
		catch(Exception e) {
		Reporter.log("Exception occured" +e.toString());
		}
	}
	public static synchronized void pageTimeOut(int time,WebElement element){
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		
	}
	
	public static synchronized void move(WebElement element){
		
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	
	}
	public static synchronized void Childwindowhandle(){
		ArrayList<String> window = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(window.get(1));
	   // driver.close();
	  }
	
	public static synchronized void Parentwindowhandle(){
		ArrayList<String> window = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(window.get(0));
	   // driver.close();
	  }
	
	public static synchronized void handleFrames(int value) {
		try {
			driver.switchTo().frame(value);
		}
		catch(Exception e) {
			Reporter.log("Exception occured" +e.toString());
		}
	}
	public static synchronized boolean ElementPresent(By by) {
	    int count = driver.findElements(by).size();
	    if (count==0) {
	        Logger.getLogger("ElementDoesNotExist: " + by, Priority.substring(20, 100));
	        return true;
	    }
	    else {
	        Logger.getLogger("ElementDoesExist: " + by, Priority.substring(20, 100));
	        return false;
	    }   
	}

	
	// Mahendran created the following methods
	public static synchronized void openNotepad() throws Exception {
		
		Runtime r=Runtime.getRuntime();

		Runtime.getRuntime().exec("cmd.exe /c Start OpenWindow.bat",null, new File("C:\\Users\\lakeba24\\Downloads\\ritchielawrence-cmdow-v1.4.8-43-g1bbcd2b\\ritchielawrence-cmdow-1bbcd2b\\bin\\Release")); //or anywhere you want.
		Thread.sleep(2000);

	}
	
	public static synchronized void minimizeWin() throws Exception {
		
		Runtime r=Runtime.getRuntime();

		Runtime.getRuntime().exec("cmd.exe /c Start MinimizeWindow.bat",null, new File("C:\\Users\\lakeba24\\Downloads\\ritchielawrence-cmdow-v1.4.8-43-g1bbcd2b\\ritchielawrence-cmdow-1bbcd2b\\bin\\Release")); //or anywhere you want.
		Thread.sleep(2000);

	}
	
	public static synchronized void maxmizeWin() throws Exception {
		
		Runtime r=Runtime.getRuntime();
		
		Runtime.getRuntime().exec("cmd.exe /c Start MaximizeWindow.bat",null, new File("C:\\Users\\lakeba24\\Downloads\\ritchielawrence-cmdow-v1.4.8-43-g1bbcd2b\\ritchielawrence-cmdow-1bbcd2b\\bin\\Release")); //or anywhere you want.
		Thread.sleep(2000);
	}
	
	public static synchronized void typeit(String text) throws Exception {

//		Thread.sleep(1000);//not required though gives a good feel.
		Robot r1=new Robot();      
		String a=text;
		char c;
		int d=a.length(),e=0,f=0;
		while(e<d)
		{
			c=a.charAt(e);
			f=(int) c; //converts character to Unicode. 
			r1.keyPress(KeyEvent.getExtendedKeyCodeForChar(f));
			e++;
			Thread.sleep(100);

		}
		
	}

}
