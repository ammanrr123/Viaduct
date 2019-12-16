package Test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.ie.InternetExplorerDriver;


public class Test2 {
            
public static void main(String[] args) throws Exception {
{               
	
	// System.setProperty("webdriver.ie.driver", "C://Users//ammanrr//Downloads//IEDriverServer.exe");
   //  WebDriver driver = new InternetExplorerDriver();
System.setProperty("webdriver.chrome.driver","C://Users//ammanrr//Downloads//chromedriver.exe");
WebDriver driver = new ChromeDriver(); 
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("http://usappobiewt100:81/fins_oui/start.swe?SWECmd=Login&SWECM=S&SRN=&SWEHo=usappobiewt100");
Thread.sleep(3000);
driver.findElement(By.name("SWEUserName")).sendKeys("ammanrr");
driver.findElement(By.name("SWEPassword")).sendKeys("Uana1siri!1");
driver.findElement(By.id("s_swepi_22")).click();
Thread.sleep(3000);
//click on communication tab
driver.findElement(By.xpath("//*[@id='s_sctrl_tabScreen']/ul/li[11]")).click();
//click on query
driver.findElement(By.xpath("//*[@id='s_1_1_8_0_Ctrl']")).click();
//enter the communication name as input
driver.findElement(By.xpath("//table[@id='s_1_l']/tbody/tr[2]/td[2]/input")).sendKeys("IPC");
//click on Go button
driver.findElement(By.xpath("//*[@id='s_1_1_5_0_Ctrl']")).click();

//click on show active
driver.findElement(By.xpath("//*[@id='s_3_1_3_0_Ctrl']")).click();
//click on instance
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert = driver.switchTo().alert();
promptAlert.sendKeys("03/31/2018");
promptAlert.accept();
Thread.sleep(8000);
Alert promptAlert1 = driver.switchTo().alert();
promptAlert1.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[3]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert2 = driver.switchTo().alert();
promptAlert2.sendKeys("03/31/2018");
promptAlert2.accept();
Thread.sleep(8000);
Alert promptAlert3 = driver.switchTo().alert();
promptAlert3.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[4]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert4 = driver.switchTo().alert();
promptAlert4.sendKeys("03/31/2018");
promptAlert4.accept();
Thread.sleep(8000);
Alert promptAlert5 = driver.switchTo().alert();
promptAlert5.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[5]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert6 = driver.switchTo().alert();
promptAlert6.sendKeys("03/31/2018");
promptAlert6.accept();
Thread.sleep(8000);
Alert promptAlert7 = driver.switchTo().alert();
promptAlert7.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[6]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert8 = driver.switchTo().alert();
promptAlert8.sendKeys("03/31/2018");
promptAlert8.accept();
Thread.sleep(8000);
Alert promptAlert9 = driver.switchTo().alert();
promptAlert9.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[7]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert10 = driver.switchTo().alert();
promptAlert10.sendKeys("03/31/2018");
promptAlert10.accept();
Thread.sleep(5000);
Alert promptAlert11 = driver.switchTo().alert();
promptAlert11.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[8]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert12 = driver.switchTo().alert();
promptAlert12.sendKeys("03/31/2018");
promptAlert12.accept();
Thread.sleep(5000);
Alert promptAlert13 = driver.switchTo().alert();
promptAlert13.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[9]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert14 = driver.switchTo().alert();
promptAlert14.sendKeys("03/31/2018");
promptAlert14.accept();
Thread.sleep(5000);
Alert promptAlert15 = driver.switchTo().alert();
promptAlert15.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[10]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);
Alert promptAlert16 = driver.switchTo().alert();
promptAlert16.sendKeys("03/31/2018");
promptAlert16.accept();
Thread.sleep(5000);
Alert promptAlert17 = driver.switchTo().alert();
promptAlert17.accept();

//Returnback to communication tab
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='siebui-threadbar']/li[1]/span/a")).click();
Thread.sleep(5000);
//click on show active
driver.findElement(By.xpath("//button[@data-display='Show Active']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[11]/td[9]/a")).click();
Thread.sleep(5000);
//click on adhoc submit
driver.findElement(By.xpath("//button[@aria-label='Communication Maintenance:Adhoc Submit']")).click();
Thread.sleep(5000);;
Alert promptAlert18 = driver.switchTo().alert();
promptAlert18.sendKeys("03/31/2018");
promptAlert18.accept();
Thread.sleep(5000);
Alert promptAlert19 = driver.switchTo().alert();
promptAlert19.accept();

}}}