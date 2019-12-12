package Test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Lib.Utility4;

public class ViaDesProgram {
  static String sFileName ="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\DeleteCommunicationsV1-Copy.xlsx" ;
  static String sSheetName ="Sheet1";
  static String Type;
  public static void main(String[] args) throws Exception {
	  // launching the browser
	  try {
		  System.setProperty("webdriver.chrome.driver", "C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
	  } 
	  catch (Exception e)
	  {
		  System.out.println("unable to find the chrome driver");
				}
	  
	 WebDriver driver = new ChromeDriver();
	 // maximizing the browser
	 driver.manage().window().maximize();
	 
	 // searching for user data file
	 try {
		 Utility4.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\DeleteCommunicationsV1-Copy.xlsx", "Sheet1");
	 } 
	 catch (Exception e) {
		 System.out.println("Given Updated user input file is not availble in specified location");
	 }
	 // Entering the user data from excel file
	 try {
		 driver.get(Utility4.getCellData(sFileName,sSheetName,1, 10));

		 driver.findElement(By.xpath("//*[@id='userid']")).sendKeys(Utility4.getCellData(sFileName,sSheetName,1, 11));
		 
		 driver.findElement(By.xpath("//*[@id='password']")).sendKeys(Utility4.getCellData(sFileName,sSheetName,1, 12));

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

			 String Runmode= Utility4.getCellData(sFileName,sSheetName,row, 8);
			
			 if(Runmode.equals("Yes")) {
				 String Type=Utility4.getCellData(sFileName,sSheetName,row, 7);
				
				 if(Type.equals("Type1")) {
			
					 System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
					 System.out.println("Main SHee Name "+sSheet1);
					 //WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
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
						//Act_Search.selectByVisibleText("Acct #");
						Act_Search.selectByValue("AccountNumber");
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
						Actions action1=new Actions(driver);
						WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[3]//img"));
						//action1.contextClick(save).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						action1.contextClick(save).build().perform();;
						Robot robot=new Robot();
						robot.delay(3000);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(3000);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(3000);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(3000);
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(3000);
						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(5000);
						//	provide the custom folder path
						String textF = Utility4.getCellData(sFileName,str,0, 3);
						StringSelection stringSelection = new StringSelection(textF);
						Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboard.setContents(stringSelection, stringSelection);
						
						//provide the custom file name
						String textb = Utility4.getCellData(sFileName,str,Arow, 2);
						String strs="\\";
						
						String Fname=textF+strs+textb;
						StringSelection stringSelectionb = new StringSelection(Fname);
						Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
						clipboardb.setContents(stringSelectionb, stringSelectionb);
						robot.keyPress(KeyEvent.VK_CONTROL);
						Thread.sleep(3000);
						robot.keyPress(KeyEvent.VK_V);
						Thread.sleep(3000);
						robot.keyRelease(KeyEvent.VK_V);
						Thread.sleep(3000);
						robot.keyRelease(KeyEvent.VK_CONTROL);
						Thread.sleep(3000);
						robot.keyPress(KeyEvent.VK_ENTER);
						//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
						Thread.sleep(5000);
						//WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
						//e6.click();
					}catch(Exception e) {
						System.out.println("Runing the program no problem");
					}
					
					Thread.sleep(2000);
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
										driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
										System.out.println("act# got deleted succesfully "+Utility4.getCellData(sFileName,str,Arow, 0));
										driver.findElement(By.xpath("//input[@value='Reset']")).click();
												
										break;
										}

									}
								}
							}catch(Exception e) {
							System.out.println("act# not present");
							WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
							e6.click();
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
							//Act_Search.selectByVisibleText("Acct #");
							Act_Search.selectByValue("AccountNumber");
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
							Actions action1=new Actions(driver);
							WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[3]//img"));
						
							//action1.contextClick(save).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
						
							action1.contextClick(save).build().perform();;
							
							
							Robot robot=new Robot();
							robot.delay(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							Thread.sleep(5000);
							//provide the custom folder path
							String textF = Utility4.getCellData(sFileName,str,0, 2);
							StringSelection stringSelection = new StringSelection(textF);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(stringSelection, stringSelection);
							
							//provide the custom file name
							String textb = Utility4.getCellData(sFileName,str,Arow, 1);
							String strs="\\";
							
							String Fname=textF+strs+textb;
							StringSelection stringSelectionb = new StringSelection(Fname);
							Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboardb.setContents(stringSelectionb, stringSelectionb);
							robot.keyPress(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
									//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
							//Thread.sleep(5000);
							Thread.sleep(5000);}catch(Exception e) {
								System.out.println("Running the program no problem");
							}
							
WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
				            
				            e6.click();
				            Thread.sleep(2000);
							
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
										driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
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
								//Act_Search.selectByVisibleText("Acct #");
								Act_Search.selectByValue("AccountNumber");
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
								Actions action1=new Actions(driver);
								WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[3]//img"));
							
							
								action1.contextClick(save).build().perform();;
								
								
								Robot robot=new Robot();
								robot.delay(3000);
								robot.keyPress(KeyEvent.VK_DOWN);
								Thread.sleep(3000);
								robot.keyPress(KeyEvent.VK_DOWN);
								Thread.sleep(3000);
								robot.keyPress(KeyEvent.VK_DOWN);
								Thread.sleep(3000);
								robot.keyPress(KeyEvent.VK_DOWN);
								Thread.sleep(3000);
								robot.keyPress(KeyEvent.VK_ENTER);
								Thread.sleep(5000);
								//provide the custom folder path
								String textF = Utility4.getCellData(sFileName,str,0, 2);
								StringSelection stringSelection = new StringSelection(textF);
								Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
								clipboard.setContents(stringSelection, stringSelection);
								
								//provide the custom file name
								String textb = Utility4.getCellData(sFileName,str,Arow, 1);
								String strs="\\";
								
								String Fname=textF+strs+textb;
								StringSelection stringSelectionb = new StringSelection(Fname);
								Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
								clipboardb.setContents(stringSelectionb, stringSelectionb);
								robot.keyPress(KeyEvent.VK_CONTROL);
								Thread.sleep(3000);
								robot.keyPress(KeyEvent.VK_V);
								Thread.sleep(3000);
								robot.keyRelease(KeyEvent.VK_V);
								Thread.sleep(3000);
								robot.keyRelease(KeyEvent.VK_CONTROL);
								Thread.sleep(3000);
								robot.keyPress(KeyEvent.VK_ENTER);
										//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
								//Thread.sleep(5000);
								Thread.sleep(5000);}catch(Exception e) {
									System.out.println("Running the program no problem");
								}
								
								WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
					            
					            e6.click();
					            Thread.sleep(2000);
								
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
											driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
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
							//Act_Search.selectByVisibleText("Acct #");
							Act_Search.selectByValue("AccountNumber");
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
							Actions action1=new Actions(driver);
							WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[3]//img"));
						
						
							action1.contextClick(save).build().perform();
							
							
							Robot robot=new Robot();
							robot.delay(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							Thread.sleep(5000);
							//provide the custom folder path
							String textF = Utility4.getCellData(sFileName,str,0, 2);
							StringSelection stringSelection = new StringSelection(textF);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(stringSelection, stringSelection);
						
							//provide the custom file name
							String textb = Utility4.getCellData(sFileName,str,Arow, 1);
							String strs="\\";
							
							String Fname=textF+strs+textb;
							StringSelection stringSelectionb = new StringSelection(Fname);
							Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboardb.setContents(stringSelectionb, stringSelectionb);
							robot.keyPress(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
									//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
							//Thread.sleep(5000);
							Thread.sleep(5000);}catch(Exception e1) {
								System.out.println("running the program no problem");
							}
							
							WebElement e6=driver.findElement(By.xpath("//input[@value='Reset']"));
				            
				            e6.click();
				            Thread.sleep(2000);
							
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
										driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
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
else if(Type.equals("Type2")) {
	System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
	System.out.println("Main SHee Name "+sSheet1);
	//WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
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
							//Act_Search.selectByVisibleText("Account Number");
							Act_Search.selectByValue("AccountNumber");
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
						
						try {
							driver.findElement(By.xpath("//input[@value='Go']")).click();
						} catch (Exception e) {
							System.out.println("unable to click Go  button");
						}
						try {
							Actions action1=new Actions(driver);
							WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[3]//img"));
										
							//action1.contextClick(save).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
										
							action1.contextClick(save).build().perform();;
											
							//Thread.sleep(5000);
										
							Robot robot=new Robot();
							robot.delay(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							Thread.sleep(5000);
							//provide the custom folder path
							String textF = Utility4.getCellData(sFileName,str,0, 2);
							StringSelection stringSelection = new StringSelection(textF);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(stringSelection, stringSelection);
							
							//provide the custom file name
							String textb = Utility4.getCellData(sFileName,str,Arow, 1);
							String strs="\\";
							
							String Fname=textF+strs+textb;
							StringSelection stringSelectionb = new StringSelection(Fname);
							Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboardb.setContents(stringSelectionb, stringSelectionb);
							robot.keyPress(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
							Thread.sleep(5000);
						}catch(Exception e) {
							System.out.println("Runing the program no problem");
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
													driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
													System.out.println("act# got deleted succesfully "+Utility4.getCellData(sFileName,str,Arow, 0));
													driver.findElement(By.xpath("//input[@value='Reset']")).click();
																
													break;
													}
													}
												}
											}catch(Exception e) {
											System.out.println("act# not present");
											}
									
					}WebElement element5;
					try {
						element5=driver.findElement(By.xpath("//*[@id='Summary1']"));
						element5.click();
						driver.findElement(By.xpath("//*[@id='branding']/a/img")).click();
						Thread.sleep(2000);
						break;
					}catch(Exception e) {
						element5=null;
					}
									
				}}catch(Exception e) {System.out.println("error2");}
								
							/*---*/
		}
					
				}
			
					
			}	
	 	

else if(Type.equals("Type6")) {
	System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
	System.out.println("Main SHee Name "+sSheet1);
	//WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
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
					
					List<WebElement> links6 = driver.findElements(By.xpath(
							"//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]"));
					System.out.println("Total effective dates are" + links6.size());

					for (int k = 0; k < links6.size(); k++) {

						WebElement element3 = links6.get(k);
						String text3 = element3.getAttribute("innerHTML");

						System.out.println("Worflow Type is:" + text3);

												
												// given in excel sheet to navigate to Active date or historical dates
						if (text3.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 3))) {
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
							//Act_Search.selectByVisibleText("Account Number");
							Act_Search.selectByValue("PortfolioID");
						} catch (Exception e) {
							System.out.println("PortfolioID element not found");
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
							operator2.selectByVisibleText("Version");
						} catch (Exception e) {
							System.out.println("Version option is not available");
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
							Actions action1=new Actions(driver);
							WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[3]//img"));
										
							//action1.contextClick(save).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
										
							action1.contextClick(save).build().perform();;
											
							//Thread.sleep(5000);
										
							Robot robot=new Robot();
							robot.delay(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							Thread.sleep(5000);
							//provide the custom folder path
							String textF = Utility4.getCellData(sFileName,str,0, 3);
							StringSelection stringSelection = new StringSelection(textF);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(stringSelection, stringSelection);
							
							//provide the custom file name
							String textb = Utility4.getCellData(sFileName,str,Arow, 2);
							String strs="\\";
							
							String Fname=textF+strs+textb;
							StringSelection stringSelectionb = new StringSelection(Fname);
							Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboardb.setContents(stringSelectionb, stringSelectionb);
							robot.keyPress(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
							Thread.sleep(5000);
						}catch(Exception e) {
							System.out.println("Runing the program no problem");
						}
										
									
						driver.findElement(By.xpath("//input[@value='Reset']")).click();}
					int totalNoOfRows2 = Utility4.rowcount(str);
					
for(int Arow=0;Arow<=totalNoOfRows2;Arow++)
							
{
try {
	Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
	//Act_Search.selectByVisibleText("Account Number");
	Act_Search.selectByValue("PortfolioID");
} catch (Exception e) {
	System.out.println("PortfolioID element not found");
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
	operator2.selectByVisibleText("Version");
} catch (Exception e) {
	System.out.println("Version option is not available");
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
							driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
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
					
					
					WebElement element5;
					try {
						element5=driver.findElement(By.xpath("//*[@id='Summary1']"));
						element5.click();
						driver.findElement(By.xpath("//*[@id='branding']/a/img")).click();
						Thread.sleep(2000);
						break;
					}catch(Exception e) {
						element5=null;
					}
									
				}}catch(Exception e) {System.out.println("error2");}
								
							/*---*/
		}
					
				}
			
					
			}	
else if(Type.equals("Type5")) {
	System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
	System.out.println("Main SHee Name "+sSheet1);
	//WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
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
								
			try {
				WebElement elementdate;
				elementdate=driver.findElement(By.xpath("//*[@id='EffectiveDate']"));
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
									
					List<WebElement> links2 = driver.findElements(By.xpath(
							"//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));

					System.out.println("Projects are" + links2.size());

					for (int j = 0; j < links2.size(); j++) {

						WebElement element2 = links2.get(j);
						String text2 = element2.getAttribute("innerHTML");

						System.out.println("Project name is:" + text2);
						// given in excel sheet to navigate to Active date or historical dates
						if (text2.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 4))) {

							element2.click();
							break;
							}
						}
					List<WebElement> links4 = driver.findElements(By.xpath(
							"//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));

					System.out.println("Projects are" + links4.size());

					for (int j = 0; j < links4.size(); j++) {

						WebElement element5 = links4.get(j);
						String text2 = element5.getAttribute("innerHTML");

						System.out.println("Project name is:" + text2);
						// given in excel sheet to navigate to Active date or historical dates
						if (text2.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 3))) {

							element5.click();
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
							//Act_Search.selectByVisibleText("Account Number");
							Act_Search.selectByValue("AccountNumber");
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
						
						try {
							driver.findElement(By.xpath("//input[@value='Go']")).click();
						} catch (Exception e) {
							System.out.println("unable to click Go  button");
						}
						try {
							Actions action1=new Actions(driver);
							WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[4]//img"));
										
							//action1.contextClick(save).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
										
							action1.contextClick(save).build().perform();;
											
							//Thread.sleep(5000);
										
							Robot robot=new Robot();
							robot.delay(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							Thread.sleep(5000);
							//provide the custom folder path
							String textF = Utility4.getCellData(sFileName,str,0, 2);
							StringSelection stringSelection = new StringSelection(textF);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(stringSelection, stringSelection);
							
							//provide the custom file name
							String textb = Utility4.getCellData(sFileName,str,Arow, 1);
							String strs="\\";
							
							String Fname=textF+strs+textb;
							StringSelection stringSelectionb = new StringSelection(Fname);
							Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboardb.setContents(stringSelectionb, stringSelectionb);
							robot.keyPress(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
							Thread.sleep(5000);
						}catch(Exception e) {
							System.out.println("Runing the program no problem");
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
													driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
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
									
					}WebElement element5;
					try {
						element5=driver.findElement(By.xpath("//*[@id='Summary1']"));
						element5.click();
						driver.findElement(By.xpath("//*[@id='branding']/a/img")).click();
						Thread.sleep(2000);
						break;
					}catch(Exception e) {
						element5=null;
					}
									
				}}catch(Exception e) {System.out.println("error2");}
								
							/*---*/
		}
					
				}
			
					
			}
	 	
else if(Type.equals("Type7")) {
	System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
	System.out.println("Main SHee Name "+sSheet1);
	//WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
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
								
								
					//driver.findElement(By.xpath("//div[@id='taskListTarget']//table[@id='tasklistTable']/tbody//tr[@mouseoverclass='highlightTaskListRow']/td[1]")).click();
					
					System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 6));
										
					String str = Utility4.getCellData(sFileName,sSheetName,row, 6);
											
					System.out.println("account sheetname"+str);
											
					int totalNoOfRows1 = Utility4.rowcount(str);
											
					for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
													
					{
						try {
							Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
							//Act_Search.selectByVisibleText("Account Number");
							Act_Search.selectByValue("EffectiveDate");
						} catch (Exception e) {
							System.out.println("Effective Date element not found");
						}
						try {
							Select Condition_Search = new Select(
									driver.findElement(By.xpath("//select[@id='filter_date_operator']")));
							Condition_Search.selectByVisibleText("equals");
						} catch (Exception e) {
							System.out.println("Condition_Search element not found");
						}
						try {
							
							Select act1=new Select(driver.findElement(By.xpath("//select[@id='filter_date_suboperator']")));
							act1.selectByValue("SpecifyDate");
							//act1.sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));
						} catch (Exception e) {
							System.out.println("Unable to enter data");
									}
								//handling date-month -year calender module			
						try {
						Select act2=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
						String month=Utility4.getCellData(sFileName,str,0, 1);
						act2.selectByValue(month);
						
						
						Select act3=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
						String year=Utility4.getCellData(sFileName,str,0, 2);
						act3.selectByValue(year);
						
						//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[6]/td[2]")).click();
						
						List<WebElement> days= driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td[@class]/a"));
						
						System.out.println(days.size());
						for (int l = 0; l < days.size(); l++) {
							WebElement day = days.get(l);
							String dayy = day.getText();
							String selectday=Utility4.getCellData(sFileName,str,0, 3);
							if (dayy.equalsIgnoreCase(selectday)) {
								
								day.click();
						}}
						}catch(Exception e) {
							System.out.println("calender error");
						}
						

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
							operator2.selectByVisibleText("Account Number");
						} catch (Exception e) {
							System.out.println("Version option is not available");
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
							e4.sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));
						} catch (Exception e) {
							System.out.println("unable to enter data from excel on to notes text box");
						}

						try {
							driver.findElement(By.xpath("//input[@value='Go']")).click();
						} catch (Exception e) {
							System.out.println("unable to click Go  button");
						}
						try {
							Actions action1=new Actions(driver);
							WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[4]//img"));
										
							//action1.contextClick(save).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
										
							action1.contextClick(save).build().perform();;
											
							//Thread.sleep(5000);
										
							Robot robot=new Robot();
							robot.delay(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							Thread.sleep(5000);
							//provide the custom folder path
							String textF = Utility4.getCellData(sFileName,str,0, 2);
							StringSelection stringSelection = new StringSelection(textF);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(stringSelection, stringSelection);
							
							//provide the custom file name
							String textb = Utility4.getCellData(sFileName,str,Arow, 1);
							String strs="\\";
							
							String Fname=textF+strs+textb;
							StringSelection stringSelectionb = new StringSelection(Fname);
							Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboardb.setContents(stringSelectionb, stringSelectionb);
							robot.keyPress(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
							Thread.sleep(5000);
						}catch(Exception e) {
							System.out.println("Runing the program no problem");
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
													driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
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
									
					}WebElement element5;
					try {
						element5=driver.findElement(By.xpath("//*[@id='Summary1']"));
						element5.click();
						driver.findElement(By.xpath("//*[@id='branding']/a/img")).click();
						Thread.sleep(2000);
						break;
					}catch(Exception e) {
						element5=null;
					}
									
							/*---*/
		}
					
				}
			
					
			}
else if(Type.equals("Type4")) {
	System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
	System.out.println("Main SHee Name "+sSheet1);
	//WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
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
							
					System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 6));
							
					String str = Utility4.getCellData(sFileName,sSheetName,row, 6);
								
					System.out.println("account sheetname"+str);
								
					int totalNoOfRows1 = Utility4.rowcount(str);
								
					for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
										
					{
						try {
							Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
							//Act_Search.selectByVisibleText("Account Number");
							Act_Search.selectByValue("AccountNumber");
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
								
						try {
							driver.findElement(By.xpath("//input[@value='Go']")).click();
						} catch (Exception e) {
							System.out.println("unable to click Go  button");
						}
						try {
							Actions action1=new Actions(driver);
							WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[4]//img"));
							
								//action1.contextClick(save).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
							
							action1.contextClick(save).build().perform();;
								
								//Thread.sleep(5000);
								
							
							Robot robot=new Robot();
							robot.delay(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_DOWN);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
							Thread.sleep(5000);
							//provide the custom folder path
							String textF = Utility4.getCellData(sFileName,str,0, 2);
							StringSelection stringSelection = new StringSelection(textF);
							Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboard.setContents(stringSelection, stringSelection);
							
							//provide the custom file name
							String textb = Utility4.getCellData(sFileName,str,Arow, 1);
							String strs="\\";
							
							String Fname=textF+strs+textb;
							StringSelection stringSelectionb = new StringSelection(Fname);
							Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
							clipboardb.setContents(stringSelectionb, stringSelectionb);
							robot.keyPress(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_V);
							Thread.sleep(3000);
							robot.keyRelease(KeyEvent.VK_CONTROL);
							Thread.sleep(3000);
							robot.keyPress(KeyEvent.VK_ENTER);
									//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
							Thread.sleep(5000);
						}catch(Exception e) {
							System.out.println("Runing the program no problem");
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
											driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
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
						
								 }WebElement element5;
									try {
										element5=driver.findElement(By.xpath("//*[@id='Summary1']"));
										element5.click();
										driver.findElement(By.xpath("//*[@id='branding']/a/img")).click();
										Thread.sleep(2000);
										break;
										}catch(Exception e) {
										element5=null;
									}
						
						}}catch(Exception e) {System.out.println("error2");}
					
				/*---*/
				}
		
	}

		
}
	else if(Type.equals("Type3")) {
				
			System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 0));
				
			System.out.println("Main SHee Name "+sSheet1);
				
			//WebElement element = driver.findElement(By.xpath("//a[contains(.,'Views»')]"));
				
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
							
					driver.findElement(By.xpath("//*[@id='gutterDiv']//a[contains(.,'Summary by Document')]")).click();
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
						}}
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
						String	 text3 = element3.getAttribute("innerHTML");

							 System.out.println("Effective date is:" + text3);
														
														// given in excel sheet to navigate to Active date or historical dates
							 if (text3.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 5))) {
								 element3.click();
								 break;
							 }}
						List<WebElement> links5 = driver.findElements(By.xpath("//tr[contains(@id,'Row_GroupingForm')]//following-sibling::td//preceding-sibling::td[@class='']"));

						System.out.println("Projects are" + links5.size());

						for (int p = 0; p < links5.size(); p++) {

							WebElement element5 = links5.get(p);
							String text5 = element5.getAttribute("innerHTML");

							System.out.println("Project name is:" + text5);
														// given in excel sheet to navigate to Active date or historical dates
							if (text5.equalsIgnoreCase(Utility4.getCellData(sFileName,sSheetName,row, 4))) {

								element5.click();
								break;
							}}
						System.out.println(Utility4.getCellData(sFileName,sSheetName,row, 6));
															
						String str = Utility4.getCellData(sFileName,sSheetName,row, 6);
																
						System.out.println("account sheetname"+str);
																
						int totalNoOfRows1 = Utility4.rowcount(str);
																
						for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
																		
						{
							try {
								Select Act_Search = new Select(driver.findElement(By.xpath("//select[@id='filter_column']")));
									//Act_Search.selectByVisibleText("Account Number");
								Act_Search.selectByValue("AccountNumber");
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
										
							try {
											driver.findElement(By.xpath("//input[@value='Go']")).click();
										} catch (Exception e) {
											System.out.println("unable to click Go  button");
										}
							try {
									Actions action1=new Actions(driver);
									WebElement save=driver.findElement(By.xpath("//*[@id]//td//a[3]//img"));
											
									//action1.contextClick(save).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
															
									action1.contextClick(save).build().perform();;
																
									//Thread.sleep(5000);
																	
									Robot robot=new Robot();
									robot.delay(3000);
									robot.keyPress(KeyEvent.VK_DOWN);
									Thread.sleep(3000);
									robot.keyPress(KeyEvent.VK_DOWN);
									Thread.sleep(3000);
									robot.keyPress(KeyEvent.VK_DOWN);
									Thread.sleep(3000);
									robot.keyPress(KeyEvent.VK_DOWN);
									Thread.sleep(3000);
									robot.keyPress(KeyEvent.VK_ENTER);
									Thread.sleep(5000);
									//provide the custom folder path
									String textF = Utility4.getCellData(sFileName,str,0, 2);
									StringSelection stringSelection = new StringSelection(textF);
									Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
									clipboard.setContents(stringSelection, stringSelection);
									
									//provide the custom file name
									String textb = Utility4.getCellData(sFileName,str,Arow, 1);
									String strs="\\";
									
									String Fname=textF+strs+textb;
									StringSelection stringSelectionb = new StringSelection(Fname);
									Clipboard clipboardb = Toolkit.getDefaultToolkit().getSystemClipboard();
									clipboardb.setContents(stringSelectionb, stringSelectionb);
									robot.keyPress(KeyEvent.VK_CONTROL);
									Thread.sleep(3000);
									robot.keyPress(KeyEvent.VK_V);
									Thread.sleep(3000);
									robot.keyRelease(KeyEvent.VK_V);
									Thread.sleep(3000);
									robot.keyRelease(KeyEvent.VK_CONTROL);
									Thread.sleep(3000);
									robot.keyPress(KeyEvent.VK_ENTER);
											//	action1.sendKeys(Keys.CONTROL,"v").build().perform();
									Thread.sleep(5000);
								}catch(Exception e) {
									System.out.println("Runing the program no problem");
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
												driver.findElement(By.xpath("//*[@id='RouteWorkflow']/div/input[@value='Yes']")).click();
												System.out.println("act# got deleted succesfully "+Utility4.getCellData(sFileName,str,Arow, 3));
												driver.findElement(By.xpath("//input[@value='Reset']")).click();
												break;
											}
											else if (sValue.equalsIgnoreCase("Cancel")) {
												values.selectByVisibleText(sValue);
												System.out.println("act# got Cancelled succesfully "+Utility4.getCellData(sFileName,str,Arow, 3));
												driver.findElement(By.xpath("//input[@value='Reset']")).click();
												break;
											}
										}
									}
								}catch(Exception e) {
									System.out.println("act# not present");
									driver.findElement(By.xpath("//input[@value='Reset']")).click();
								}
														
							}WebElement element5;
							try {
								element5=driver.findElement(By.xpath("//*[@id='Summary1']"));
								element5.click();
								driver.findElement(By.xpath("//*[@id='branding']/a/img")).click();
								Thread.sleep(2000);
								break;
							}catch(Exception e) {
								element5=null;
									}
								}	
							}catch(Exception e) 
							{
								System.out.println("error3");
							}
						}
					
						}
						}
				
				}
			
			}
				
					}
		
	
	

		{
			
			 String sFileName1 ="C:\\Users\\ammanrr.CORP\\eclipse-workspace\\ViaductDroppinglist.xlsx" ;
			 String sSheetName1 ="Sheet1";
			 String sRunMode1 = null;
			//System.setProperty("webdriver.chrome.driver","C://Users//ammanrr.CORP//Downloads//chromedriver.exe");
			
			
			//WebDriver driver = new ChromeDriver(); 
			//driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//loading the excel file
			try {
			Utility4.setExcelFile(sFileName1, sSheetName1);}
			catch (Exception e){System.out.println("invalid excel file");
			}

			//navigating to Viaduct UAT instance from excel file
			try {
				driver.get(Utility4.getCellData(sFileName1, sSheetName1, 1, 8));
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}

			//login details from excel file
			try {
			driver.findElement(By.name("SWEUserName")).sendKeys(Utility4.getCellData(sFileName1, sSheetName1, 1, 6));
			driver.findElement(By.name("SWEPassword")).sendKeys(Utility4.getCellData(sFileName1, sSheetName1, 1, 7));
			driver.findElement(By.id("s_swepi_22")).click();}catch(Exception e) {System.out.println("login failed");}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}

			//browser refresh
			driver.navigate().refresh();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}

			//click on communication tab
			try {
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-tabindex='tabScreen10']"))).click();;
			}catch(Exception e) {System.out.println("unable to click communication tab");}


			//Getting total project or communications from sheet1 that need to drop
			String sSheet1 = "Sheet1";
			int totalNoOfRows = Utility4.rowcount(sSheet1);
			System.out.println(+totalNoOfRows);
			int row;
			for ( row = 1; row <= totalNoOfRows; row++) 
			{
				//setting and verifying the Run mode
				int count=0;
				try {
					sRunMode1=Utility4.getCellData(sFileName1, sSheetName1, row, 2);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				//checking RunMode status that need to drop

				if(sRunMode1.equals("Yes")) {
			
					//click on query
			try {
				driver.findElement(By.xpath("//*[@id='s_1_1_8_0_Ctrl']")).click();}
				catch(Exception e) {System.out.println("unabble to click the query button");}

			//Entering the communication name from excel file
			String S="*";
			String Cname = null;
			try {
				Cname = Utility4.getCellData(sFileName1, sSheetName1, row, 0);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			//driver.findElement(By.xpath("//table[@id='s_1_l']/tbody/tr[2]/td[2]/input")).sendKeys(Utility4.getCellData(sFileName, sSheetName, row, 0));
			try {
				driver.findElement(By.xpath("//table[@id='s_1_l']/tbody/tr[2]/td[2]/input")).sendKeys(S+Cname+S);}
			catch(Exception e) {System.out.println("unable to enter the communication name");}

			//click on Go button
			driver.findElement(By.xpath("//*[@id='s_1_1_5_0_Ctrl']")).click();

			//click on show active
			//driver.findElement(By.xpath("//*[@id='s_3_1_3_0_Ctrl']")).click();

			//Getting the sheet name
			try {
			System.out.println(Utility4.getCellData(sFileName1,sSheetName1,row, 1));
			String str = Utility4.getCellData(sFileName1,sSheetName1,row, 1);
			System.out.println("account sheetname"+str);
			int totalNoOfRows1 = Utility4.rowcount(str);

			for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
			
			{
				try {
					//click on act query
			driver.findElement(By.xpath("//button[@id='s_2_1_11_0_Ctrl']")).click();}
			catch(Exception e) {System.out.println("quer button is not responding");}

			try{//Enter the account number or communication name from excel file
			
			String S1="*";
			String ActName=Utility4.getCellData(sFileName1,str,Arow, 0);
			
			//driver.findElement(By.xpath("//input[@id='1_Account_Number']")).sendKeys(Utility4.getCellData(sFileName,str,Arow, 0));}
			driver.findElement(By.xpath("//input[@id='1_Account_Number']")).sendKeys(S1+S1+ActName);}
			catch(Exception e) {System.out.println("act number is not able to enter in specified location");}

			try{//click on Go button
			driver.findElement(By.xpath("//*[@id='s_2_1_8_0_Ctrl']")).click();}
			catch(Exception e) {System.out.println("go button is mot responding");}

			try {
				//click on communication instance
			WebDriverWait wait1=new WebDriverWait(driver,5);
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[9]/a"))).click();
			//driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[9]/a")).click();
			Thread.sleep(5000);}
			catch(Exception e) {System.out.println("unable to click on communication isntance");}



			try {
				//click on Adhoc submit
			WebDriverWait wait1=new WebDriverWait(driver,5);
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']"))).click();
			//driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
			Thread.sleep(5000);}
			catch(Exception e) {System.out.println("unable to click on adhoc submit button");}


			try {
				//Handling the alert window
			
			
			Alert promptAlert = driver.switchTo().alert();

			//Enter the given Effective date i.e Quarterly or Monthly dates
			promptAlert.sendKeys(Utility4.getCellData(sFileName1,sSheetName1,row, 3));
			WebDriverWait wait3=new WebDriverWait(driver,15);
			wait3.until(ExpectedConditions.alertIsPresent());
			promptAlert.accept();
			Thread.sleep(10000);}
			catch(Exception e) {System.out.println("alert is not present");}
			try {
			Alert promptAlert1 = driver.switchTo().alert();
			//Thread.sleep(8000);
			
			WebDriverWait wait3=new WebDriverWait(driver,15);
			wait3.until(ExpectedConditions.alertIsPresent());
			promptAlert1.accept();
			Thread.sleep(8000);
			Utility4.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\ViaductDroppinglist.xlsx", str);
			Utility4.setCellData("Dropped", Arow, 1);
			
			}
			
			catch(Exception e) {System.out.println("alert2 is not working");
			Utility4.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\ViaductDroppinglist.xlsx", str);
			Utility4.setCellData("Failed", Arow, 1);
			count++;
			
			}
			//Return back to communication tab

			try{
				WebDriverWait wait1=new WebDriverWait(driver,5);
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a"))).click();}
			//driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();}
			catch(Exception e) {System.out.println("unable to naviagte to back page");}
			Thread.sleep(5000);


			}
			}catch(Exception e) {System.out.println("unable to get the sheet name");}

			//Knowing the account numbers for that communication instance 

			if(count>=1) {
				try {
					Utility4.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\ViaductDroppinglist.xlsx", "Sheet1");
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Utility4.setCellData("Fail", row, 5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else {
				try {
					Utility4.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\ViaductDroppinglist.xlsx", "Sheet1");
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Utility4.setCellData("Pass", row, 5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				}
				//these communications which or depended on communication instances names no account numbers 
			else if (sRunMode1.equals("Type2")) {
				
				//Click on Query button 
				try {
				driver.findElement(By.xpath("//*[@id='s_1_1_8_0_Ctrl']")).click();}catch(Exception e) {
					System.out.println("unable to click the query button");
				}
				
				try {
				String S="*";
				String Cname=Utility4.getCellData(sFileName1, sSheetName1, row, 0);
				//Enter the Communication name
				driver.findElement(By.xpath("//table[@id='s_1_l']/tbody/tr[2]/td[2]/input")).sendKeys(S+Cname+S);}catch(Exception e)
				{
					System.out.println("unable to enter the communication name");
				}

				try {
				//click on Go button
				driver.findElement(By.xpath("//*[@id='s_1_1_5_0_Ctrl']")).click();
				}
				catch(Exception e) {System.out.println("unable to click go button");}

				//click on show active
				//driver.findElement(By.xpath("//*[@id='s_3_1_3_0_Ctrl']")).click();
				try {
				 //Getting sheet number for Test accounts 
				System.out.println(Utility4.getCellData(sFileName1,sSheetName1,row, 1));

				String str = Utility4.getCellData(sFileName1,sSheetName1,row, 1);
					
				System.out.println("account sheetname"+str);
				Thread.sleep(5000);
				int totalNoOfRows1 = Utility4.rowcount(str);
				for(int Arow=0;Arow<=totalNoOfRows1;Arow++)
					
				{
					try {
				//click on act query
				driver.findElement(By.xpath("//button[@id='s_2_1_11_0_Ctrl']")).click();}
					catch(Exception e) {System.out.println("unable to click the act query button");}
				
					try {
				//Navigating to the column to enter the communication
				driver.findElement(By.xpath("//input[@id='1_Account_Number']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//input[@id='1_Account_Name']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//input[@id='1_Product']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//input[@id='1_Account_Managing_COE']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//input[@id='1_Account_Product_Delivery']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//input[@id='1_Participant_Fund_Name']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//input[@id='1_Client_Name']")).sendKeys(Keys.TAB);
					}catch(Exception e)
					{System.out.println("unable to navigate the column");}

					try {
				WebElement e1=driver.findElement(By.xpath("//*[@id='1_Name']"));

				//Entering the communication instance name
				e1.sendKeys(Utility4.getCellData(sFileName1,str,Arow, 0));
					}catch(Exception e) {System.out.println("");}	
				//click on go button
				driver.findElement(By.xpath("//*[@id='s_2_1_8_0_Ctrl']")).click();
				
				//perform  random click operation to highlight the communication instance link 
				driver.findElement(By.xpath("//*[@id='pager_s_1_l_right']")).click();
			
				Thread.sleep(2000);
				//	Refreshing the browser
				//driver.navigate().refresh();
				
				try {		//Click on the instance Link
				driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[9]/a")).click();
				}catch(Exception e) {System.out.println("unable to click the communication instance link");}
				//Navigate to communication instance window
				Thread.sleep(5000);
				try {		//click on Adhoc submit
				driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
				}catch(Exception e) {System.out.println("adhoc submit is not working");}	
				Thread.sleep(5000);

				try{//Switch to alert window to enter the Effective date
				Alert promptAlert = driver.switchTo().alert();
				promptAlert.sendKeys(Utility4.getCellData(sFileName1,sSheetName1,row, 3));
				WebDriverWait wait3=new WebDriverWait(driver,15);
				wait3.until(ExpectedConditions.alertIsPresent());
				promptAlert.accept();
				Thread.sleep(10000);}catch(Exception e) {System.out.println("alert is not working");}
				try{
					
					Alert promptAlert1 = driver.switchTo().alert();
				//Thread.sleep(8000);
					WebDriverWait wait3=new WebDriverWait(driver,15);
					wait3.until(ExpectedConditions.alertIsPresent());
				promptAlert1.accept();
				Utility4.setCellData("Dropped", Arow, 1);
				//Return back to communication tab
				Thread.sleep(8000);}catch(Exception e) 
				{
				System.out.println("alert 2 is not responding");
				Utility4.setCellData("Failed", Arow, 1);
				count++;
				
				}
				try{
					driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
				Thread.sleep(5000);
				}
				catch(Exception e) {System.out.println("unable to go back to the communiation page");
				}
				
				}
				
				}catch(Exception e) {
					System.out.println("unable to perform the action");
					}
				//Knowing the count of test accounts of the communications
				
				if(count>=1) {
					try {
						Utility4.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\ViaductDroppinglist.xlsx", "Sheet1");
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						Utility4.setCellData("Fail", row, 5);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}else {
					try {
						Utility4.setExcelFile("C:\\Users\\ammanrr.CORP\\eclipse-workspace\\ViaductDroppinglist.xlsx", "Sheet1");
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						Utility4.setCellData("Pass", row, 5);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				}


				
				}
		}


}}