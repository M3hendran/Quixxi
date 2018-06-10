package javafiles;

import java.io.File;

public class FilesAndPaths {
	
	public static synchronized File ScreenShotDirectory() throws Exception {
		
		File scrDir=new File("Screenshots"+File.separator);
		
		try {
			if(!scrDir.exists()){
				
				scrDir.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scrDir;
		
	}
	
	
	public static synchronized File PDFDirectory() throws Exception{
		
		File docdir = new File("Documents"+File.separator);

		try {
			if(!docdir.exists()){
				
				docdir.mkdir();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return docdir;
		
	}
	
	public static synchronized File TestReport() throws Exception{
		
		File exceldir = new File("ExcelReports"+File.separator);

		try {
			if(!exceldir.exists()){
				
				exceldir.mkdir();				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exceldir;
		
	}
	
	public static synchronized File TestLog() throws Exception{
		
		File logdir = new File("TestLogs"+File.separator);

		try {
			if(!logdir.exists()){
				
				logdir.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return logdir;
		
	}

	public static synchronized File TestData(){
		
		File datadir = null;
		
		try {
			datadir = new File("exceldata"+File.separator);
			if(!datadir.exists()){
				
				datadir.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datadir;
	}
	
	public static synchronized File Browsers() throws Exception{
		
		File datadir = new File("Browser"+File.separator);
		
		try {
			if(!datadir.exists()){
				
				datadir.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datadir;
		
	}

	public static synchronized File imagePath() throws Exception{
		
		File datadir = new File("ImagesToCompare"+File.separator);
		
		try {
			if(!datadir.exists()){
				
				datadir.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datadir;
		
	}

	public static synchronized File apkPath() throws Exception{
		
		File datadir = new File("APK Files"+File.separator);
		
		try {
			if(!datadir.exists()){
				
				datadir.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datadir;
		
	}


	public static synchronized File ShowTestNGReport() throws Exception{
		
		File report = new File("test-output"+File.separator);
		
		try {
			if(report.exists()){
				
				new File(report+File.separator+"emailable-report.html");
				Thread.sleep(3000);
				new File(report+File.separator+"extent-report.html");
				Thread.sleep(3000);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return report;
		
	}

	public static synchronized File macSystem() throws Exception{
		
		File mac = new File("macsystem"+File.separator);
		
		try {
			if(!mac.exists()){
				
				mac.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mac;
		
	}

	public static synchronized File linuxSystem() throws Exception{
		
		File linux = new File("linuxsystem"+File.separator);
		
		try {
			if(!linux.exists()){
				
				linux.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return linux;
		
	}

}
