package excelexercise;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingExcel {

	@Test
	
	public void readExcel() throws Exception {
		
		String  excelfilepath = "src/test/resources/TestExcel.xls"; // location of file
		
		FileInputStream fileinput = new FileInputStream(excelfilepath); //open file to read data
	    HSSFWorkbook workbook = new HSSFWorkbook(fileinput);  // get workbook of file
		HSSFSheet sheet = workbook.getSheet("Sheet1");  //name of excel file that present at 0 index.
		
		int rownum = sheet.getLastRowNum(); // length of row
		
		for(int i=0; i<rownum; i++) {    // for getting row
			HSSFRow  row = sheet.getRow(i);  // get row one by one
			
			for(int j=0; j<row.getLastCellNum(); j++) {  // for getting column
				
				HSSFCell cell = row.getCell(j);  // get column one by one
				System.out.print(cell+" ");    // print
			}
			System.out.println(); //for new line
		}
	}
	
	// or other way to reading data
	@Test
	
	public void readExcelOtherWay() throws Exception {
		
		String filepath =  "src/test/resources/TestExcel.xls"; 
		
		FileInputStream inputstream = new FileInputStream(filepath);
		HSSFWorkbook workbook = new HSSFWorkbook(inputstream);
		HSSFSheet sheet = workbook.getSheetAt(1); // index of the sheet Citydetail
		
		Iterator iterate = sheet.iterator(); // return iterator object that import from java.util package
		while(iterate.hasNext()) { // check object are present or not
			HSSFRow row = (HSSFRow) iterate.next(); // get the first row
			
			Iterator itratecell = row.cellIterator(); // return iterator object
			while(itratecell.hasNext()) {// check object are present or not
				HSSFCell cell = (HSSFCell) itratecell.next();
				System.out.print(cell+" ");
			}
			System.out.println();
		}
	}

}

