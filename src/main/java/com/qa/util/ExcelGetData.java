package com.qa.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGetData {

	
	
	public static String getData(String Sheet_name, int Row,int col) throws Exception {
		File f= new File("C:/Users/Dattatray/eclipse-workspace/Eprobiling1/src/main/java/com/qa/excel/Eprobillingtestdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		 XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(Sheet_name);
		XSSFRow row= sh.getRow(Row);
		XSSFCell cell= row.getCell(col);
		String data= cell.getStringCellValue();
		return data;
	}
	
	
	
	
}
