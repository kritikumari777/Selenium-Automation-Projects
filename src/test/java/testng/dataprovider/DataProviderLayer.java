package testng.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderLayer {

	@DataProvider(name="data-provider-1")
	public Object[][] firstDataProvider(){
		return new Object[][] {
			{"Tejashwin"},{"Nishath"},{"Sharad"},{"Priyanka"}};
			
		}
}
