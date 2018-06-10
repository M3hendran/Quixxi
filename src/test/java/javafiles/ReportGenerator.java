package javafiles;

import java.io.File;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenerator {
	
	private static ExtentReports extent;
    private static ExtentTest test;
    private static String reportFilePath;
    
    public ReportGenerator(String fileNameWithExtention, ExtentReports extent, ExtentTest test){
    	
    	this.extent=extent;
    	this.test=test;
    	
    	reportFilePath = System.getProperty("user.dir") +"/test-output/"+fileNameWithExtention;
    	extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/"+fileNameWithExtention, true);
        extent
        .addSystemInfo("Host Name", "Krishna")
        .addSystemInfo("Environment", "QA")
        .addSystemInfo("User Name", "Krishna Sakinala");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

    }
    
    public void appendReport(String title, String reportDescription, LogStatus statusCode){
    	test = extent.startTest("demoReportPass");
    	test.log(statusCode, "Assert Pass as condition is True");
    }

    public void sendReportViaEmail(){
    	
    	extent.endTest(test);
    	extent.flush();
        sendEmailReport();
    	
    }
    
/*
      ReportGenerator reporGenerator = new ReportGenerator("quixxi-login.html");
    reporGenerator.appendReport("Invalid Email", "Email entered is invalid");
    reporGenerator.sendReportViaEmail()

 * */    
    
    private void sendEmailReport() {
    	
    	HtmlEmail email = new HtmlEmail();
		try {
			email.setHostName("smtp.gmail.com");
			email.setSslSmtpPort("465");

			email.setAuthentication("jantest1lakeba@gmail.com", "M@he1234");
			email.setSSL(true);
			email.setFrom("jantest1lakeba@gmail.com");
			email.setSubject("Quixxi Automation test report");
			email.addTo("m.rajagopalan@lakeba.com");
//			email.addTo("s.khule@lakeba.com");
//			email.addTo("d.shah@lakeba.com");
//			email.addTo("b.sivam@lakeba.com");
			
			// Create the attachment
			EmailAttachment attachment = new EmailAttachment();
			//Create message body
			email.setHtmlMsg("<html>"+ 
					"<body> <div style='background-color:grey; height:50px; width:350px; margin:0;  padding:0'>"+
					"<h2 style='text-align: center; color:white;  padding:10px'> Mail content </h2></div>"+
					"<div><p>Hi,</p>"+
					"<p>Please download the attachment and view the content in Chrome browser</p><br>"+
					"<p style='color:red'>Report is Confidential</p>"+
					"</div></body></html>");

			//attachment = new EmailAttachment();
			File attachedFile = new File(reportFilePath);
			
			if(attachedFile.exists()){
				
				attachment.setPath(reportFilePath);
				System.out.println("File Length:"+attachedFile.length());
				Thread.sleep(3000);
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				Thread.sleep(6000);
				attachment.setName("Quixxi Automation - Extents Report");
				email.attach(attachment);
				email.send();
				System.out.println("Mail sent successfully");

			}
			else{
				System.out.println("File Not found at path : " + reportFilePath);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block`
			System.out.println(e.getMessage());
		}
    }
    
}
