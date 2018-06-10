package quixxiversion3;

import java.io.File;

import javafiles.FilesAndPaths;
import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.itextpdf.xmp.impl.Base64;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SignInLink {
	
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	
	public static String mail=null;
	public static String pass=null;
	
	public SignInLink(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){
		
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
		
	}
	
	@Test(groups="positive", dataProvider="signin", dataProviderClass=dataproviders.SignInDataProviders.class)
	public static synchronized void signinUsingLink(Object[][] data) throws Exception {
		
		mail=data[0][0].toString();
		pass=data[0][1].toString();
		
		try {
			
			parent=extent.startTest("Signin from Signup page");
			child1=extent.startTest("Signin from Signup Page functional test");
			parent.appendChild(child1);
			
			//login from signup page
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[5]/p[2]/a")).click();
			child1.log(LogStatus.INFO, "User clicked signin link");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='form_control_1']")).sendKeys(data[0][0].toString());
			child1.log(LogStatus.INFO, "User typed mail id :: "+data[0][0].toString());
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[4]/div[1]/input")).sendKeys(data[0][1].toString());
			child1.log(LogStatus.INFO, "User typed password :: "+Base64.encode(data[0][1].toString()));
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/a")).click();
			child1.log(LogStatus.INFO, "User clicked signin button");
			Thread.sleep(10000);
			System.out.println("Your are in SignInLink  - Successful");
			child1.log(LogStatus.INFO, "Sign in link testcase completed successfully");
			//logout the system
			driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[1]/li[2]/a/i")).click();
			driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[1]/li[2]/ul/li[6]/a")).click();
			child1.log(LogStatus.INFO, "User logged out the system");
			Thread.sleep(6000);

			child1.log(LogStatus.INFO, "Signin from Signup page was successful");
			
			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "signinlinkerror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}

	}

}
