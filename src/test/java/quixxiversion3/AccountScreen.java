package quixxiversion3;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import javafiles.RobotClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageobjects.AccountPageObjects;

public class AccountScreen {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest parent;
	private static ExtentTest child1;
	private static ExtentTest child2;

	public AccountScreen(WebDriver driver, ExtentReports extent, ExtentTest parent, ExtentTest child1, ExtentTest child2)
	{
		this.driver=driver;
		this.extent=extent;
		this.parent=parent;
		this.child1=child1;
		this.child2=child2;
	}

	public synchronized void Account() throws InterruptedException, AWTException 
	{
		
		try {
			
			parent=extent.startTest("Account Screen");
			child1=extent.startTest("Addition of Card Details");
			parent.appendChild(child1);
			
			//***********Loads the accountPageObjects and accessing the elements in this method ******************//
			AccountPageObjects accObj = PageFactory.initElements(driver, AccountPageObjects.class);
			RobotClass robot = PageFactory.initElements(driver, RobotClass.class);

			Thread.sleep(5000);

			/*	if(accObj.Profile.isDisplayed() && accObj.Profile.isEnabled())
			{
				accObj.Profile.click();
				Thread.sleep(3000);
				System.out.println("=====================================================================================================================================");
				System.out.println("The Following options in User Profile menu ");
				for(WebElement profile : accObj.profilemenu)
				{

					System.out.println("-> " +profile.getText());
				}
				System.out.println("=====================================================================================================================================");

			}
			else
			{
				System.out.println("-------------------User Profile Menu not Displayed ---------------------");
				driver.close();
			}

			if(accObj.Account.isDisplayed() && accObj.Account.isEnabled())
			{
				accObj.Account.click();
				Thread.sleep(3000);
				System.out.println("-----------------------------------User Account Page -------------------------------------------------");

			}
			else
			{
				System.out.println("-------------------Account Option not Displayed from profile menu ---------------------");
				driver.close();
			}

			if(accObj.FirstName.isDisplayed() && accObj.FirstName.isEnabled())
			{
				System.out.println("-----------------------------------Checking " +accObj.BasicSetting.getText()+" option in Account screen -------------------------------------------------");
				accObj.FirstName.clear();
				Thread.sleep(3000);
				accObj.FirstName.sendKeys(accObj.First_Name);
				System.out.println(accObj.Fname_Label.getText()+" = "+accObj.First_Name);
				Thread.sleep(3000);
			}
			else
			{
				System.out.println("-------------------FirstName Field not Displayed in Account ---------------------");
				driver.close();
			}
			if(accObj.AccEmail.isEnabled())
			{
				System.out.println("-------------------Email Field is Editable in Account ---------------------");
				driver.close();
			}
			else
			{
				System.out.println(accObj.Email_Label.getText()+" = "+Config.username);
			}

			if(accObj.LastName.isDisplayed() && accObj.LastName.isEnabled())
			{
				accObj.LastName.clear();
				Thread.sleep(3000);
				accObj.LastName.sendKeys(accObj.Last_Name);
				System.out.println(accObj.Lname_Label.getText()+" = "+accObj.Last_Name);
				Thread.sleep(3000);
			}
			else	
			{
				System.out.println("-------------------LastName Field not Displayed in Account ---------------------");
				driver.close();
			}
			if(accObj.TimeZone.isEnabled() && accObj.TimeZone.isDisplayed())
			{
				System.out.println("TIME ZONE List are = ");
				for(WebElement TimeZoneList : accObj.TzoneList)
				{
					System.out.println(TimeZoneList.getText());
				}

			}
			else
			{
				System.out.println("-------------------TimeZone Field not Displayed in Account ---------------------");
				driver.close();
			}


			RobotClass robot = PageFactory.initElements(driver, RobotClass.class);
			if(accObj.ProfileImg.isDisplayed() && accObj.ProfileImg.isEnabled())
			{

				  accObj.ProfileImg.click();
				  robot.chooseImageFromDesktop();
				  Thread.sleep(5000);
			}
			else
			{
				System.out.println("error");
			}

			      if(accObj.Update.isDisplayed()&&accObj.Update.isEnabled())
			      {
			    	  accObj.Update.click(); 
			      }
			      else
			      {
			    	  System.out.println("---------------------------Unable to update - Update button not enable--------------------------------");
			    	  driver.close();
			      }

			      if(accObj.CurrPwd.isDisplayed()&&accObj.CurrPwd.isEnabled())
			      {
					  System.out.println("-----------------------------------Checking " +accObj.ChangePwd_Label.getText()+" option in Account screen -------------------------------------------------");
					  System.out.println(accObj.CurrPwd_Label.getText()+" = "+Config.password);
			    	  accObj.CurrPwd.sendKeys(Config.password); 
			    	  Thread.sleep(3000);
			      }
			      else
			      {
			    	  System.out.println("----------------------CURRENT PASSWORD field is not Enable--------------------------");  
			    	  driver.close();

			      }
			      if(accObj.NewPwd.isDisplayed()&&accObj.NewPwd.isEnabled())
			      {
			    	  System.out.println(accObj.NewPwd_Label.getText()+" = "+accObj.New_Pwd);
			    	  accObj.NewPwd.sendKeys("Testing@12"); 
			    	  Thread.sleep(3000);
			      }
			      else
			      {
			    	  System.out.println("----------------------NEW PASSWORD field is not Enable--------------------------");  
			    	  driver.close();

			      }
			      if(accObj.ConfmPwd.isDisplayed()&&accObj.ConfmPwd.isEnabled())
			      {
			    	  System.out.println(accObj.RePwd_Label.getText()+" = "+accObj.New_Pwd);
			    	  accObj.ConfmPwd.sendKeys("Testing@12"); 
			    	  Thread.sleep(3000);
			      }
			      else
			      {
			    	  System.out.println("----------------------CONFORM PASSWORD field is not Enable--------------------------");  
			    	  driver.close();

			      }
			      JavascriptExecutor jse = (JavascriptExecutor)driver;
			      jse.executeScript("window.scrollBy(0,250)", "");
			      if(accObj.PwdUpdate.isDisplayed()&&accObj.PwdUpdate.isEnabled())
			      {
			    	  accObj.PwdUpdate.click(); 
			    	  Thread.sleep(3000);
			      }
			      else
			      {
			    	  System.out.println("---------------------------Unable to update - Update button not enable--------------------------------");
			    	  driver.close();
			      }*/

			// Card Test //
			if(accObj.AddNewCard.isDisplayed()&&accObj.AddNewCard.isEnabled())
			{
				System.out.println("-----------------------------------Checking " +accObj.Cards_Label.getText()+" option in Account screen -------------------------------------------------");
				//test.log(LogStatus.INFO, "-----------------------------------Checking " +accObj.Cards_Label.getText()+" option in Account screen -------------------------------------------------");
				accObj.AddNewCard.click();
				child1.log(LogStatus.INFO, "User clicked Add new Card Button");
				Thread.sleep(3000);
			}
			else
			{
				System.out.println("---------------------------Add card button not displayed--------------------------------");
				child1.log(LogStatus.INFO, "---------------------------Add card button not displayed--------------------------------");
				driver.close();  
			}
			if(accObj.CardName.isDisplayed()&&accObj.CardName.isEnabled())
			{
				System.out.println("Card Name"+" = "+accObj.Card_Name);
				child1.log(LogStatus.INFO, "Card Name"+" = "+accObj.Card_Name);
				accObj.CardName.sendKeys(accObj.Card_Name);
				Thread.sleep(3000);
			}
			else
			{
				System.out.println("---------------------------Card Name Field not displayed--------------------------------");
				child1.log(LogStatus.INFO, "---------------------------Card Name Field not displayed--------------------------------");
				driver.close();  
			}
			System.out.println("Card Number"+" = "+accObj.CardNum.getText());
			child1.log(LogStatus.INFO,"Card Number"+" = "+accObj.CardNum.getText());
			System.out.println("Expired Date(MM/YY)"+" = "+accObj.ExpDate.getText());
			child1.log(LogStatus.INFO, "Expired Date(MM/YY)"+" = "+accObj.ExpDate.getText());
			System.out.println("CVC"+" = "+accObj.CVC);
			child1.log(LogStatus.INFO, "CVC"+" = "+accObj.CVC);
			System.out.println("ZIP"+" = "+accObj.ZIP);
			child1.log(LogStatus.INFO, "ZIP"+" = "+accObj.ZIP);
			robot.cardDetails();
			Thread.sleep(6000);

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.custom-tile-md.clearfix")));

			if(accObj.AddCard.isDisplayed()&&accObj.AddCard.isEnabled())
			{
				accObj.AddCard.click();
				child1.log(LogStatus.INFO, "User clicked Add card button");
				Thread.sleep(5000);
			}
			else
			{
				System.out.println("---------------------------Add card Button not displayed--------------------------------");
				child1.log(LogStatus.INFO, "Add card Button not displayed");
				driver.close();  
			}  
			Thread.sleep(3000);
			if(accObj.EditCard.isDisplayed()&& accObj.EditCard.isEnabled())
			{
				accObj.EditCard.click();
				child1.log(LogStatus.INFO, "User editing the card details");
				Thread.sleep(8000);
			}
			else
			{
				System.out.println("---------------------------Edit card not displayed--------------------------------");
				child1.log(LogStatus.INFO, "Edit card not displayed");
				driver.close(); 
			}
			Thread.sleep(3000);
			if(accObj.EditCardName.isDisplayed()&& accObj.EditCardName.isEnabled())
			{
				accObj.EditCardName.sendKeys("Lakeba");
				child1.log(LogStatus.INFO, "User typed Lakeba");
				Thread.sleep(3000);
			}
			else
			{
				System.out.println("---------------------------Card Name Field not displayed--------------------------------");
				child1.log(LogStatus.INFO, "Card Name Field not displayed");
				driver.close();  
			}
			Thread.sleep(3000);
			if(accObj.Exp_month.isDisplayed()&& accObj.Exp_month.isEnabled())
			{
				accObj.Exp_month.click();
				child1.log(LogStatus.INFO, "User clicked month");


				RobotClass.robot.keyPress(KeyEvent.VK_DOWN);
				RobotClass.robot.keyRelease(KeyEvent.VK_DOWN);

				RobotClass.robot.keyPress(KeyEvent.VK_ENTER);
				RobotClass.robot.keyRelease(KeyEvent.VK_ENTER);
			}
			else
			{
				System.out.println("--------------------------------Exp.Month field not displayed-----------------------------");
				child1.log(LogStatus.INFO, "Exp.Month field not displayed");
			}
			Thread.sleep(3000);
			if(accObj.Exp_year.isDisplayed()&& accObj.Exp_year.isEnabled())
			{
				accObj.Exp_year.click();
				child1.log(LogStatus.INFO, "User clicked year");
				RobotClass.robot.keyPress(KeyEvent.VK_DOWN);
				RobotClass.robot.keyRelease(KeyEvent.VK_DOWN);

				RobotClass.robot.keyPress(KeyEvent.VK_ENTER);
				RobotClass.robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);

				RobotClass.robot.keyPress(KeyEvent.VK_TAB);
				RobotClass.robot.keyRelease(KeyEvent.VK_TAB);

				RobotClass.robot.keyPress(KeyEvent.VK_ENTER);
				RobotClass.robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);
			}
			else
			{
				System.out.println("--------------------------------Exp.Year field not displayed-----------------------------");
				child1.log(LogStatus.INFO, "Exp.Year field not displayed");
			}
			Thread.sleep(3000);
			if(accObj.CardDelete.isDisplayed()&&accObj.CardDelete.isEnabled())
			{
				accObj.CardDelete.click();
				child1.log(LogStatus.INFO, "User clicked Delete");
				Thread.sleep(8000);
			}
			else
			{
				System.out.println("---------------------------------Delete button of Card not displayed--------------------" );
				child1.log(LogStatus.INFO, "Delete button of Card not displayed");
			}
			Thread.sleep(3000);
			if(accObj.DeleteYes.isDisplayed()&&accObj.DeleteYes.isEnabled())
			{
				accObj.DeleteYes.click();
				child1.log(LogStatus.INFO, "User Clicked Yes to Delete the Card Details");
				Thread.sleep(8000);
				System.out.println("=====================================================================================================================================");
				//child1.log(LogStatus.INFO, "=====================================================================================================================================");

			}
			else
			{
				System.out.println("---------------------------------Continue button of Card delete not displayed--------------------" );
				child1.log(LogStatus.INFO, "Continue button of Card delete not displayed" );
			}
			
			extent.endTest(parent);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-400)", "");
			Thread.sleep(5000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
