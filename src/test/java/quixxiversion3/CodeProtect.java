package quixxiversion3;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javafiles.Action;
import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageobjects.CodeProtectObjects;
import pageobjects.ControlObjects;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CodeProtect {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;

	public CodeProtect(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1){

		this.driver = driver;
		this.extent = extent;
		this.parent = parent;
		this.child1 = child1;
	}

	@Test(groups="positive")
	public static synchronized void codeProtectAAR() throws Exception {


		parent=extent.startTest("Security - Code Protect");
		child1=extent.startTest("Code Protect - Android & Web");
		parent.appendChild(child1);

		try {

			//click myapp
			driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[4]/li/a/span")).click();
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User clicked myapp");
			Thread.sleep(2000);

			//Search with app name
			driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).clear();
			driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).sendKeys("indoor_aar file");
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User typed :: "+driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[1]/div/input")).getText());
			Thread.sleep(2000);

			// click on app
			Action.click(ControlObjects.clickOnApp(driver));
			Thread.sleep(6000);

			// Select Security in the menu
			driver.findElement(By.xpath("html/body/div[4]/header[2]/div/div[2]/div[3]/div/a")).click();
			Thread.sleep(6000);
			child1.log(LogStatus.INFO, "User selected security");
			Thread.sleep(2000);

			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,800)");
			Thread.sleep(2000);

			// click protect
			CodeProtectObjects.protectlink(driver).click();
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User clicked protect on left menu");
			Thread.sleep(2000);

			int count = 1;

			while(count<=2){

				if(count==1){

					StringSelection selection=new StringSelection(javafiles.FilesAndPaths.apkPath().getAbsolutePath()+File.separator+"indoorsdk-1.0.0.aar");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
					Thread.sleep(3000);


					child1.log(LogStatus.INFO, "User selected android");
					Thread.sleep(2000);

				}

				if (count==2){

					Robot robot=new Robot();
					robot.mouseMove(560,366);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					Thread.sleep(2000);

					child1.log(LogStatus.INFO, "User clicked Web option");
					Thread.sleep(2000);

					StringSelection selection=new StringSelection(javafiles.FilesAndPaths.apkPath().getAbsolutePath()+File.separator+"validator.js");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
					Thread.sleep(3000);

				}
				// click upload
				CodeProtectObjects.uploadfile(driver).click();
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User clicked upload");
				Thread.sleep(2000);

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL );

				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(5000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);

				((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
				Thread.sleep(2000);


				if (count == 1){

					try {

						// if subscription exits for the new application
						if (driver.findElement(By.xpath("//*[@id='uiview']/div[2]/div/div/div[1]/div/div[1]/div[5]/div[1]/h5")) !=null){

							//select subscription
							driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[1]/div[4]/div[2]/div/div[1]/div[2]/div/table/tbody/tr[5]/td[3]/div/button")).click();
							Thread.sleep(3000);
							//click continue button in the popup
							driver.findElement(By.xpath("//*[@id='planProcessingView']/div/div/div/form/div[2]/div[2]/div[2]/div/div/button[2]")).click();
							Thread.sleep(3000);
							//click next button
							driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[2]/button")).click();
							Thread.sleep(3000);

						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.getStackTrace();
					}


					// click next button
					CodeProtectObjects.nextButton(driver).click();
					Thread.sleep(3000);
					child1.log(LogStatus.INFO, "User clicked Next button");
					Thread.sleep(2000);


				}

				if (count==2){


					// click next button
					driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[2]/button")).click();
					Thread.sleep(2000);
					
					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
					Thread.sleep(2000);
					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,800)");
					Thread.sleep(2000);

					// click next button in shield options
					driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[2]/button")).click();
					Thread.sleep(6000);
					child1.log(LogStatus.INFO, "User clicked next button shield options");
					Thread.sleep(2000);

					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-800)");
					Thread.sleep(3000);

					waitForCompilation();
					child1.log(LogStatus.INFO, "Code protect for JS file completed successfully");
					Thread.sleep(2000);

				}

				if( count==1 ){
					
					waitForCompilation();
					child1.log(LogStatus.INFO, "Code protect for AAR file completed successfully");
					Thread.sleep(2000);
					
				}
				
				if (count==1){
					
					((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-300)");
					Thread.sleep(2000);
				}

				CodeProtectObjects.downloadLibrary(driver).click();
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User clicked download library button");
				Thread.sleep(2000);

				count++;
			}

			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.ERROR, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "codeprotecterror")));
			extent.endTest(parent);
			Thread.sleep(6000);
		}
	}

	public static synchronized void waitForCompilation()throws Exception{

		boolean compiled = false;

		try {
			
			WebElement element = driver.findElement(By.xpath("//*[@id='dropfile']/div/div[3]/h1"));
			//*[@id="dropfile"]/div/div[3]/h1
			do {
				
				if (element.getText().contains("100%") ) {

					compiled=true;
					
				}

			} while (!compiled);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
