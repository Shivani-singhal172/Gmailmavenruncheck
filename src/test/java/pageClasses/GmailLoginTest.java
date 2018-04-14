package pageClasses;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pagefactory.Gmaillogin;
import Utility.ReadDataFiles;

public class GmailLoginTest {

	WebDriver driver;	
	Gmaillogin objtest2;

	@BeforeMethod
	public  void launch() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		driver.get("https://www.google.com//gmail/");
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
		//driver.get("https://mail.google.com//mail//u//0/#inbox");

	}
	@Test(dataProvider="credentials2")
	public void gmailLogin(String sendername, String receivername, String pasword, String randomtext) throws InterruptedException, AWTException{
		objtest2 = new Gmaillogin(driver);
		objtest2.enterCredentials(sendername, receivername, pasword, randomtext);
		objtest2.attachment();

	}

	@DataProvider(name="credentials2")
	public Object[][] data() throws Exception{
		Object[][] data = ReadDataFiles.data(1);
		return data;
	}



	/*@AfterTest
	public void end(){
		driver.quit();
	}*/

}
