package quixxiversion3;

import java.io.File;

import javafiles.FilesAndPaths;
import javafiles.ScreenCapture;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageobjects.CodeProtectObjects;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestClasses {
	
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	private static final String url="https://sta-portal.quixxi.com";
	
	public TestClasses (WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){
		
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
		
		
	}

	@Test(groups="positive")
	public static synchronized void testClassesToRun(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2) throws Exception {
		
		try {
			
			driver.get(url);
			String currentUrl=driver.getCurrentUrl();
			
			SignUp sign=new SignUp(driver, extent, parent, child1, child2);
			TermsAndConditions tc=new TermsAndConditions(driver, extent, parent, child1, child2);
			SignInLink signinlink=new SignInLink(driver, extent, parent, child1, child2);
			ForgotPassword forgotpwd=new ForgotPassword(driver, extent, parent, child1, child2);
			SignInPage signinpage=new SignInPage(driver, extent, parent, child1, child2);
			QuixxiAccount qa=new QuixxiAccount(driver, extent, parent, child1, child2);
			SubscriptionScreen subs=new SubscriptionScreen(driver, extent, parent, child1);
			BillingScreen billing=new BillingScreen(driver, extent,parent, child1, child2);
			OverviewAddPlatform overview=new OverviewAddPlatform(driver, extent, parent, child1, child2);
			PackageAddPlatform pack=new PackageAddPlatform(driver, extent, parent, child1, child2);
			VerifyingDocs docs=new VerifyingDocs(driver, extent, parent, child1, child2);
			VulnerabilityCheck vul=new VulnerabilityCheck(driver, extent, parent, child1, child2);
			ControlFunction control=new ControlFunction(driver, extent, parent, child1, child2);
			ProtectNow protect=new ProtectNow(driver, extent, parent, child1, child2);
			CodeProtect code = new CodeProtect(driver, extent, parent, child1);
			MarketPlaceFunction market= new MarketPlaceFunction(driver, extent, parent, child1, child2);
			VideoandSupport videosupport=new VideoandSupport(driver, extent, parent, child1, child2);
			Logout logout=new Logout(driver, extent, parent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
