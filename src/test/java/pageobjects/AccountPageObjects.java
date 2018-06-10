package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AccountPageObjects {
	
	WebDriver driver;
	
	public AccountPageObjects(WebDriver driver)
	{
		
		this.driver = driver;

	}
	
	public final String First_Name ="Lakeba";
	public final String Last_Name ="Admin";
	public final String New_Pwd= "Testing@12";
	public final String Card_Name= "TestCardName";
	public final String CVC= "123";
	public final String ZIP= "1234";

	
	
	@FindBy (how =How.XPATH, using = "/html/body/div[4]/header[1]/div/div/div[2]/div/ul[1]/li[2]/a/span[2]")
	public WebElement Profile;
	
	@FindBy (how =How.XPATH, using = "/html/body/div[4]/header[1]/div/div/div[2]/div/ul[1]/li[2]/ul/li[1]/a")
	public WebElement Account;
	
	// Basic Settings objects //
	
	@FindBy (how =How.NAME, using = "firstName")
	public WebElement FirstName;
	
	@FindBy (how =How.NAME, using = "lastName")
	public WebElement LastName;

	@FindBy (how =How.XPATH, using = "//*[@id=\"uiview\"]/div[1]/div/div[1]/div[1]/div/div[2]/form/div[1]/div[2]/input")
	public WebElement AccEmail;
	
	@FindBy (how = How.XPATH, using ="//*[@id=\"uiview\"]/div[1]/div/div[1]/div[1]/div/div[2]/form/div[2]/div[2]/select")
	public WebElement TimeZone;
	
	@FindBy (how =How.XPATH, using = "//*[@id=\"profilepic\"]")
	public WebElement ProfileImg;
	
	@FindBy (how =How.XPATH, using = "//*[@id=\"uiview\"]/div[1]/div/div[1]/div[1]/div/div[2]/form/div[3]/div/a/span[1]")
	public WebElement Update;
	
	@FindBy (how =How.NAME, using = "currPassword")
	public WebElement CurrPwd;
	
	@FindBy (how =How.NAME, using = "newPassword")
	public WebElement NewPwd;
	
	@FindBy (how =How.NAME, using = "confPassword")
	public WebElement ConfmPwd;
	
	@FindBy (how =How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[2]/div/div[2]/form/div[4]/div[1]/span/a")
	public WebElement PwdUpdate;
	
	@FindBy (how =How.XPATH, using = ".//*[@id='uiview']/div[1]/div/div[1]/div[3]/div/div[1]/div/a")
	public WebElement AddNewCard;
	
	@FindBy (how =How.XPATH, using = ".//*[@id='stripeCollectCardinfo']/form/div[1]/label/input")
	public WebElement CardName;
	
	@FindBy (how =How.XPATH, using = "html/body/div[1]/form/div/div[2]/span[1]/span[2]/label/input")
	public WebElement CardNo;
	
	@FindBy (how =How.XPATH, using = ".//*[@id='stripeCollectCardinfo']/form/button")
	public WebElement AddCard;
	
	@FindBy (how = How.XPATH, using ="//*[@id='uiview']/div[1]/div/div[1]/div[3]/div/div[2]/div[2]/div[2]/span/span[3]/span")
	public WebElement EditCard;
	
	@FindBy (how = How.XPATH, using ="html/body/div[5]/div[2]/ui-view/div[3]/div/div/div[2]/stripe-edit-cardinfo/form/div[1]/label/input")
	public WebElement EditCardName;
	
	@FindBy (how = How.XPATH, using =".//*[@id='stripeCollectCardinfo']/form/div[2]/label[1]/select")
	public WebElement Exp_month;
	
	@FindBy (how = How.XPATH, using =".//*[@id='stripeCollectCardinfo']/form/div[2]/label[2]/select")
	public WebElement Exp_year;
	
	@FindBy (how = How.CLASS_NAME, using ="ladda-button")
	public WebElement UpdateBtn;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[3]/div/div[2]/div[2]/div[2]/span/span[2]/span")
	public WebElement CardDelete;
	
	@FindBy (how = How.XPATH, using =".//*[@id='deleteCard']/div/div/div[2]/div/div[2]/div/div/button[2]")
	public WebElement DeleteYes;
	
	@FindBy (how = How.XPATH, using ="/html/body/div[4]/header/div/div/div[2]/div/ul[1]/li[2]/ul/li/a/span")
	public List <WebElement> profilemenu;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[1]/span/strong")
	public WebElement BasicSetting;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[1]/div[1]/label")
	public WebElement Fname_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[1]/div[2]/label")
	public WebElement Email_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[2]/div[1]/label")
	public WebElement Lname_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[2]/div[2]/label")
	public WebElement Tzone_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[1]/div/div[2]/form/div[2]/div[2]/select")
	public List <WebElement> TzoneList;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[2]/div/div[1]/span")
	public WebElement ChangePwd_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[2]/div/div[2]/form/div[1]/label")
	public WebElement CurrPwd_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[2]/div/div[2]/form/div[3]/div[1]/label")
	public WebElement NewPwd_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[2]/div/div[2]/form/div[3]/div[2]/label")
	public WebElement RePwd_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[3]/div/div[1]/div/span")
	public WebElement Cards_Label;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[3]/div/div[2]/div[1]/div[1]/span[2]")
	public WebElement CardNum;
	
	@FindBy (how = How.XPATH, using =".//*[@id='uiview']/div[1]/div/div[1]/div[3]/div/div[2]/div[1]/div[1]/span[3]")
	public WebElement ExpDate;
	
	
	
}
