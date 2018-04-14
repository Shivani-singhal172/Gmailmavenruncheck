package Pagefactory;


import java.awt.RenderingHints.Key;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnreadEmails {

	WebDriver driver;
String filename ;
	
	@FindBy(xpath="//input[@type='email']")  //i have used few element locators in differnt test class//
	WebElement txtbxGmailaddress;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement btnNext;

	@FindBy(xpath="//input[@type='password']")
	WebElement txtbxpassword;
	
	@FindBy(xpath="//*[@id=':cx']/tbody/tr")
	WebElement Allmails;
	
	@FindBy(xpath="//*[@id=':3b']")
	WebElement btnAllmails;
	
	@FindBy(xpath="//*[starts-with(@id,':')][contains(@class,'hP')]")
	WebElement mailsubject;
	
	//"//*[@id=':2']/div/div[3]/div/table/tr/td[1]/div[2]/div[1]/div[2]/div[1]/h2"
	@FindBy(xpath="//div[@class='ii gt '][1]")
	WebElement mailcontent;
	
	@FindBy(xpath="//div[@class='ar6 T-I-J3 J-J5-Ji']")
	WebElement btnbacktoallmail;

	@FindBy(xpath="(//*[@id=':10q']/div[1]/div[2]/div[1]/table/tbody/tr[1]/td[1]/table/tbody/tr/td/h3/span[1])")
	WebElement Sendermailname;
	

	/*@FindAll(xpath="//table/tbody/tr[@class='zA zE']")
	 WebElement Unreadmails;*/
	
	public UnreadEmails(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void totalUnreadMail() throws InterruptedException, IOException{
	txtbxGmailaddress.sendKeys("Shivani.singhal172@gmail.com");
	txtbxGmailaddress.sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	txtbxpassword.sendKeys("Monday#12");
	txtbxpassword.sendKeys(Keys.ENTER);
	Thread.sleep(5000);
	driver.navigate().refresh();
	Thread.sleep(5000);
	btnAllmails.click();
	Thread.sleep(3000);
	List<WebElement> unreadmails= driver.findElements(By.xpath("//table/tbody/tr[@class='zA zE']"));
	int rowcount = unreadmails.size();
	System.out.println(rowcount);
	while(unreadmails.listIterator().hasNext()){
		for(WebElement e :unreadmails){
		e.click();
		Thread.sleep(5000);
		String mailSubject = senderemailaddress();
		Thread.sleep(5000);
		System.out.println(mailSubject);
		writetext();
		btnbacktoallmail.click();
		}
		
	}
	
	}
	public void writetext() throws IOException
	{ 
		String content = "Hello";
	
		File txtfilepath = new File("D:\\workspaceneon\\Mavenproject" +"\\mailSubject.txt");
		FileWriter file = new FileWriter(txtfilepath);
		BufferedWriter bufferwriter = new BufferedWriter(file);
		bufferwriter.write(content);
	}
	public String senderemailaddress(){
		WebElement senderemailtable =driver.findElement(By.xpath("//*[@class='gE iv gt']/table/tbody/tr[1]/td[1]/table/tbody/tr[1]"));
		WebElement tablerow = senderemailtable.findElement(By.tagName("td"));
		WebElement tabledata = tablerow.findElement(By.className("iw"));
		String emaildata = tabledata.getText();
		String[] email = emaildata.split("<");
String senderemailaddress = email[0];	
return senderemailaddress;
		 }
	}


