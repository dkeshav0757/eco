package com.safezoo.genericUtility;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.safezoo.ObjectRefository.AdminPage;
import com.safezoo.ObjectRefository.EditAnimalPage;
import com.safezoo.ObjectRefository.HomePage;
import com.safezoo.ObjectRefository.LoginPage;
import com.safezoo.ObjectRefository.MnageAnimals;
import com.safezoo.ObjectRefository.SearchForgnierTicket;
import com.safezoo.ObjectRefository.SearchNomalTicket;
import com.safezoo.ObjectRefository.addAnimal;
import com.safezoo.ObjectRefository.addForgnerZooTicket;
import com.safezoo.ObjectRefository.addNormalZooTicket;
import com.safezoo.ObjectRefository.commonPage;

	   public class BaseClass    {
	   protected WebDriver driver;
	   protected JavaUtility javautility;
	   protected ExcelUtility excelutility;
	   protected FileUtility fileUtility;
	   protected WebDriverUtility webdriverUtility;
	   protected addAnimal addanimal;
	   protected MnageAnimals manageanimals;
	   protected LoginPage loginpage;
	   protected commonPage comonpage;
	   protected AdminPage adminpage;
	   protected EditAnimalPage editanimal;
	   protected HomePage homepage;
	   protected WebDriverWait wait;
	   protected int randomNumber;
	   protected addForgnerZooTicket addforginerzooticket;
	   protected addNormalZooTicket addnormalzooticket;
	   protected SearchForgnierTicket searchforgnerticket;
	   protected SearchNomalTicket searchnormalticket;
	   protected long timeout;
	   
	   //
		public static WebDriver staticDriver;
		public static ExtentReports report;
		public static ExtentTest test;
	   
	   //public static WebDriver edriver;
	   @BeforeSuite
		public void configBS() {
		    File file = new File(".\\ExtentReport\\report.html");
			ExtentSparkReporter htmlReport=new ExtentSparkReporter(file);				
	        htmlReport.config().setDocumentTitle("Extent Report");
	        htmlReport.config().setTheme(Theme.DARK);
	        htmlReport.config().setReportName("Functional Test");
	         report=new ExtentReports();
            report.attachReporter(htmlReport);
	        report.setSystemInfo("TestURL", "https://example.com");
	        report.setSystemInfo("Platform", "Windows 10");
	        report.setSystemInfo("Reporter Name", "Nithesh");
		}
	
		@BeforeClass
		public void classSetup() {
	
		/** objects of generic utility*/
		javautility=new JavaUtility();
		excelutility=new ExcelUtility();
		fileUtility = new FileUtility();
		webdriverUtility=new WebDriverUtility();
		
		
		/** objects of pom classes*/
		
		comonpage=new commonPage(driver);
		addforginerzooticket=new addForgnerZooTicket(driver);
		searchforgnerticket=new SearchForgnierTicket(driver);
		searchnormalticket=new SearchNomalTicket(driver);
		
		/** read common data */
		fileUtility.openPropertyFile(IConstuntPath.PROPERTY_FILE_PATH);
		
		String browser=fileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url=fileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString());
		String randomNumberLimit = fileUtility.getDataFromPropertyFile(PropertyFileKeys.RANDOMNMBERLIMIT.convertToString());
		long timeout = (Long)javautility.stringToAnyDataType(fileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString()),"long");
		int randomNumber = javautility.getRandomNumber((Integer)javautility.stringToAnyDataType(randomNumberLimit,"int"));
		
		
		/** open the excel file*/
		excelutility.openExcel(IConstuntPath.EXCEL_PATH);
		
		/** intililize the Browser*/
		driver=webdriverUtility.launchApplication(browser,timeout,url);
		staticDriver=driver;
		//edriver=driver;
		
		wait = new WebDriverWait(driver,(Long) timeout);
		}
	
		/** Login the application*/
		@BeforeMethod
		public void methodSetup()
		{
		adminpage=new AdminPage(driver);
		loginpage=new LoginPage(driver);
		String username=fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.convertToString());
		String password=fileUtility.getDataFromPropertyFile(PropertyFileKeys.PASSWORD.convertToString());
		adminpage.clickOnAdminButton();
		loginpage.LoginDetailsusname(username);
		loginpage.LoginDetailspaswd(password);
		loginpage.LoginDetailssend();
		
		}
	
		/** Logout the application*/
		@AfterMethod
		public void tearDown(ITestResult result) 
		{
	    comonpage=new commonPage(driver);
		comonpage.LogoutActionAdmin();
		comonpage.LogoutActionLog();
		comonpage.LogoutActionHomepg();
		
		
		if(result.getStatus()==ITestResult.FAILURE) {
		   test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		   test.log(Status.FAIL, result.getThrowable());
			try {
				WebDriverUtility WebDriverutiity=new WebDriverUtility();
				String path = WebDriverutiity.takeScreenshot(BaseClass.staticDriver, result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(path);
			} catch (Throwable e) {
					
				e.printStackTrace();
				}
				
			}
			else if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");				
			    test.log(Status.SKIP, result.getThrowable());
			}
			
			driver.close();
		}
		}
	   
	  
	
