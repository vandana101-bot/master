package com.ct.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ct.qa.properties.AppProperties;

/**
 * 
 * @author Vandana
 *
 */
public class TestUtil{
	
   private static Workbook book;
   private static Sheet sheet;
   private static DataFormatter dataFormatter=new DataFormatter();
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream fileStream = null;
		try {
			 System.out.print("file name is" + AppProperties.getPropertyObject().getProperty("testDataFilePath"));
			File file = new File(AppProperties.getPropertyObject().getProperty("testDataFilePath"));
			fileStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		try {
			book = WorkbookFactory.create(fileStream);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = dataFormatter.formatCellValue(sheet.getRow(i + 1).getCell(k));
			}
		}
		return data;
	}



}
