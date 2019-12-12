package Test;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import Lib.Utility;

public class ActCommentary2 {

		
	public static void main(String[] args) throws Exception {
		//launching the browser
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
        	Utility.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\UploadCommentary2p.xlsx", "Sheet1");
		} catch (Exception e) {
			System.out.println("Given Updated user input file is not availble in specified location");
		}
       //Entering the user data from excel file
        try {
		driver.get(Utility.getCellData(1, 4));
		
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(Utility.getCellData(1, 5));
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Utility.getCellData(1, 6));
		
		driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);}catch(Exception e) {
			System.out.println("User is unable to login into aplication");
		}
		//after login mouse overing the views option
		 //Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
	
		Actions action=new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
		//this will fetch the all projects
		List<WebElement> links=driver.findElements(By.xpath("//*[@id='NavMenu']/ul[@class='jd_menu']/li[2]/ul[@class='jdm_events']/li/a"));
		
		//this will give total project
		System.out.println("Total projects are"+links.size());
		
		//this is will print the projects in order
		for(int i=0;i<links.size();i++) {
		
		WebElement element1=links.get(i);
		String text=element1.getAttribute("innerHTML");
			
		//String text=element1.getText();
		
		System.out.println("View is:"+text);
		
		if(text.equalsIgnoreCase(Utility.getCellData(1, 7))) {
			element1.click();
		
			String s1="//a[text()='";
			String s2="']//following-sibling::ul//a[text()='";
			String s3="']";
			
			
			String s4=Utility.getCellData(1, 8);
			String s5=Utility.getCellData(1, 9);
			
			WebElement subview=driver.findElement(By.xpath(s1+s4+s2+s5+s3));
			subview.click();
			
			//This is navigate to investment center which is mentioned in the excel
			List<WebElement> links2=driver.findElements(By.xpath("//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));
			
			System.out.println("Projects are"+links2.size());
			
			for(int j=0;j<links2.size();j++) {
				
			WebElement element2=links2.get(j);
			String text2=element2.getAttribute("innerHTML");
			
			
			System.out.println("Project name is:"+text2);
			
			if(text2.equalsIgnoreCase(Utility.getCellData(1, 10))){
			
			element2.click();
			
			WebElement e1=driver.findElement(By.xpath("//tr[contains(@id,'Row_GroupingForm')]//td[@class='']"));
			String text5=e1.getAttribute("innerHTML");
			
			System.out.println("product name is:"+text5);
			
			if(text5.equalsIgnoreCase(Utility.getCellData(1, 11)))
			{
				e1.click();
			//WebElement v1=driver.findElement(By.xpath("//*[@id='Row_GroupingForm_2']/td[3]/input"));
			//v1.click();
			
			int totalNoOfRows=Utility.rowcount("Sheet1");
					
			for(int row=1;row<=totalNoOfRows;row++) 
			
			{
				try {
			Select Act_Search=new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
			Act_Search.selectByVisibleText("Acct #");
			}
			catch(Exception e){
				System.out.println("Act_Search element not found");
				}
				
			
			try {
			Select Condition_Search=new Select(driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
			Condition_Search.selectByVisibleText("equals");
			}catch(Exception e) {
				System.out.println("Condition_Search element not found");
			}
			
			try {
			WebElement act1=driver.findElement(By.xpath("//input[@id='filter_Text_value']"));
			
			
			act1.clear();
			act1.sendKeys(Utility.getCellData(row, 0));
			}catch(Exception e) {
				System.out.println("Unable to enter data");
			}
			
			//second filter
			try {
			WebElement e5=driver.findElement(By.xpath("//input[@value='Add Condition']"));
			e5.click();}catch(Exception e) {
				System.out.println("unable to click the add condition button");
			}
			
			try {
			Select Note_search=new Select(driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
			Note_search.selectByVisibleText("And");}catch(Exception e) {
				System.out.println("And/OR option is not available");
			}
			
			try {
			Select operator2=new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
			operator2.selectByVisibleText("Notes");}catch(Exception e) {
				System.out.println("Notes option is not available");
			}
			
			try {
			Select operator3=new Select(driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
			operator3.selectByVisibleText("contains");}catch(Exception e) {
				System.out.println("Contains search option is not able to select");
			}
			
			
			try {
			WebElement e4=driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
			e4.clear();
			e4.sendKeys(Utility.getCellData(row, 1));}catch(Exception e) {
				System.out.println("unable to enter data from excel on to notes text box");
			}
			
			try {
			driver.findElement(By.xpath("//input[@value='Go']")).click();}catch(Exception e) {
				System.out.println("unable to click Go  button");
			}
			//after act#search,this will search for UserAction drop down
			try {
			WebElement select1=driver.findElement(By.xpath("//select[@id='UserAction']"));
			if(select1!=null) {
			Select values=new Select(select1);
			//this will collect all the options in dropdown into a list
			List<WebElement> options=values.getOptions();
			int isize=options.size();
			
			for(int s=0;s<isize;s++)
			{
				String sValue=options.get(s).getText();
				System.out.println(sValue);
			//these options  will compare with download commentary option
			if(sValue.equalsIgnoreCase("Download Commentary"))
			
			{   values.selectByVisibleText(sValue);
						
					
					driver.findElement(By.xpath("//input[@value='Return to Dashboard']")).click();
					
					Select user_action1=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
			        user_action1.selectByVisibleText("Upload Commentary");
						
			              
			        driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(Utility.getCellData(1,3 ));
			        driver.findElement(By.xpath("//input[@value='Upload Document']")).click();
						
			        Select user_action2=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
			        user_action2.selectByVisibleText("Rebuild");
			        System.out.println(Utility.getCellData(row, 0)+"successfully upload the commentary file");
			        WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
		            
		            e6.click();
		            Thread.sleep(2000);
		            //this will write into excel after successfully file upload
		            Utility.setCellData("File Uploaded", row, 2); 
		            break;
			}
			//these options  will compare with Upload commentary option
			else if(sValue.equalsIgnoreCase("Upload Commentary")) {
				values.selectByVisibleText(sValue);
				driver.findElement(By.xpath("//*[@id='CompDataWordML']")).sendKeys(Utility.getCellData(1,3 ));
		        driver.findElement(By.xpath("//input[@value='Upload Document']")).click();
					
		        Select user_action2=new Select(driver.findElement(By.xpath("//select[@id='UserAction']")));
		        user_action2.selectByVisibleText("Rebuild");
		        //this wil print the Act# that recently uploaded successfully on the console
		        System.out.println(Utility.getCellData(row, 0)+"successfully upload the commentary file");
		        WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
	            
	            e6.click();
	            Thread.sleep(2000);
	          //this will write into excel after successfully file upload
	            Utility.setCellData("File Uploaded", row, 2); 
	            break;
			}
			}
			}//if act# search is not available,this will throw the error with below error message
			else {
				System.out.println("Act# and User action is not available on dashboard");
				
			}}catch(Exception e) {
				System.out.println("Not valid account");
				WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
				e6.click();
				//this will write into excel if Act# is not present
				Utility.setCellData("Act# is not present", row, 2);
			}
		
            }
            
			System.out.println("All  "+totalNoOfRows+" Commentary files uploaded successfully:");
			break;
		}else {
			System.out.println("investment center is not present");
		}
		
				
		}
		}
						
		break;}	
			
		}driver.quit();}}
	

