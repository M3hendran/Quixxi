package quixxiversion3;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.PackageAddplatform_PageObject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OverviewAddPlatform {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	private static PackageAddplatform_PageObject packadd;
	private static ArrayList<String> tabs1;

	public OverviewAddPlatform(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){

		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;

		packadd=PageFactory.initElements(driver, PackageAddplatform_PageObject.class);
	}

	@Test(groups="positive")
	public static synchronized void overview_addplatform() throws Exception{

		try {

			parent=extent.startTest("Control -> Overview -> Add Platform Page");
			child1=extent.startTest("Add Platform functional test");
			parent.appendChild(child1);

			pageobjects.Overviewaddplatform_PageObject overadd=PageFactory.initElements(driver, pageobjects.Overviewaddplatform_PageObject.class);

			//click myapp
			driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[4]/li/a/span")).click();
			child1.log(LogStatus.INFO, "User clicked myapp");
			Thread.sleep(6000);

			//click add new
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/div[1]/div[3]/div[1]/a/div")).click();
			child1.log(LogStatus.INFO, "User clicked Add New button");
			Thread.sleep(3000);

			// type app name
			WebElement newappname = driver.findElement(By.xpath("//*[@id='basic']/div/form/div/div[2]/div/div/input"));
			String textintextbox = newappname.getAttribute("value");
			System.out.println("text present " +textintextbox);
			Thread.sleep(3000);
			newappname.sendKeys("emulator launch");
			child1.log(LogStatus.INFO, "User type app name :: "+newappname.getText());
			Thread.sleep(3000);

			//click create app button
			driver.findElement(By.xpath("//*[@id='basic']/div/form/div/div[3]/button")).click();
			child1.log(LogStatus.INFO, "User clicked create app button");
			Thread.sleep(4000);


			//Search the app
			Thread.sleep(3000);
			overadd.app_search.clear();
			Thread.sleep(2000);
			overadd.app_search.sendKeys("emulator launch");
			child1.log(LogStatus.INFO, "User typed "+overadd.app_search.getText());
			Thread.sleep(3000);

			//Click the newly created app
			overadd.Click_Newapp.click();
			child1.log(LogStatus.INFO, "User selected the app");
			Thread.sleep(8000);

			//Click Control
			overadd.Click_Control.click();
			child1.log(LogStatus.INFO, "User clicked control menu");
			Thread.sleep(10000);

			//Click addplatform button in the overview screen
			boolean dis=overadd.overview_addplatform_btn.isDisplayed();
			if(dis){

				overadd.overview_addplatform_btn.click();
				child1.log(LogStatus.INFO, "User clicked Add Platform in overview page");
				Thread.sleep(8000);

			}else{

				System.out.println("Overview screen - add platform button not displayed");
			}


			//Click add platform button in the package screen
			//Thread.sleep(2000);

			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.delay(3000);
			child1.log(LogStatus.INFO, "User clicked pagedown key");

			boolean isd=overadd.package_addplatform_btn.isDisplayed();

			if(isd){

				overadd.package_addplatform_btn.click();
				child1.log(LogStatus.INFO, "User clicked Add Platform in package menu");
				Thread.sleep(6000);
			}
			else{

				System.out.println("Package Screen - Add platform button not displayed");

			}

			//Click Licensing Checkbox
			boolean isl=overadd.Licensing_checkbox.isSelected();
			if(isl){
				System.out.println("Licensing Checkbox already selected");
			}else{

				overadd.Licensing_checkbox.click();
				child1.log(LogStatus.INFO, "User selected Licensing framework");
				Thread.sleep(3000);
			}


			WebElement elemen=overadd.add_packagename;

			Actions action=new Actions(driver);
			action.moveToElement(elemen).perform();
			Thread.sleep(3000);

			//Click and Enter package name
			boolean packname=overadd.add_packagename.isEnabled();
			if(packname){
				overadd.add_packagename.clear();
				Thread.sleep(2000);
				overadd.add_packagename.sendKeys("com.emulator");
				child1.log(LogStatus.INFO, "User type package name :: "+overadd.add_packagename.getText());
				Thread.sleep(3000);
			}else{

				System.out.println("Package Name already displayed");
			}

			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(2000);

			//********

			child1.log(LogStatus.INFO, "User pressed pagedown button");
			Thread.sleep(2000);

			// type server key
			driver.findElement(By.xpath("//*[@id='platform']/div/div/form/div[2]/div/div[7]/div[1]/div/input")).sendKeys("Test");
			Thread.sleep(2000);

			// type license key
			driver.findElement(By.xpath("//*[@id='platform']/div/div/form/div[2]/div/div[7]/div[4]/div/input")).sendKeys("Test");
			Thread.sleep(2000);

			//Click start packaging button
			boolean ist=packadd.startpackaging_btn.isEnabled();
			if(ist){
				packadd.startpackaging_btn.click();
				Thread.sleep(5000);
				child1.log(LogStatus.INFO, "User clicked start package button");
				Thread.sleep(2000);

			}else{

				System.out.println("Start packaging button was not enabled");
				child1.log(LogStatus.INFO, "Start packaging button was not enabled");
				Thread.sleep(2000);
			}


			if(driver.findElement(By.xpath("//*[@id='platform']/div/div/form/div[3]")).isDisplayed()){

				// click on hack detection checkbox in subscription

				WebElement elem=packadd.licensing_checkbox_subscribe;
				action.moveToElement(elem).perform();
				Thread.sleep(5000);

				//Click and select Licensing checkbox in subscribe window
				packadd.licensing_checkbox_subscribe.click();
				Thread.sleep(3000);

				//Click subscribe button 
				boolean isc=packadd.subscribe_btn.isEnabled();
				if(isc){
					packadd.subscribe_btn.click();
					Thread.sleep(5000);
				}else{
					System.out.println("Subscribe button not enabled");
				}

				//Click Continue button in the subscription pop up window
				boolean isv=packadd.continue_btn_subscription.isDisplayed();
				if(isv){
					packadd.continue_btn_subscription.click();
					Thread.sleep(5000);
					System.out.println("Your Subscription Updated Successfully");

				}else{
					System.out.println("Continue button not displayed in the subscription pop up window");
				}

			}
			//Check and Verify licensing added or not 
			Thread.sleep(8000);
			String lic="HACK DETECTION";
			String str=packadd.licensing_text_verify.getText();

			if(str.equalsIgnoreCase(lic)){

				System.out.println("Licensing Platform added successfully into your app");
				child1.log(LogStatus.INFO, "Licensing Platform added successfully into your app");
				Thread.sleep(2000);
			}else{

				System.out.println("Licensing Platform was not added successfully in to app");
				child1.log(LogStatus.INFO, "Licensing Platform was not added successfully in to app");
				Thread.sleep(2000);
			}

			// if progress bar exists, wait for compilation
			if (driver.findElement(By.xpath("//*[@id='progress-info']/span[1]/span[1]")).isDisplayed()) {

				if(driver.findElement(By.xpath("//*[@id='progress-info']/span[1]/span[1]")).getText().contains("completed")){

					System.out.println("Compilation already completed");
				}

			} else {

				waitForCompilation();
				child1.log(LogStatus.INFO, "Compilation is successfull");
				Thread.sleep(2000);

			}


			// click download library
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div[4]/div/div/table/tbody/tr/td[6]/div/span[1]/a/img")).click();

			// click download app
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div[4]/div/div/table/tbody/tr/td[6]/div/span[2]/a/img")).click();

			// click launch app
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div[4]/div/div/table/tbody/tr/td[6]/div/span[3]/a/img")).click();
			Thread.sleep(20000);

			tabs1=new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(1));
			Thread.sleep(3000);
			driver.close();

			// switch to quixxi application window
			driver.switchTo().window(tabs1.get(0));
			Thread.sleep(3000);

			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "overviewpage")));
			Thread.sleep(6000);

			extent.endTest(parent);
		}

	}

	public static synchronized void waitForCompilation()throws Exception{

		boolean compiled = false;


		try {

			do {

				Thread.sleep(3000);

				// 100% completed
				WebElement completed = driver.findElement(By.xpath("//*[@id='progress-info']/li[1]"));

				String completedtext=completed.getText();

				if ((Integer.parseInt(completedtext.substring(0,completedtext.indexOf("%") )))>10 ){

					System.out.println(completedtext);

					if (completedtext.equalsIgnoreCase("100% completed") ) {

						compiled=true;

						child1.log(LogStatus.INFO, "compilation success");

					}

				}

			} while (compiled == false);

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		if(compiled==false){

			Thread.sleep(3000);

			// compilation failed
			WebElement failed=driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div[3]/div[1]/div[3]/h3"));

			String failedtext=failed.getText();

			System.out.println(failedtext);

			if(failed.isDisplayed()){

				if(failedtext.contains("compilation failed")){

					child1.log(LogStatus.INFO, "compilation failed");

				}

			}

		}

	}

}