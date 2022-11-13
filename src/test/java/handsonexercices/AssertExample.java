package handsonexercices;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExample {

@Test
public void testAssert(){
	Assert.assertTrue(true);
	Assert.assertEquals("Anamika", "Anamika");
	Assert.assertEquals("Ekka", "Ekka");
	Assert.assertEquals("Tester", "Tester");
	Assert.assertTrue(true);
}
@Test
public void softAssertTest() {
SoftAssert sf= new SoftAssert();
sf.assertTrue(true);
sf.assertEquals("Anamika", "Anamika");
sf.assertEquals("Ekka", "Ekka");
sf.assertEquals("Tester", "Tester");
sf.assertTrue(false);
sf.assertAll();

}
}
