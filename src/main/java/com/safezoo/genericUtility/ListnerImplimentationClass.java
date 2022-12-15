package com.safezoo.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentationClass implements ITestListener {
	//WebDriver edriver;
	private ExtentTest test;
	private ExtentTest test1;
	private ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestStart");
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test1.pass(result.getMethod().getMethodName()+"is passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result)  {
		System.out.println(Thread.currentThread().getId()+"onTestFailure");
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName()+"is failed");
		ThreadSafe.getExtentTest().fail(result.getThrowable());
		//String screenshot;
		try {
			String screenshot = ThreadSafe.getWebdriverutility().takeScreenshot(result.getMethod().getMethodName());
			ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"onTestFailure");
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName()+"is skipped");
		ThreadSafe.getExtentTest().fail(result.getThrowable());
		//String screenshot;
		try {
			String screenshot = ThreadSafe.getWebdriverutility().takeScreenshot(result.getMethod().getMethodName());
			ThreadSafe.getExtentTest().addScreenCaptureFromPath(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}
	/**String screenshot = result.getName();
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.edriver);
	File src = edriver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshot"+screenshot+".png");
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/

	@Override
	public void onStart(ITestContext context) {
		
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

	@Override
	public void onFinish(ITestContext context) {
		ExtentReports report = new ExtentReports();
		System.out.println(Thread.currentThread().getId()+"onTestFinish");
		report.flush();
		// TODO Auto-generated method stub
		
	}
	
}