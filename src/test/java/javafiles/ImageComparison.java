package javafiles;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class ImageComparison {
	
	public static boolean compare(File file1, File file2) throws Exception  { 
		
		boolean filematches=false;

        if(file1.exists() && file2.exists() ){
             if(FileUtils.contentEquals(file1, file2)){
            	 filematches=true;
             }else{
             	 filematches=false;
             }	
        }else{
        	 System.out.println("File does not exists ");
        }
       
	 return filematches;
	 
   }

}
