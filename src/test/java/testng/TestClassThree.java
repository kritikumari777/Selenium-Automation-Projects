package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestClassThree {

@Test
public void TestOne(){
	System.out.println("TestOne");
}
  
@Test
public void TestTwo() {
	System.out.println("TestTwo");
}
@BeforeMethod
public void BeforeMethod() {
	System.out.println("BeforeMethod");
}

@AfterMethod
public void AfterMethod() {
	System.out.println("BeforeMethod");
}

@BeforeClass
public void BeforeClass() {
	System.out.println("BeforeClass");
}

@AfterClass
public void AfterClass() {
	System.out.println("AfterClass");	
}

}