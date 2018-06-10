package javafiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.codec.binary.Base64;

public class demobase64 {

	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		//encode image to Base64 String
				File f = new File("C:/Users/lakeba24/Desktop/Waypoints.ip-vulnerability.png");		//change path of image according to you
				FileInputStream fis = new FileInputStream(f);
				byte byteArray[] = new byte[(int)f.length()];
				fis.read(byteArray);
				String imageString = Base64.encodeBase64String(byteArray);
				
				System.out.println(imageString);
				
//z				//decode Base64 String to image
//				FileOutputStream fos = new FileOutputStream("C:/Users/lakeba24/Desktop/base64output.png"); //change path of image according to you
//				byteArray = Base64.decodeBase64(imageString);
//				fos.write(byteArray);
//		 
				fis.close();
//				fos.close();
	}

}
