package quixxiversion3;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafiles.FilesAndPaths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TakeScreenShots {
	
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest test;
	
	public TakeScreenShots(WebDriver driver,ExtentReports extent, ExtentTest test){
		
		this.driver=driver;
		this.extent=extent;
		this.test=test;
		
	}
	
	public static synchronized void getResult(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 			
                        String screenshotPath = getScreenShot(driver, result.getName());
			//To add it in the extent report 
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
	}
	
	public static synchronized String getScreenShot(WebDriver driver, String ScreenshotName) throws Exception {
		
		String destination=null;
		try {
			
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
			destination= FilesAndPaths.ScreenShotDirectory()+ScreenshotName+dateName+".png";
			System.out.println(destination);
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return destination;

	}

}
