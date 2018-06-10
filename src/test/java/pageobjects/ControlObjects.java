package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ControlObjects{

	private static WebDriver driver;

	public static By clickOnApp = By.xpath("//*[@id='uiview']/div[1]/div[3]/div[2]/a/div");
	public static By clickControl = By.xpath("html/body/div[4]/header[2]/div/div[2]/div[2]/div/a/span");
	public static By clickPlatform = By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[1]/li[2]/a/span");
	public static By clickPlatformButton = By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[3]/div/div[2]/div[4]/a");
	public static By platformTextbox= By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[2]/div/div[5]/div/input");
	public static By startPackagingButton= By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[3]/button");
	public static By subscribeButton= By.xpath("html/body/div[5]/div[2]/ui-view/div[3]/div/div/form/div[2]/div/div[2]/div/div/div[1]/div[4]/div[2]/div/div[2]/div[2]/button");
	public static By subscriptionContinueButton= By.xpath("//*[@id='planProcessingView']/div/div/div/div[2]/div[2]/div[2]/div/div/button[2]");
	public static By progress= By.xpath("//*[@id='progress-info']/li[1]/s00pan[1]");
	public static By progressCompleted= By.xpath("//*[@id='progress-info']/li[1]/span[2]");
	public static By launchDemoApp= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[3]/div[2]/div/div[3]");
	public static By rotateLeft= By.xpath("html/body/div/div[1]/img[1]");
	//public static By progressCompleted= By.xpath("//*[@id=\'progress-info\']/li[1]/span[2]");
	public static By tapToPlay= By.xpath("//*[@id='buttonContainer']/span[1]/div[2]");
	public static By mockEvent= By.xpath("//*[@id='1513532613004']");
	public static By event= By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[6]/li[1]/a/span");
	public static By user= By.xpath("/html/body/div[5]/div[1]/div/div/div/div/ul/div[2]/li/a[2]/span");

	public static By appStarted= By.xpath("//*[@id='totalUserPiechart\']/div/div[2]/svg/g/g/g[1]/rect");
	public static By mockEventButtonClicked= By.xpath("//*[@id='totalUserPiechart']/div/div[2]/svg/g/g/g[2]/rect");
	public static By EventCalendarddarrow= By.xpath("//*[@id='selectedrangeid']");
	public static By EventCalendarddyear= By.xpath("//div[@class='ranges']/ul/li[7]");
	public static By TotalCount= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[2]/div");
	public static By ViewRecordsdd= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[3]/div[2]/div/select");
	public static By ViewRecordsSecondValuevalue= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[3]/div[2]/div/select/option[2]");
	public static By EventCategorydd= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[3]/div[3]/div/select");
	public static By EventCategorySecondvalue= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[3]/div[3]/div/select");
	public static By EventViewButton= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[4]/div/div/table/tbody/tr/td[5]/a");
	public static By EventViewCloseIcon= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[2]/div[1]/i");
	public static By EventCategoryThirdvalue= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[3]/div[3]/div/select/option[3]");
	public static By EventCategoryFourthvalue= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[3]/div[3]/div/select/option[4]");
	public static By SupportCloseButton= By.xpath("//*[@id='lc_chat_header']");
	public static By UserCalendarddarrow= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[1]/div[2]/div[2]/label/b");
	public static By UserCalendarddyear= By.xpath("//div[@class='ranges']/ul/li[7]");
	public static By UserViewDetails= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[2]/div[4]/div/div[2]/table/tbody/tr/td[6]/div/a/i[2]");
	public static By UserViewDetailsButton= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[2]/div[4]/div/div[2]/table/tbody/tr/td[6]/div/ul/li[1]");
	public static By UserViewDetailsClose= By.xpath("html/body/div[5]/div[2]/ui-view/nav/button");
	public static By UserChartView= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a");
	public static By Diagnostics= By.xpath("html/body/div[5]/div[1]/div/div/div/div/ul/div[4]/li[1]/a/span");
	public static By DiagnosticsData= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[1]/div[4]/div/ul/li[2]/a");
	public static By DiagnosticsCalendarddarrow= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[1]/div[3]/div/label/b");
	public static By DiagnosticsCalendarddyear= By.xpath("//div[@class='ranges']/ul/li[7]");
	public static By DiagnosticsViewButton= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[2]/div[2]/div[3]/div/table/tbody/tr/td[5]/a");
	public static By DiagnosticsViewCloseButton= By.xpath("html/body/div[5]/div[2]/ui-view/nav/div/div[1]/i");
	public static By DiagnosticsChartView= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div/div[1]/div[4]/div/ul/li[1]/a");
	//public static By Diagnostics= By.xpath("/html/body/div[5]/div[2]/ui-view/div[2]/div/div[1]/div[4]/div/ul/li[1]/a\n");

	public ControlObjects(WebDriver driver){

		this.driver=driver;
	}


	public static By totalCountNumber= By.xpath("html/body/div[5]/div[2]/ui-view/div[2]/div[1]/div[2]/div/div[1]/div/span[2]/p[1]");
	//Function to find App

	public static synchronized WebElement clickOnApp(WebDriver driver) {
		return driver.findElement(clickOnApp);
	}

	//Function to find Control Page
	public static synchronized WebElement clickControl(WebDriver driver) {
		return driver.findElement(clickControl);
	}
	public static synchronized WebElement clickPlatform(WebDriver driver) {
		return driver.findElement(clickPlatform);
	}
	public static synchronized WebElement clickPlatformButton(WebDriver driver) {
		return driver.findElement(clickPlatformButton);
	}
	public static synchronized WebElement PlatformTextbox(WebDriver driver) {
		return driver.findElement(platformTextbox);
	}
	public static synchronized WebElement startPackagingButton(WebDriver driver) {
		return driver.findElement(startPackagingButton);
	}
	public static synchronized WebElement subscribeButton(WebDriver driver) {
		return driver.findElement(subscribeButton);
	}
	public static synchronized WebElement subscriptionContinueButton(WebDriver driver) {
		return driver.findElement(subscriptionContinueButton);
	}
	public static synchronized WebElement progress(WebDriver driver) {
		return driver.findElement(progress);
	}
	public static synchronized WebElement progressCompleted(WebDriver driver) {
		return driver.findElement(progressCompleted);
	}
	public static synchronized WebElement launchDemoApp(WebDriver driver) {
		return driver.findElement(launchDemoApp);
	}
	public static synchronized WebElement tapToPlay(WebDriver driver) {
		return driver.findElement(tapToPlay);
	}
	public static synchronized WebElement mockEvent(WebDriver driver) {
		return driver.findElement(mockEvent);
	}
	public static synchronized WebElement rotateLeft(WebDriver driver) {
		return driver.findElement(rotateLeft);
	}
	public static synchronized WebElement event(WebDriver driver) {
		return driver.findElement(event);
	}
	public static synchronized WebElement user(WebDriver driver) {
		return driver.findElement(user);
	}
	public static synchronized WebElement totalCountNumber(WebDriver driver) {
		return driver.findElement(totalCountNumber);
	}
	public static synchronized WebElement appStarted(WebDriver driver) {
		return driver.findElement(appStarted);
	}
	public static synchronized WebElement mockEventButtonClicked(WebDriver driver) {
		return driver.findElement(mockEventButtonClicked);
	}
	public static synchronized WebElement EventCalendarddarrow(WebDriver driver) {
		return driver.findElement(EventCalendarddarrow);
	}
	public static synchronized WebElement EventCalendarddyear(WebDriver driver) {
		return driver.findElement(EventCalendarddyear);
	}
	public static synchronized WebElement TotalCount(WebDriver driver) {
		return driver.findElement(TotalCount);
	}
	public static synchronized WebElement ViewRecords(WebDriver driver) {
		return driver.findElement(ViewRecordsdd);
	}
	public static synchronized WebElement ViewRecordsSecondValuevalue(WebDriver driver) {
		return driver.findElement(ViewRecordsSecondValuevalue);
	}
	public static synchronized WebElement EventCategorydd(WebDriver driver) {
		return driver.findElement(EventCategorydd);
	}
	public static synchronized WebElement EventCategorySecondvalue(WebDriver driver) {
		return driver.findElement(EventCategorySecondvalue);
	}
	public static synchronized WebElement EventViewButton(WebDriver driver) {
		return driver.findElement(EventViewButton);
	}
	public static synchronized WebElement EventViewCloseIcon(WebDriver driver) {
		return driver.findElement(EventViewCloseIcon);
	}
	public static synchronized WebElement EventCategoryThirdvalue(WebDriver driver) {
		return driver.findElement(EventCategoryThirdvalue);
	}
	public static synchronized WebElement EventCategoryFourthvalue(WebDriver driver) {
		return driver.findElement(EventCategoryFourthvalue);
	}
	public static synchronized WebElement SupportCloseButton(WebDriver driver) {
		return driver.findElement(SupportCloseButton);
	}
	public static synchronized WebElement UserCalendarddarrow(WebDriver driver) {
		return driver.findElement(UserCalendarddarrow);
	}
	public static synchronized WebElement UserCalendarddyear(WebDriver driver) {
		return driver.findElement(UserCalendarddyear);
	}
	public static synchronized WebElement UserViewDetails(WebDriver driver) {
		return driver.findElement(UserViewDetails);
	}
	public static synchronized WebElement UserViewDetailsButton(WebDriver driver) {
		return driver.findElement(UserViewDetailsButton);
	}
	public static synchronized WebElement UserViewDetailsClose(WebDriver driver) {
		return driver.findElement(UserViewDetailsClose);
	}
	public static synchronized WebElement UserChartView(WebDriver driver) {
		return driver.findElement(UserChartView);
	}
	public static synchronized WebElement Diagnostics(WebDriver driver) {
		return driver.findElement(Diagnostics);
	}
	public static synchronized WebElement DiagnosticsData(WebDriver driver) {
		return driver.findElement(DiagnosticsData);
	}
	public static synchronized WebElement DiagnosticsCalendarddarrow(WebDriver driver) {
		return driver.findElement(DiagnosticsCalendarddarrow);
	}
	public static synchronized WebElement DiagnosticsCalendarddyear(WebDriver driver) {
		return driver.findElement(DiagnosticsCalendarddyear);
	}
	public static synchronized WebElement DiagnosticsViewButton(WebDriver driver) {
		return driver.findElement(DiagnosticsViewButton);
	}
	public static synchronized WebElement DiagnosticsViewCloseButton(WebDriver driver) {
		return driver.findElement(DiagnosticsViewCloseButton);
	}
	public static synchronized WebElement DiagnosticsChartView(WebDriver driver) {
		return driver.findElement(DiagnosticsChartView);
	}

}



