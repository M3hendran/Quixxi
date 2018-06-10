package quixxiversion3;

import java.io.File;

import javafiles.FilesAndPaths;
import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ForgotPassword {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	public ForgotPassword(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest chidl1, ExtentTest child2){

		this.driver=driver;
		this.extent=extent;
		this.child1=chidl1;
		this.child2=child2;
	}

	@Test(groups="positive")
	public static synchronized void forget() throws Exception {

		try {
			
			parent=extent.startTest("Forgot Password");
			child1=extent.startTest("Forgot Password Functional test");
			parent.appendChild(child1);

			// click forgot password
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[5]/a")).click();
			Thread.sleep(5000);
			child1.log(LogStatus.INFO, "User clicked forgot password button");

			//clear the input field and enter value
			//driver.findElement(By.xpath("html/body/div[4]/div[2]/section/div/div[3]/form/div/div/input")).clear();
			//driver.findElement(By.xpath("html/body/div[4]/div[2]/section/div/div[3]/form/div/div/input")).sendKeys("jantest1lakeba@gmail.com");
			
			//new path is
			driver.findElement(By.xpath("//*[@id='form_control_1']")).clear();
			driver.findElement(By.xpath("//*[@id='form_control_1']")).sendKeys("jantest1lakeba@gmail.com");
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User typed :: "+driver.findElement(By.xpath("//*[@id='form_control_1']")).getText());
			// click reset button
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/div/a/span[1]")).click();
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User clicked reset button");
			Thread.sleep(2000);

			// verify the message
			String message=driver.findElement(By.xpath("html/body/div[4]/div[2]/section/div/div[2]/span")).getText();
			child1.log(LogStatus.INFO, "Message Displayed as :: "+message);
			Thread.sleep(2000);
			//click login
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/div/div[4]/p/a")).click();
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked login again");
			Thread.sleep(2000);
			extent.endTest(parent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "forgotpassworderror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}

	}
}
