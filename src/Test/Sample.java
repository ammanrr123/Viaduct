package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

    public static void main(String[] args) throws Exception {
         // TODO Auto-generated method stub
    	
System.setProperty("webdriver.chrome.driver","C://Users//gaddas1//Downloads//chromedriver.exe");
ChromeDriver driver = new ChromeDriver();
driver.manage().deleteAllCookies();
driver.get("http://usappobiewt100:81/fins_oui/start.swe?SWECmd=Login&SWECM=S&SRN=&SWEHo=usappobiewt100");
driver.manage().window().maximize();
driver.findElementByXPath("//input[@name='SWEUserName']").sendKeys("gaddas1");
driver.findElementByXPath("//input[@name='SWEPassword']").sendKeys("April@04051518");
driver.findElementByXPath("//a[text()='Login']").click();
Thread.sleep(3000);
driver.navigate().refresh();
Thread.sleep(3000);
//driver.findElementByXPath("//*[@data-tabindex='tabScreen8']").click();
driver.findElement(By.xpath("//*[@data-tabindex='tabScreen8']")).click();
         ////*[@id="gutterDiv"]//div//div/table/tbody//tr//td[text()='Build Communication']
}
}
