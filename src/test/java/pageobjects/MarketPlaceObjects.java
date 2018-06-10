package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarketPlaceObjects{

	private static WebDriver driver;

	public static By clickMarketPlace = By.xpath("html/body/div[4]/header[2]/div/div[3]/div/a/span");
	public static By AddMusixxiButton = By.xpath("//*[@id='uiview']/div[2]/div/div[2]/div[2]/div/div[3]/div[2]/button");
												  //*[@id="uiview"]/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/button
	public static By AddANPRButton = By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[2]/div[3]/div/div[3]/div[2]/button");
	public static By PackageNextButton = By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[3]/a/span[1]");
	public static By ChoosingPlanMusixxi = By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[2]/div/div/div/table-plan-selection/div[1]/div/div/div[1]/table/tbody/tr[7]/td[3]");
	public static By ChoosingPlanANPR= By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[2]/div/div/div/table-plan-selection/div[1]/div/div/div[1]/table/tbody/tr[8]/td[3]/div");;
	public static By SubscribeNow= By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[2]/div/div/div/table-plan-selection/div[1]/div/div/div[2]/a");
	public static By SubscriptionContinueButton= By.xpath("html/body/div[5]/div[2]/ui-view/div[5]/div[2]/div/div/div/form/div[2]/div[2]/div[2]/div/div/button[2]");
	public static By PackageName= By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[2]/div/div[3]/div/input");
	public static By PackageNameAddButton= By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[3]/a/span[1]");
	public static By FindSDK= By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div/li[1]/a/span");
	public static By SwapToiOS= By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[2]/div/div[1]/span[2]/label\n");
	public static By ProgressCompleted= By.xpath("//*[@id='progress-info']");

	public MarketPlaceObjects(WebDriver driver){

		this.driver=driver;
	}



	public static synchronized WebElement clickMarketPlace(WebDriver driver) {
		return driver.findElement(clickMarketPlace);
	}
	public static synchronized WebElement AddMusixxiButton(WebDriver driver) {
		return driver.findElement(AddMusixxiButton);
	}
	public static synchronized WebElement AddANPRButton(WebDriver driver) {
		return driver.findElement(AddANPRButton);
	}
	public static synchronized WebElement PackageNextButton(WebDriver driver) {
		return driver.findElement(PackageNextButton);
	}
	public static synchronized WebElement ChoosingPlanMusixxi(WebDriver driver) {
		return driver.findElement(ChoosingPlanMusixxi);
	}
	public static synchronized WebElement ChoosingPlanANPR(WebDriver driver) {
		return driver.findElement(ChoosingPlanANPR);
	}
	public static synchronized WebElement SubscribeNow(WebDriver driver) {
		return driver.findElement(SubscribeNow);
	}
	public static synchronized WebElement SubscriptionContinueButton(WebDriver driver) {
		return driver.findElement(SubscriptionContinueButton);
	}
	public static synchronized WebElement PackageName(WebDriver driver) {
		return driver.findElement(PackageName);
	}
	public static synchronized WebElement PackageNameAddButton(WebDriver driver) {
		return driver.findElement(PackageNameAddButton);
	}
	public static synchronized WebElement FindSDK(WebDriver driver) {
		return driver.findElement(FindSDK);
	}
	public static synchronized WebElement SwapToiOS(WebDriver driver) {
		return driver.findElement(SwapToiOS);
	}
	public static synchronized WebElement ProgressCompleted(WebDriver driver) {
		return driver.findElement(ProgressCompleted);
	}
}