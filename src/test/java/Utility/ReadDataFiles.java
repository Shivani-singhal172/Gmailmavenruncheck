package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadDataFiles {
	
	
	public static String[][] data(int sheetno) throws Exception{
		File file = new File("C:\\Users\\dz\\Desktop\\Automation learning stuff\\Gmail\\Gmail\\wrongpasswords\\gmail.xls");
		FileInputStream readdata = new FileInputStream(file);
		Workbook wrkbk = new HSSFWorkbook(readdata);
		Sheet sheet = wrkbk.getSheetAt(sheetno);
		int rowcount = sheet.getLastRowNum()+1;
		
		int cellcount = sheet.getRow(0).getLastCellNum();
		String[][] exceldata = new String[rowcount][cellcount];
		
		for (int i =0; i<rowcount;i++){
			Row row = sheet.getRow(i);
			for (int j = 0; j<cellcount; j++){
				Cell cell = row.getCell(j);
				String value = row.getCell(j).getStringCellValue();
				System.out.println(value);
			exceldata[i][j]= value;
			
				
			}
			
		}
		return exceldata;
	
		/*System.out.println(rowcount);
		System.out.println(cellcount);
		System.out.println(exceldata);*/
		
		 
		


	}
}
