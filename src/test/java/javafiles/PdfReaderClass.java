package javafiles;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PdfReaderClass {

	public String pdfReaderfromDesktop(String filePath) throws IOException, InterruptedException
	{
				
		PDDocument TestPDF = PDDocument.load(new File(filePath));
		
		PDFTextStripper pdfStripper = new PDFTextStripper();
		
		String pdfText = pdfStripper.getText(TestPDF);
		Thread.sleep(3000);
		TestPDF.close();
		return pdfText;
		
	}
	

	
}
