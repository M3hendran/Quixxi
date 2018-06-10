package quixxiversion3;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import javafiles.Action;
import javafiles.ScreenCapture;
import javafiles.emulator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageobjects.ControlObjects;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ControlFunction{

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;
	private static Robot robot;

	public ControlFunction(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){

		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;

	}

	//Function to add analytics platform
	@Test(groups="positive", priority=1)
	public static synchronized void quixxi_superAdmin_004() throws Exception {

		try {
			//Robot
			robot = new Robot();
			Thread.sleep(5000);

			parent=extent.startTest("Control");
			child1=extent.startTest("User & Events");
			parent.appendChild(child1);

			//click myapp
			driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[4]/li/a/span")).click();
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked myapp");
			Thread.sleep(2000);

			//Search with app name
			driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).clear();
			driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).sendKeys("CommBank-3-28");
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User typed :: "+driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).getText());
			Thread.sleep(2000);

			Action.click(ControlObjects.clickOnApp(driver));
			Thread.sleep(6000);
			//child1.log(LogStatus.INFO, "User selected the :: "+ControlObjects.clickOnApp(driver).getText());

			Action.click(ControlObjects.clickControl(driver));
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked Control");
			Thread.sleep(2000);
			

			// Click package
			driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[1]/li[2]/a/span")).click();
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User clicked package on left");
			Thread.sleep(2000);
			
			//Launch Demo App

			Action.click(ControlObjects.launchDemoApp(driver));
			Thread.sleep(20000);
			ArrayList<String> window = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(window.get(1));
			Thread.sleep(25000);

			//Emulator Process
			emulator.robot();
			Thread.sleep(3000);

			driver.switchTo().window(window.get(1)).close();

			driver.switchTo().window(window.get(0));

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	@Test(groups="positive", priority=2)
	public static synchronized void dataTab() throws Exception {
		
		try {
			// click Device/users
			driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div/div/div/ul/div[2]/li/a[2]/span")).click();
			Thread.sleep(6000);

			//data tab
			driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
			Thread.sleep(6000);

			for (int i=1; i<=7; i++){

				Action.click(ControlObjects.EventCalendarddarrow(driver));
				driver.findElement(By.xpath("//div[@class='ranges']/ul/li["+i+"]")).click();
				Thread.sleep(3000);

			}		

			// click the view option
			driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[2]/div[4]/div/div[2]/table/tbody/tr[1]/td[7]/div/a")).click();
			Thread.sleep(2000);

			// click View details
			driver.findElement(By.xpath("//*[@id='dataAction1']/li[1]")).click();
			Thread.sleep(6000);

			// click close button inside window
			driver.findElement(By.xpath("//*[@id='c-menu--slide-right']/button/i")).click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(groups="positive", priority=3)
	public static synchronized void chartTab() throws Exception {

		try {
			Thread.sleep(3000);
			
			// Click chart
			driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[1]/div[2]/div[1]/ul/li[1]")).click();
			Thread.sleep(3000);

			for (int i=1; i<=7; i++){

				Action.click(ControlObjects.EventCalendarddarrow(driver));
				driver.findElement(By.xpath("//div[@class='ranges']/ul/li["+i+"]")).click();
				Thread.sleep(3000);

			}

			//ChartValue
			List<WebElement> texts=driver.findElements(By.cssSelector("div.amChartsLegend.amcharts-legend-div svg g g g"));
			for(WebElement count:texts){
				System.out.println(count.getText());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	@Test(groups="positive", priority=4)
	public static synchronized void illegalUsers() throws Exception {
		
		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
			Thread.sleep(3000);

			// click illegal users
			driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[3]/li[1]/a[2]/span")).click();
			Thread.sleep(6000);

			for (int i=1; i<=7; i++){

				Action.click(ControlObjects.EventCalendarddarrow(driver));
				driver.findElement(By.xpath("/html/body/div[8]/div[1]/ul/li["+i+"]")).click();
				Thread.sleep(3000);

			}

			// click actions
			driver.findElement(By.xpath("//*[@id='dataTable']/tbody/tr[1]/td[8]/div/button")).click();
			Thread.sleep(3000);

			// click view
			driver.findElement(By.xpath("//*[@id='dataAction1']/li[1]")).click();
			Thread.sleep(3000);

			// click close inside window
			driver.findElement(By.xpath("//*[@id='c-menu--slide-right']/button")).click();
			Thread.sleep(2000);

			// get total illegal users
			String totalusers=driver.findElement(By.xpath("//*[@id='chart-area']/div/div[3]/div/div[1]/div/b")).getText();
			System.out.println(totalusers);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(groups="positive", priority=5)
	private static synchronized void piratedVersions() throws Exception {

		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
			Thread.sleep(3000);
			
			// click pirated versions
			driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div/div/div/ul/div[3]/li[2]/a[2]/span")).click();
			Thread.sleep(6000);


			for (int i=1; i<=7; i++){

				Action.click(ControlObjects.EventCalendarddarrow(driver));
				driver.findElement(By.xpath("/html/body/div[9]/div[1]/ul/li["+i+"]")).click();
				Thread.sleep(3000);

			}

//		// click andorid icon
//		driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/ul/li[1]")).click();
//		Thread.sleep(2000);
//
//		// click ios icon
//		driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/ul/li[2]")).click();
//		Thread.sleep(2000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(groups="positive", priority=6)
	public static synchronized void threatlogs() throws Exception {

		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
			Thread.sleep(3000);
			
			// click threat logs
			driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[4]/li[1]/a[2]/span")).click();
			Thread.sleep(6000);

			// click android icon
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/ul/li[1]")).click();
			Thread.sleep(3000);

			// click ios icon
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/ul/li[2]")).click();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(groups="positive", priority=7)
	public static synchronized void malwareDetection() throws Exception {

		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
			Thread.sleep(3000);
			
			// click malware
			driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[4]/li[2]/a[2]/span")).click();
			Thread.sleep(6000);

			// click android icon
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/ul/li[1]")).click();
			Thread.sleep(3000);

			// click ios icon
			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[1]/div[1]/ul/li[2]")).click();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Test(groups="positive", priority=8)
	public static synchronized void diagnostics() throws Exception {

		//Diagnostics

		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
			Thread.sleep(3000);

			//Action.click(ControlObjects.Diagnostics(driver));
			driver.findElement(By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[5]/li[1]/a/span")).click();
			Thread.sleep(20000);
			child1.log(LogStatus.INFO, "User clicked Diagnostics on left");
			Thread.sleep(2000);
			
			//robot.keyPress(KeyEvent.VK_PAGE_UP);
			//robot.keyRelease(KeyEvent.VK_PAGE_UP);
			Thread.sleep(6000);

			for (int i=1; i<=7; i++){

				Action.click(ControlObjects.EventCalendarddarrow(driver));
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[10]/div[1]/ul/li["+i+"]")).click();
				Thread.sleep(3000);

			}

			String totalcrash=driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[1]/div[1]/h1[2]")).getText();
			System.out.println(totalcrash);

			String distinctcrash=driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[1]/div[2]/h1")).getText();
			System.out.println(distinctcrash);

			//		// Click the calendar
			//		driver.findElement(By.xpath("//*[@id='selectedrangeid']/span[2]")).click();
			//		child1.log(LogStatus.INFO, "User clicked calendar");
			//		Thread.sleep(3000);
			//		// Select This years in the calendar
			//		driver.findElement(By.xpath("html/body/div[8]/div[1]/ul/li[7]")).click();
			//		child1.log(LogStatus.INFO, "User selected "+driver.findElement(By.xpath("//*[@id='selectedrangeid']")).getText().toUpperCase());
			//		Thread.sleep(5000);

			Action.click(ControlObjects.DiagnosticsData(driver));
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked data");
			Thread.sleep(2000);

			//		Action.click(ControlObjects.DiagnosticsCalendarddarrow(driver));
			//		child1.log(LogStatus.INFO, "User clicked Calendar on data page");
			//		Thread.sleep(5000);
			//		//Action.click(ControlObjects.DiagnosticsCalendarddyear(driver));
			//		driver.findElement(By.xpath("html/body/div[8]/div[1]/ul/li[7]")).click();
			//		child1.log(LogStatus.INFO, "User selected "+driver.findElement(By.xpath("//*[@id='selectedrangeid']")).getText().toUpperCase());
			//		Thread.sleep(5000);

			for (int i=1; i<=7; i++){

				Action.click(ControlObjects.EventCalendarddarrow(driver));
				driver.findElement(By.xpath("/html/body/div[10]/div[1]/ul/li["+i+"]")).click();
				Thread.sleep(3000);

			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			WebDriverWait element=new WebDriverWait(driver, 10);
			element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dataTabView']/div[3]/div/p")));
			String textOfElement=driver.findElement(By.xpath("//*[@id='dataTabView']/div[3]/div/p")).getText();
			if (textOfElement.equalsIgnoreCase("No data available")){

				System.out.println("No records found");
				child1.log(LogStatus.INFO, "No records found");

			} else {

				Action.click(ControlObjects.DiagnosticsViewButton(driver));
				Thread.sleep(5000);
				child1.log(LogStatus.INFO, "User clicked view button");
				Thread.sleep(2000);

				Action.click(ControlObjects.DiagnosticsViewCloseButton(driver));
				Thread.sleep(5000);
				child1.log(LogStatus.INFO, "User clicked close button");
				Thread.sleep(2000);

				Action.click(ControlObjects.DiagnosticsChartView(driver));
				Thread.sleep(5000);
				child1.log(LogStatus.INFO, "User clicked chart");
				Thread.sleep(2000);

			}

			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.INFO, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "Diagnosticpage")));
			Thread.sleep(6000);

			extent.endTest(parent);
		}

		//ChartValue
		System.out.println("Total Crash Count:");
		List<WebElement> texts11=driver.findElements(By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[2]/div[1]/div[1]/div/div[1]"));
		for(WebElement count:texts11){
			System.out.println(count.getText());
		}

		Thread.sleep(5000);

		extent.endTest(parent);
	}

//	@Test(groups="positive", priority=9)
//	public static synchronized void Events() throws Exception {
//
//		try {
//			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
//			Thread.sleep(3000);
//
//			//Event
//			Action.click(ControlObjects.event(driver));
//			Thread.sleep(5000);
//			child1.log(LogStatus.INFO, "User clicked Event on left");
//
//			for (int i=1; i<=7; i++){
//
//				Action.click(ControlObjects.EventCalendarddarrow(driver));
//				driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li["+i+"]")).click();
//				Thread.sleep(3000);
//
//			}
//
//			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
//			Thread.sleep(3000);
//
//			// view record no of rows selection
//			Action.click(ControlObjects.ViewRecords(driver));
//			child1.log(LogStatus.INFO, "User selected view records");
//			Thread.sleep(3000);
//			Action.click(ControlObjects.ViewRecordsSecondValuevalue(driver));
//			Thread.sleep(3000);
//			child1.log(LogStatus.INFO, "User selected number of records "+ControlObjects.ViewRecordsSecondValuevalue(driver).getText().toUpperCase());
//
//			// view record event selection
//			//Action.click(ControlObjects.EventCategorydd(driver));
//			driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[3]/div[3]/div/select/option[2]")).click();
//			Thread.sleep(3000);
//			child1.log(LogStatus.INFO, "User selected the event "+driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[3]/div[3]/div/select/option[2]")).getText().toUpperCase());
//			
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		try {
//
//			Thread.sleep(6000);
//			WebElement element=driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[4]/div/div/table/tbody/tr"));
//
//			// checking table row is displayed
//			if (element.isDisplayed()){
//
//				//Action.click(ControlObjects.EventViewButton(driver));
//				driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div[1]/div[4]/div/div/table/tbody/tr/td[5]/a")).click();
//				Thread.sleep(6000);
//				child1.log(LogStatus.INFO, "User clicked event view button");
//				Action.click(ControlObjects.EventViewCloseIcon(driver));
//				child1.log(LogStatus.INFO, "User clicked event window Close button");
//				Thread.sleep(2000);
//				//				Action.click(ControlObjects.EventCategoryThirdvalue(driver));
//				//				child1.log(LogStatus.INFO, "User clicked event category");
//				//				Thread.sleep(2000);
//				//				Action.click(ControlObjects.EventViewButton(driver));
//				//				child1.log(LogStatus.INFO, "User clicked event view button");
//				//				Thread.sleep(2000);
//				//				Action. click(ControlObjects.EventViewCloseIcon(driver));
//				//				child1.log(LogStatus.INFO, "User clicked event window Close button");
//				//				Thread.sleep(2000);
//				//				Action.click(ControlObjects.EventCategoryFourthvalue(driver));
//				//				child1.log(LogStatus.INFO, "User clicked event category fourth value");
//				//				Thread.sleep(2000);
//				//				Action.click(ControlObjects.EventViewButton(driver));
//				//				child1.log(LogStatus.INFO, "User clicked event view button");
//				//				Thread.sleep(2000);
//				//				Action.click(ControlObjects.EventViewCloseIcon(driver));
//				//				child1.log(LogStatus.INFO, "User clicked event window close button");
//				//				Thread.sleep(2000);
//
//				extent.endTest(parent);
//
//			}
//
//		} catch (Exception e) {
//
//			// TODO Auto-generated catch block
//			try {
//
//				WebDriverWait norecord=new WebDriverWait(driver, 10);
//				norecord.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id='recordNotFoundMsg']")));
//				String elementText=driver.findElement(By.xpath("")).getText();
//				// checking no records found appears
//				if(elementText.equals("No data available")){
//
//					//to move up
//					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)","");
//					Thread.sleep(3000);
//
//				}
//
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				//to move up
//				((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)","");
//				Thread.sleep(3000);
//			}
//
//			child1.log(LogStatus.FAIL, e.getMessage(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "Eventspage")));
//			Thread.sleep(6000);
//
//			extent.endTest(parent);
//
//		}
//
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)");
//		
//		Thread.sleep(3000);
//		Action.click(ControlObjects.user(driver));
//		child1.log(LogStatus.INFO, "User clicked user on left");
//		Thread.sleep(6000);
//		
//		// click chart
//		driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[1]/div[2]/div[1]/ul/li[1]")).click();
//		Thread.sleep(3000);
//		
//		Action.click(ControlObjects.UserCalendarddarrow(driver));
//		child1.log(LogStatus.INFO, "User clicked calendar on user page");
//		Thread.sleep(6000);
//		//Action.click(ControlObjects.UserCalendarddyear(driver));
//
//		for (int i=1; i<=7; i++){
//
//			Action.click(ControlObjects.EventCalendarddarrow(driver));
//			driver.findElement(By.xpath("/html/body/div[8]/div[1]/ul/li["+i+"]")).click();
//			Thread.sleep(3000);
//
//		}
//
//		try {
//
//			WebDriverWait elementvisible=new WebDriverWait(driver, 10);
//			elementvisible.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='o-wrapper']/div[1]/div[2]/div[4]/div/div[1]/span[2]")));
//			String element=driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[2]/div[4]/div/div[1]/span[2]")).getText();
//
//			if(element.equals(0)){
//
//				System.out.println("No data available");
//				child1.log(LogStatus.INFO, "No data available");
//
//			}else {
//
//				//Action.click(ControlObjects.UserViewDetails(driver));
//				driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[2]/div[4]/div/div[2]/table/tbody/tr[1]/td[7]/div/a")).click();
//				child1.log(LogStatus.INFO, "User clicked view details");
//				Thread.sleep(6000);
//				//Action.click(ControlObjects.UserViewDetailsButton(driver));
//				driver.findElement(By.xpath("//*[@id='dataAction1']/li[1]")).click();
//				child1.log(LogStatus.INFO, "User clicked view details button");
//				Thread.sleep(6000);
//				Action.click(ControlObjects.UserViewDetailsClose(driver));
//				child1.log(LogStatus.INFO, "User clicked close button");
//				Thread.sleep(6000);
//				Action.click(ControlObjects.UserChartView(driver));
//				child1.log(LogStatus.INFO, "User clicked Chart");
//				Thread.sleep(6000);
//
//			}
//
//			extent.endTest(parent);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			child1.log(LogStatus.FAIL, e.getMessage(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "Userspage")));
//			Thread.sleep(6000);
//
//			extent.endTest(parent);
//		}
//
//
//		try {
//
//			//ChartValue
//			System.out.println("Total Users Count:");
//			Thread.sleep(6000);
//			List<WebElement> texts1=driver.findElements(By.cssSelector("div.amChartsLegend.amcharts-legend-div svg g g g"));
//
//			for(WebElement count:texts1){
//				System.out.println(count.getText());
//			} 
//
//			Thread.sleep(3000);
//			
//			// click data 
//			driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[1]/div[2]/div[1]/ul/li[2]")).click();
//			Thread.sleep(6000);
//			
//			// click view details arrow
//			driver.findElement(By.xpath("//*[@id='o-wrapper']/div[1]/div[2]/div[4]/div/div[2]/table/tbody/tr[1]/td[7]/div")).click();
//			Thread.sleep(3000);
//
//			// click view details
//			driver.findElement(By.xpath("//*[@id='dataAction1']/li[1]")).click();
//			Thread.sleep(6000);
//			
//			// click close icon
//			driver.findElement(By.xpath("//*[@id='c-menu--slide-right']/button/i")).click();
//			
//			//robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//			//Thread.sleep(3000);
//			//robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			child1.log(LogStatus.FAIL, e.getMessage(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "Userspagecount")));
//			Thread.sleep(6000);
//
//			extent.endTest(parent);
//		}
//	}	
//
}