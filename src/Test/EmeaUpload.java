package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Lib.Utility6;



public class EmeaUpload {
	   static String sFileName ="\\\\crate\\share\\IGNA\\IS\\AlfrescoUpload2\\Alfresco_Upload_Files1.xlsx" ;
	   static String sSheetName ="Sheet1";
	   static String sRunMode;
	   static int Error;
	 //main method
	   public static void main(String[] args) throws Exception {
		   {    
	
				
		try {
			
			Utility6.setExcelFile("\\\\crate\\share\\IGNA\\IS\\AlfrescoUpload2\\Alfresco_Upload_Files1.xlsx", "Sheet1");
		} catch (Exception e) {
		System.out.println("Given Updated user input file is not availble in specified location");
		}
	//getting no.of files to load
		String sSheet1 = "Sheet1";
		int totalNoOfRows = Utility6.rowcount(sSheet1);
		System.out.println(+totalNoOfRows);
		int row;
	
		for ( row = 1; row <= totalNoOfRows; row++) 
		{
		
			sRunMode=Utility6.getCellData(sFileName,sSheetName,row, 12);
		

			if(sRunMode.equals("Yes")) {
		
				System.out.println(+row + " File uploading Started");
				//driver.navigate().refresh();

	
				//browser properties
				try {
					System.setProperty("webdriver.chrome.driver","\\\\crate\\share\\IGNA\\IS\\AlfrescoUpload2\\chromedriver.exe");
				}catch(Exception e) {
				System.out.println("Driver is outdated please reinstall the new chrome driver exe");
				}
	
				WebDriver driver = new ChromeDriver(); 
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	

				try {
					//navigating to URL
					driver.get("https://invescohub.com/share/page/site/emea-marketing-library/dp/ws/faceted-search#sortField=null&scope=repo");
				}catch(Exception e) {
					System.out.println("Url is not valid or no access to the site");
				}
			//clicking on document_library
				try {
					driver.findElement(By.xpath("//*[@id='HEADER_SITE_DOCUMENTLIBRARY_text']/a")).click();
				}catch(Exception e) {
					System.out.println("unable to click Document library button");
				}

				Thread.sleep(2000);
				
				//Clicking on General Marketing option
				try {
					driver.findElement(By.xpath("//*[@class='yui-dt30-col-fileName yui-dt-col-fileName']/div/h3/span/a[text()='General Marketing Collateral']")).click();
				}catch(Exception e) {
				System.out.println("unable to click General Marketing option button");
				}
				Thread.sleep(2000);

			//driver.navigate().refresh();
				
				//Click on upload button tab summary
				try {
					driver.findElement(By.xpath("//*[text()='_Upload']")).click();
				}catch(Exception e) {
				System.out.println("unable to click upload button");
				}

			//click on upload files
	
				try {
				driver.findElement(By.xpath("//*[@class='yui-dt-message']/tr/td/div//span/a[text()='Upload files']")).click();
				}catch(Exception e) {
				System.out.println("unable to click on upload button");
				}

				Thread.sleep(5000);
	
				//uploading the file
				try {
				driver.findElement(By.xpath("//*[@class='yui-button yui-push-button alf-primary-button']/span/input[contains(@name,'files[]')]")).sendKeys((Utility6.getCellData(sFileName,sSheetName,row, 0)));
				}catch(Exception e) {
				System.out.println("unable to upload the file");
				}


				//content type
				try {
					Select user_action1=new Select(driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-content-type-select']")));

					user_action1.selectByVisibleText((Utility6.getCellData(sFileName,sSheetName,row, 1)));
				}catch(Exception e) {
					System.out.println("Unable to select the content type parameter");
				}

				//Investment_Team
				try {
					WebElement user_action2= 
			driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form_prop_ipm_investmentTeam-entry']"));
					Select Investment_team =new Select(user_action2);

					List<WebElement> teams=Investment_team.getOptions();
	//int s1=teams.size();
	/*for(int l=0;l<s1;l++) {
 	 	System.out.println(teams.get(l).getText());
 	 	}*/
					int isize=teams.size();
					String Values = Utility6.getCellData(sFileName,sSheetName,row, 3);
					List<String>options=new ArrayList<String>(Arrays.asList(Values.split(",")));
					int ivalues=options.size();
					for(int k=0;k<ivalues;k++) {
						String options1=options.get(k);
						for(int p=0;p<isize;p++) {
							String optionelement=teams.get(p).getText();
		//System.out.println(optionelement);
		
							if(options1.equalsIgnoreCase(optionelement)) {
								Investment_team.selectByVisibleText(options1);
								break;
							}	
						}
					}
				}
				catch(Exception e) {
					System.out.println("unable to select the investment team parameters");
						Utility6.setCellData("please provide proper Investment team options", row, 13); 
	
				}

	//Asset_class
try {
	WebElement user_action3=
			driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form_prop_ipm_assetClass-entry']"));
	Select asset_class=new Select(user_action3);

	List<WebElement>assetclass=asset_class.getOptions();
	//int s2=assetclass.size();
			/*for(int l=0;l<s2;l++) {
		 	 	System.out.println(assetclass.get(l).getText());
		 	 	}*/
	int asize= assetclass.size();
	String Avalues=Utility6.getCellData(sFileName,sSheetName,row, 4);
	List<String>aoptions=new ArrayList<String>(Arrays.asList(Avalues.split(",")));
	int a1options=aoptions.size();
 	for(int m=0;m<a1options;m++) {
	String setoptions=aoptions.get(m);
	for(int n=0;n<asize;n++) {
		 String assetelement=assetclass.get(n).getText();
		 if(setoptions.equalsIgnoreCase(assetelement)){
		 asset_class.selectByVisibleText(setoptions);
		 break;
	 }
		 
 }
}
}catch(Exception e) {
	System.out.println("Unable to select the Asset class parameter");
	Utility6.setCellData("please provide proper Investment team options", row, 13); 
}

 	//Document Type
try {
 	Select user_action4=new Select(driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form_prop_ipm_documentType']")));
 	List<WebElement>e2=user_action4.getOptions();
 	int size3=e2.size();
 	for(int l=0;l<size3;l++) {
 		System.out.println(e2.get(l).getText());
 	}
 	String document_type=Utility6.getCellData(sFileName,sSheetName,row, 5);
 	user_action4.selectByVisibleText(document_type);
}catch(Exception e) {
	System.out.println("Unable to select the document type parameter");
	Utility6.setCellData("please provide the proper Asset class parameter", row, 13); 
}

 	//products
try {
 	Select user_action5=new Select(driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form_prop_ipm_fund-entry']")));
 	//List<WebElement>e=user_action5.getOptions();
 	/*int size1=e.size();
 	for(int l=0;l<size1;l++) {
 		System.out.println(e.get(l).getText());
 	}*/
 	String products=Utility6.getCellData(sFileName,sSheetName,row, 6);
 	user_action5.selectByVisibleText(products);
}catch(Exception e) {
	System.out.println("Unable to select the products parameters");
	Utility6.setCellData("please provide the proper prodcut options", row, 13); 
}

 	//Date
try {
 	Select user_action6=new Select(driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form_prop_ipm_asAt']")));
 	String Date=Utility6.getCellData(sFileName,sSheetName,row, 8);
 	user_action6.selectByVisibleText(Date);
}catch(Exception e) {
	System.out.println("Unable to select the Date option");
}

 	//complied for
try {
 	WebElement user_action7= 
 			driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form_prop_ipm_compliedFor-entry']"));
 	Select complied_for=new Select(user_action7);
	
 	List<WebElement>compliedfor=complied_for.getOptions();
 	int csize=compliedfor.size();
 	/*for(int l=0;l<csize;l++) {
 	 	System.out.println(compliedfor.get(l).getText());
 	 	}*/
 	String Cvalues=Utility6.getCellData(sFileName,sSheetName,row, 9);
 	List<String>coptions=new ArrayList<String>(Arrays.asList(Cvalues.split(",")));
 	int c1options=coptions.size();
	for(int j=0;j<c1options;j++) {
		String comoptions=coptions.get(j);
		for(int a=0;a<csize;a++) {
	 String comelement=compliedfor.get(a).getText();
	 if(comoptions.equalsIgnoreCase(comelement)){
		 complied_for.selectByVisibleText(comoptions);
	 break;
	 }
	 
			}
	}
	
}catch(Exception e) {
	System.out.println("unable to select the complied for parameters");
	Utility6.setCellData("please provide the complied for options", row, 13); 
}
	//Audience
try {
	Select user_action8=new Select (driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form_prop_ipm_audience']")));

	user_action8.selectByVisibleText(Utility6.getCellData(sFileName,sSheetName,row, 10));
}catch(Exception e) {
	System.out.println("Unable to select the Audience parameter");
}
	//Language
try {
	Select user_action9=new Select(driver.findElement(By.xpath("//select[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form_prop_ipm_language']")));

	user_action9.selectByVisibleText(Utility6.getCellData(sFileName,sSheetName,row, 11));
	
}catch(Exception e) {
	System.out.println("unable to select the language options");
}
	//click on ok button finally
	try {
		
	driver.findElement(By.xpath("//*[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_uploader-plus-metadata-form-form-submit-button']")).click();
	Utility6.setExcelFile("\\\\crate\\share\\IGNA\\IS\\AlfrescoUpload2\\Alfresco_Upload_Files1.xlsx", "Sheet1");
	 Utility6.setCellData("File Uploaded Successfully", row, 13); 
	 System.out.println(+row + "File upload completed");
	 driver.quit();
	Thread.sleep(2000);
	}catch(Exception e) {
		System.out.println("unable to click on ok button");
	}
}
		else{
			Utility6.setExcelFile("\\\\crate\\share\\IGNA\\IS\\AlfrescoUpload2\\Alfresco_Upload_Files1.xlsx", "Sheet1");
			Utility6.setCellData("File Uploading Skipped", row, 13); 
			}}}}
		}