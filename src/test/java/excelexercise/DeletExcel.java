package excelexercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class DeletExcel {
	WebDriver driver;
	WebDriverManager webdrvmgr;
	
	@Test(dataProvider = "user-login")
	public void login(String user, String pass) {
	
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("Chrome");
		driver.get("https://example.testproject.io/web/");

		driver.findElement(By.id("name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login")).click();
		String expected = "TestProject Demo";
		
		try {
		if(driver.getTitle().equals(expected)) {
			Thread.sleep(2000);
			System.out.println("login Secessfully");
			driver.findElement(By.id("logout")).click();
			System.out.println("Logout");
		  }
		}
		catch(Exception e) {
			System.out.println("Invalid login ID");
		}
		
	}
		
	
	@DataProvider(name ="user-login")
	public String[][] readandread() throws IOException {
		
		
		File file = new File("src\\test\\resources\\TestExcel.xls");
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheet("LoginData");
		
		int rcount = sheet.getLastRowNum();
		int ccount = sheet.getRow(0).getLastCellNum();
		
		
		String[][] login = new String[rcount][ccount];
		for(int i=0; i<rcount; i++) {
			HSSFRow row = sheet.getRow(i);
			for(int j=0; j < ccount; j++) {
				HSSFCell cell = row.getCell(j);
				String value = "";
				switch(cell.getCellType()) {
				case Cell.CELL_TYPE_STRING :
					value = cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					Object data = cell.getNumericCellValue();
					value = String.valueOf(data);
					break;
				}
				login[i][j] = value;
			}
	
			
		}
		return login;
		
	}

}
