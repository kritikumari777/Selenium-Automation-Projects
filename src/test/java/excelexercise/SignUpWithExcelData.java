package excelexercise;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import util.WebDriverManager;

public class SignUpWithExcelData {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	
	@BeforeClass
	public void set() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("Chrome");
		driver.get("https://www.demoblaze.com/#carouselExampleIndicators");
	}
	
	@Test(dataProvider="signUp-user")
	public void signUpWithExcel(String user, String pass) throws InterruptedException {
		driver.findElement(By.id("signin2")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("sign-username")).sendKeys(user);
		driver.findElement(By.id("sign-password")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[onclick='register()']")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		
		if(text.equals("This user already exist.")) {
			System.out.println(text);
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@onclick='register()']//parent::div/button[1]")).click();
		}
		else {
			System.out.println(text);
		}
		
	}
	@AfterClass
	
	public void sutDown() {
		driver.quit();
	}
	
	@DataProvider(name="signUp-user")
	public String[][] dPExcel() throws Exception {
		String path = "src\\test\\resources\\TestExcel.xls";
		FileInputStream fileinput = new FileInputStream(path);
		HSSFWorkbook workbook = new HSSFWorkbook(fileinput);
		HSSFSheet sheet = workbook.getSheet("login");
		int rowsize = sheet.getLastRowNum();
	    int colsize =sheet.getRow(1).getLastCellNum();
		
	    String[][] signupdata = new String[rowsize][colsize];
	    
		for(int i=0; i<rowsize; i++) {
			HSSFRow row = sheet.getRow(i);
			String value = null;  // or String value = " ";
			for(int j=0; j<colsize; j++) {
				HSSFCell cell = row.getCell(j);
		        switch(cell.getCellType()){
		        	case Cell.CELL_TYPE_STRING :
		        		value=cell.getStringCellValue();
		        		break;
		        	case Cell.CELL_TYPE_NUMERIC:
		        		int data =(int) cell.getNumericCellValue(); //or Object data = cell.getNumericCellValue();
		        		value= String.valueOf(data);
		        		break;
		        }
		        signupdata[i][j]=value;
		        System.out.print(value+" ");
			}
		}
		return signupdata;
		
	}

}
