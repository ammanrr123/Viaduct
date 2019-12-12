package Test;

import java.io.IOException;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

public class app2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PDFUtil pdfUtil = new PDFUtil();
		//int a=pdfUtil.getPageCount("C:\\Users\\ammanrr.CORP\\Downloads\\LU0102737144_DE_CH.pdf");
		//System.out.println(a);
		//String text=pdfUtil.getText("C:\\Users\\ammanrr.CORP\\Downloads\\LU0102737144_DE_CH.pdf");
		//System.out.println(text);
		//pdfUtil.setImageDestinationPath("C:\\Users\\ammanrr.CORP\\Downloads");
		//pdfUtil.extractImages("C:\\Users\\ammanrr.CORP\\Downloads\\V40.pdf");
		
		//pdfUtil.setImageDestinationPath("C:\\Users\\ammanrr.CORP\\eclipse-workspace");
		
		//pdfUtil.savePdfAsImage("C:\\Users\\ammanrr.CORP\\Downloads\\V40.pdf");
		
		String file1="C:\\Users\\ammanrr.CORP\\Downloads\\V40.pdf";
		String file2="C:\\Users\\ammanrr.CORP\\Downloads\\VP40.pdf";
		
		// compares the pdf documents &amp; returns a boolean
		// true if both files have same content. false otherwise.
		// Default is CompareMode.TEXT_MODE
		pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		pdfUtil.setImageDestinationPath("C:\\Users\\ammanrr.CORP\\Downloads\\VK");
		pdfUtil.savePdfAsImage("testdiff");
		pdfUtil.compare(file1, file2);
		 
		// compare the 3rd page alone
		pdfUtil.compare(file1, file2, 3, 3);
		 
		// compare the pages from 1 to 5
		pdfUtil.compare(file1, file2, 1, 5);
		 
		//if you need to store the result
		pdfUtil.highlightPdfDifference(true);
		pdfUtil.setImageDestinationPath("C:\\Users\\ammanrr.CORP\\Downloads");
		pdfUtil.compare(file1, file2);
	}

}
