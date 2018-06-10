package quixxiversion3;

import java.awt.Robot;
import java.util.ArrayList;

import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyingDocs {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	private static ArrayList<String> tabs1;
	
	public VerifyingDocs(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){
		
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
		
	}
	
	@Test(groups="positive", priority=1)
	public static synchronized void controlDocs() throws Exception {


		try {
			parent=extent.startTest("Quixxi Docs");
			child1=extent.startTest("Verifying docs for Control");
			parent.appendChild(child1);
			
			//Home page

			//click doc
			driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[3]/li/a/span")).click();
			child1.log(LogStatus.INFO, "User clicked docs menu");
			Thread.sleep(6000);
			
			tabs1=new ArrayList<String>(driver.getWindowHandles());

			// close the vulnerability in tab index
			driver.switchTo().window(tabs1.get(1));
			Thread.sleep(2000);


			WebElement drpdown = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/div[1]/div/div/a[2]"));
			//Select dropdown = new Select(drpdown);
			//dropdown.selectByVisibleText("Control");
			drpdown.click();
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User selected Control from dropdown list");
			Thread.sleep(3000);

			//Analytics
			System.out.println("ANALYTICS");

			//Android
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique04f8b3']/div/div[2]/dl/dt[1]/span/span/a")).click();
			child1.log(LogStatus.INFO, "User clicked Android on left menu");
			Thread.sleep(6000);
			String Andtext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(Andtext.equalsIgnoreCase("Android SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +Andtext);
				child1.log(LogStatus.INFO, "Header Text "+Andtext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "content mismatched");
			}

			//iOS
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique04f8b3']/div/div[2]/dl/dt[2]/span/span/a")).click();
			child1.log(LogStatus.INFO, "User clicked iOS on left");
			Thread.sleep(7000);
			String iostext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(iostext.equalsIgnoreCase("iOS SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +iostext);
				child1.log(LogStatus.INFO, "Header Text "+iostext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "Content mismatched");
			}

			//.NET UWP
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique04f8b3']/div/div[2]/dl/dt[2]/span/span/a")).click();
			child1.log(LogStatus.INFO, "User clicked .NET on left");
			Thread.sleep(6000);
			String nettext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(nettext.equalsIgnoreCase(".NET UWP SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +nettext);
				child1.log(LogStatus.INFO, "Header Text "+nettext+" verified");
				
			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "Content Mismatched");
			}

			//Web
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique04f8b3']/div/div[2]/dl/dt[4]/span/span/a")).click();
			child1.log(LogStatus.INFO, "User clicked Web on left");
			Thread.sleep(6000);
			String webtext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(webtext.equalsIgnoreCase("Web SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +webtext);
				child1.log(LogStatus.INFO, "Header Text "+webtext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "Content Mismatched");
			}

			//HoloLens
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique04f8b3']/div/div[2]/dl/dt[5]/span/span/a")).click();
			child1.log(LogStatus.INFO, "User clicked Hololens on left ");
			Thread.sleep(6000);
			String holotext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(holotext.equalsIgnoreCase("HoloLens(Unity) SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +holotext);
				child1.log(LogStatus.INFO, "Header Text "+holotext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "Content Mismatched");
			}

			//tvOS
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique04f8b3']/div/div[2]/dl/dt[6]/span/span/a")).click();
			child1.log(LogStatus.INFO, "User clicked tvOS on left");
			Thread.sleep(6000);
			String tvostext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(tvostext.equalsIgnoreCase("tvOS Analytics SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +tvostext);
				child1.log(LogStatus.INFO, "Header Text "+tvostext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "Content Mismatched");
			}

			//Licensing  /  Hack Detection
			System.out.println("Hack Detection");

			//ANDROID
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique756f393']/div/div[2]/dl/dt/span/span/a")).click();
			child1.log(LogStatus.INFO, "User clicked Licensing Android on left");
			Thread.sleep(6000);
			String licenseandroidtext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(licenseandroidtext.equalsIgnoreCase("Android Licensing SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +licenseandroidtext);
				child1.log(LogStatus.INFO, "Header Text "+licenseandroidtext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "Content Mismatched");
			}
			Thread.sleep(5000);

			//Scroll
			Robot robot = new Robot();
			robot.mouseWheel(-4);
			Thread.sleep(10000);

			//PATCH
			System.out.println("PATCH");

			// scroll down the bar
			//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");

			//ANDROID
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique8257332']/div/div[2]/dl/dt[1]/span/span/a")).click();
			child1.log(LogStatus.INFO, "User clicked Patcher android on left");
			Thread.sleep(8000);
			String patchandroidtext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(patchandroidtext.equalsIgnoreCase("Android Patch SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +patchandroidtext);
				child1.log(LogStatus.INFO, "Header Text "+patchandroidtext+" verified");

			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "Content Mismatched");
			}

			//IOS
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique8257332']/div/div[2]/dl/dt[2]/span/span/a")).click();
			child1.log(LogStatus.INFO, "User selected Patcher iOS on left");
			Thread.sleep(6000);
			String patchiostext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(patchiostext.equalsIgnoreCase("iOS Patch SDK - Quick Start Guide"))
			{
				System.out.println("Text present - success" +patchiostext);
				child1.log(LogStatus.INFO, "Header Text "+patchiostext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child1.log(LogStatus.INFO, "Content Mismatched");
			}
			
			child1.log(LogStatus.INFO, "Verifying Control docs was successful");

			extent.endTest(parent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "controlpageerror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}
	}


	@Test(groups="positive", priority=2)
	public static synchronized void securityDocs() throws Exception {

		try {
			
			child2=extent.startTest("Verifying docs for Security");	
			parent.appendChild(child2);
			//Home page

			WebElement drpdown = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div/div[1]/div/div/a[1]"));
//			Select dropdown = new Select(drpdown);
//			dropdown.selectByVisibleText("Security");
			drpdown.click();
			Thread.sleep(3000);
			child2.log(LogStatus.INFO, "User selected Security in the dropdown list");
			Thread.sleep(3000);


			//Android
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique372df12']/div/div[2]/dl/dt[1]/span/span/a")).click();
			child2.log(LogStatus.INFO, "User selected android security on left");
			Thread.sleep(6000);
			String Andtext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(Andtext.equalsIgnoreCase("ANDROID APP SHIELD"))
			{
				System.out.println("Text present - success" +Andtext);
				child2.log(LogStatus.INFO, "Header Text "+Andtext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child2.log(LogStatus.INFO, "Content Mismatched");
			}

			//iOS
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique372df12']/div/div[2]/dl/dt[2]/span/span/a")).click();
			child2.log(LogStatus.INFO, "User clicked iOS Security on left");
			Thread.sleep(6000);
			String iostext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(iostext.equalsIgnoreCase("IOS SDK – QUICK START GUIDE"))
			{
				System.out.println("Text present - success" +iostext);
				child2.log(LogStatus.INFO, "Header Text "+iostext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child2.log(LogStatus.INFO, "Content Mismatched");
			}
			
			// Security - Android - Web
			//*[@id="nextend-accordion-menu-unique372df12"]/div/div[2]/dl/dt[3]/span/span/a
			
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique372df12']/div/div[2]/dl/dt[3]/span/span/a")).click();
			child2.log(LogStatus.INFO, "User clicked Web Security on left");
			Thread.sleep(6000);
			String webtext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(webtext.equalsIgnoreCase("QUIXXI JAVASCRIPT OBFUSCATION – QUICK START GUIDE"))
			{
				System.out.println("Text present - success" +webtext);
				child2.log(LogStatus.INFO, "Header Text "+webtext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child2.log(LogStatus.INFO, "Content Mismatched");
			}
			
			// Click REST API
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique9c2ba17']/div/div[2]/dl/dt[1]/span/span/a")).click();
			Thread.sleep(3000);
			child2.log(LogStatus.INFO, "User clicked REST API");

			// Click CLI
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique9c2ba17']/div/div[2]/dl/dt[2]/span/span/a")).click();
			child2.log(LogStatus.INFO, "User clicked CLI on left");
			Thread.sleep(6000);
			String clitext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(clitext.equalsIgnoreCase("QUIXXI CLI"))
			{
				System.out.println("Text present - success" +clitext);
				child2.log(LogStatus.INFO, "Header Text "+clitext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child2.log(LogStatus.INFO, "Content Mismatched");
			}
			
			// Click Jenkins
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-unique9c2ba17']/div/div[2]/dl/dt[3]/span/span/a")).click();
			child2.log(LogStatus.INFO, "User clicked Jenkins on left");
			Thread.sleep(6000);
			String jenkinstext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(jenkinstext.equalsIgnoreCase("JENKINS INTEGRATION"))
			{
				System.out.println("Text present - success" +jenkinstext);
				child2.log(LogStatus.INFO, "Header Text "+jenkinstext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child2.log(LogStatus.INFO, "Content Mismatched");
			}
			
//			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");
//			Thread.sleep(3000);
			
			// Click How to do App profiling
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-uniquedc0c130']/div/div[2]/dl/dt[1]/span/span/a")).click();
			Thread.sleep(3000);
			child2.log(LogStatus.INFO, "User clicked How to do app profiling");
			
			// Click Voicepro Profiling
			driver.findElement(By.xpath("//*[@id='nextend-accordion-menu-uniquedc0c130']/div/div[2]/dl/dt[2]/span/span/a")).click();
			Thread.sleep(3000);
			child2.log(LogStatus.INFO, "User clicked Voicepro profiling");
			Thread.sleep(2000);
			String voiceprostext = driver.findElement(By.xpath("//*[@id='main-tabs-content']/div[2]/div/div/div/div/h1")).getText();
			if(voiceprostext.equalsIgnoreCase("JENKINS INTEGRATION"))
			{
				System.out.println("Text present - success" +voiceprostext);
				child2.log(LogStatus.INFO, "Header Text "+voiceprostext+" verified");
			}
			else
			{
				System.out.println("content mismatched");
				child2.log(LogStatus.INFO, "Content Mismatched");
			}

			child2.log(LogStatus.INFO, "Verifying security docs was successful");

			driver.close();
			
			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child2.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child2.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "securitypageerror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}
	}
}
