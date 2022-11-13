package testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPrividerExample {


@Test(dataProvider="data-provider-1", dataProviderClass=DataProviderLayer.class)
public void firstDataProviderTest(String input) {
	System.out.println(input);
}

@DataProvider(name="data-provider-2")
public Object[][] secondDataProvider(){
	return new Object[][] {
		{1,2},{3,4},{5,6}};
	}
@Test(dataProvider="data-provider-2")
public void secondDataProviderTest(int num1, int num2) {
	int sum=num1+num2;
	System.out.println(sum);
}
}

