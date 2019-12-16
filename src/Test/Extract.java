package Test;


import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;

import Lib.Utility;

public class Extract {

 public static void main(String[] args){
 PDDocument pd;
 BufferedWriter wr;
 try {
		Utility.setExcelFile("C://Users//ammanrr//eclipse-workspace//Pdfextract.xlsx", "Sheet1");
	} catch (Exception e) {
		System.out.println("Given Updated user input file is not availble in specified location");
	}
 try {
         
         int totalNoOfRows=Utility.rowcount("Sheet1");
			
         for(int row=1;row<=totalNoOfRows;row++) {
        	 File input = new File(Utility.getCellData(row, 0));	
        	 pd = PDDocument.load(input);
        	 System.out.println(pd.getNumberOfPages());
        	 System.out.println(pd.isEncrypted());
         
        	 PDFTextStripper stripper = new PDFTextStripper();
        	 File output = new File(Utility.getCellData(row, 1)); 
        	 wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
        	 stripper.writeText(pd, wr);
        	 if (pd != null) {
        		 pd.close();
        	 }
        // I use close() to flush the stream.
        	 wr.close();}
 	} catch (Exception e){
         e.printStackTrace();
        } 
     }
}