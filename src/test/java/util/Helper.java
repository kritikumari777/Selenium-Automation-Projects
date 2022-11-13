package util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class Helper {

public String readFromExcel(String fpath, String Sheetname, int rownum,int colnum){
	String cellvalue=null;
	try {
		Workbook workbook=null;
		FileInputStream fis=new FileInputStream(new File(fpath));
		DataFormatter df=new DataFormatter();
		String extenstion =FilenameUtils.getExtension(fpath);
		cellvalue=extenstion;
		
		if(extenstion.equalsIgnoreCase("xls"))
			workbook=new HSSFWorkbook(fis);
		else if (extenstion.equalsIgnoreCase("xlsx"))
			workbook = new XSSFWorkbook(fis);
	} catch (Exception e) {
		e.printStackTrace();
		Assert.fail("FALL| Exception");
	}
	
	return cellvalue;
	
}

}
