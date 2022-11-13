package excelexercise;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;


public class ReadExcelSheet {
	
	@Test
	public void dataReadTest() throws Exception {
		
		File src = new File("src/test/resources/TestExcel.xls");  // TestExcel.xlsx 
		FileInputStream fis = new FileInputStream(src);
		
	    //XSSFWorkbook xsf = new XSSFWorkbook(fis);  // for xlsx file
	    //XSSFSheet sheet = xsf.getSheetAt(0);    // for xlsx file
		
		HSSFWorkbook hwb = new HSSFWorkbook(fis);  ///for xls file
		
		HSSFSheet sheet = hwb.getSheetAt(0);  // 0 represent first excel sheet.
		
		 Row row = sheet.getRow(1);
		 
		String entry1 = row.getCell(1).getStringCellValue(); //or
		
		// Cell cell = (Cell) row.getCell(1);
	    // String entry1 = cell.getStringCellValue(); 
		
		System.out.println("The data in the box is"+ entry1);
		
		hwb.close();
		
	}

}
