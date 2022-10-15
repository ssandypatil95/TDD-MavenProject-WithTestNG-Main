package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SelectCityAndSelectIdPage;
import pages.SelectInsurerPage;
import pages.SelectProductPage;
import utility.ReadDataFromConfigProperties;

public class BaseTest {
   public static WebDriver driver;
	SelectProductPage lp;
	SelectInsurerPage si;
	SelectCityAndSelectIdPage sc;
	@BeforeSuite
	public void initBrowser() throws IOException 
	{
//      System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//chrome//chromedriver.exe");
//	    System.setProperty("webdriver.chrome.driver","D:\\Software\\Java Selenium\\chromedriver_win32\\chromedriver.exe");
   
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
//		options.addArguments("--incognito");
		
//		options.addArguments("--start-maximized");
		
//		options.addArguments("--headless");
		
//		options.addArguments("--disable-notifications");
		
		
        driver=new ChromeDriver(options);  
		
        driver.manage().window().maximize();                                
        
//	    driver.get("https://www.policybazaar.com/");            	

        driver.get(ReadDataFromConfigProperties.getProData("testsiteurl"));
	}
	
	@BeforeClass
	public void creatObject() 
	{
		lp = new SelectProductPage(driver);
		
		si = new SelectInsurerPage(driver);
		
		sc = new SelectCityAndSelectIdPage(driver);
	}
	
		
	@AfterSuite
	public void tearDown() 
	{
		driver.quit();
	}
	
	

}
