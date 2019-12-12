package Lib;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Utility {
public static final String Path="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary2p.xlsx";
private static XSSFSheet ExcelWSheet;
private static XSSFWorkbook ExcelWBook;
private static XSSFCell Cell;
private static XSSFRow Row;
private static MissingCellPolicy xRow;
//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

public static void setExcelFile(String Path,String SheetName) throws Exception {

try {

// Open the Excel file

FileInputStream ExcelFile = new FileInputStream(Path);

//Access the required test data sheet

ExcelWBook = new XSSFWorkbook(ExcelFile);

ExcelWSheet = ExcelWBook.getSheet(SheetName);

} catch (Exception e){

throw (e);

}

}

public static int rowcount(String SheetName) {
	ExcelWSheet=ExcelWBook.getSheet(SheetName);
int totalNoOfRows=ExcelWSheet.getLastRowNum();

return totalNoOfRows;
}


public static void excelReader(String Path,String SheetName) {
    @SuppressWarnings("unused")
	String data;
    try {
        InputStream is = new FileInputStream(Path);
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheet(SheetName);
        Iterator<Row> rowIter = sheet.rowIterator();
        Row r = (Row)rowIter.next();
        short lastCellNum = r.getLastCellNum();
        int[] dataCount = new int[lastCellNum];
        int col = 0;
        rowIter = sheet.rowIterator();
        while(rowIter.hasNext()) {
            Iterator<Cell> cellIter = ((Row)rowIter.next()).cellIterator();
            while(cellIter.hasNext()) {
                Cell cell = (Cell)cellIter.next();
                col = cell.getColumnIndex();
                dataCount[col] += 1;
                DataFormatter df = new DataFormatter();
                data = df.formatCellValue(cell);
              //  System.out.println("Data: " + data);
            }
        }
        is.close();
        for(int x = 0; x < dataCount.length; x++) {
        	int[] rowcount=new int[3];
        	
        	rowcount[x]=dataCount[x];
        	System.out.println(+rowcount[x]);
            System.out.println("col " + x + ": " + dataCount[x]);
            //int Col= col;
        }
    }
    catch(Exception e) {
        e.printStackTrace();
        return;
    }
}




//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(int RowNum, int ColNum) throws Exception{

try{

Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

String CellData = Cell.getStringCellValue();
//int totalNoOfRows=ExcelWSheet.getLastRowNum();
return CellData;

}catch (Exception e){

return"";

}

}

//This method is to write in the Excel cell, Row num and Col num are the parameters

@SuppressWarnings("static-access")
public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

try{

Row  = ExcelWSheet.getRow(RowNum);

Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);

if (Cell == null) {

Cell = Row.createCell(ColNum);

Cell.setCellValue(Result);

} else {

Cell.setCellValue(Result);

}

// Constant variables Test Data path and Test Data file name

FileOutputStream fileOut = new FileOutputStream(Path);

ExcelWBook.write(fileOut);

fileOut.flush();

fileOut.close();

}catch(Exception e){

throw (e);

}

}

}