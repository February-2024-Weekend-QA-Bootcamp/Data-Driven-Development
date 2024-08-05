package dbUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import dataTestObject.User;



public class ExcelUtility {

	private Workbook workbook;
	private Sheet sheet;

	public ExcelUtility(String fileName, String sheetName) {
		init(fileName, sheetName);
	}

	private void init(String fileName, String sheetName) {
		try {
			InputStream iStream = getClass().getClassLoader().getResourceAsStream(fileName);
			workbook = WorkbookFactory.create(iStream);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Map<String, Object>> getData(){
		int totalRows = sheet.getLastRowNum();
		List<Map<String, Object>> listData = new ArrayList<Map<String,Object>>();
		
		for(int i = 1; i <= totalRows; i++) {
			Row row = sheet.getRow(i);
			Map<String, Object> rowMap = new LinkedHashMap<String, Object>();
			
			for(int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				
				if(cell != null) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					Object value = null;
					
					if(cell.getCellType() == CellType.NUMERIC) {
						value = (int) cell.getNumericCellValue();
					}else if(cell.getCellType() == CellType.STRING) {
						value = cell.getStringCellValue();
					}else if(cell.getCellType() == CellType.BOOLEAN) {
						value = cell.getBooleanCellValue();
					}					
					rowMap.put(key, value);
				}
			}
			
			if(rowMap.get("Execute") != null) {
				if(String.valueOf(rowMap.get("Execute")).toLowerCase().trim().equalsIgnoreCase("y")) {
					listData.add(rowMap);
				}
			}
			
			
		}
		
		//listData.forEach(System.out::println);
		
		return listData;
	}
	
	public List<User> getUsers(){
		List<User> listOfUsers = new ArrayList<User>();
		
		List<Map<String, Object>> dataMaps = getData();
		
		for(Map<String, Object> map : dataMaps) {
			User user = new User(getValue(map, "UserId"), getValue(map, "Password"));
			listOfUsers.add(user);		
		}		
		return listOfUsers;
	}

	private String getValue(Map<String, ?> map, String key) {
		String value = "";
		try {
			value = map.get(key).toString();
		}catch (NullPointerException e) {
		}
		return value;
	}
	
	public Workbook getWorkbook() {
		return workbook;
	}

	public Sheet getSheet() {
		return sheet;
	}
}
