package Pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Screenshotsutility;


public class createAccount {
 static int i;
 String emialadress;
 String passwordvalue;
 String phnno;
 Screenshotsutility takscsht = new Screenshotsutility();
 WebDriver driver;
 
	@FindBy(id="FirstName")
	WebElement Firstname;
	
	@FindBy(id="LastName")
	WebElement lastname;
	
	@FindBy(id="GmailAddress")
	WebElement username;
	
	@FindBy(id="Passwd")
	WebElement password;
	
	@FindBy(id="PasswdAgain")
	WebElement confirmpassword;
	
	@FindBy(id="BirthDay")
	WebElement Birthday;
	
	@FindBy(xpath ="//span[@id='BirthMonth']")
	WebElement birthmonths;
	
	@FindBy(xpath="//div[@class='goog-menuitem-content' and contains(text(),'January')]")
	WebElement Birthmonth;
	
	@FindBy(id="BirthYear")
	WebElement Birthyear;
	
	@FindBy(xpath="//div[@id='Gender']")
	WebElement genders;
	
	@FindBy(xpath="//div[@class='goog-menuitem-content' and contains(text(),'Male')]")
	WebElement gender;
	
	@FindBy(id="RecoveryPhoneNumber")
	WebElement phonenumbercountry;
	
	@FindBy(id="RecoveryPhoneNumber")
	WebElement phonenumber;
	
	@FindBy(id="RecoveryEmailAddress")
	WebElement Currentemail;
	
	@FindBy(xpath="//div[@id='CountryCode']")
	WebElement Locations;
	
	@FindBy(id=":i")
	WebElement Location;

	@FindBy(id="submitbutton")
	WebElement Nextstep;
	
	@FindBy(xpath="//div[@id='tos-scroll-button']")
	WebElement scrollbtn;
	
	@FindBy(xpath="//*[@id= 'iagreebutton']")
	WebElement Agreebtn;
	
	@FindBy(id="next-button")
	WebElement btncontinue;
	
	

	public createAccount(WebDriver driver){
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	public void NameM(){
		Firstname.sendKeys("Rishabh");
		lastname.sendKeys("Singhal");
		takscsht.screenshot(driver, "firstname");
		
	}
	
	public void emailPassword(int i){
		 passwordvalue = "Monday@123"+i+"";
			 emialadress = "rs683267"+i+"@gmail.com";
			 phnno = "880578343"+i+"";
			 username.sendKeys(emialadress);
			 takscsht.screenshot(driver, "emailaddress");
			 password.sendKeys(passwordvalue);
			 takscsht.screenshot(driver, "password");
			 confirmpassword.sendKeys(passwordvalue);
			 takscsht.screenshot(driver, "confirmpassword");
	}
	public void BirthDayM(){
		Birthday.sendKeys("17");
		actionclass(birthmonths, Birthmonth);
		takscsht.screenshot(driver, "birthmonth");
		Birthyear.sendKeys("1994");
		takscsht.screenshot(driver, "Birthdetails");
		
	}
	
	
	public void GenderM(){
		actionclass(genders, gender);
	}
	
	public void LocationM(){
		actionclass(Locations, Location);
	}
	public void PhoneNumberM(){
		phonenumber.sendKeys(phnno);
		takscsht.screenshot(driver, "phoneno");
	}
	
	public void recoveryEmailaddressM(){
		Currentemail.sendKeys("shivani.singhal172@gmail.com");
		takscsht.screenshot(driver, "recoveryemail");
	}
	
	public void Submit(){
		Nextstep.click();
		takscsht.screenshot(driver, "nextpage");
	}

	public void agreebtn(){
		while(true){
			try{
				scrollbtn.click();			
			}catch(Exception e){
				break;	
			}
		}
		
		
		//scrollbtn.sendKeys(Keys.PAGE_DOWN);
        //JavascriptExecutor jse =(JavascriptExecutor)driver;
        //jse.executeScript("window.scrollby(0,600)");
        
        //jse.executeScript("arguments[0].scrollIntoView(true);",scrollbtn);
        Agreebtn.click();
        btncontinue.click();
		
	}
		
	
	
	public  void actionclass(WebElement mainelmnt , WebElement subelemnet){
		Actions act = new Actions(driver);
		
		act.click(mainelmnt).moveToElement(subelemnet).click();
		act.build().perform();
		
	}
	public WebElement dropdownlist( String input ){
	List<WebElement> droplist = driver.findElements(By.xpath("goog-inline-block goog-flat-menu-button jfk-select"));
		if (input == "birthmonths"){
	    WebElement birthmonthmain = droplist.get(1);
	    return birthmonthmain;
		}
		if (input == "genders"){
		  WebElement gendermain = droplist.get(2);
		  return  gendermain;}
		
		 WebElement locationmain = droplist.get(3);
		 return locationmain;
	}

}
/*public static void dropdown(WebElement name , String fieldvalue ){

Select obj = new Select(name);
obj.selectByVisibleText(fieldvalue);;
 }*/

/*public WebElement listelemnt(){
List<WebElement> iteratelement = driver.findElements(By.xpath("//div[@class='goog-menuitem-content' and contains(text(), 'India (भारत)')]"));
WebElement india = iteratelement.listIterator().next();
return india;

}*/

