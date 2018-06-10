package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Overviewaddplatform_PageObject {
	
	private WebDriver driver;
	
	public Overviewaddplatform_PageObject(WebDriver driver){
		
		this.driver=driver;
		
	}

	//Search the app
		@FindBy(how=How.XPATH, using="/html/body/div[4]/header[2]/div/div[1]/div/input")
		public WebElement app_search;
	
	//Click the created app
		@FindBy(how = How.XPATH, using = "//*[@id='uiview']/div[1]/div[3]/div[2]/a/div")
		public WebElement Click_Newapp;
			
	//Click Control 
		@FindBy(how = How.XPATH, using = "/html/body/div[4]/header[2]/div/div[2]/div[2]/div")
		public WebElement Click_Control;
				
	//Click Add Platform button in overiew screen
		@FindBy(how = How.XPATH, using = "//*[@id='uiview']/div[2]/div/div[3]/div[1]/div/div[2]/span/a")
		public WebElement overview_addplatform_btn;
				
				
	//Click Add Platform button in the Package screen
		@FindBy(how = How.XPATH, using = "//*[@id='uiview']/div[2]/div/div[3]/div/div[2]/div[4]/a")
		public WebElement package_addplatform_btn;
				
	//Click Licensing checkbox
		@FindBy(how = How.XPATH, using = "//*[@id='platform']/div/div/form/div[2]/div/div[3]/div[2]/div/label")
		public WebElement Licensing_checkbox;
				
	//Click  add package name text field
		@FindBy(how = How.XPATH, using = "//*[@id='platform']/div/div/form/div[2]/div/div[5]/div/input")
		public WebElement add_packagename;
				
				
	//Click Start Packaging button
		@FindBy(how = How.XPATH, using = "//*[@id='platform']/div/div/form/div[3]/button")
		public WebElement startpackaging_btn;
						
	//Click and enable licensing checkbox in the subscribe screen
		@FindBy(how = How.XPATH, using = "//*[@id='platform']/div/div/form/div[2]/div/div[2]/div/div/div[1]/div[4]/div[1]/div[4]/div/div[1]/input")
		public WebElement licensing_checkbox_subscribe;

	//Click subscribe button
		@FindBy(how = How.XPATH, using = "//*[@id='platform']/div/div/form/div[2]/div/div[2]/div/div/div[1]/div[4]/div[2]/div/div[2]/div[2]/button")
		public WebElement subscribe_btn;
				
	//Click continue button in the continue subscription pop up
		@FindBy(how = How.XPATH, using = "//*[@id='planProcessingView']/div/div/div/div[2]/div[2]/div[2]/div/div/button[2]")
		public WebElement continue_btn_subscription;				

	//Get licensing text 
		@FindBy(how = How.XPATH, using = "//*[@id='uiview']/div[2]/div/div[3]/div[1]/div[2]/span/span[1]")
		public WebElement licensing_text_verify;			
				
	//Click My apps 
		@FindBy(how = How.XPATH, using = "/html/body/div[4]/header[1]/div/div/div[2]/div/ul[4]/li/a/span")
		public WebElement My_app;			
}
