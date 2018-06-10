package quixxiversion3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javafiles.FilesAndPaths;
import javafiles.ScreenCapture;




//import org.openqa.grid.internal.TimeSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageobjects.PackageAddplatform_PageObject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Stub {

	private static WebDriver driver;
	private static WebDriverWait wait;
	private static ExtentReports extent;
	private static ExtentTest test;
	private static ArrayList<String> tabs1;

	@Test(priority=1)
	public static void openApp() throws Exception {

		try {

			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver",
					javafiles.FilesAndPaths.Browsers() + "\\chromedriver.exe");
			driver = new ChromeDriver(options);

			// HtmlUnitDriver driver=new HtmlUnitDriver();
			driver.get("https://sta-portal.quixxi.com");
			wait=new WebDriverWait(driver, 10);


			/*
			 * // wd.get("https://sta-portal.quixxi.com");
			 * driver.findElement(By.
			 * xpath("html/body/div[4]/div[2]/section/form/div/div[3]/div[1]/input"
			 * )).sendKeys(data[0][0].toString()); String
			 * username=data[0][0].toString(); driver.findElement(By.xpath(
			 * "html/body/div[4]/div[2]/section/form/div/div[4]/div[1]/input"
			 * )).sendKeys(data[0][1].toString()); String
			 * pass=data[0][1].toString();
			 * 
			 * // Assert.assertEquals("Sign In", wd.findElement(By.xpath(
			 * ".//*[@id='notification']/div/div/div/div[2]/div/h2"
			 * )).getText());
			 * 
			 * Thread.sleep(5000); SignInPage.signin(wd).click();
			 * Thread.sleep(5000);
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	
	@Test(priority=3)
	public static void invitemail() throws Exception {

		//opening gmail

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);

		tabs1=new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs1.get(0));
		Thread.sleep(3000);
		driver.get("https://gmail.com");
		Thread.sleep(6000);

		// click sign in in google.com
		driver.findElement(By.xpath("html/body/nav/div/a[2]")).click();
		Thread.sleep(3000);

		// enter mailid
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("jantest1lakeba@gmail.com");

		// click next button
		driver.findElement(By.xpath("//*[@id='identifierNext']/content")).click();
		Thread.sleep(3000);

		//enter password
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("M@he1234");
		Thread.sleep(3000);

		//click next button
		driver.findElement(By.xpath("//*[@id='passwordNext']/content")).click();
		Thread.sleep(10000);

		robot.mouseMove(320,315);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(8000);


		// click freescan button in mail
		robot.mouseMove(775,540);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(8000);

	}

}
