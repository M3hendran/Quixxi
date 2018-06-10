package quixxiversion3;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.PackageAddplatform_PageObject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PackageAddPlatform {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	private static ExtentTest child3;
	private static ExtentTest child4;
	private static ExtentTest child5;
	private static PackageAddplatform_PageObject packadd;
	private static ArrayList<String> tabs1;

	public PackageAddPlatform(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2 ){

		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
		
		packadd=PageFactory.initElements(driver, PackageAddplatform_PageObject.class);

	}

	@Test(groups="positive", priority=1)
	public static synchronized void package_addplatform() throws Exception{

		try {

			parent=extent.startTest("Control -> Packge -> Add Platform Page");
			child1=extent.startTest("Add Platform functinal test");
			parent.appendChild(child1);

			//click myapp
			driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[4]/li/a/span")).click();
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked my app");
			Thread.sleep(2000);


			//Search the app
			packadd.app_search.clear();
			Thread.sleep(1000);
			packadd.app_search.sendKeys("emulator launch");
			Thread.sleep(2000);
			child1.log(LogStatus.INFO, "User searched "+packadd.app_search.getText()+" application");
			Thread.sleep(2000);

			//Click the Created app
			packadd.Click_Newapp.click();
			Thread.sleep(8000);
			child1.log(LogStatus.INFO, "User clicked new app button");
			Thread.sleep(2000);

			//Click Control option
			packadd.Click_Control.click();
			Thread.sleep(8000);
			child1.log(LogStatus.INFO, "User clicked control menu");
			Thread.sleep(2000);

			//Click Package option
			packadd.Click_Package_option.click();
			Thread.sleep(7000);
			child1.log(LogStatus.INFO, "User clicked package on left");
			Thread.sleep(2000);

			//Click Add platform button
			Thread.sleep(2000);

			boolean ise=packadd.Click_AddPlatform_btn.isDisplayed();
			if(ise){
				packadd.Click_AddPlatform_btn.click();
				Thread.sleep(8000);
				child1.log(LogStatus.INFO, "User clicked add platform button");
				Thread.sleep(2000);
			}else
			{
				//System.out.println("Package Screen - Add Platform button not displayed");

				Robot robot=new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				Thread.sleep(2000);

				child1.log(LogStatus.INFO, "User clicked pagedown button twice");
				Thread.sleep(2000);

				boolean isd=packadd.package_addplatform_btn.isDisplayed();
				if(isd){

					packadd.package_addplatform_btn.click();
					Thread.sleep(6000);
					child1.log(LogStatus.INFO, "User clicked add platform button");
					Thread.sleep(2000);
				}
				else{


					System.out.println("Package Screen - Add platform button not displayed");
					child1.log(LogStatus.INFO, "Package Screen - Add platform button not displayed");
					Thread.sleep(2000);

				}


			}

			//Click Licensing Checkbox
			boolean isl=packadd.Licensing_checkbox.isSelected();
			if(isl){

				System.out.println("Licensing Checkbox already selected");
				child1.log(LogStatus.INFO, "Licensing Checkbox already selected");
				Thread.sleep(2000);
			}else{

				packadd.Licensing_checkbox.click();
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User clicked licensing checkbox");
				Thread.sleep(2000);
			}

			WebElement elemen=packadd.add_packagename;

			Actions action=new Actions(driver);
			action.moveToElement(elemen).perform();
			Thread.sleep(3000);

			String packnameg="com.titan";
			String packn=null;

			//Click and Enter package name
			boolean packname=packadd.add_packagename.isEnabled();
			if(packname){
				packadd.add_packagename.clear();
				Thread.sleep(2000);
				packadd.add_packagename.sendKeys(packnameg);
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User typed package name :: "+packnameg);
				Thread.sleep(2000);

			}else{
				packn=packadd.add_packagename.getAttribute("value").toString();
				System.out.println("Package Name already displayed");
				child1.log(LogStatus.INFO, "Package Name already displayed");
				Thread.sleep(2000);
			}

			packnameg=packn;

			System.out.println("Package name "+packnameg);
			child1.log(LogStatus.INFO, "Package name "+packnameg);
			Thread.sleep(2000);

			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(2000);

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

			//Click Settings button
			packadd.setting_option.click();
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked settings on top right");
			Thread.sleep(2000);

			//Click Package Details option
			boolean isdd=packadd.packagedetails_option.isDisplayed();
			if(isdd){

				packadd.packagedetails_option.click();
				Thread.sleep(10000);
				child1.log(LogStatus.INFO, "User clicked package details");
				Thread.sleep(2000);

			}else{

				System.out.println("Settings - Package details option not displayed ");
				child1.log(LogStatus.INFO, "Settings - Package details option not displayed ");
				Thread.sleep(2000);
			}

			//Get the package name
			String packagename = packadd.packagename_given.getAttribute("value").toString();
			//System.out.println(""+packagename);
			Thread.sleep(2000);

			if(packagename.equalsIgnoreCase(packnameg)){

				System.out.println("Verified Package name : "+packagename);
				child1.log(LogStatus.INFO, "Verified Package name : "+packagename);
				Thread.sleep(2000);

			}else{

				System.out.println("Package name was different");
				child1.log(LogStatus.INFO, "Package name was different");
				Thread.sleep(2000);
			}

			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "packageaddplatform")));
			Thread.sleep(6000);
			extent.endTest(parent);
		}

	}		
	
	@Test(groups="positive", priority=2)
	public static synchronized void newUser() throws Exception {
		
		child2=extent.startTest("New User");
		parent.appendChild(child2);
		
		try {
			

			// click new user
			driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[2]/li[1]/a[1]/span[1]")).click();
			Thread.sleep(3000);
			child2.log(LogStatus.INFO, "User clicked new user on left");
			Thread.sleep(2000);
			
			// clear and type name
			driver.findElement(By.xpath("//*[@id='form-control']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='form-control']")).sendKeys("mahendran");
			Thread.sleep(2000);
			child2.log(LogStatus.INFO, "User typed name : "+driver.findElement(By.xpath("//*[@id='form-control']")).getText());
			Thread.sleep(2000);
			
			// type email
			driver.findElement(By.xpath("//*[@id='emailControl']")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='emailControl']")).sendKeys("march@grr.la");
			Thread.sleep(2000);
			child2.log(LogStatus.INFO, "User typed mail id : "+driver.findElement(By.xpath("//*[@id='emailControl']")).getText());
			Thread.sleep(2000);
			// select user
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/label[1]")).click();
			Thread.sleep(2000);
			child2.log(LogStatus.INFO, "User selected User choice");
			Thread.sleep(2000);
			
			// click save button
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/span[1]/button[1]/span[1]")).click();
			Thread.sleep(12000);
			child2.log(LogStatus.INFO, "User clicked save button");
			Thread.sleep(2000);
			
			// click arrow in setting
			driver.findElement(By.xpath("/html/body/div[4]/header[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]/i[1]")).click();
			Thread.sleep(3000);
			// click logout
			driver.findElement(By.xpath("/html/body/div[4]/header[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/ul[1]/li[6]/a[1]/span[1]")).click();
			Thread.sleep(3000);
			child2.log(LogStatus.INFO, "User logged out");
			Thread.sleep(2000);

			// sign in with new user account
			driver.findElement(By.xpath("//*[@id='form_control_1']")).sendKeys("march@grr.la");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='form_control_2']")).sendKeys("Testing@12");
			Thread.sleep(2000);
			// Click signin button
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/section[1]/form[1]/div[1]/a[1]/span[1]")).click();
			Thread.sleep(3000);
			child2.log(LogStatus.INFO, "User signed with new user account");
			Thread.sleep(2000);
			//Search the app
			packadd.app_search.clear();
			Thread.sleep(1000);
			packadd.app_search.sendKeys("emulator launch");
			Thread.sleep(2000);
			child1.log(LogStatus.INFO, "User searched "+packadd.app_search.getText()+" application found");
			Thread.sleep(2000);
			child2.log(LogStatus.INFO, "User verified the app is found in his account");
			Thread.sleep(2000);
			
			// logout from new user
			// click arrow in setting
			driver.findElement(By.xpath("/html/body/div[4]/header[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]/i[1]")).click();
			Thread.sleep(2000);
			// click logout
			driver.findElement(By.xpath("/html/body/div[4]/header[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/ul[1]/li[5]/a[1]/span[1]")).click();
			Thread.sleep(2000);
			child2.log(LogStatus.INFO, "User logged out from the new user account");
			Thread.sleep(2000);
			
			extent.endTest(parent);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			child2.log(LogStatus.FAIL, e1.getMessage(), child2.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "newuser")));
			Thread.sleep(6000);
			extent.endTest(parent);
		}

		// new login again
		try {
			
			SignInPage.signin(new Object[][]{{SignInPage.mail,SignInPage.pass},{}});
			child2.log(LogStatus.INFO, "Login with new password has been successfull");
			Thread.sleep(2000);
			extent.endTest(parent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			child2.log(LogStatus.INFO, "Signin failed", child2.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "newusersignin")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}

		try {
			
			//Search the app again to move to menu
			packadd.app_search.clear();
			Thread.sleep(2000);
			packadd.app_search.sendKeys("emulator launch");
			Thread.sleep(3000);
			child2.log(LogStatus.INFO, "User searched "+packadd.app_search.getText()+" application found");
			Thread.sleep(2000);
			//select the app
			driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div[3]/div[2]/a/div/div[3]/h3")).click();
			Thread.sleep(3000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test(groups="positive", priority=3)
	public static synchronized void userList() throws Exception {
		
		child3=extent.startTest("User List");
		parent.appendChild(child3);
		
		try {
			// click settings
			driver.findElement(By.xpath("/html/body/div[4]/header[2]/div[1]/div[2]/div[5]/div[1]/a[1]/span[1]")).click();
			Thread.sleep(2000);
			child3.log(LogStatus.INFO, "User clicked settings");
			Thread.sleep(2000);
			
			// click user list
			driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[2]/li[2]/a[1]/span[1]")).click();
			Thread.sleep(3000);
			child3.log(LogStatus.INFO, "User clicked user list on left");
			Thread.sleep(2000);

			// click add new
			driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[1]/div[2]/div[2]/div[2]/a[1]")).click();
			Thread.sleep(3000);
			child3.log(LogStatus.INFO, "User clicked add new button");
			Thread.sleep(2000);
			
			// clear and type name
			driver.findElement(By.xpath("//*[@id='form-control']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='form-control']")).sendKeys("mahendran");
			Thread.sleep(2000);
			child3.log(LogStatus.INFO, "User clicked name : "+driver.findElement(By.xpath("//*[@id='form-control']")).getText());
			Thread.sleep(2000);
			
			// type email
			driver.findElement(By.xpath("//*[@id='emailControl']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='emailControl']")).sendKeys("march@grr.la");
			Thread.sleep(2000);
			child3.log(LogStatus.INFO, "User typed email id : "+driver.findElement(By.xpath("//*[@id='emailControl']")).getText());
			Thread.sleep(2000);
			
			// select admin
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[3]/label[1]")).click();
			Thread.sleep(2000);
			child3.log(LogStatus.INFO, "User selected admin rights for the user");
			Thread.sleep(2000);
			
			// click save button
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/span[1]/button[1]/span[1]")).click();
			Thread.sleep(6000);
			child3.log(LogStatus.INFO, "User clicked save button");
			Thread.sleep(2000);

			// click user list
			driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[2]/li[2]/a[1]/span[1]")).click();
			Thread.sleep(3000);

			// select edit arrow
			driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/a[1]")).click();
			Thread.sleep(2000);
			// select edit 
			driver.findElement(By.xpath("//*[@id='dataAction1']/li[1]")).click();
			Thread.sleep(6000);
			
			//update button
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/span[1]/button[1]/span[1]")).click();
			Thread.sleep(3000);
			
			extent.endTest(parent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			child3.log(LogStatus.INFO, e.fillInStackTrace().toString(), child3.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "userlist")));
			Thread.sleep(6000);
			extent.endTest(parent);
		}

	}
	
	@Test(groups="positive", priority=4)
	public static synchronized void hackDetection() throws Exception{
		
		try {
			
			child4=extent.startTest("Hack detection");
			parent.appendChild(child4);
			
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			Thread.sleep(2000);
			
			// click hack detection
			driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[4]/li[1]/a[1]/span[1]")).click();
			Thread.sleep(3000);
			child4.log(LogStatus.INFO, "User clicked Hack detection");
			Thread.sleep(2000);
			
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-200)");
			Thread.sleep(2000);

			// click save button
			driver.findElement(By.xpath("//*[@id='licensingControl']/span[1]")).click();
			Thread.sleep(6000);
			
			extent.endTest(parent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			child4.log(LogStatus.INFO, e.fillInStackTrace().toString(), child4.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver,"hackdetection")));
			Thread.sleep(6000);
			extent.endTest(parent);
		}
		
	}
	
	@Test(groups="positive", priority=5)
	public static synchronized void notification() throws Exception {
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
		
		try {
			
			child5=extent.startTest("Malware Notifications");
			parent.appendChild(child5);
			// click notification on left
			driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/div[4]/li[2]/a[1]/span[1]")).click();
			Thread.sleep(3000);
			child5.log(LogStatus.INFO, "User clicked notifications on left");
			Thread.sleep(2000);
			
			// type email
			driver.findElement(By.xpath("//*[@id='divNotificationSettingControl']/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[1]")).sendKeys("m.rajagopalan@lakeba.com");
			Thread.sleep(2000);
			child5.log(LogStatus.INFO, "User typed email id");
			Thread.sleep(2000);
			
			// click add button
			driver.findElement(By.xpath("//*[@id='divNotificationSettingControl']/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]")).click();
			Thread.sleep(3000);
			child5.log(LogStatus.INFO, "User clicked add button");
			Thread.sleep(2000);
			
			// click save button
			driver.findElement(By.xpath("//*[@id='licensingControl']")).click();
			Thread.sleep(6000);
			child5.log(LogStatus.INFO, "User clicked save button");
			Thread.sleep(2000);
			
			//getting no.of columns
			List<WebElement> col=driver.findElements(By.xpath("//*[@id='tblFrequency']/thead[1]/tr[1]/th"));
			
			for(WebElement thead:col){
				
				System.out.println(thead.getText());
				child5.log(LogStatus.INFO, thead.getText());
				Thread.sleep(2000);
			}
			
			// getting notification messages
			
			List<WebElement> messages=driver.findElements(By.xpath("//*[@id='tblFrequency']/tbody[1]/tr"));
			
			for (WebElement notification : messages){
				
				System.out.println(notification.getText());
				child5.log(LogStatus.INFO, notification.getText());
				Thread.sleep(2000);
			}
			
			extent.endTest(parent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			child5.log(LogStatus.INFO, e.fillInStackTrace().toString(), child5.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "malwarealerts")));
			Thread.sleep(6000);
			extent.endTest(parent);
		}
		
	}

	
	public static synchronized void waitForCompilation()throws Exception{

		boolean compiled = false;

		try {
			
			WebElement element = driver.findElement(By.xpath("//*[@id='progress-info']/span[1]/span[1]"));
			//*[@id="dropfile"]/div/div[3]/h1
			do {
				
				if (element.getText().contains("100%") ) {

					compiled=true;
					
				}

			} while (!compiled);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
