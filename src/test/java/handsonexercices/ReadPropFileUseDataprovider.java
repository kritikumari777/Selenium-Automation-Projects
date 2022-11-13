package handsonexercices;

import org.testng.annotations.Test;

import util.DataProvider;

public class ReadPropFileUseDataprovider {

@Test
public void testReadFromPropFile() {
	String propfile="src\\test\\resources\\base.prop";
	String propName="searchParam";
	
	String value=DataProvider.getTestData(propfile, propName);
	System.out.println(value);
	System.out.println(DataProvider.getTestData(propfile, "timeout"));
}
}
