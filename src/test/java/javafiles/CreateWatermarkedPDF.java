package javafiles;

import java.io.File;
import java.io.IOException;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.extgstate.PdfExtGState;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;


public class CreateWatermarkedPDF
{
	String size1 = "C:\\Users\\lakeba24\\workspace\\newquixxi_version3\\exceldata\\Billing.pdf";
	
	 public static final String SRC = javafiles.FilesAndPaths.TestData()+File.separator+"Billing.pdf";
	 
	    public static final String DEST = javafiles.FilesAndPaths.TestData()+File.separator+"Verified.pdf";
	    
	    int size = size1.length();
	   
	    
	    		public void manipulatepdf1() throws IOException
	    		{
	    			 System.out.println(size);
	    			File file = new File(DEST);
	    			
	    			if(size ==68 || size==33)
	    			{
	    				System.out.println(size);
		    			file.getParentFile().mkdirs();
		    			new CreateWatermarkedPDF().manipulatePdf(SRC, DEST);
	    			}
	    			else if(size==34)
	    			{
	    				System.out.println(size);
	    				file.getParentFile().mkdirs();
		    			new CreateWatermarkedPDF().manipulatePdf2(SRC, DEST);
	    			}
	    			else
	    			{
	    				System.out.println("File size exceeds");
	    				    			
	    			}
	    		}
	    	
	   
	    	public void manipulatePdf(String src, String dest) throws IOException 
	    	{
	 
	 	    //Initialize PDF document
	    		PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
	        
	    		Document document = new Document(pdfDoc);

	    		PdfCanvas canvas;
	    		int n = pdfDoc.getNumberOfPages();
	    		for (int i = 1; i <= n; i++) 
	    		{
	    			PdfPage page = pdfDoc.getPage(i);
	    			Rectangle pageSize = page.getPageSize();
	    			
	    			canvas = new PdfCanvas(page);
	            //new Canvas(canvas, pdfDoc, new Rectangle(120, 500, 130, 280));
	            canvas.rectangle(265, 662, 140, 28).setStrokeColor(Color.RED);
	            canvas.rectangle(115, 662, 120, 28).setStrokeColor(Color.RED);
	            canvas.rectangle(430, 635, 90, 28).setStrokeColor(Color.RED);
	            canvas.rectangle(455, 755, 90, 28).setStrokeColor(Color.RED);

	            canvas.stroke();
	            //Draw watermark
	            Paragraph p = new Paragraph("VERIFIED").setFontSize(35).setBackgroundColor(Color.GRAY);
	            canvas.saveState();
	            PdfExtGState gs1 = new PdfExtGState().setFillOpacity(0.2f);
	            canvas.setExtGState(gs1);
	            document.showTextAligned(p, 300, 500, TextAlignment.CENTER);
//	            document.showTextAligned(p,
//	                    pageSize.getWidth() / 2, pageSize.getHeight() / 2,
//	                    pdfDoc.getPageNumber(page),
//	                    TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);
	            canvas.restoreState();
	           
	        }
	    		 pdfDoc.close();
	   	}
	    	public void manipulatePdf2(String src, String dest) throws IOException 
	    	{
	    		PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
		        
	    		Document document = new Document(pdfDoc);

	    		PdfCanvas canvas;
	    		int n = pdfDoc.getNumberOfPages();
	    		for (int i = 1; i <= n; i++) 
	    		{
	    			PdfPage page = pdfDoc.getPage(i);
	    			Rectangle pageSize = page.getPageSize();
	    			
	    			canvas = new PdfCanvas(page);
	            //new Canvas(canvas, pdfDoc, new Rectangle(120, 500, 130, 280));
	          
	            canvas.rectangle(130, 667, 80, 20).setStrokeColor(Color.RED);
	            canvas.rectangle(130, 640, 80, 20).setStrokeColor(Color.RED);
	            canvas.rectangle(220, 667, 80, 20).setStrokeColor(Color.RED);
	            canvas.rectangle(220, 640, 80, 20).setStrokeColor(Color.RED);
	            canvas.rectangle(400, 665, 80, 20).setStrokeColor(Color.RED);
	            canvas.rectangle(400, 640, 80, 20).setStrokeColor(Color.RED);
	            canvas.rectangle(400, 610, 80, 20).setStrokeColor(Color.RED);
	            //date//
	            canvas.rectangle(455, 755, 90, 28).setStrokeColor(Color.RED);

	            canvas.stroke();
	            //Draw watermark
	            Paragraph p = new Paragraph("VERIFIED").setFontSize(35).setBackgroundColor(Color.GRAY);
	            canvas.saveState();
	            PdfExtGState gs1 = new PdfExtGState().setFillOpacity(0.2f);
	            canvas.setExtGState(gs1);
	           document.showTextAligned(p, 300, 450, TextAlignment.CENTER);
//	            document.showTextAligned(p,
//	                    pageSize.getWidth() / 2, pageSize.getHeight() / 2,
//	                    pdfDoc.getPageNumber(page),
//	                    TextAlignment.CENTER, VerticalAlignment.MIDDLE, 45);
	            canvas.restoreState();
	           
	    	    	
	    	   }
	    		pdfDoc.close();
	    	}
	    	
}
	    



