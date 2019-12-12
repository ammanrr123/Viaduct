package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import Lib.Utility4;
import Lib.Utility5;

public class WebCrap {
	static String sFileName ="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\WebCrap1.xlsx" ;
	   static String sSheetName ="Sheet1";
	public static void main(String[] args) {
		
		try {
			System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");}
			catch(Exception e){
				System.out.println("unable to find the chrome driver");
			}
			
			WebDriver driver=new ChromeDriver();
			//maximizing the browser
			driver.manage().window().maximize();
			
			//searching for user data file
	        try {
				Utility5.setExcelFile("C://Users//ammanrr.CORP//eclipse-workspace//WebCrap.xlsx", "Sheet1");
			} catch (Exception e) {
				System.out.println("Given Updated user input file is not availble in specified location");
			}
	       //Entering the user data from excel file
	        try {
	    		driver.get(Utility5.getCellData(sFileName,sSheetName,1, 7));

	    		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(Utility5.getCellData(sFileName,sSheetName,1, 8));

	    		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Utility5.getCellData(sFileName,sSheetName,1, 9));

	    		driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
	    		} catch (Exception e) {
	    		System.out.println("User is unable to login into aplication");
	    		}
	    		

}
}