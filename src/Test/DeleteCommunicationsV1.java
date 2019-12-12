package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import Lib.Utility4;

public class DeleteCommunicationsV1 {
   static String sFileName ="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\DeleteCommunicationsV1-Copy.xlsx" ;
   static String sSheetName ="Sheet1";
	public static void main(String[] args) throws Exception {
		// launching the browser
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ammanrr.CORP\\eclipse-workspace\\Error\\chromedriver.exe");}
		catch(Exception e){
			System.out.println("unable to find the chrome driver");
		}

	WebDriver driver = new ChromeDriver();
		// maximizing the browser
	driver.manage().window().maximize();

		// searching for user data file
	try {
		Utility4.setExcelFile("C://Users//ammanrr.CORP//eclipse-workspace//DeleteCommunicationsV1-Copy.xlsx", "Sheet1");
		} 
	catch (Exception e) {
		System.out.println("Given Updated user input file is not availble in specified location");
		}
		// Entering the user data from excel file
	try {
		//driver.get("http://ushoucwsys01vt/logon");

		driver.get(Utility4.getCellData(sFileName,sSheetName,1, 8));

		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(Utility4.getCellData(sFileName,sSheetName,1, 9));

		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Utility4.getCellData(sFileName,sSheetName,1, 10));

		driver.findElement(By.className("userAction")).sendKeys(Keys.ENTER);
		} catch (Exception e) {
		System.out.println("User is unable to login into aplication");
		}
		
		
		//get the rows of the excel sheet
		// after login mouse overing the views option
		// Thread.sleep(2000);
		{
		String sSheet1 = "Sheet1";
		int totalNoOfRows = Utility4.rowcount(sSheet1);
		
		for (int row = 1; row <= totalNoOfRows; row++) 
		{
			
		System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
		System.out.println("Main SHee Name "+sSheet1);
			WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));

			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();

		// this will fetch the all projects
			List<WebElement> links = driver.findElements(By.xpath("//*[@id='NavMenu']/ul[@class='jd_menu']/li[2]/ul[@class='jdm_events']/li/a"));

		// this will give total project
			System.out.println("Total projects are" + links.size());

		// this is will print the projects in order
			for (int i = 0; i < links.size(); i++) {

				WebElement element1 = links.get(i);
				String text = element1.getAttribute("innerHTML");

			// String text=element1.getText();

				System.out.println("View is:" + text);
				System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
				if (text.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 0))) {
				 
					element1.click();

					String s1 = "//a[text()='";
					String s2 = "']//following-sibling::ul//a[text()='";
					String s3 = "']";

					String s4 = Utility4.getCellData(sFileName,sSheetName,row, 1);
					String s5 = Utility4.getCellData(sFileName,sSheetName,row, 2);

					WebElement subview = driver.findElement(By.xpath(s1 + s4 + s2 + s5 + s3));
					subview.click();

				// This is navigate to investment center which is mentioned in the excel
					List<WebElement> links2 = driver.findElements(By.xpath(
						"//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));

					System.out.println("Projects are" + links2.size());

					for (int j = 0; j < links2.size(); j++) {

						WebElement element2 = links2.get(j);
						String text2 = element2.getAttribute("innerHTML");

						System.out.println("Project name is:" + text2);
					// given in excel sheet to navigate to Active date or historical dates
						if (text2.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 3))) {

							element2.click();
							break;
						}
					}
					break;
				}
			}
				WebElement element4;
						
				try {
							//Display name individually--edit 1
						element4=driver.findElement(By.xpath("//*[@id='Row_GroupingForm_1']"));
							
						if(element4!=null) {
					
							List<WebElement> links7 = driver.findElements(By.xpath(
										"//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]"));
								
							System.out.println("Total display dates"+ links7.size());
								
							for (int k = 0; k < links7.size(); k++) {

									
							WebElement element7 = links7.get(k);
									
							String text7 = element7.getAttribute("innerHTML");

									
							System.out.println("Display name is:" + text7);

							try{// given in excel sheet to navigate to Active date or historical dates
									
								if (text7.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 4))) {
								//driver.findElement(By.xpath("//*[@value='View Details']")).click();
									element7.click();
									WebElement element11;
									element11=driver.findElement(By.xpath("//*[@value='View Details']"));
									if(element11!=null) {
										element11.click();
									}	
									else 
									{
									element11=null;
									}
									}}
							catch(Exception e4) {
										
								if (text7.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 5))) {
									
									element4.click();
																							
									break;
									}
								}
									
									
							}
							Thread.sleep(2000);
							//Effective dates
							
						try {
							WebElement elementdate;
							elementdate=driver.findElement(By.xpath("//*[@id='EffectiveDate']/span[2]"));
							if(elementdate!=null){
							
									//driver.findElement(By.xpath("//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]")).click();
									
								List<WebElement> links3 = driver.findElements(By.xpath(
											"//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]"));
								System.out.println("Total effective dates are" + links3.size());

								for (int k = 0; k < links3.size(); k++) {

										
								WebElement element3 = links3.get(k);
								String text3 = element3.getAttribute("innerHTML");

								System.out.println("Effective date is:" + text3);

										
										// given in excel sheet to navigate to Active date or historical dates
								if (text3.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 5))) {
									element3.click();
									break;
									}

								}
						System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 6));
							
						String str = Utility4.getCellData(sFileName,sSheetName,row, 6);
							
						System.out.println("account sheetname"+str);
							
						int totalNoOfRows1 = Utility4.rowcount(str);
							
							for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
									
							 {
							try {
							Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
							Act_Search.selectByVisibleText("Acct #");
							} catch (Exception e) {
							System.out.println("Act_Search element not found");
							}
							try {
							Select Condition_Search = new Select(
										driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
							Condition_Search.selectByVisibleText("equals");
							} catch (Exception e) {
							System.out.println("Condition_Search element not found");
							}
							try {
							WebElement act1 = driver.findElement(By.xpath("//input[@id='filter_Text_value']"));

							act1.clear();
							act1.sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));
							} catch (Exception e) {
							System.out.println("Unable to enter data");
							}
							// second filter
							try {
							WebElement e5 = driver.findElement(By.xpath("//input[@value='Add Condition']"));
							e5.click();
							} catch (Exception e) {
							System.out.println("unable to click the add condition button");
							}
							try {
							Select Note_search = new Select(
									driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
							Note_search.selectByVisibleText("And");
							} catch (Exception e) {
							System.out.println("And/OR option is not available");
							}
							try {
							Select operator2 = new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
							operator2.selectByVisibleText("Notes");
							} catch (Exception e) {
							System.out.println("Notes option is not available");
							}
							try {
							Select operator3 = new Select(
									driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
							operator3.selectByVisibleText("contains");
							} catch (Exception e) {
							System.out.println("Contains search option is not able to select");
							}
							try {
							WebElement e4 = driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
							e4.clear();
							e4.sendKeys(Utility4.getCellData(sFileName,str,Arow, 1));
							} catch (Exception e) {
							System.out.println("unable to enter data from excel on to notes text box");
							}
							try {
							driver.findElement(By.xpath("//input[@value='Go']")).click();
							} catch (Exception e) {
							System.out.println("unable to click Go  button");
							}
							try {
							WebElement select1 = driver.findElement(By.xpath("//select[@id='UserAction']"));
							if (select1 != null) {
								Select values = new Select(select1);
								List<WebElement> options = values.getOptions();
								int isize = options.size();
								for (int s = 0; s < isize; s++) {
									String sValue = options.get(s).getText();
									System.out.println(sValue);

									if (sValue.equalsIgnoreCase("Delete")) {
										values.selectByVisibleText(sValue);
										driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='No']")).click();
										System.out.println("act# got deleted succesfully "+Utility4.getCellData(sFileName,str,Arow, 0));
										driver.findElement(By.xpath("//input[@value='Reset']")).click();
												
										break;
										}

									}
								}
							}catch(Exception e) {
							System.out.println("act# not present");
							}
								 
							} WebElement element5;
							try {
							element5=driver.findElement(By.xpath("//*[@id='Summary1']"));
							element5.click();
							driver.findElement(By.xpath("//*[@id='branding']/a/img")).click();
							Thread.sleep(2000);
							}catch(Exception e) {
							element5=null;
						}
															 
				}else{
						
				WebElement element7=driver.findElement(By.xpath("//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));
				element7.click();

				String str = Utility4.getCellData(sFileName,sSheetName,row, 6);
						
				System.out.println("account sheetname"+str);
						
				int totalNoOfRows1 = Utility4.rowcount(str);
						
					for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
								
					 {
							try {
							Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
							Act_Search.selectByVisibleText("Acct #");
							} catch (Exception e) {
								System.out.println("Act_Search element not found");
							}
							try {
								Select Condition_Search = new Select(
								driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
								Condition_Search.selectByVisibleText("equals");
								} catch (Exception e) {
							System.out.println("Condition_Search element not found");
							}
							try {
							WebElement act1 = driver.findElement(By.xpath("//input[@id='filter_Text_value']"));

							act1.clear();
							act1.sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));
							} catch (Exception e) {
							System.out.println("Unable to enter data");
							}
						// second filter
							try {
							WebElement e5 = driver.findElement(By.xpath("//input[@value='Add Condition']"));
							e5.click();
							} catch (Exception e) {
							System.out.println("unable to click the add condition button");
							}
							try {
							Select Note_search = new Select(
									driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
							Note_search.selectByVisibleText("And");
							} catch (Exception e) {
							System.out.println("And/OR option is not available");
							}
							try {
							Select operator2 = new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
							operator2.selectByVisibleText("Notes");
							} catch (Exception e) {
							System.out.println("Notes option is not available");
							}
							try {
							Select operator3 = new Select(
									driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
							operator3.selectByVisibleText("contains");
							} catch (Exception e) {
							System.out.println("Contains search option is not able to select");
							}
							try {
							WebElement e4 = driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
							e4.clear();
							e4.sendKeys(Utility4.getCellData(sFileName,str,Arow, 1));
							} catch (Exception e) {
							System.out.println("unable to enter data from excel on to notes text box");
							}
							try {
							driver.findElement(By.xpath("//input[@value='Go']")).click();
							} catch (Exception e) {
							System.out.println("unable to click Go  button");
							}
						try {
							WebElement select1 = driver.findElement(By.xpath("//select[@id='UserAction']"));
							if (select1 != null) {
								Select values = new Select(select1);
								List<WebElement> options = values.getOptions();
								int isize = options.size();
								for (int s = 0; s < isize; s++) {
									String sValue = options.get(s).getText();
									System.out.println(sValue);

									if (sValue.equalsIgnoreCase("Delete")) {
										values.selectByVisibleText(sValue);
										driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='No']")).click();
										System.out.println("act# got deleted succesfully "+Utility4.getCellData(sFileName,str,Arow, 0));
										driver.findElement(By.xpath("//input[@value='Reset']")).click();
											
										break;
										}

									}
								}
							}catch(Exception e) {
							System.out.println("act# not present");
							driver.findElement(By.xpath("//input[@value='Reset']")).click();
							}
							 
						 }
						
					}
							
						}
						catch(Exception e1) {
							//WebElement element7=driver.findElement(By.xpath("//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));
							//element7.click();

						String str = Utility4.getCellData(sFileName,sSheetName,row, 6);
							
						System.out.println("account sheetname"+str);
							
						int totalNoOfRows1 = Utility4.rowcount(str);
							
							for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
									
							{
								try {
								Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
								Act_Search.selectByVisibleText("Acct #");
								} catch (Exception e) {
								System.out.println("Act_Search element not found");
								}
								try {
								Select Condition_Search = new Select(
										driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
								Condition_Search.selectByVisibleText("equals");
								} catch (Exception e) {
								System.out.println("Condition_Search element not found");
								}
								try {
								WebElement act1 = driver.findElement(By.xpath("//input[@id='filter_Text_value']"));

								act1.clear();
								act1.sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));
								} catch (Exception e) {
								System.out.println("Unable to enter data");
								}
							// second filter
								try {
								WebElement e5 = driver.findElement(By.xpath("//input[@value='Add Condition']"));
								e5.click();
								} catch (Exception e) {
								System.out.println("unable to click the add condition button");
								}
								try {
								Select Note_search = new Select(
										driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
									Note_search.selectByVisibleText("And");
								} catch (Exception e) {
								System.out.println("And/OR option is not available");
								}
								try {
								Select operator2 = new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
								operator2.selectByVisibleText("Notes");
								} catch (Exception e) {
								System.out.println("Notes option is not available");
								}
								try {
								Select operator3 = new Select(
										driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
								operator3.selectByVisibleText("contains");
								} catch (Exception e) {
								System.out.println("Contains search option is not able to select");
								}
								try {
								WebElement e4 = driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
								e4.clear();
								e4.sendKeys(Utility4.getCellData(sFileName,str,Arow, 1));
								} catch (Exception e) {
								System.out.println("unable to enter data from excel on to notes text box");
								}
								try {
								driver.findElement(By.xpath("//input[@value='Go']")).click();
								} catch (Exception e) {
								System.out.println("unable to click Go  button");
								}
							try {
								WebElement select1 = driver.findElement(By.xpath("//select[@id='UserAction']"));
								if (select1 != null) {
									Select values = new Select(select1);
									List<WebElement> options = values.getOptions();
									int isize = options.size();
									for (int s = 0; s < isize; s++) {
										String sValue = options.get(s).getText();
										System.out.println(sValue);

										if (sValue.equalsIgnoreCase("Delete")) {
											values.selectByVisibleText(sValue);
											driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='No']")).click();
											System.out.println("act# got deleted succesfully "+Utility4.getCellData(sFileName,str,Arow, 0));
											driver.findElement(By.xpath("//input[@value='Reset']")).click();
												
											break;
											}

										}
									}
								}catch(Exception e) {
								System.out.println("act# not present");
								driver.findElement(By.xpath("//input[@value='Reset']")).click();
								}
								 
							 }
							
						}
					}
						
					}
			catch(Exception e) {
					List<WebElement> links3 = driver.findElements(By.xpath(
								"//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]"));
					System.out.println("Total effective dates are" + links3.size());

					for (int k = 0; k < links3.size(); k++) {

						WebElement element3 = links3.get(k);
						String text3 = element3.getAttribute("innerHTML");

						System.out.println("Effective date is:" + text3);

							
							// given in excel sheet to navigate to Active date or historical dates
						if (text3.equalsIgnoreCase(Utility4.getCellData(sFileName, sSheet1, row, 5))) {
							element3.click();
							break;
							}

						}
					String str = Utility4.getCellData(sFileName,sSheetName,row, 6);
						
					System.out.println("account sheetname"+str);
						
					int totalNoOfRows1 = Utility4.rowcount(str);
						
						for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
								
						{
							try {
							Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
							Act_Search.selectByVisibleText("Acct #");
							} catch (Exception e2) {
							System.out.println("Act_Search element not found");
							}
							try {
							Select Condition_Search = new Select(
									driver.findElement(By.xpath("//select[@id='filter_Text_operator']")));
							Condition_Search.selectByVisibleText("equals");
							} catch (Exception e3) {
							System.out.println("Condition_Search element not found");
							}
							try {
							WebElement act1 = driver.findElement(By.xpath("//input[@id='filter_Text_value']"));

							act1.clear();
							act1.sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));
							} catch (Exception e4) {
							System.out.println("Unable to enter data");
							}
						// second filter
							try {
							WebElement e5 = driver.findElement(By.xpath("//input[@value='Add Condition']"));
							e5.click();
							} catch (Exception e5) {
							System.out.println("unable to click the add condition button");
							}
							try {
							Select Note_search = new Select(
									driver.findElement(By.xpath("//select[@id='multifilter_operator2']")));
							Note_search.selectByVisibleText("And");
							} catch (Exception e6) {
							System.out.println("And/OR option is not available");
							}
							try {
							Select operator2 = new Select(driver.findElement(By.xpath("//select[@id='filter_column2']")));
							operator2.selectByVisibleText("Notes");
							} catch (Exception e7) {
							System.out.println("Notes option is not available");
							}
							try {
							Select operator3 = new Select(
									driver.findElement(By.xpath("//select[@id='filter_Text_operator2']")));
							operator3.selectByVisibleText("contains");
							} catch (Exception e8) {
							System.out.println("Contains search option is not able to select");
							}
							try {
							WebElement e4 = driver.findElement(By.xpath("//input[@id='filter_Text_value2']"));
							e4.clear();
							e4.sendKeys(Utility4.getCellData(sFileName,str,Arow, 1));
							} catch (Exception e9) {
							System.out.println("unable to enter data from excel on to notes text box");
							}
							try {
							driver.findElement(By.xpath("//input[@value='Go']")).click();
							} catch (Exception e10) {
							System.out.println("unable to click Go  button");
							}
							try {
							WebElement select1 = driver.findElement(By.xpath("//select[@id='UserAction']"));
							if (select1 != null) {
								Select values = new Select(select1);
								List<WebElement> options = values.getOptions();
								int isize = options.size();
								for (int s = 0; s < isize; s++) {
									String sValue = options.get(s).getText();
									System.out.println(sValue);

									if (sValue.equalsIgnoreCase("Delete")) {
										values.selectByVisibleText(sValue);
										driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='No']")).click();
										System.out.println("act# got deleted succesfully "+Utility4.getCellData(sFileName,str,Arow, 0));
										driver.findElement(By.xpath("//input[@value='Reset']")).click();
											
										break;
									}

								}
							}
						}catch(Exception e11) {
							System.out.println("act# not present");
							driver.findElement(By.xpath("//input[@value='Reset']")).click();
						}
							 
						}
						
				}WebElement element5;
					try {
					element5=driver.findElement(By.xpath("//*[@id='Summary1']"));
					element5.click();
					driver.findElement(By.xpath("//*[@id='branding']/a/img")).click();
					Thread.sleep(2000);
				}catch(Exception e) {
					element5=null;
				}
						
				}
			
					//break;
				}
						
									
			
			}}