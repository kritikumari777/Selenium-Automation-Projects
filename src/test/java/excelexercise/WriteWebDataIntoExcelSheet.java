package excelexercise;


import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class WriteWebDataIntoExcelSheet {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	
	@BeforeTest
	public void set() {
		webdrvmgr = new WebDriverManager();
		driver =webdrvmgr.launchBrowser("Chrome");
		driver.get("http://demo.seleniumeasy.com/table-pagination-demo.html");
	}
   
	@Test()
	public void writeInXl()throws Exception {
		
	String path = "src\\test\\resources\\TemporySheet.xls";
	HSSFWorkbook workbook = new HSSFWorkbook();
	HSSFSheet sheet = workbook.createSheet("Recoed");
	
	List<WebElement> headline = driver.findElements(By.xpath("//thead[@class='btn-primary']//tr/th"));
	int colsize = headline.size();
	List<WebElement> rowtable = driver.findElements(By.xpath("//tbody[@id='myTable']/tr"));
	int rowsize = rowtable.size();
	
	int k=0;
	HSSFRow headingrow = sheet.createRow(k);
	for(int r=0; r<rowsize; r++) {

		HSSFRow row = sheet.createRow(r+1);
		List<WebElement> coltable = rowtable.get(r).findElements(By.xpath("td"));
		
		for(int c=0; c<colsize; c++) {
		
		if(k==0) {
			HSSFCell headingcell = headingrow.createCell(c);	
			String heading = headline.get(c).getText();
			System.out.println(headingcell+" ");
			headingcell.setCellValue(heading);
		}
		
		
		HSSFCell cell = row.createCell(c);
		String cellvalue = coltable.get(c).getText();
		cell.setCellValue(cellvalue);
		System.out.println(cellvalue+" ");
		
		}
		k++;
		System.out.println();
	}
	
	FileOutputStream fileoutput = new FileOutputStream(path);
	workbook.write(fileoutput);
	workbook.close();
	fileoutput.close();
	
	}
	
	@AfterClass
	public void sutdown() {
		driver.quit();
	}
}
