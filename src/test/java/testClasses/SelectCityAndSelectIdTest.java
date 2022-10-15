package testClasses;

import org.testng.annotations.Test;

public class SelectCityAndSelectIdTest extends BaseTest {
	
	@Test(priority = 5)
	public void validateCitySelection()
	{
		sc.selectCity();
	}
	
	@Test(priority = 6)
	public void validateEnterDetails() 
	{
		sc.enterDetails();
	}

}
