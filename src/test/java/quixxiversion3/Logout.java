package quixxiversion3;

import javafiles.ReportGenerator;
import javafiles.ScreenCapture;
import javafiles.SendReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Logout {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest test;

	public Logout(WebDriver driver, ExtentReports extent, ExtentTest test){

		this.driver=driver;
		this.extent=extent;
		this.test=test;
	}

	@Test(groups="positive")
	public static synchronized void signout() throws Exception{

		ReportGenerator report=new javafiles.ReportGenerator("extent-report.html", extent, test);
		
		try {
			test=extent.startTest("Signout");

			//logout the system
			driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[1]/li[2]/a/i")).click();
			driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[1]/li[2]/ul/li[6]/a")).click();
			Thread.sleep(5000);


			test.log(LogStatus.INFO, "Logout was successfull");

			report.sendReportViaEmail();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(LogStatus.FAIL, e.fillInStackTrace().toString(), test.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "logouterror")));
			Thread.sleep(6000);

			report.sendReportViaEmail();
		}

	}
}
