package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;




public class ExcelUtility {
    
	String path=null;
	public FileInputStream fileinput;
	public FileOutputStream fileoutput;
	public HSSFWorkbook  workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;
	
	public ExcelUtility(String path) {
		this.path=path;
	}
	
	public int getRowNum(String sheetName) throws Exception  {
		fileinput = new FileInputStream(path);
        workbook = new HSSFWorkbook(fileinput);
        sheet = workbook.getSheet(sheetName);
        int rownum = sheet.getLastRowNum();
        workbook.close();
        fileinput.close();
		return rownum;
	}
	
	public int getcellNum(String sheetName, int rownum) throws Exception {
		fileinput = new FileInputStream(path);
		workbook = new HSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellnum = row.getLastCellNum();
		workbook.close();
		fileinput.close();
		return cellnum;
		
	}
	
	public String getCellValue(String sheetName, int rownum, int cellnum) throws Exception {
		fileinput  = new FileInputStream(path);
		workbook = new HSSFWorkbook(fileinput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum); 
		String value="";
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
               value = cell.getStringCellValue();
                break;

            case Cell.CELL_TYPE_NUMERIC:
                Integer data=(int) cell.getNumericCellValue();
                value= String.valueOf(data);
                break;
            }
            workbook.close();
    		fileinput.close();
			return value;
            
	}
	
	public void SetCellValue(String sheetName, int rownum, int cellnum, String value) throws Exception {
		File xlfile = new File(path);
		if(!xlfile.exists()) {
		     workbook= new HSSFWorkbook();
		     sheet = workbook.createSheet(sheetName);
		     row = sheet.createRow(rownum);
		     cell = row.createCell(cellnum);
		     cell.setCellValue(value);
		     fileoutput = new FileOutputStream(path);
			 workbook.write(fileoutput);
			 workbook.close();
			 fileoutput.close();
		}
		else {
			fileinput  = new FileInputStream(path);
			workbook = new HSSFWorkbook(fileinput);
			sheet = workbook.getSheet(sheetName);
			if(sheet.getRow(rownum)==null) {
				 row = sheet.createRow(rownum);
			}
			row = sheet.getRow(rownum);  //else
			
		   cell = row.createCell(cellnum);	
		   cell.setCellValue(value);
		
		   fileoutput = new FileOutputStream(path);
		   workbook.write(fileoutput);
		   workbook.close();
		   fileoutput.close();
		   fileinput.close();
		}
	}
}
