package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SubscriptionPageObjects {
	
	WebDriver driver;
	
	public SubscriptionPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}

	
	@FindBy (how = How.XPATH, using ="html/body/div[5]/div[1]/div/div/div/div/ul/div/li[2]/a/span")
	public WebElement Subscription;
	

	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[5]/td[3]/div/button")
	public WebElement FreePlan;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[2]/div/h2")
	public WebElement FreePlan_Label;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[2]/div/h3")
	public WebElement FreePlanCost;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[2]/div/p")
	public WebElement FreePlanValidity;
	
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[3]/td[2]/div/h4/div")
	public WebElement FreePlanReport;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[3]/div/h2")
	public WebElement StartUpPlan_Label;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[3]/div/h3")
	public WebElement StartUpPlanCost;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[3]/div/p")
	public WebElement StartUpPlanValidity;
	
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[3]/td[3]/div/h4/div/h4")
	public WebElement StartUpPlanReport;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[4]/div/h2")
	public WebElement ProPlan_Label;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[4]/div/h3")
	public WebElement ProPlanCost;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[1]/td[4]/div/p")
	public WebElement ProPlanValidity;
	
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[3]/td[4]/div/h4/div/h4")
	public WebElement ProPlanReport;
		
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div/div[1]/div/a/div/div")
	public WebElement Apps;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div/div[1]/div/ul/li[2]/a")
	public WebElement AppSelect;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[5]/td[3]/div/button")
	public WebElement StartUpPlan;
	
	@FindBy (how = How.XPATH, using ="//*[@id='securityPlan']/div/div[1]/div[3]/div/table/tbody/tr[5]/td[4]/div/button")
	public WebElement ProPlan;
	
	@FindBy (how = How.XPATH, using ="//*[@id='planProcessingView']/div/div/div/form/div[2]/div[2]/div[2]/div/div/button[2]")
	public WebElement ContinueBtn;
	
	@FindBy (how = How.XPATH, using ="//*[@id='planProcessingView']/div/div/div/form/div[2]/div[2]/div[2]/div/div/button[1]")
	public WebElement CancelBtn;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div/div[3]/div[1]/div/ul/li[1]/a")
	public WebElement Control;
	
	@FindBy (how = How.XPATH, using ="//*[@id='controlPlan']/div/div[1]/div[4]/div[1]/div[3]/div/div[1]/input")
	public WebElement Patcher;         
	
	@FindBy (how = How.XPATH, using ="//*[@id='controlPlan']/div/div[1]/div[4]/div[1]/div[4]/div/div[1]/input")
	public WebElement Licensing;
	
	@FindBy (how = How.XPATH, using ="//*[@id='controlPlan']/div/div[1]/div[4]/div[2]/div/div[2]/div[3]/button")
	public WebElement SubscribeBtn;
	

	@FindBy (how = How.XPATH, using ="//*[@id='controlPlan']/div/div[1]/div[4]/div[2]/div/div[2]/div[3]/button")
	public WebElement PaidSubscribeBtn;
	
	@FindBy (how = How.XPATH, using ="//*[@id='controlPlan']/div/div[1]/div[2]/div[3]/div/span[3]")
	public WebElement Volume;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div/div/div/div[1]/div/ul")
	public List<WebElement> AppList;
	
	
	
	}

