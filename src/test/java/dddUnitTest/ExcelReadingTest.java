package dddUnitTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import dataTestObject.User;
import dbUtils.ExcelUtility;


public class ExcelReadingTest {
	
	@Test
	// workbook and excel sheet is same
	// we got value of a cell
	public void readDataByInputStream() throws EncryptedDocumentException, IOException {
		InputStream iStream = getClass().getClassLoader().getResourceAsStream("loginData.xlsx");
		// make sure you choose the ss one
		Workbook workbook = WorkbookFactory.create(iStream);
		// make sure you choose the ss one
		Sheet sheet = workbook.getSheet("testData");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());		
	}
	
	@Test
	// we got value of a row
	public void readDataByFile() throws EncryptedDocumentException, IOException {
		File file = new File("C:\\Users\\Tofael\\eclipse-workspace\\february.gov.cms.portal\\src\\test\\resources\\loginData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("testData");
		Row row = sheet.getRow(1);
		
		// int a = row.getPhysicalNumberOfCells(); // avoid null value, so we choose the below method
		int totalCell = row.getLastCellNum();
		System.out.println("Total cells : " + totalCell);
		
		List<Object> rowData = new ArrayList<Object>();

		for (int i = 0; i < totalCell; i++) {
			Cell cell = row.getCell(i);
			// in excel sheet, reader read as a String, but if we have int data then we have to cast it
			if (cell != null) {
				if (cell.getCellType() == CellType.NUMERIC) {
					rowData.add((int) cell.getNumericCellValue()); // cast by int
				} else {
					rowData.add(cell.getStringCellValue());
				}
			} else {
				rowData.add(cell); // it will add null
			}
		}
		System.out.println(rowData);		
	}
	
	@Test
	public void readDataByMap() throws EncryptedDocumentException, IOException {
		// File file = new File("C:\\Users\\Tofael\\eclipse-workspace\\february.gov.cms.portal\\src\\test\\resources\\loginData.xlsx");
		InputStream iStream = getClass().getClassLoader().getResourceAsStream("loginData.xlsx");
		
		Workbook book = WorkbookFactory.create(iStream);
		Sheet sheet = book.getSheet("testData");
		
		int totalRows = sheet.getLastRowNum();
		System.out.println("Total rows : " + totalRows);
		
		List<Map<String, Object>> listData = new ArrayList<Map<String,Object>>();
		
		// why count start from 1? because 0 contain header
		for(int i = 1; i <= totalRows; i++) {
			Row row = sheet.getRow(i);
			// why we used LinkedHashMap? to get data index wise
			// We write Object? because we can retrieve various data type like String, int, boolean
			Map<String, Object> rowMap = new LinkedHashMap<String, Object>();
			
			for(int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				
				if(cell != null) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue(); // to read header
					Object value = null;
					
					if(cell.getCellType() == CellType.NUMERIC) {
						value = (int) cell.getNumericCellValue();
					}else if(cell.getCellType() == CellType.STRING) {
						value = cell.getStringCellValue();
					}else if(cell.getCellType() == CellType.BOOLEAN) {
						value = cell.getBooleanCellValue();
					} 
					// we add data in Map by put()
					rowMap.put(key, value);
				} 
				
			}
			
			if(rowMap.get("Execute") != null) {
				if(String.valueOf(rowMap.get("Execute")).trim().equalsIgnoreCase("Y")) {
					listData.add(rowMap);
				}
			}
			
		}
		// Java lambda is used
		listData.forEach(System.out::println);
		// err represent error outcome as printed red color
		// System.err.println(listData.get(0).get("Password"));
	}
	
	// We didn't write the below code
	
	@Test
	public void unitTestExcelUtil() {
		ExcelUtility excelUtility = new ExcelUtility("loginData.xlsx", "testData");
		
		// Map Data
		//excelUtil.getData();
		
		// User Data
		List<User> list = excelUtility.getUsers();
		list.forEach(e -> System.out.println(e.getPassword()));
	}
	/*	
	@Test
	public void studetnNullAllowed() {
		Student student = new Student("Fa", null, 2, "June", 2002);
		System.err.println(student.getDob_date());
	}
*/

}
