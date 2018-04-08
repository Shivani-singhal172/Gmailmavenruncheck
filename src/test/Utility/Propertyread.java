package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Propertyread {
	
	
	public static void propertyread(){
   try{
	File Selectindex = new File("D:/workspaceneon/Mavenproject/selectindex.properties");
	
	 FileInputStream readprop = new FileInputStream(Selectindex);
	 Properties proppertyobj = new Properties();
	 proppertyobj.load(readprop);
   }
   catch(Exception e){
	   e.printStackTrace();
   }
   }
	
}
