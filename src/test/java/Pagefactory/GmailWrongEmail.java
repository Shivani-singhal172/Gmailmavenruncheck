package Pagefactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.ReadDataFiles;



public class GmailWrongEmail {
	WebDriver driver;
	ReadDataFiles readdata = new ReadDataFiles();
static String textVerify;
	Assert assert1;

	@FindBy(xpath="//input[@type='email']")  //i have used few element locators in differnt test class//
	WebElement txtbxGmailaddress;

	@FindBy(xpath="//div[contains(text(),\"Couldn't find your Google Account\")]")
	WebElement Errormsg;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement btnNext;

	@FindBy(xpath="//input[@type='password']")
	WebElement txtbxpassword;

	
	@FindBy(xpath="//div[@id='forgotPassword']")
	WebElement forgotpaswrdtext;
	
	@FindBy(xpath="//div[@class='dEOOab RxsGPe' and contains(text(),'Your password was changed 21 days ago')]")
	WebElement incorrectpaswrdtext;
	
	
	public GmailWrongEmail(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public  void chechEmail() throws InterruptedException{
		txtbxGmailaddress.sendKeys("dvgcvfyhbhcbdyugcdbc@gmail.com");
		txtbxGmailaddress.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
      textVerify = Errormsg.getText();
		 Assert.assertEquals(Errormsg.getText(), "Couldn't find your Google Account");
		 Thread.sleep(5000);
		 System.out.println(textVerify);

	}
	
	public void checknavigttopassword() throws InterruptedException{
		txtbxGmailaddress.sendKeys("shivani.singhal172@gmail.com");
		txtbxGmailaddress.sendKeys(Keys.ENTER);
Thread.sleep(5000);
textVerify =forgotpaswrdtext.getText();
		Assert.assertEquals(forgotpaswrdtext.getText(), "Forgot password?");
		Thread.sleep(5000);
		System.out.println(textVerify);
	}
	public void checkpassword() throws InterruptedException
{
		txtbxGmailaddress.sendKeys("shivani.singhal172@gmail.com");
		txtbxGmailaddress.sendKeys(Keys.ENTER);
		 //driver.manage().timeouts().wait(10000);
		
		Thread.sleep(10000);
		txtbxpassword.sendKeys("shiny172");
		txtbxpassword.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	//	driver.manage().timeouts().wait(10000);
		textVerify = incorrectpaswrdtext.getText();
Assert.assertEquals(incorrectpaswrdtext.getText(), "Your password was changed 21 days ago");
System.out.println(textVerify);
		}
	
	public void getdataformxl(String username , String password) throws InterruptedException{
	 txtbxGmailaddress.sendKeys(username);
	 txtbxGmailaddress.sendKeys(Keys.ENTER);
	 Thread.sleep(10000);
	 txtbxpassword.sendKeys(password);
		txtbxpassword.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
}




