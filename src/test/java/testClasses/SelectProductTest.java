package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utility.ReadDataFromConfigProperties;

public class SelectProductTest extends BaseTest {
	
	
	@Test(priority = 2)
	public void selectProductTest()
	{
		lp.clickonproduct();
		
		Assert.fail();
	}
	
	
	@Test(priority = 1,dependsOnMethods = "selectProductTest")
	public void validateTitle() 
	{
		String actual = lp.fetchTitle();
		
		String expected = "Insurance - Compare";
		
		boolean ispresent = actual.contains(expected);
		
		Assert.assertTrue(ispresent);
	}
}
 