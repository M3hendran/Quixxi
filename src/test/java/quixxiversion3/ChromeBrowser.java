package quixxiversion3;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javafiles.FilesAndPaths;
import javafiles.ScreenCapture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.MouseEvent;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ChromeBrowser {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest parent;
	public static ExtentTest child1;
	public static ExtentTest child2;

	@Test(groups="positive", priority=1)
	public static synchronized void createReport() throws Exception {
		
		extent = new ExtentReports(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"extent-report.html", true);
		
		System.out.println(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"extent-report.html");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+File.separator+"extent-config.xml"));
		
		System.out.println(new File(System.getProperty("user.dir")+File.separator+"extent-config.xml"));
		
		parent=extent.startTest("Chrome Browser");
		
	}

	@Test(groups="positive", priority=2)
	public static synchronized void chrome() throws Exception {

		try {

			// checking os
			String osname=System.getProperty("os.name").toLowerCase();

			if (osname.indexOf("win")>=0){

				child1=extent.startTest("Automation using Chrome Browser in "+osname);
				parent.appendChild(child1);
				
				child1.log(LogStatus.INFO, "Test Classname: "+ Thread.currentThread().getStackTrace()[1].getClassName());
				child1.log(LogStatus.INFO, "Initialization of browser and extent report done successfully");
				

				// Chrome
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("--disable-extensions");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				options.setExperimentalOption("prefs", prefs);

				System.setProperty("webdriver.chrome.driver",
						javafiles.FilesAndPaths.Browsers()+File.separator+"chromedriver.exe");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				TestClasses.testClassesToRun(driver, extent, parent, child1, child2);
				
			}else if(osname.indexOf("mac")>=0){

				child1=extent.startTest("Automation using Chrome Browser in "+osname);
				parent.appendChild(child1);

				// Chrome
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				options.setExperimentalOption("prefs", prefs);

				System.setProperty("webdriver.chrome.driver",
						javafiles.FilesAndPaths.macSystem()+File.separator+"chromedriver");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				TestClasses.testClassesToRun(driver, extent, parent, child1, child2);

			}else if(osname.indexOf("nix") >= 0 || osname.indexOf("nux") >= 0 || osname.indexOf("aix") > 0 ){

				child1=extent.startTest("Automation using Chrome Browser in "+osname);
				parent.appendChild(child1);

				// Chrome
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				options.setExperimentalOption("prefs", prefs);

				System.setProperty("webdriver.chrome.driver",
						javafiles.FilesAndPaths.linuxSystem()+File.separator+"chromedriver");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				TestClasses.testClassesToRun(driver, extent, parent, child1, child2);

			}
			
			extent.endTest(parent);

		}

		catch (Exception e){

			child1.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "chromeerror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);

		}

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

	public static synchronized void openCloseWindow() throws Exception {
		
		Robot r1=new Robot();
		
		r1.mouseMove(642, 742);
		Thread.sleep(1000);
		r1.mousePress(java.awt.event.MouseEvent.BUTTON1_MASK);
		Thread.sleep(1000);
		r1.mouseRelease(java.awt.event.MouseEvent.BUTTON1_MASK);
		Thread.sleep(1000);
		
	}

}
