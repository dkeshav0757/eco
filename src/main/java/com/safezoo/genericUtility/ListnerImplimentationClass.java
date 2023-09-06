package com.safezoo.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentationClass implements ITestListener {
	private ExtentTest test;
	private ExtentReports report;
	private WebDriverUtility WebDriverutiity;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestStart");
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"is passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result)  {
		WebDriverutiity=new WebDriverUtility();
		
        test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
        test.log(Status.FAIL, result.getThrowable());
		try {
			String path = WebDriverutiity.takeScreenshot(BaseClass.staticDriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	WebDriverutiity=new WebDriverUtility();
		
        test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
        test.log(Status.SKIP, result.getThrowable());
		try {
			String path = WebDriverutiity.takeScreenshot(BaseClass.staticDriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {
System.out.println("on start");
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./Extent_Reports/Report.html");
		spark.config().setDocumentTitle("Report");
		spark.config().setReportName("Keshav");
		spark.config().setTheme(Theme.DARK);
		
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating System", "Windows 10");
		report.setSystemInfo("Browser name", "chrome");
		report.setSystemInfo("Browser version", "108.0.5359.99");
		report.setSystemInfo("Reporter Name", "Keshav d");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//ExtentReports report = new ExtentReports();
		System.out.println(Thread.currentThread().getId()+"onTestFinish");
		report.flush();	
		// TODO Auto-generated method stub
		
	}
	
}