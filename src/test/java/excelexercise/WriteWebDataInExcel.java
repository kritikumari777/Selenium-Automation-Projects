package excelexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.ExcelUtility;
import util.WebDriverManager;

public class WriteWebDataInExcel {

	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	
	@BeforeClass
	
	public void set() {
		webdrvmgr = new WebDriverManager();
		driver= webdrvmgr.launchBrowser("Chrome");
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
	}
	@Test
	
	public void Test() throws Exception {
		String path = "src\\test\\resources\\Population.xls";
		ExcelUtility excel = new ExcelUtility(path);
		String sneetName = "PopulationTable";
		// write header into excel sheet*/
		
		excel.SetCellValue(sneetName, 0, 0, "Contury");
		excel.SetCellValue(sneetName, 0, 1, "Containts");
		excel.SetCellValue(sneetName, 0, 2, "Population");
		excel.SetCellValue(sneetName, 0, 3, "Perofworld");
		excel.SetCellValue(sneetName, 0, 4, "Date");
		excel.SetCellValue(sneetName, 0, 5, "Source");
		excel.SetCellValue(sneetName, 0, 6, "Notic");
		
		WebElement table =driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody"));
		
		int totalrow = table.findElements(By.xpath("tr")).size();
		System.out.println(totalrow);
		
		/* String Beforxpath = "tr[";  ----------or==================
		   String Afterxpath = "]/td[2]"; */
		
		for(int r=1 ; r <=totalrow ; r++) {
			/*String actualxpath = Beforexpath+r+Afterxpath;  --------------or============
			String country = table.findElement(By.xpath(actualxpath)).getText();*/
			
			String country = table.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			String containts = table.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
			String population = table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			String perofworld = table.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
			String date = table.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
			String source = table.findElement(By.xpath("tr["+r+"]/td[6]")).getText();
			String notic = table.findElement(By.xpath("tr["+r+"]/td[7]")).getText();
			
			System.out.println(country+containts+population+perofworld+date+source+notic);
			
			excel.SetCellValue(sneetName, r, 0, country);
			excel.SetCellValue(sneetName, r, 1, containts);
			excel.SetCellValue(sneetName, r, 2, population);
			excel.SetCellValue(sneetName, r, 3, perofworld);
			excel.SetCellValue(sneetName, r, 4, date);
			excel.SetCellValue(sneetName, r, 5, source);
			excel.SetCellValue(sneetName, r, 6, notic);	
			
		}
		
		System.out.println("data entered in excel sheet secessfully");
	}
	@AfterClass
	public void sutdown() {
		driver.quit();
	}
	
}
