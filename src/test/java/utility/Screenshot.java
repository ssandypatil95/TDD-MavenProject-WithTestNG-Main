package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static String captureScreenshotWithPath(WebDriver driver,String filename) throws IOException
	{
        TakesScreenshot scrshot = (TakesScreenshot)driver;
		
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		
//		String path = "C:\\Users\\sande\\Pictures\\Screenshots\\"+filename+".png";
		// this path saved the screenshot in to the pc at c drive on particular location
		
//		String path = "C:\\Users\\sande\\eclipse-workspace\\A Java Selenium\\Screenshot\\"+filename+".png";
		// this path is our pc and saved the screenshot in to the "A java Selenium project" at "screenshot folder" on particular location

		String path = System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png";      
		//this path is directly ""project path+folder location+filename+extension"" ------------this type used in industry--------IMPORTANT-------------
		
		File destination = new File(path);
		
		FileHandler.copy(source, destination);           // calling this method from classname.methodname for the screenshot
	
		return path;
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	

	public static void captureScreenshot(WebDriver driver,String filename) throws IOException
	{
        TakesScreenshot scrshot = (TakesScreenshot)driver;
		
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		
//		String path = "C:\\Users\\sande\\Pictures\\Screenshots\\"+filename+".png";
		// this path saved the screenshot in to the pc at c drive on particular location
		
//		String path = "C:\\Users\\sande\\eclipse-workspace\\A Java Selenium\\Screenshot\\"+filename+".png";
		// this path is our pc and saved the screenshot in to the "A java Selenium project" at "screenshot folder" on particular location

		String path = System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png";      
		//this path is directly ""project path+folder location+filename+extension"" ------------this type used in industry--------IMPORTANT-------------
		
		File destination = new File(path);
		
		FileHandler.copy(source, destination);    		                    	// calling this method from classname.methodname for the screenshot
	}
	

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public static void main(String[] args) throws IOException  {
		System.setProperty("webdriver.chrome.driver","D:\\Software\\Java Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/signup");
		
		Screenshot.captureScreenshot(driver,"fbsignup1"); // method calling for the screenshot
		// calling this method anywhere of the project
	
	}
}
