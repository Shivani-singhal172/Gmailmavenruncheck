package pageClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pagefactory.createAccount;


public class createAccounttest1  {
 
	 WebDriver driver;
	 createAccount testobj ;
 
	@BeforeTest
	public  void launch(){
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/SignUp?hl=en-GB");
		
	}
	
	@Test
	public void createaccount(){
		testobj= new createAccount(driver);
		testobj.NameM();
		testobj.emailPassword(0);
		testobj.BirthDayM();
		testobj.GenderM();
		testobj.PhoneNumberM();
		testobj.recoveryEmailaddressM();
		testobj.LocationM();
		testobj.Submit();
		testobj.agreebtn();
		
	}
	
	/*@AfterTest
	public void quit(){
		driver.quit();
	}*/

	
   

	
}
