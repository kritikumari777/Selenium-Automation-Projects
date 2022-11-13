package testng;

import org.testng.annotations.Test;


public class TestClassFour_group {

@Test(priority=1, groups= {"Regession"})
public void TestOne(){
	System.out.println("TestOne");
}
  
@Test(priority=2, groups= {"Regession","Sanity"})
public void TestTwo() {
	System.out.println("TestTwo");
}

@Test(priority=3, groups= {"Regession"})
public void Testthree() {
	System.out.println("TestThree");
}

@Test(priority=4, groups= {"Sanity"})
public void TestFour() {
	System.out.println("Testfour");
}

}