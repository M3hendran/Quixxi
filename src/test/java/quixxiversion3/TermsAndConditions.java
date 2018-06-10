package quixxiversion3;

import java.util.ArrayList;

import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TermsAndConditions {
	
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	
	public TermsAndConditions(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){
		
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
		
	}
	
	@Test(groups="positive")
	public static synchronized void quixxiPolicy() throws Exception {
		
		try {
			
			parent=extent.startTest("Terms and Conditions");
			child1=extent.startTest("Terms and Conditions functional test");
			parent.appendChild(child1);
			
			Thread.sleep(3000);
			// get current window position
			String currentTab=driver.getWindowHandle();
			
			// click terms and conditions
			
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[4]/div[2]/section/form/div/div[5]/p[1]/a[1]")));
			WebElement terms=driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[5]/p[1]/a[1]"));
			terms.click();
			child1.log(LogStatus.INFO, "User clicked terms");
			Thread.sleep(10000);
			child1.log(LogStatus.INFO, "Terms and conditions link verified");
			
			// get all windows opened
			ArrayList<String> tabs1=new ArrayList<String>(driver.getWindowHandles());
			
			// close the 1st window in tab index
			driver.switchTo().window(tabs1.get(1));
			driver.close();
			
			Thread.sleep(3000);
			
			//get back to the original window position
			driver.switchTo().window(currentTab);
			
			Thread.sleep(5000);
			
			//click policy link
			WebElement policy=driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[5]/p[1]/a[2]"));
			policy.click();
			child1.log(LogStatus.INFO, "User clicked Policy link");
			Thread.sleep(10000);
			child1.log(LogStatus.INFO, "Policy link verified");
			
			//get all window handles in an array
			ArrayList<String> tabs2=new ArrayList<String>(driver.getWindowHandles());

			// close the window in tab array index
			driver.switchTo().window(tabs2.get(1));
			driver.close();
			
			Thread.sleep(2000);

			//get back to the original window position
			driver.switchTo().window(currentTab);
			
			child1.log(LogStatus.INFO, "This class ran successfully");
			
			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "termsandconditionerror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}
		
	}

}
