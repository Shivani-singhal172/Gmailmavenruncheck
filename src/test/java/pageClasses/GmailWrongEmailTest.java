package pageClasses;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pagefactory.GmailWrongEmail;
import Utility.ReadDataFiles;
import Utility.TextRead;

public class GmailWrongEmailTest {

	WebDriver driver;	
	GmailWrongEmail objtest3;

	@BeforeMethod
	public  void launch() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);
		//Thread.sleep(3000);
		driver.get("https://www.google.com//gmail/");
		//driver.get("https://mail.google.com//mail//u//0/#inbox");

	}
	
	@Test(dataProvider="credentials")
	public void gmailLogin(String username, String password) throws InterruptedException, AWTException{
		objtest3 = new GmailWrongEmail(driver);
		//objtest3.chechEmail();
		objtest3.getdataformxl(username, password);
		//objtest3.checknavigttopassword();
		//objtest3.checkpassword();
	}

	@DataProvider(name="credentials")
	public Object[][] data() throws Exception{
		Object[][] data = ReadDataFiles.data(0);
		return data;
	}


	@DataProvider(name="textcredentials")
	public Object[][] datafrmtxt() throws Exception
	{
		Object[][] datatxt =TextRead.textread(); 
		return datatxt;
	}


	/*@AfterTest
	public void end(){
		driver.quit();
	}*/

}