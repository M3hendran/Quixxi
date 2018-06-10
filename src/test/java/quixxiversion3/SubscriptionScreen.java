package quixxiversion3;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageobjects.SubscriptionPageObjects;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SubscriptionScreen {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static WebDriverWait wait;

	public static SubscriptionPageObjects subs = null;

	public SubscriptionScreen(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1)
	{
		this.driver = driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
	}

	@Test(groups="positive", priority=1)
	public static synchronized void subscriptionsForSecurity() throws Exception 
	{
		subs = PageFactory.initElements(driver, SubscriptionPageObjects.class);

		parent=extent.startTest("Subscription Page");
		child1=extent.startTest("Subscription for Control & Security");
		parent.appendChild(child1);

		//Click Profile and then account	
		driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/ul/li[1]/a")).click();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div/li[2]/a/span")));

		if(subs.Subscription.isDisplayed())
		{
			subs.Subscription.click();
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "Subscription for Security displayed");
			System.out.println("--------------------------------Subscription for Security --------------------------------------------------");
		}
		else
		{
			child1.log(LogStatus.INFO, "Subscription option not displayed in Profile menu");
			System.out.println("--------------------------------Subscription option not displayed in Profile menu------------------------");
			//driver.close();
		}
		Thread.sleep(3000);
		if(subs.Apps.isDisplayed())
		{
			subs.Apps.click();
			Thread.sleep(3000);
			System.out.println("List of Apps are");
			for(WebElement applist : subs.AppList)
			{
				System.out.println(applist.getText());
			}

			Thread.sleep(3000);
		}
		else
		{
			child1.log(LogStatus.INFO, "Apps option not displayed in Subscription menu");
			System.out.println("--------------------------------Apps option not displayed in Subscription menu------------------------");
			//driver.close();
		}
		if(subs.AppSelect.isDisplayed())
		{
			subs.AppSelect.click();
			Thread.sleep(3000);
		}
		else
		{
			child1.log(LogStatus.INFO, "AppList having single app only");
			System.out.println("-------------------------------------AppList having single app only------------------------------------");
			//driver.close();
		}

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		try
		{
			if(subs.FreePlan.isDisplayed())
			{
				subs.FreePlan.click();
				Thread.sleep(3000);

				child1.log(LogStatus.INFO, "User is Currently Subscribed "+subs.FreePlan_Label.getText()+" plan");
				System.out.println("-------------------------------------------------User is Currently Subscribed "+subs.FreePlan_Label.getText()+" plan-------------------------------------------------");

				child1.log(LogStatus.INFO, "Plan Name = "+subs.FreePlan_Label.getText());
				System.out.println("Plan Name = "+subs.FreePlan_Label.getText());

				child1.log(LogStatus.INFO, "Plan Cost = "+subs.FreePlanCost.getText());
				System.out.println("Plan Cost = "+subs.FreePlanCost.getText());

				child1.log(LogStatus.INFO, "Plan Validity = "+subs.FreePlanValidity.getText());
				System.out.println("Plan Validity = "+subs.FreePlanValidity.getText());

				child1.log(LogStatus.INFO, "Vulnerability test automated scan = YES");
				System.out.println("Vulnerability test automated scan = YES");

				child1.log(LogStatus.INFO, "Vulnerability Report = "+subs.FreePlanReport.getText());
				System.out.println("Vulnerability Report = "+subs.FreePlanReport.getText());

				child1.log(LogStatus.INFO, "Wrapper - security framework = NO");
				System.out.println("Wrapper - security framework = NO");

				Thread.sleep(3000);
				if(subs.ContinueBtn.isDisplayed())
				{
					subs.ContinueBtn.click();
					Thread.sleep(5000);
				}
				else
				{
					subs.CancelBtn.click();
					Thread.sleep(3000);
				}

			} 
			else if(subs.StartUpPlan.isDisplayed())
			{
				subs.StartUpPlan.click();
				Thread.sleep(3000);
				System.out.println("---------------------------------------------------User is Currently Subscribed "+subs.StartUpPlan_Label.getText()+" plan--------------------------------------------");
				System.out.println("Plan Name = "+subs.StartUpPlan_Label.getText());
				System.out.println("Plan Cost = "+subs.StartUpPlanCost.getText());
				System.out.println("Plan Validity = "+subs.StartUpPlanValidity.getText());
				System.out.println("Vulnerability test automated scan = YES");
				System.out.println("Vulnerability Report = "+subs.StartUpPlanReport.getText());
				System.out.println("Wrapper - security framework = YES");
				Thread.sleep(3000);

				System.out.println("----------------------------Please confirm, Do you want to update your subscription?--------------------------");

				askSubscriptionUpdateFromUser();

			}
			else
			{
				System.out.println("--------------------------------------------***** Subscribe button in StartUp plan not displayed *****--------------------------------------------" );
			}
		}catch(NoSuchElementException e)
		{

			if(subs.ProPlan.isDisplayed())
			{
				subs.ProPlan.click();
				Thread.sleep(3000);
				System.out.println("------------------------------------------------User is Currently Subscribed "+subs.ProPlan_Label.getText()+" plan---------------------------------------------");
				System.out.println("Plan Name = "+subs.ProPlan_Label.getText());
				System.out.println("Plan Cost = "+subs.ProPlanCost.getText());
				System.out.println("Plan Validity = "+subs.ProPlanValidity.getText());
				System.out.println("Vulnerability test automated scan = YES");
				System.out.println("Vulnerability Report = "+subs.ProPlanReport.getText());
				System.out.println("Wrapper - security framework = YES");
				Thread.sleep(3000);
				askSubscriptionUpdateFromUser();

			}
			else
			{
				System.out.println("-----------------------------------------------------------User is in Enterprice plan--------------------------------------");
			}

		}

		jse.executeScript("window.scrollBy(0,-400)", "");
		Thread.sleep(6000);

		child1.log(LogStatus.INFO, "Subscription test was successful");
		
		extent.endTest(parent);

	}

	@Test(groups="positive", priority=2)
	public static synchronized void SubscriptionForControl() throws Exception 
	{	

		try {
			if(subs != null)
			{
				subs = PageFactory.initElements(driver, SubscriptionPageObjects.class);
				Control();
			}
			else
			{
				Control();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='uiview']/div/div/div/div[3]/div[1]/div/ul/li[1]/a")));
			subs.Volume.click();
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
			Thread.sleep(5000);
			selectPatchandLicense();
			ClickSubscribeButton();

			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "subscriptionerror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
			
		}
		
	}

	public static synchronized void Control() throws Exception
	{
		try {
			wait=new WebDriverWait(driver, 10);

//			if(subs.Control.isDisplayed())
//			{
//				subs.Control.click();
//				Thread.sleep(5000);
//			}
//			else
//			{
//				System.out.println("------------------------------------------------------------------Control option not displayed in subscriptions-------------------------");
//			}
			subs.Control.click();
			Thread.sleep(6000);
			selectPatchandLicense();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static synchronized void selectPatchandLicense() throws Exception
	{
		try {

			wait=new WebDriverWait(driver, 10);

			if(subs.Patcher.isDisplayed())
			{
				subs.Patcher.click();
				Thread.sleep(3000);
				ClickSubscribeButton();

			}
			else if(subs.Licensing.isDisplayed())
			{
				subs.Licensing.click();
				Thread.sleep(3000);
				ClickSubscribeButton();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static synchronized void ClickSubscribeButton() throws Exception
	{
		try
		{
			wait=new WebDriverWait(driver, 10);

			if(subs.SubscribeBtn.isDisplayed())
			{
				subs.SubscribeBtn.click();
				Thread.sleep(5000);
				askSubscriptionUpdateFromUser();
			}
			else
			{
				System.out.println("------------------------------------------------------------------Subscription button not displayed in control-------------------------");
			}
			Thread.sleep(2000);
			subs.SubscribeBtn.click();
			Thread.sleep(10000);
			askSubscriptionUpdateFromUser();

		}catch(NoSuchElementException e)
		{
			System.out.println("------------------------------------------------------------------Subscription button for paid not displayed in control-------------------------");
		}

	}


	public static synchronized void askSubscriptionUpdateFromUser() throws Exception
	{
		try {

			wait=new WebDriverWait(driver, 10);

			if(subs.ContinueBtn.isDisplayed())
			{
				subs.ContinueBtn.click();
				Thread.sleep(5000);
				// close the contact administrator popup
				if(driver.findElement(By.xpath("//*[@id='planProcessingView']/div/div/div/form/div[1]/button")).isDisplayed()){
					driver.findElement(By.xpath("//*[@id='planProcessingView']/div/div/div/form/div[1]/button")).click();
				}
			}
			else
			{
				subs.CancelBtn.click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
