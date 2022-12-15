
	package practice;

	import org.testng.Assert;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.safezoo.genericUtility.ThreadSafe;
import com.safezoo.genericUtility.WebDriverUtility;

	public class TestBaseClass{
		
		@BeforeSuite(groups="baseclass", alwaysRun=true)
		public void test1()
		{
			System.out.println(Thread.currentThread().getId()+"BeforeSuite");
		}
		
		@BeforeTest(groups="baseclass", alwaysRun=true)
		public void test2()
		{
			System.out.println(Thread.currentThread().getId()+"Beforesuite");
		}
		//@Parameters("BROWSER")
		@BeforeClass(groups="baseclass", alwaysRun=true)
		public void ClassSetup()
		{
			//ThreadSafe 
			System.out.println(Thread.currentThread().getId()+"Before Class");
			WebDriverUtility webdriverutility=new WebDriverUtility();
			ThreadSafe.setWebdriverutility(webdriverutility);
			webdriverutility.launchApplication("chrome", 10, "https://www.google.co.in/");
			
		}
		
		@BeforeMethod(groups="baseclass", alwaysRun=true)
		public void test4()
		{
			System.out.println(Thread.currentThread().getId()+"BeforeMethod");
			
		}
		
		
		
		@AfterMethod(groups="baseclass", alwaysRun=true)
		public void test6()
		{
			System.out.println(Thread.currentThread().getId()+"AfterMethod");
		}
		
		@AfterClass(groups="baseclass", alwaysRun=true)
		public void test7()
		{
			System.out.println(Thread.currentThread().getId()+"AfterClass");
		}
		
		@AfterTest(groups="baseclass", alwaysRun=true)
		public void test8()
		{
			System.out.println(Thread.currentThread().getId()+"AfterTest");
		}
		@AfterSuite(groups="baseclass", alwaysRun=true)
		public void test9()
		{
			System.out.println(Thread.currentThread().getId()+"Aftersuite");
		}
		
		
		
		
		
		
	}


