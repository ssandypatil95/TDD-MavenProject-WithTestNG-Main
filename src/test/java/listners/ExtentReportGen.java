package listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGen {
	static ExtentReports extent ;
	public static ExtentReports extentReportGenerator() 
	{
		String path = System.getProperty("user.dir")+"//reports//InsuranceReport.html";
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		
		reporter.config().setTheme(Theme.DARK);
		
		reporter.config().setReportName("Policy Bazaar Report");
		
		
		extent = new ExtentReports();                // globally defined with static keyword
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Project Name", "Policy Bazaar");
		
		extent.setSystemInfo("Environment", "SIT");
		
		extent.setSystemInfo("Executed By", "S.Patil");
		
		return extent;
	}

}
