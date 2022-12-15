package com.safezoo.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

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

	   public class BaseClass {
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
	   
	   //public static WebDriver edriver;
	
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
		public void methodTearDown()
		{
	    comonpage=new commonPage(driver);
		comonpage.LogoutActionAdmin();
		comonpage.LogoutActionLog();
		comonpage.LogoutActionHomepg();
		//SoftAssert softAssert=new SoftAssert(); 
		//softAssert.assertAll();
		}
	
	
}
	
