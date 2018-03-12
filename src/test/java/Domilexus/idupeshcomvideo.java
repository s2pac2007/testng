package Domilexus;

import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import java.util.List;


@Test
public class idupeshcomvideo extends Domilexus.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private WebDriver driver = new ChromeDriver();	
  @BeforeSuite
  public void SetBrowser(){
	  File file = new File("./chromedriver.exe");
      System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
      String ExpTitle = "Welcome: Mercury Tours";
  }

    public void testLogin() throws Exception {
	String baseUrl = "http://idupesh.com";
	driver.get(baseUrl + "/");
	List<WebElement> elems = driver.findElements(By.xpath("//ul[@id='dj-megamenu145']/li"));
	WebElement webEle = null;
	System.out.println("Cicle for idupesh.com menu started with "+elems.size()+" elements");
	for (int i=1; i<=elems.size(); i++){
	System.out.println("Count is: " + i);
	driver.switchTo().defaultContent();
	webEle=driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]"));
	webEle.click();
	System.out.println(driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]")).getText());
	System.out.println("Click menu "+i+" "+driver.findElement(By.xpath("//ul[@id='dj-megamenu145']/li["+i+"]/a")).getText());
	
	List<WebElement> elFrame = driver.findElements(By.tagName("iframe"));
	            for (WebElement elFramename : elFrame)
                System.out.println("frameid: " + elFramename.getAttribute("title"));    
	if (elFrame.size()!=0){
			System.out.println("Frames on page "+elFrame.size());
			for (int n=0; n<elFrame.size(); n++){
				driver.switchTo().frame(n);
				System.out.println("Frame number  "+n+" text "+driver.findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']")).getText());
					try
						{
							driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
							Thread.sleep(2000);
							System.out.println("Video in Frame "+n+" clicked ");
						} 
					catch(NoSuchElementException e)
						{
							System.out.println("Error in frame " +n);
						}
				
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();	
				System.out.println("Frame "+n+" switched to defaultContent ");
				webEle.click();
			}
			
			
		}
	else {
		System.out.println("No Frames on the page");
	}
	//driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();


	//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	//Thread.sleep(60000);
	}
	
	//driver.switch_to_default_content(); //*[@id="nsp-nsp-113"]/div[1]/div[2]/div/div[3]/div/div/iframe
	
	

	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	//Thread.sleep(60000);
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
