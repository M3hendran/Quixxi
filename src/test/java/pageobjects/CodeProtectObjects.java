package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class CodeProtectObjects {
	
	private static WebElement element;
	private static WebDriver driver;
	
	public CodeProtectObjects(WebDriver driver, WebElement element){
		
		this.element = element;
		this.driver = driver;
		
	}
	
	public static WebElement protectlink(WebDriver driver) throws Exception {
		
		element = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div/div/div/ul/div[4]/li/a/span"));
		
		return element;
	}
	
	public static WebElement uploadfile(WebDriver driver) throws Exception {
		
		element = driver.findElement(By.xpath("//*[@id='dropfile']/div/div[1]/label/div"));
		
		return element;
	}
	
	public static WebElement nextButton(WebDriver driver) throws Exception {
		
		element = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[2]/button"));
		
		return element;
	}
	
	public static WebElement html5Choice(WebDriver driver) throws Exception {
		
		element = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[1]/div[2]/label" ));
		
		return element;
	}
	
	public static WebElement downloadLibrary(WebDriver driver) throws Exception {
		
		element = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[1]/div[2]/div[3]/a"));
		
		return element;
	}
	
	public static WebElement subscribeStartup(WebDriver driver) throws Exception {
		
		element = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[1]/div[4]/div[2]/div/div[1]/div[2]/div/table/tbody/tr[5]/td[3]/div/button"));
		
		return element;
	}
	
	public static WebElement continueBtn(WebDriver driver) throws Exception {
		
		element = driver.findElement(By.xpath("//*[@id='planProcessingView']/div/div/div/form/div[2]/div[2]/div[2]/div/div/button[2]"));
		
		return element;
	}

	public static WebElement subscriptionNextBtn(WebDriver driver) throws Exception {
		
		element = driver.findElement(By.xpath("//*[@id='uiview']/div[1]/div/div/div[1]/div/div[2]/button"));
		
		return element;
	}
}
