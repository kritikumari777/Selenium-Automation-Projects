package util;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;

public class DataProvider {

	public static String getTestData(String propFile,String propName) {
		Properties props = new Properties();
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream(propFile);
			props.load(fis);
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("FAIL| Incorrect property fime or invalid key");
			
		}
		return props.getProperty(propName);
}
}
