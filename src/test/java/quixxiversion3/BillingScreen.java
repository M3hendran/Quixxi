package quixxiversion3;

import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.BillingPageObjects;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BillingScreen {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	public BillingScreen(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child12)
	{
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;

	}

	@Test(groups="positive")
	public static synchronized void billing() throws Exception
	{

		try {

			//test=extent.startTest(Thread.currentThread().getStackTrace()[1].getClassName()+"."+Thread.currentThread().getStackTrace()[1].getMethodName(), "Billing Screen");

			parent=extent.startTest("Billing Screen");
			child1=extent.startTest("Billing Screen flow Information");
			parent.appendChild(child1);
			
			//Document document = new Document();

			//		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("home/lakeba/Desktop/Billings.pdf"));
			//		PdfWaterMark obj = PageFactory.initElements(driver, PdfWaterMark.class);
			//		
			//		obj.onEndPage(writer, document);

			BillingPageObjects billObj = PageFactory.initElements(driver, BillingPageObjects.class);

			//Click Profile and then account	
			driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/ul/li[1]/a")).click();
			Thread.sleep(3000);
			child1.log(LogStatus.INFO, "User clicked Profile and selected Account");
			Thread.sleep(2000);

			if(billObj.Billing.isDisplayed())
			{
				billObj.Billing.click();
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User clicked billing");
				Thread.sleep(2000);
			}
			else
			{
				System.out.println("---------------------------------------------------------Billing option not displayed ----------------------------------------------");
				child1.log(LogStatus.INFO, "Billing option not displayed");
				driver.close();
			}
			if(billObj.View.isDisplayed())
			{
				billObj.View.click();
				Thread.sleep(3000);
				child1.log(LogStatus.INFO, "User clicked view");
				Thread.sleep(2000);
			}
			else
			{
				System.out.println("---------------------------------------------------------View not displayed ----------------------------------------------");
				child1.log(LogStatus.INFO, "View not displayed");
				Thread.sleep(2000);
				driver.close();
			}

//			if(billObj.Print.isDisplayed())
//			{
//
//				billObj.Print.click();
//
//
//			}
//			else
//			{
//				System.out.println("---------------------------------------------------------Print not displayed ----------------------------------------------");
//				driver.close();
//			}
//
//
			
			//			driver.findElement(By.xpath("//button[contains(text(), 'Change')]")).click();
			//			//driver.findElement(By.xpath("//*[@id='destination-settings']/div[2]/button")).click();
			//			Thread.sleep(6000);
			//			driver.findElement(By.xpath("//span[contains(text(), 'Save as PDF')]")).click();
			//			Thread.sleep(3000);
			//			driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
			//			
			//			Thread.sleep(3000);
			//			
			//			// deleting existing file
			//			new File(javafiles.FilesAndPaths.TestData().getAbsolutePath()+File.separator+"Billing.pdf").delete();
			//			new File(javafiles.FilesAndPaths.TestData().getAbsolutePath()+File.separator+"Verified.pdf").delete();
			//			
			//			StringSelection selection=new StringSelection(javafiles.FilesAndPaths.TestData().getAbsolutePath()+File.separator+"Billing.pdf");
			//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			//			
			//			robot.keyPress(KeyEvent.VK_ENTER);
			//			robot.keyRelease(KeyEvent.VK_ENTER);
			//			Thread.sleep(5000);		
			//			
			//			PdfReaderClass pdfReader = PageFactory.initElements(driver, PdfReaderClass.class);
			//			billObj.PDFContent = pdfReader.pdfReaderfromDesktop(billObj.PDFfilePath);
			//			System.out.println(billObj.PDFContent);
			//			
			//			CreateWatermarkedPDF watermark = PageFactory.initElements(driver, CreateWatermarkedPDF.class);
			//			watermark.manipulatepdf1();
			//			
			//			
			//			driver.switchTo().window(winHandleBefore);
			//			Thread.sleep(3000);
			//			
			//				
			//			robot.keyPress(KeyEvent.VK_CONTROL);
			//			robot.keyPress(KeyEvent.VK_T);
			//			robot.keyRelease(KeyEvent.VK_T);
			//			robot.keyRelease(KeyEvent.VK_CONTROL);
			//			Thread.sleep(8000);
			//			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			//			driver.switchTo().window(tabs2.get(1));
			//			driver.get(javafiles.FilesAndPaths.TestData().getAbsolutePath()+File.separator+"Verified.pdf");
			//			Thread.sleep(8000);
			//			driver.close();

			child1.log(LogStatus.INFO, "Billing test class was successful");
			Thread.sleep(2000);
			
			extent.endTest(parent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			child1.log(LogStatus.FAIL, e.fillInStackTrace().toString(), child1.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "billingerror")));
			Thread.sleep(6000);
			
			extent.endTest(parent);

		}
	}
}
