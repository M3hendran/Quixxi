package quixxiversion3;

import java.util.List;

import javafiles.Action;
import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageobjects.ControlObjects;
import pageobjects.MarketPlaceObjects;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MarketPlaceFunction{


	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	public MarketPlaceFunction(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){

		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
	}

	//Function to add App in Marketplace
	@Test(groups="positive")
	public static synchronized void quixxi_superAdmin_005() throws Exception {

		parent=extent.startTest("Marketplace");
		child1=extent.startTest("Marketplace funtional test");
		parent.appendChild(child1);
		
		Thread.sleep(3000);

		//click myapp
		driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[4]/li/a/span")).click();
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked myapp menu");
		Thread.sleep(2000);
		
		//Search with app name
		driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).sendKeys("Emulator Launch");
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User cleared search field and typed :: "+driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).getText());
		Thread.sleep(2000);
		
		// click and select the app
		Action.click(ControlObjects.clickOnApp(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User selected the app");
		Thread.sleep(2000);

		//Musixxi Android
//		Action.click(MarketPlaceObjects.clickMarketPlace(driver));
		driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[2]/div[4]/div/a/span")).click();
		Thread.sleep(10000);
		child1.log(LogStatus.INFO, "User clicked Add button");
		Thread.sleep(2000);
		List<WebElement> texts=driver.findElements(By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[1]/div/div[1]/select"));

		for(WebElement count:texts){
			System.out.println(count.getText());
		} 

		Action.click(MarketPlaceObjects.AddMusixxiButton(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked add button");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.PackageName(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked package name field");
		Thread.sleep(2000);
		
		Action.sendKeys(MarketPlaceObjects.PackageName(driver), "com.emulator");
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User typed package name :: "+ "com.emulator");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.PackageNextButton(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked Next button");
		Thread.sleep(2000);
		
		Action.PageDown();
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked page down button");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.ChoosingPlanMusixxi(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User selected plan :: "+MarketPlaceObjects.ChoosingPlanMusixxi(driver).getText());
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SubscribeNow(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked subscribe button");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SubscriptionContinueButton(driver));
		Thread.sleep(10000);
		child1.log(LogStatus.INFO, "User clicked Continue button");
		Thread.sleep(2000);

		try {
			WebElement progress = driver.findElement(By.xpath("//*[@id='progress-info']/li[1]/span[1]"));
			Thread.sleep(5000);

			do
			{
				Thread.sleep(2000);
				System.out.println(progress.getText());

			}
			while(progress.getText() != "100% completed");
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "Musixxi android Compilation completed");
			Thread.sleep(2000);
			extent.endTest(parent);
		}
		catch(Exception e)
		{
			System.out.println("Could not read progress value");
			
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "Musixxi-Android-Compilation")));
			Thread.sleep(6000);
			
			extent.endTest(parent);

		}

		// click to view subscription for musixxi
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[2]/li/a/span")).click();
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked musixxi subscription", child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "musixxisubscription")));
		Thread.sleep(2000);

		//ANPR Android
		Action.click(MarketPlaceObjects.FindSDK(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked FindSDK on left side");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.AddANPRButton(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked Add in ANPR");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.PackageName(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked package field");
		Thread.sleep(2000);
		
		Action.sendKeys(MarketPlaceObjects.PackageName(driver), "com.emulator");
		Thread.sleep(2000);
		child1.log(LogStatus.INFO, "User typed packaged name :: "+"com.emulator");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.PackageNextButton(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked Next button");
		Thread.sleep(2000);
		
		Action.PageDown();
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked Page down button");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.ChoosingPlanANPR(driver));
		Thread.sleep(8000);
		child1.log(LogStatus.INFO, "User selected plan :: "+MarketPlaceObjects.ChoosingPlanANPR(driver).getText());
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SubscribeNow(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked subscribe now button");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SubscriptionContinueButton(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked continue button");
		Thread.sleep(2000);

		try {
			WebElement progress = driver.findElement(By.xpath("//*[@id='progress-info']/li[1]/span[1]"));
			Thread.sleep(5000);                                //*[@id="progress-info"]/li[1]/span[1]
															   //*[@id="progress-info"]/li[1]/span[1]

			do
			{
				Thread.sleep(2000);
				System.out.println(progress.getText());
				
			}
			while(progress.getText() != "100% completed");
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "ANPR android compilation completed");
			Thread.sleep(2000);
			extent.endTest(parent);

		}
		catch(Exception e)
		{
			System.out.println("Compilation is not successful");
			child1.log(LogStatus.INFO, "ANPR android Compilation is not successful");
			Thread.sleep(2000);
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "ANPR-Android-Compilation")));
			Thread.sleep(6000);
			
			extent.endTest(parent);

		}
		
		// click to view subscription for ANPR
		driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[3]/li/a/span")).click();
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked ANPR subscription");
		Thread.sleep(2000);
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)","");
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked page down key");
		Thread.sleep(2000);

		//Musixxi iOS
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)","");
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked page up key");
		Thread.sleep(2000);

		Action.click(MarketPlaceObjects.FindSDK(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked FindSDK on left menu");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.AddMusixxiButton(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked Add button in Musixxi");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SwapToiOS(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked selected iOS");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.PackageName(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked in package name field");
		Thread.sleep(2000);
		
		Action.sendKeys(MarketPlaceObjects.PackageName(driver), "com.emulator");
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User type :: "+MarketPlaceObjects.PackageName(driver).getText());
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.PackageNextButton(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked next button");
		Thread.sleep(2000);
		
		Action.PageDown();
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked page down");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.ChoosingPlanMusixxi(driver));
		Thread.sleep(8000);
		child1.log(LogStatus.INFO, "User selected plan :: "+MarketPlaceObjects.ChoosingPlanMusixxi(driver).getText());
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SubscribeNow(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked subscribe now button");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SubscriptionContinueButton(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked continue button in subscription page");
		Thread.sleep(2000);

		try {
			WebElement progress = driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]"));
			Thread.sleep(5000);

			do
			{
				Thread.sleep(2000);
				System.out.println(progress.getText());

			}
			while(progress.getText() != "100% completed");
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "Musixxi iOS compilation completed");
			Thread.sleep(2000);
			extent.endTest(parent);
		}
		catch(Exception e)
		{
			System.out.println("Compilation is not successful");
			child1.log(LogStatus.INFO, "Musixxi iOS compilation not successful");
			Thread.sleep(2000);
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "Musixxi-iOS-Compilation")));
			Thread.sleep(6000);
			
			extent.endTest(parent);

		}

		//ANPR iOS
		Action.click(MarketPlaceObjects.FindSDK(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked FindSDK on left side menu");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.AddANPRButton(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked add button in ANPR in iOS Platform");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SwapToiOS(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked iOS Platform");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.PackageName(driver));
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User clicked in Package field");
		Thread.sleep(2000);
		
		Action.sendKeys(MarketPlaceObjects.PackageName(driver), "com.emulator");
		Thread.sleep(3000);
		child1.log(LogStatus.INFO, "User typed packagename :: "+MarketPlaceObjects.PackageName(driver).getText());
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.PackageNextButton(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked next button");
		Thread.sleep(2000);
		
		Action.PageDown();
		Thread.sleep(3000);
		
		child1.log(LogStatus.INFO, "User clicked page down button");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.ChoosingPlanANPR(driver));
		Thread.sleep(8000);
		child1.log(LogStatus.INFO, "User selected plan :: "+MarketPlaceObjects.ChoosingPlanANPR(driver).getText());
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SubscribeNow(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked subscribe now button");
		Thread.sleep(2000);
		
		Action.click(MarketPlaceObjects.SubscriptionContinueButton(driver));
		Thread.sleep(6000);
		child1.log(LogStatus.INFO, "User clicked continue button subscription page");
		Thread.sleep(2000);

		try {
			WebElement progress = driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]"));
			Thread.sleep(5000);

			do
			{
				Thread.sleep(2000);
				System.out.println(progress.getText());
				
			}
			while(progress.getText() != "100% completed");
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "ANPR iOS compilation completed");
			Thread.sleep(2000);
			extent.endTest(parent);
		}
		catch(Exception e)
		{
			System.out.println("Compilation is not successful");
			child1.log(LogStatus.INFO, "ANPR iOS compilation not successful");
			Thread.sleep(2000);
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "ANPR-iOS-Compilation")));
			Thread.sleep(6000);
			
			extent.endTest(parent);

		}

		extent.endTest(parent);
	}

}


