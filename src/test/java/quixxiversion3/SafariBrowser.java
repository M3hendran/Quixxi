package quixxiversion3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SafariBrowser {
	
	public static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	public SafariBrowser(WebDriver driver, ExtentReports extent,ExtentTest parent, ExtentTest child1, ExtentTest child2){
		
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
		
	}
	
	@Test(groups="positive")
	public static void safari() throws Exception {
		
	    try {
	    	
	    	parent=extent.startTest("Safari Browser");
	    	parent.appendChild(child1);
	    	
			// checking os
			String osname=System.getProperty("os.name").toLowerCase();

			if (osname.indexOf("mac")>=0){

    			child1=extent.startTest("Automation using Safari Browser in "+osname);

				// Safari Browser
				driver = new SafariDriver();
				
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
