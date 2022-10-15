package listners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testClasses.BaseTest;
import utility.Screenshot;

public class TestNGListners extends BaseTest implements ITestListener {
	
	ExtentReports extent = ExtentReportGen.extentReportGenerator();
	
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
//		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		test = extent.createTest(result.getName()); 
		
		System.out.println("Test case "+result.getMethod().getMethodName()+" has been started");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{		
		System.out.println("Test case "+result.getMethod().getMethodName()+" has been passed");

		test.log(Status.PASS, "Test case has been Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{	
		System.out.println("Test case "+result.getMethod().getMethodName()+" has been failed");
		
		test.fail(result.getThrowable());
		

		try {
			
			  test.addScreenCaptureFromPath(Screenshot.captureScreenshotWithPath(driver, result.getMethod().getMethodName()));
			
//			  Screenshot.captureScreenshot(driver,result.getMethod().getMethodName());
		    } 
		catch (IOException e)
		    {
			
		    }
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{		
		System.out.println("Test case "+result.getMethod().getMethodName()+" has been skipped");
	
		test.log(Status.SKIP, "Test case has been Skipped");	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
	
	}

	@Override
	public void onStart(ITestContext context) 
	{
	    System.out.println("Test tag "+context.getName()+" has been started");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
	    System.out.println("Test tag "+context.getName()+" has been finished");

	    extent.flush();
	}
	
	

}
