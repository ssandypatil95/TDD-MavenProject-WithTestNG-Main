package testClasses;

import org.testng.annotations.Test;

public class SelectInsurerTest extends BaseTest {
	
	@Test(priority = 3)
	public void validateSelectInsurer() 
	{
		si.selectPerson();
	}
	
	@Test(priority = 4)
	public void validateselectAge()
	{
		si.selectAge();
	}

}
