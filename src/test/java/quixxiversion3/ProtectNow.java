package quixxiversion3;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javafiles.FilesAndPaths;
import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProtectNow {

	private static WebDriverWait wait;
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	public ProtectNow(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){

		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
	}

	@Test(groups="positive", priority=1)
	public static synchronized void security() throws Exception {

		//creating new application

		try {

			parent=extent.startTest("Security -> Protect Page");
			child1=extent.startTest("Protect app functional test");
			parent.appendChild(child1);
			
			Thread.sleep(3000);

			//click myapp
			driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[4]/li/a/span")).click();
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User clicked my app");
			Thread.sleep(2000);

			//click add new
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/div[1]/div[3]/div[1]/a/div")).click();
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User clicked add new button");
			Thread.sleep(2000);

			//click create app button
			driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/form/div/div[3]/button")).click();
			Thread.sleep(4000);
			child1.log(LogStatus.INFO, "User clicked create app button");
			Thread.sleep(2000);


			// type app name
			WebElement newappname = driver.findElement(By.xpath("//*[@id='basic']/div/form/div/div[2]/div/div/input"));
			String textintextbox = newappname.getAttribute("value");
			System.out.println("text present " +textintextbox);
			Thread.sleep(3000);
			newappname.sendKeys("ApkSecurity");
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User type app name as :: "+newappname.getText());
			Thread.sleep(2000);

			//click create app button
			driver.findElement(By.xpath("//*[@id='basic']/div/form/div/div[3]/button")).click();
			Thread.sleep(4000);
			child1.log(LogStatus.INFO, "User clicked create app button");
			Thread.sleep(2000);

			//Checking Newly created application is present or not in Homepage/My Apps page

			//Search with app name
			driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).sendKeys("ApkSecurity");
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User searched for :: "+driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).getText());
			Thread.sleep(2000);

			//Compare new app is present or not	
			String newapplicationname = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div[3]/div[2]/a/div/div[3]/h3")).getText();
			WebElement appname = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div[3]/div[2]/a/div/div[3]/h3"));
			if(newapplicationname.equalsIgnoreCase("ApkSecurity")){
				child1.log(LogStatus.INFO, "New application present");
				Thread.sleep(2000);
				
				appname.click();
				Thread.sleep(4000);
				String title = driver.getTitle();
				System.out.println(title);

				// Select Security in the menu
				driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[2]/div[3]/div/a")).click();
				Thread.sleep(6000);
				child1.log(LogStatus.INFO, "User selected security");
				Thread.sleep(2000);

				//Go to Protect now page
				driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div[1]/div/div[2]/div[2]/div/div[4]/button")).click();
				Thread.sleep(6000);
				child1.log(LogStatus.INFO, "User clicked protect on left menu");
				child1.log(LogStatus.INFO, driver.getTitle());
				Thread.sleep(2000);

				//Selecting Android
				//WebElement Androidelement = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/label"));
				WebElement Androidelement = driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div/div[1]/div/div[1]/div[2]/div[1]"));
				
				if(Androidelement.isSelected())							
				{
					child1.log(LogStatus.INFO, "Already selected - Platform Android");
					Thread.sleep(2000);
				}
				else
				{
					Androidelement.click();
					Thread.sleep(3000);
					child1.log(LogStatus.INFO, "Not Selected - Platform Selected by script");
					Thread.sleep(2000);
				}
				
				//Uploading Apk file
				driver.findElement(By.xpath(".//*[@id='dropfile']/div/div[2]/label/div")).click();
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User clicked upload apk");
				Thread.sleep(2000);
				

				Robot robot = new Robot();

				//checking os for file dialog box
				String osname=System.getProperty("os.name").toLowerCase();

				if (osname.indexOf("win")>=0){

					StringSelection selection=new StringSelection(javafiles.FilesAndPaths.apkPath().getAbsolutePath()+"\\"+"MoneyTracker.apk");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
					Thread.sleep(5000);
					robot.keyPress(KeyEvent.VK_CONTROL );
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_V);
					Thread.sleep(3000);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(5000);

				}else if(osname.indexOf("mac")>=0){

					Toolkit.getDefaultToolkit().getImage(javafiles.FilesAndPaths.apkPath().getAbsolutePath()+"\\"+"MoneyTracker.apk");

					robot.mouseMove(436, 318);
					robot.delay(100);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseMove(598, 183);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					System.out.println("app selected");
					robot.delay(100);
					robot.mouseMove(1030, 540);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					Thread.sleep(5000);
					robot.mouseWheel(-2000);
					Thread.sleep(5000);
					System.out.println("Page scrolled");	
				}
				//Subscription for application
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(3000);
				jse.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(3000);

				// getting text of startup
				String plan = driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div/div[1]/div/div[1]/div[5]/div[2]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[3]/div/h2")).getText();
				// click subscribe button for Startup
				driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div/div[1]/div/div[1]/div[5]/div[2]/div/div[1]/div[2]/div/table/tbody/tr[5]/td[3]/div/button")).click();
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User subscription :: "+plan);
				Thread.sleep(2000);
				
				// user clicked yes in confirmation box
				driver.findElement(By.xpath("//*[@id='planProcessingView']/div/div/div/form/div[2]/div[2]/div[2]/div/div/button[2]")).click();
				Thread.sleep(6000);
				child1.log(LogStatus.INFO, "Subscription activated");
				Thread.sleep(2000);
				
				//Click Next in subscription page
				driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div/div[1]/div/div[2]/button")).click();
				Thread.sleep(5000);          //*[@id="uiview"]/div[2]/div/div/div[1]/div/div[2]/button
				child1.log(LogStatus.INFO, "User clicked next button");
				Thread.sleep(2000);

				//page down
				jse.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(3000);
				jse.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User clicked pagedown key two times");
				Thread.sleep(2000);
				
				// Click next in compilation options
				driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div/div[2]/button/span[1]")).click();
				Thread.sleep(5000);
				child1.log(LogStatus.INFO, "User clicked next in Security options page");
				Thread.sleep(2000);

				waitForCompilation();
				Thread.sleep(30000);
				
				WebElement successtext = driver.findElement(By.cssSelector("#dropfile > h4:nth-child(12)"));
				String Successtext =successtext.getText();
				child1.log(LogStatus.INFO, "The following text verified "+Successtext);
				Thread.sleep(2000);
				child1.log(LogStatus.INFO, "The security applied successfully...");
				Thread.sleep(2000);
				
				extent.endTest(parent);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "protecterror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}
	}

	@Test(groups="positive", priority=2)
	public static synchronized void viewCertificate() throws Exception {
		Thread.sleep(6000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)");
		Thread.sleep(3000);
		ArrayList<String> tabs1;
		// click the viewcertificate
		driver.findElement(By.xpath("//*[@id='androidReport']/div[1]/div[2]/div[1]/a/label")).click();
		Thread.sleep(15000);         //*[@id="androidReport"]/div[1]/div[2]/div[1]/a/label
		// getting window handles
		tabs1=new ArrayList<String>(driver.getWindowHandles());
		// switch to tab
		driver.switchTo().window(tabs1.get(1));
		// close the tab
		driver.close();
		
	}
	
	@Test(groups="positive", priority=3)
	public static synchronized void shieldConfig() throws Exception {
		ArrayList<String> tabs1;
		tabs1=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(0));
		Thread.sleep(3000);
		// click sheild config
		driver.findElement(By.xpath("//*[@id='androidReport']/div[1]/div[2]/div[2]/div/span")).click();
		Thread.sleep(6000);
		// close the shielf config
		driver.findElement(By.xpath("//*[@id='appProtectConfigView']/div/div/div/button")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(groups="positive", priority=4)
	public static synchronized void viewReportContent() throws Exception {
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		// click to view first vulnerability
		driver.findElement(By.xpath("//*[@id='androidReport']/div[4]/div[1]/div[1]/div[4]")).click();
		Thread.sleep(3000);
		// click to close
		driver.findElement(By.xpath("//*[@id='androidReport']/div[4]/div[1]/div[1]/div[4]")).click();
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-600)");

	}
	
	public static synchronized void waitForCompilation()throws Exception{

		boolean compiled = false;

		try {
			
			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//*[@id='dropfile']/div/div[3]/h1"));

			do {

				if (element.getText().equalsIgnoreCase("95%") ) {

					compiled=true;
				}

			} while (compiled != true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
