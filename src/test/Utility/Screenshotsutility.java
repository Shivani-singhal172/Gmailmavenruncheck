package Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshotsutility {

	public static String currentTCrsltfldr;
	
	String scrnshotpath = Screenshotsutility.TodayDate();
	File f = new File(scrnshotpath);
	
	public   void screenshot(WebDriver driver , String filename   ) {
		new Screenshotsutility();
		f.mkdirs();
		currentTCrsltfldr = scrnshotpath;
		try{
			File screenshot = 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
			
			File scrpath = new File((String)currentTCrsltfldr +"\\" +filename+".png");
			FileUtils.copyFile(screenshot, scrpath );
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public static String TodayDate(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return formater.format(calendar.getTime());
		
	}
}
