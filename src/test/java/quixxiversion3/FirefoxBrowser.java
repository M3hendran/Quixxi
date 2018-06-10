package quixxiversion3;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FirefoxBrowser {

	public static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	@Test(groups="positive", priority=1)
	public static void createReport() throws Exception {

		extent = new ExtentReports(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"extent-report.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir")+File.separator+"extent-config.xml"));
		parent=extent.startTest("Firefox Browser");
		parent.appendChild(child1);
		child1.assignAuthor("Automation done by: Mahendran");
		child1.log(LogStatus.INFO, "Report created successfully");
	}



	@SuppressWarnings("deprecation")
	@Test(groups="positive", priority=2)
	public static void firefox() throws Exception {

		try {
			// checking os
			String osname=System.getProperty("os.name").toLowerCase();

			if (osname.indexOf("win")>=0){

				child1=extent.startTest("Automation using Firefox Browser in "+osname);

//				Proxy proxy=new Proxy();
//				proxy.setHttpProxy("localhost:8090");
//				proxy.setFtpProxy("localhost:8090");
//				proxy.setSslProxy("localhost:8090");
				
				
				// Firefox
				System.setProperty("webdriver.gecko.driver", javafiles.FilesAndPaths.Browsers()+File.separator+"geckodriver.exe");

				// set DesiredCapabilities
//				DesiredCapabilities capabilities=new DesiredCapabilities();
//				capabilities.setCapability(CapabilityType., proxy);
				
				
				driver=new FirefoxDriver();

				TestClasses.testClassesToRun(driver, extent, parent, child1, child2);

			}else if(osname.indexOf("mac")>=0){

				child1=extent.startTest("Automation using Firefox Browser in "+osname);

				// Firefox
				System.setProperty("webdriver.gecko.driver", javafiles.FilesAndPaths.macSystem()+File.separator+"geckodriver");

				driver=new FirefoxDriver();

				TestClasses.testClassesToRun(driver, extent, parent, child1, child2);

			}else if(osname.indexOf("nix") >= 0 || osname.indexOf("nux") >= 0 || osname.indexOf("aix") > 0 ){

				child1=extent.startTest("Automation using Firefox Browser in "+osname);

				// Firefox
				System.setProperty("webdriver.gecko.driver", javafiles.FilesAndPaths.linuxSystem()+File.separator+"geckodriver");

				driver=new FirefoxDriver();

				TestClasses.testClassesToRun(driver, extent, parent, child1, child2);

			}
			
			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, e.getMessage());
			
			extent.endTest(parent);

		}

	}
}
