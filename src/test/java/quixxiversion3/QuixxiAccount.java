package quixxiversion3;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import javafiles.FilesAndPaths;
import javafiles.ScreenCapture;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QuixxiAccount {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	public QuixxiAccount(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2){

		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;

	}

	@Test(groups="positive", dataProvider="signin", dataProviderClass=dataproviders.SignInDataProviders.class)
	public static synchronized void Settings(Object[][] data) throws Exception {

		try {
			//login

			parent=extent.startTest("Settings Page");
			child1=extent.startTest("Settings Page options");
			parent.appendChild(child1);
			

			new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches("https://sta-portal.quixxi.com/#/appList"));

			String url = driver.getCurrentUrl();

			//Home page
			if(url.contentEquals("https://sta-portal.quixxi.com/#/appList")){

				//Click Profile and then account	
				driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/a")).click();
				child1.log(LogStatus.INFO, "User clicked profile and selected Settings");
				Thread.sleep(5000);
				driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/ul/li[1]/a")).click();

				//Basic Settings	
				WebElement fname = driver.findElement(By.xpath(".//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[1]/div[1]/input"));
				fname.clear();
				Thread.sleep(2000);
				fname.sendKeys("Sivam");
				child1.log(LogStatus.INFO, "User typed :: "+fname.getText()+" as First name");
				Thread.sleep(3000);
				WebElement lname = driver.findElement(By.xpath(".//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[2]/div[1]/input"));
				lname.clear();
				Thread.sleep(2000);
				lname.sendKeys("Shanmugam");
				child1.log(LogStatus.INFO, "User type :: "+lname.getText()+" as Last name");
				Thread.sleep(3000);
				//click update button
				driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[3]/div/button/span[1]")).click();
				child1.log(LogStatus.INFO, "User clicked update button");
				Thread.sleep(5000);

				child1.log(LogStatus.INFO, "Basic Settings updated successfully");

				//Change Password
				//scroll the bar down using javascriptexecutor
				JavascriptExecutor js;
				WebElement cpassword = driver.findElement(By.name("currPassword"));
				cpassword.clear();
				cpassword.sendKeys(data[0][1].toString());
				
				
				// to scroll down the page
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)", "");
				child1.log(LogStatus.INFO, "User pressed pagedown key");

				String newpassword="M@he123456";
				
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.custom-tile-md.clearfix")));
				
				driver.findElement(By.name("newPassword")).sendKeys(newpassword);
				Thread.sleep(3000);
				driver.findElement(By.name("confPassword")).sendKeys(newpassword);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div[1]/div[2]/div/div[2]/form/div[4]/div[1]/span/button")).click();
				Thread.sleep(5000);

				child1.log(LogStatus.INFO, "password changed successfully");

				Thread.sleep(5000);
				//logout the system
				driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[1]/li[2]/a/i")).click();
				driver.findElement(By.xpath("html/body/div[4]/header[1]/div/div/div[2]/div/ul[1]/li[2]/ul/li[6]/a")).click();
				child1.log(LogStatus.INFO, "User logged out the system to check new password authentication");
				Thread.sleep(5000);

				try {
					//updating value in excel // new Object[][]{{newpassword},{}}
					//(String FPath, HSSFWorkbook wb, HSSFSheet ws, String sname, int RowNum, int ColNum, Object[][] data)
					// This stream used to open a file
					FileInputStream filein = new FileInputStream(new File(javafiles.FilesAndPaths.TestData()+File.separator+"Login.xls"));
					HSSFWorkbook wb=null;
					HSSFSheet ws=null;

					// getting workbook instance
					wb = new HSSFWorkbook(filein);

					// getting sheet instance
					ws = wb.getSheet("Signin");
					
					javafiles.ReadExcel.setCellValue(javafiles.FilesAndPaths.TestData()+File.separator+"Login.xls", wb, ws, "Signin", 1, 1,new Object[][]{{data[0][0],newpassword},{}});

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// Here I sign again
				
				try {
					
					SignInPage.signin(new Object[][]{{SignInPage.mail,SignInPage.pass},{}});
					child1.log(LogStatus.INFO, "Login with new password has been successfull");
					
					extent.endTest(parent);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					child1.log(LogStatus.FAIL, "Signin failed", child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "signinagain")));
					Thread.sleep(6000);
					
					extent.endTest(parent);
				}
				

				//Changing Profile picture

				Thread.sleep(5000);

				((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-400)");
				child1.log(LogStatus.INFO, "User pressed pageup key");

				Thread.sleep(5000);

				//Click Profile and then account	
				driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/a")).click();
				driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/ul/li[1]/a")).click();
				child1.log(LogStatus.INFO, "User clicked profile and setting");
				// click picture
				driver.findElement(By.xpath("html/body/div[5]/div[2]/ui-view/div[1]/div/div[2]/div[2]/div")).click();
				child1.log(LogStatus.INFO, "User clicked profile picture");
				Thread.sleep(3000);

				Robot robot = new Robot();
				//				robot.mouseMove(260, 199);
				//				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				//				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				//				Thread.sleep(4000);
				// selecting a file from open dialog
				StringSelection selection=new StringSelection(javafiles.FilesAndPaths.TestData().getAbsolutePath()+File.separator+"profile.png");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
				Thread.sleep(10000);
				robot.keyPress(KeyEvent.VK_CONTROL );
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(5000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
				//click the update button to save the picture
				driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[3]/div/button/span[1]")).click();
				Thread.sleep(5000);
				child1.log(LogStatus.INFO, "Profile picture updated successfully");

				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(3000);
				jse.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(3000);
				
				child1.log(LogStatus.INFO, "User clicked pagedown key");
				
				// Account screen
				AccountScreen qa=new AccountScreen(driver, extent, parent, child1, child2);
				qa.Account();
				
				child1.log(LogStatus.INFO, "Account details updated successfully");

				//Add New Card 
				/*				driver.findElement(By.xpath(".//*[@id='uiview']/div[1]/div/div[1]/div[3]/div/div[1]/div/a")).click();
				//driver.findElement(By.xpath(".//*[@id='basic']/div/div/div[1]/button")).click();
				Thread.sleep(7000);
				WebElement choldername = driver.findElement(By.xpath(".//*[@id='stripeCollectCardinfo']/form/div[1]/label/input"));
				choldername.clear();
				choldername.sendKeys("Mutlat");
				Thread.sleep(7000);
				System.out.println("Card Holder name added");
				WebElement cardno = driver.findElement(By.xpath("//*[@id='root']/form/div/div[2]/span[1]"));
				//WebElement cardno = driver.findElement(By.name("cardnumber"));
				cardno.click();
				cardno.clear();			
				cardno.sendKeys("123456789012345");
				WebElement expdate = driver.findElement(By.xpath("//*[@id='root']/form/div/div[2]/span[2]"));
				expdate.clear();
				expdate.sendKeys("2324");
				WebElement cvc = driver.findElement(By.xpath("//*[@id='root']/form/div/div[2]/span[3]"));
				cvc.clear();
				cvc.sendKeys("543");
				driver.findElement(By.xpath(".//*[@id='stripeCollectCardinfo']/form/button")).click();
				Thread.sleep(5000);
				System.out.println("@#$%^&*()");
				 */
			}

			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "quixxiaccounterror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);
		}
	}

}
