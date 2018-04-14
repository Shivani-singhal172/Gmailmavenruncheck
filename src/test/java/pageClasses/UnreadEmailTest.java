package pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pagefactory.UnreadEmails;

public class UnreadEmailTest {
	WebDriver driver ;
	UnreadEmails objtest4 ;
	
	
	@BeforeTest
	public  void launch(){
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com//gmail/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
	}
	
	
	
	@Test
	public void unreadmails() throws InterruptedException, Exception{
		objtest4   = new UnreadEmails(driver);
		objtest4.totalUnreadMail();
		
		
		
	}
}
