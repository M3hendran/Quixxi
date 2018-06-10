package quixxiversion3;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javafiles.FilesAndPaths;
import javafiles.ScreenCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FindingBrokenLinks {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest test;

	public FindingBrokenLinks(WebDriver driver, ExtentReports extent, ExtentTest test){

		this.driver=driver;
		this.extent=extent;
		this.test=test;

	}

	public static void brokenLinks() throws Exception {

		try {
			
			//Wait for 5 seconds
			Thread.sleep(5000);
			//Used tagName method to collect the list of items with tagName "a"
			//findElements - to find all the elements with in the current page. It returns a list of all webelements or an empty list if nothing matches
			List<WebElement> links = driver.findElements(By.tagName("a"));	
			//To print the total number of links
			System.out.println("Total links are "+links.size());	
			//used for loop to 
			for(int i=0; i<links.size(); i++) {
				WebElement element = links.get(i);
				//By using "href" attribute, we could get the url of the requried link
				String url=element.getAttribute("href");
				//calling verifyLink() method here. Passing the parameter as url which we collected in the above link
				//See the detailed functionality of the verifyLink(url) method below
				verifyLink(url);			
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();

			test.log(LogStatus.FAIL, e.getMessage(), test.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "findingbrokenlinks")));

		}	
	}

	// The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
	public static void verifyLink(String urlLink) throws Exception {
		//Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
		try {
			//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
			URL link = new URL(urlLink);
			// Create a connection using URL object (i.e., link)
			HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
			//Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);
			//connect using connect method
			httpConn.connect();
			//use getResponseCode() to get the response code. 
			if(httpConn.getResponseCode()== 200) {

				test.log(LogStatus.INFO, urlLink+" - "+httpConn.getResponseMessage());
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}
			if(httpConn.getResponseCode()== 404) {

				test.log(LogStatus.INFO, urlLink+" - "+httpConn.getResponseMessage());
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}
		}
		//getResponseCode method returns = IOException - if an error occurred connecting to the server. 
		catch (Exception e) {
			//e.printStackTrace();

			test.log(LogStatus.FAIL, e.getMessage(), test.addBase64ScreenShot(ScreenCapture.encodeBase64String(driver, "findingbrokenlinks.png")));

		}
	} 
}
