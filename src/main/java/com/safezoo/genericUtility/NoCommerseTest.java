package com.safezoo.genericUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NoCommerseTest {
	
	
	public void setExtent() {
		//public ExtentReporter report;
		
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Reporter Name");
		spark.config().setTheme(Theme.DARK);
		
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating System", "Windows 10");
		report.setSystemInfo("Browser name", "chrome");
		report.setSystemInfo("Browser version", "108.0.5359.99");
		report.setSystemInfo("Reporter Name", "Keshav d");
	}

}
