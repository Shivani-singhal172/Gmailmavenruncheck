package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.poi.util.SystemOutLogger;

public class TextRead {
static String filename ="C:\\Users\\dz\\Desktop\\Automation learning stuff\\Gmail\\Gmail\\wrongpasswords\\gmail.txt";
	public static String[][] textread() throws Exception{
		String line = null;
		String[][] username= new String[5][2];
		FileReader filereader = new FileReader(filename);
		BufferedReader file = new BufferedReader(filereader);
		int rowcounter=0;
		while((line = file.readLine())!=null){
			System.out.println(line);
				String[] value = line.split("~");
				for (int columncounter = 0 ; columncounter<2; columncounter++){
				username[rowcounter][columncounter] = value[columncounter];
				}
				
				rowcounter++;				
		}
		file.close();
		return username;
		
	}
}
