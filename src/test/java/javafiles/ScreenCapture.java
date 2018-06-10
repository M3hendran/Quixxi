package javafiles;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture {

	private static String imageString=null;

	public static synchronized String encodeBase64String(WebDriver driver, String filename) throws Exception
	{


		File Dest = new File(FilesAndPaths.ScreenShotDirectory()+File.separator+filename+".png");

		try {

			FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),Dest);
			Thread.sleep(10000);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		try {

			//encode image to Base64 String
			File f = new File(FilesAndPaths.ScreenShotDirectory()+File.separator+filename+".png");		//change path of image according to you
			FileInputStream fis = new FileInputStream(f);
			byte byteArray[] = new byte[(int)f.length()];
			fis.read(byteArray);
			imageString = Base64.encodeBase64String(byteArray);
			
			fis.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return "data:image/png;base64,"+imageString;

	}

}
