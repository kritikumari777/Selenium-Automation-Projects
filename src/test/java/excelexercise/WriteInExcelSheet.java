package excelexercise;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class WriteInExcelSheet {
	
	@Test
	
	public void tesstwrit() throws Exception {
	
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("employe");
	
	Object emp[][] = { {"empid", "empname", "compny"},
			           {101, "kriti", "ps"},
	                   {102, "kriti", "TCS"}
	                 };
	
	int rows = emp.length; //3
	int cols = emp[0].length; // if we take fast row and find column it give 3
    
	
 	for(int i=0; i<rows; i++ ) {        
	HSSFRow row = sheet.createRow(i);    
	                   
	for(int j=0; j<cols; j++) {          
		HSSFCell cell = row.createCell(j);
		
		Object value = emp[i][j];         
		
		if(value instanceof String) {
			cell.setCellValue((String)value);
		}
		if(value instanceof Integer) {     // or else if{
			cell.setCellValue((Integer)value);
		}
		if(value instanceof Boolean) {    // or else if{
			cell.setCellValue((Boolean)value);
		}
	 }
	} //  till now we have added all data to the sheet
 	
 	//now we are going to add in workbook
 	String path = "src/test/resources/Employee.xls";  //create
 	FileOutputStream fileoutput = new FileOutputStream(path); // open
 	workbook.write(fileoutput);  // write
 	
 	System.out.println("data is intered in employe sheet");
 
 }
	
	@Test
	
	public void writeExcel() throws Exception {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Student");
		
		ArrayList<Object[]> liststd = new ArrayList<Object[]>();
		liststd.add(new Object[] {"sid", "sname"});
		liststd.add(new Object[] {"101", "kriti"});
		liststd.add(new Object[] {"102", "Priti"});
		
		int rowindex=0;
		
		for(Object[] std : liststd) {
			HSSFRow row = sheet.createRow(rowindex++);
			
			int colindex=0;
			for(Object value : std) {
				HSSFCell cell = row.createCell(colindex++);
				
				if(value instanceof String){
					cell.setCellValue((String) value);
				}
				if(value instanceof Number) {
					cell.setCellValue((double) value);
				}
				if(value instanceof Boolean) {
					cell.setCellValue((Boolean)value);
				}
			}
		}
		
		String path = "src/test/resources/Student.xls";
		FileOutputStream outputstream = new FileOutputStream(path);
		workbook.write(outputstream);
		System.out.println("data is inserted into student sheet");
	}
}
