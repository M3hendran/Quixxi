package javafiles;

import java.io.File;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SendReports {
	
	private  HtmlEmail email=new HtmlEmail();
	private  WebDriver driver;
	
	public SendReports(){
		
	}
	
	public SendReports(WebDriver driver){
		
		this.driver=driver;
		
	}

//	public synchronized void sendMail() throws Exception {
//
//		try {
//			email.setHostName("smtp.gmail.com");
//			email.setSslSmtpPort("465");
//
//			email.setAuthentication("jantest1lakeba@gmail.com", "M@he1234");
//			email.setSSL(true);
//			email.setFrom("jantest1lakeba@gmail.com");
//			email.setSubject("Quixxi Automation test report");
//			email.addTo("m.rajagopalan@lakeba.com");
//			email.addTo("mahendran.k.rajagopal@gmail.com");
//			
////			email.addTo("s.khule@lakeba.com");
////			email.addTo("d.shah@lakeba.com");
////			email.addTo("b.sivam@lakeba.com");
//
////			// Create the attachment
//			EmailAttachment attachment = new EmailAttachment();
////			attachment.setPath(javafiles.FilesAndPaths.ShowTestNGReport()+File.separator+"emailable-report.html");
////			attachment.setDisposition(EmailAttachment.ATTACHMENT);
////			attachment.setName("Automation TestNG Report");
//
//			//Create message body
//			email.setHtmlMsg("<html>"+ 
//					"<body> <div style='background-color:grey; height:50px; width:350px; margin:0;  padding:0'>"+
//					"<h2 style='text-align: center; color:white;  padding:10px'> Mail content </h2></div>"+
//					"<div><p>Hi,</p>"+
//					"<p>Please download the attachment and view the content in Chrome browser</p><br>"+
//					"<p style='color:red'>Report is Confidential</p>"+
//					"</div></body></html>");
//
////			email.attach(attachment);
//			
//			
//			//attachment = new EmailAttachment();
//			String reportFilePath = javafiles.FilesAndPaths.ShowTestNGReport()+File.separator+"extent-report.html";
//			attachment.setPath(reportFilePath);
//			File attachedFile = new File(javafiles.FilesAndPaths.ShowTestNGReport()+File.separator+"extent-report.html");
//			
//			if(attachedFile.exists()){
//				System.out.println("File Length:"+attachedFile.length());
//				Thread.sleep(3000);
//				attachment.setDisposition(EmailAttachment.ATTACHMENT);
//				Thread.sleep(6000);
//				attachment.setName("Quixxi Automation - Extents Report");
//				email.attach(attachment);
//				email.send();
//				System.out.println("Mail sent successfully");
//
//			}
//			else{
//				System.out.println("File Not found at path : " + reportFilePath);
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block`
//			System.out.println(e.getMessage());
//		}
//	}

	
	public synchronized void sendMail() throws Exception {

		try {
			email.setHostName("smtp.gmail.com");
			email.setSslSmtpPort("465");

			email.setAuthentication("jantest1lakeba@gmail.com", "M@he1234");
			email.setSSL(true);
			email.setFrom("m.rajagopalan.com");
			email.setSubject("Quixxi Automation test report");
			email.addTo("m.rajagopalan@lakeba.com");
			email.addTo("s.khule@lakeba.com");
			email.addTo("d.shah@lakeba.com");
			email.addTo("b.sivam@lakeba.com");
			
//			// Create the attachment
			EmailAttachment attachment = new EmailAttachment();
			//Create message body
			email.setHtmlMsg("<html>"+ 
					"<body> <div style='background-color:grey; height:50px; width:350px; margin:0;  padding:0'>"+
					"<h2 style='text-align: center; color:white;  padding:10px'> Mail content </h2></div>"+
					"<div><p>Hi,</p>"+
					"<p>Please download the attachment and view the content in Chrome browser</p><br>"+
					"<p style='color:red'>Report is Confidential</p>"+
					"</div></body></html>");

//			email.attach(attachment);
			
			
			//attachment = new EmailAttachment();
			String reportFilePath = javafiles.FilesAndPaths.ShowTestNGReport()+File.separator+"extent-report.html";
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
