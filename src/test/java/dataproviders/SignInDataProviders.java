package dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class SignInDataProviders {
	
	private static WebDriver driver;
	private static WebDriver wd;
	private static HSSFWorkbook wb;
	private static HSSFSheet ws;

	
	public SignInDataProviders(WebDriver driver){
		
		this.driver=driver;
	}

	@DataProvider(name="signin")
	public static synchronized Object[][] signindata() throws Exception {

		Object[][] data=null;
		
		try {
			
			FileInputStream filein=new FileInputStream(new File(javafiles.FilesAndPaths.TestData()+File.separator+"Login.xls"));
			wb=new HSSFWorkbook(filein);
			ws=wb.getSheet("Signin");
			
			Iterator<Row> row1=ws.iterator();
			HSSFRow hssfrow1=(HSSFRow)row1.next();
			
			int rows=ws.getLastRowNum();
			int cols=hssfrow1.getLastCellNum();
			
			data=new Object[rows][cols];
			
			int i=0; 
			
			while(row1.hasNext()){
				
				HSSFRow hssfrow2=(HSSFRow)row1.next();
				
				Iterator<Cell> cell1=hssfrow2.cellIterator();
				
				int j=0;
				
				while(cell1.hasNext()){
					
					HSSFCell hssfcell=(HSSFCell)cell1.next();
					
					data[i][j]=hssfcell.getStringCellValue();
					
					j++;
				}
				
				i++;
			}
			
			filein.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Object[][]{new Object[]{data}};
		
	}

}
