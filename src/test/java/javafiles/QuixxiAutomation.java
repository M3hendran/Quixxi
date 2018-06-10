package javafiles;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


public class QuixxiAutomation {

	public static synchronized void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			XmlSuite suite = new XmlSuite();
			suite.setName("functional");
			 
			XmlTest chrometest = new XmlTest(suite);
			chrometest.setName("chrome");
			List<XmlClass> chromeclasses = new ArrayList<XmlClass>();
			chromeclasses.add(new XmlClass("quixxiversion3.ChromeBrowser"));
			chromeclasses.add(new XmlClass("quixxiversion3.SignUp"));
			chromeclasses.add(new XmlClass("quixxiversion3.TermsAndConditions"));
			chromeclasses.add(new XmlClass("quixxiversion3.SignInLink"));
			chromeclasses.add(new XmlClass("quixxiversion3.ForgotPassword"));
			chromeclasses.add(new XmlClass("quixxiversion3.SignInPage"));
			chromeclasses.add(new XmlClass("quixxiversion3.QuixxiAccount"));
			chromeclasses.add(new XmlClass("quixxiversion3.SubscriptionScreen"));
			chromeclasses.add(new XmlClass("quixxiversion3.BillingScreen"));
			chromeclasses.add(new XmlClass("quixxiversion3.OverviewAddPlatform"));
			chromeclasses.add(new XmlClass("quixxiversion3.PackageAddPlatform"));
			chromeclasses.add(new XmlClass("quixxiversion3.VerifyingDocs"));
			chromeclasses.add(new XmlClass("quixxiversion3.VulnerabilityCheck"));
			chromeclasses.add(new XmlClass("quixxiversion3.ProtectNow"));
			chromeclasses.add(new XmlClass("quixxiversion3.ControlFunction"));
			chromeclasses.add(new XmlClass("quixxiversion3.MarketPlaceFunction"));
			chromeclasses.add(new XmlClass("quixxiversion3.VideoandSupport"));
			chromeclasses.add(new XmlClass("quixxiversion3.Logout"));

			chrometest.setXmlClasses(chromeclasses);
			
			
			List<XmlSuite> suites = new ArrayList<XmlSuite>();
			suites.add(suite);
			TestNG tng = new TestNG();
			tng.setXmlSuites(suites);
			tng.run();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
