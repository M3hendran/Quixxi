package quixxiversion3;

import java.util.ArrayList;

import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VideoandSupport {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	public VideoandSupport(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){

		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
	}

	// Video Gallery
	@Test(groups="positive", priority = 1)
	public static synchronized void video() throws Exception {

		try {

			parent=extent.startTest("Video and Support");
			child1=extent.startTest("Checking Video and support functionality");
			parent.appendChild(child1);

			//click myapp
			driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[4]/li/a/span")).click();
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked my app");
			Thread.sleep(2000);
			
			//Search with app name
			driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).sendKeys("Protect Now");
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User typed "+driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).getText()+" in the search box");
			Thread.sleep(2000);

			//Compare new app is present or not	
			String newapplicationname = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div[3]/div[2]/a/div/div[3]/h3")).getText();
			WebElement appname = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div[3]/div[2]/a/div/div[3]/h3"));
			if(newapplicationname.contentEquals("Protect Now")){
				//				test.log(LogStatus.INFO, "New application present");
				appname.click();
				Thread.sleep(4000);
				String title = driver.getTitle();
				child1.log(LogStatus.INFO, title);
				Thread.sleep(2000);
			}
			Thread.sleep(10000);
			child1.log(LogStatus.INFO, "Checking Video Gallery");
			Thread.sleep(2000);

			// Checking video gallery text is present	
			String expected = "Video Gallery";
			WebElement textvideogallery = driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/section/div/div[3]/div[2]/p"));
			String textvideo = textvideogallery.getText();
//			child1.log(LogStatus.INFO, textvideo);
//			child1.log(LogStatus.INFO, "Actual and expected texts are: "+ textvideo.equals(expected));

			// Click Video Gallery
			driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/section/div/div[3]/div[2]/a/img")).click();
			Thread.sleep(20000);
			child1.log(LogStatus.INFO, "User clicked video gallery");
			Thread.sleep(2000);
			
			// Storing Newly opened tab and verify
			ArrayList<String> browsertabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browsertabs.get(1));
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, driver.getTitle());
			Thread.sleep(2000);
			
			String Channelname = driver.findElement(By.xpath("//*[@id='channel-title']")).getText();
			child1.log(LogStatus.INFO, Channelname);
			Thread.sleep(2000);
			
			driver.close();
			driver.switchTo().window(browsertabs.get(0));
			Thread.sleep(7000);
			child1.log(LogStatus.INFO, driver.getTitle());
			Thread.sleep(2000);

			extent.endTest(parent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "videopageerror.png")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}
	}

	// Support
	@Test(groups="positive", priority = 2)
	public static synchronized void support() throws Exception{

		try {
			driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/section/div/div[3]/div[3]/img")).click();
			Thread.sleep(20000);
			child1.log(LogStatus.INFO, "User clicked support");
			Thread.sleep(2000);
			
			ArrayList<String> browsertabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(browsertabs.get(1));
			Thread.sleep(10000);
			child1.log(LogStatus.INFO, driver.getTitle());
			Thread.sleep(2000);
			
			// Closing newly opened tab and get back to Quixxi
			driver.close();
			driver.switchTo().window(browsertabs.get(0));
			Thread.sleep(3000);
			
			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "supporterror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}

	}

}
