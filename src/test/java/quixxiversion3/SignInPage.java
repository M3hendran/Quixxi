package quixxiversion3;

import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.itextpdf.xmp.impl.Base64;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SignInPage {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	public static String mail=null;
	public static String pass=null;
	
	public SignInPage(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){
		
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
	}
	
	@Test(groups="positive", dataProvider="signin", dataProviderClass=dataproviders.SignInDataProviders.class)
	public static synchronized void signin(Object[][] data) throws Exception {
		
		mail=data[0][0].toString();
		pass=data[0][1].toString();
		
		System.out.println(mail);
		System.out.println(pass);
		
		try {
			
			parent=extent.startTest("Signin Page");
			child1=extent.startTest("User signin process");
			parent.appendChild(child1);
			
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='form_control_1']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='form_control_1']")).sendKeys(data[0][0].toString());
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User typed mail id:: " + data[0][0].toString());
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[4]/div[1]/input")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[4]/div[1]/input")).sendKeys(data[0][1].toString());
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User typed password:: "+Base64.encode(data[0][1].toString()));
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/a")).click();
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked siginin button");
			Thread.sleep(2000);
			
			//checking dashboard is shown
			String dashboard=driver.getCurrentUrl().toString();
			if(dashboard.equalsIgnoreCase("https://sta-portal.quixxi.com/#/appList")){
				
				child1.log(LogStatus.INFO, "Signin test case successfull");
				Thread.sleep(2000);
				
			}else {
				child1.log(LogStatus.FAIL, "Signin test case failed", child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "Signinpage")));
				Thread.sleep(6000);
			}

			
			child1.log(LogStatus.INFO, "This class ran successfully");
			
			extent.endTest(parent);
			
		} catch (Exception e) {
			
			e.printStackTrace();

			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "errorpage")));
			Thread.sleep(6000);

			extent.endTest(parent);
		}
	}

}
