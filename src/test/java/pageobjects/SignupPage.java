package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {

	private static WebDriver driver;
	private static WebElement element;
	
	public SignupPage(WebDriver driver){
		
		this.driver=driver;
		
	}
	public static synchronized WebElement registerLink(WebDriver driver) throws Exception{
		
		element = driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[5]/p/a"));
		
		return element;
	}
	public static synchronized WebElement email(WebDriver driver) throws Exception{
		
		element=driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[3]/div[1]/input"));
		
		return element; 
	}
	
	public static synchronized WebElement password(WebDriver driver)throws Exception{
		
		element = driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/div[4]/div[1]/input"));
		
		return element;
	}
	
	public static synchronized WebElement registerButton(WebDriver driver)throws Exception{
		
		element = driver.findElement(By.xpath("html/body/div[4]/div[2]/section/form/div/a"));
		
		return element;
	}
}
