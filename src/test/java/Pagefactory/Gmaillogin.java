package Pagefactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Screenshotsutility;

public class Gmaillogin {

	WebDriver driver;
	Screenshotsutility takscsht = new Screenshotsutility();

	@FindBy(xpath="//input[@type='email']")  //i have used few element locators in differnt test class//
	WebElement txtbxGmailaddress;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement btnNext;

	@FindBy(xpath="//input[@type='password']")
	WebElement txtbxpassword;

	/*@FindBy(className="WaidBe")
	WebElement gmailicon;*/

	@FindBy(xpath="//div[contains(text(),'COMPOSE')]")
	WebElement btnCompose;

	@FindBy(xpath="//*[@id=':gr']")
	WebElement textboxTo;

	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement txtbxSubject;


	@FindBy(xpath="//div[@id=':hz']")
	WebElement btnattach;


	@FindBy(xpath="//div[@id=':fz']")
	WebElement btnsend;

	@FindBy(xpath="//a[contains(text(),'Sent Mail')]")
	WebElement sentmail;


	public Gmaillogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterCredentials(String sendername, String receivername, String password , String randomtext) throws InterruptedException{
		txtbxGmailaddress.sendKeys(sendername);
		takscsht.screenshot(driver, "emailaddress");
		btnNext.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS );
		boolean breakIt = true;
		while (true) {
			breakIt = true;
			try {
				txtbxpassword.sendKeys(password);
				txtbxpassword.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				driver.navigate().refresh();
				takscsht.screenshot(driver, "password");
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}

		}  

		btnCompose.click();
		takscsht.screenshot(driver, "composebtnpress");
		Thread.sleep(3000);

		textboxTo.sendKeys(receivername);
		txtbxSubject.sendKeys(randomtext);
		takscsht.screenshot(driver, "emailandsubjecttext");

	}
	public void attachment() throws AWTException{
		btnattach.click();

		/*Robot robot= new Robot();

		StringSelection stringselection = new StringSelection("C:\\Users\\dz\\Desktop\\RESUME\\SHIVANI.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.setAutoDelay(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(10000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(1000);
		takscsht.screenshot(driver, "mailsent");*/
		sentmail.click();
		takscsht.screenshot(driver, "sent");
	}



}
