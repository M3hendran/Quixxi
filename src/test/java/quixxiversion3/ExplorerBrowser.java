package quixxiversion3;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExplorerBrowser {

	public static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;


	public ExplorerBrowser(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2) {

		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
		
	}

	@Test(groups="positive")
	public static void explorer() throws Exception {

		try {
			
			parent=extent.startTest("Internet Explorer");
			
			// checking os
			String osname=System.getProperty("os.name").toLowerCase();

			System.out.println(osname);

			if (osname.indexOf("windows 8.1")>=0){

				child1=extent.startTest("Automation using IE Browser in "+osname);
				
				parent.appendChild(child1);

				// Internet Explorer
				System.setProperty("webdriver.ie.driver", javafiles.FilesAndPaths.Browsers()+File.separator+"IEDriverServer.exe");
				driver = new InternetExplorerDriver();	

				TestClasses.testClassesToRun(driver, extent, parent, child1, child2);

			}

			if (osname.indexOf("windows 10")>=0){

				child1=extent.startTest("Automation using Edge Browser in "+osname);
				parent.appendChild(child1);

				// Internet Explorer
				System.setProperty("webdriver.edge.driver", javafiles.FilesAndPaths.Browsers()+File.separator+"MicrosoftWebDriver.exe");
				DesiredCapabilities edgebrowser=new DesiredCapabilities().edge();
				driver = new EdgeDriver(edgebrowser);

				TestClasses.testClassesToRun(driver, extent, parent, child1, child2);

			}
			
			extent.endTest(parent);
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.ERROR, e.getMessage());
			
			extent.endTest(parent);
			
		}
	}

}
