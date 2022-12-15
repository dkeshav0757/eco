package practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportPractice {

	public static void main(String[] args) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Reporter Name");
		spark.config().setTheme(Theme.DARK);
		
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating System", "Windows 10");
		report.setSystemInfo("Browser name", "chrome");
		report.setSystemInfo("Browser version", "108.0.5359.99");
		report.setSystemInfo("Reporter Name", "Keshav d");
		
		ExtentTest test1 = report.createTest("test1");
		test1.info("This information comming from script");
		test1.warning("warning message");
		test1.fail("test fail");
		
		ExtentTest test2 = report.createTest("test2");
		test2.info("This information comming from script");
		test2.info("This information comming from script");
		test2.info("This information comming from script");
		
		ExtentTest test3 = report.createTest("test2");
		test3.info("This information comming from script");
		test3.info("This information comming from script");
		test3.info("This information comming from script");
		
		
		
		
		

	}

}
