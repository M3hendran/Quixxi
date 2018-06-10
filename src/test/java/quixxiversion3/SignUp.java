package quixxiversion3;


import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.SignupPage;

import com.itextpdf.xmp.impl.Base64;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SignUp{

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	
	public SignUp(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){
		
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
		
	}
	
	@Test(groups="positive", dataProvider="signup", dataProviderClass=dataproviders.SignupDataProviders.class)
	public static synchronized void userRegistrationNegative(Object[][] data) throws Exception {
		
		
		try {
			
			parent=extent.startTest("User registration negative test");
			child1=extent.startTest("User registration functional test");
			parent.appendChild(child1);
					
			Thread.sleep(3000);
			SignupPage.registerLink(driver).click();
			child1.log(LogStatus.INFO, "User clicked registration link");
			Thread.sleep(3000);
			
			SignupPage.registerButton(driver).click();
			child1.log(LogStatus.INFO, "User clicked register button");
			Thread.sleep(3000);
			
			WebElement message1=driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div"));
			
			Thread.sleep(5000);
			
			if(message1 !=null){
				
				Assert.assertTrue(message1.getText().contains("Email is required."), "Email field validated");
				Assert.assertTrue(message1.getText().contains("Password is required"), "Password field validated");
			
				child1.log(LogStatus.INFO, "Email and password field validated");
			}
			
			
			SignupPage.email(driver).sendKeys(data[0][0].toString());
			child1.log(LogStatus.INFO, "User typed email :: "+data[0][0].toString());
			Thread.sleep(5000);
			SignupPage.password(driver).sendKeys(data[0][1].toString());
			child1.log(LogStatus.INFO, "User type password :: "+Base64.encode(data[0][1].toString()));
			Thread.sleep(5000);
			SignupPage.registerButton(driver).click();
			child1.log(LogStatus.INFO, "User clicked register button");
			Thread.sleep(5000);
			
			WebElement source=driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[1]/span"));
			
			Thread.sleep(8000);
			
			if (source.getText().equalsIgnoreCase("User Already Exist")){
				
				System.out.println("user already exists - validation appears");
				child1.log(LogStatus.INFO, "user already exists - validation appears");
				
			}else{

				System.out.println("user already exists - validation not appears");
				child1.log(LogStatus.INFO, "user already exists - validation not appears");

			}
			Thread.sleep(6000);
			//checking dashboard is shown
			String dashboard=driver.getCurrentUrl().toString();
			if(dashboard.equalsIgnoreCase("https://sta-portal.quixxi.com/#/appList")){
				
				child1.log(LogStatus.INFO, "Signup case successfull, Dashboard screen visible");
				
			}else {

				child1.log(LogStatus.INFO, "Signup not successfull, hence dashboard screen not visible", child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "signup")));
				Thread.sleep(6000);
				
			}

			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, "Signup test case failed", child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "signuperror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}
		
	}
	
	
}
