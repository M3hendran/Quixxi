package pageobjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingPageObjects {

	public static WebDriver driver;
	
	public static String PDFfilePath =javafiles.FilesAndPaths.TestData().getAbsolutePath()+File.separator+"Billing.pdf"; 
	public static String PDFContent = null; 


	public BillingPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@FindBy (how = How.XPATH, using ="/html/body/div[5]/div[1]/div/div/div/div/ul/div/li[3]/a/span")
	public WebElement Billing;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div[1]/div/div/div/table/tbody/tr[1]/td[7]/a")
	public WebElement View;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div[2]/div[4]/div[2]/a")
	public WebElement Print;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div[2]/div[3]/div/table/tbody/tr[1]/td[2]")
	public WebElement AppName;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div[2]/div[3]/div/table/tbody/tr[1]/td[3]")
	public WebElement PlanName;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div[2]/div[3]/div/table/tbody/tr[1]/td[4]")
	public WebElement PlanAmount;
	
	
}
