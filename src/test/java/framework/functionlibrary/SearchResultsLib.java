package framework.functionlibrary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.pageobjects.SearchResultsPO;

public class SearchResultsLib {

	private WebDriver driver;
	private SearchResultsPO searespo;

	public SearchResultsLib(WebDriver driver) {
	 this.driver=driver;
	}
	public List<String>returnListOfProdNames(){
		searespo=new SearchResultsPO(driver);
		List<WebElement>prodList=searespo.returnProdList();
		List<String>prodNames=new ArrayList<String>();
		
		for(WebElement oelem: prodList) {
			String prodName=oelem.getText();
			prodNames.add(prodName);
		}
		return prodNames;
	}
}
