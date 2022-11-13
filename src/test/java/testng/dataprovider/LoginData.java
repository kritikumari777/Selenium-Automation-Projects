package testng.dataprovider;

import org.testng.annotations.DataProvider;
public class LoginData {
	
@DataProvider(name="user-password")

public Object[][] data() {
	Object[][] userdata = {{"123kritikumari@gmail.com", "12345", "Valid"},
	{"123kritikumari@gmail.com", "123", "Invalid"},
	{"kritikumari", "3452", "Invalid"}};
    
	return userdata;
 }

}
