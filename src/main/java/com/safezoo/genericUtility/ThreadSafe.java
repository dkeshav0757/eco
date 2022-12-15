package com.safezoo.genericUtility;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {
	
	private static ThreadLocal<WebDriverUtility> webdriverutility=new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> ExtentTest=new ThreadLocal<>();

	/**
	 * This method is used to get the data
	 * @return the webdriverutility
	 */
	public static WebDriverUtility getWebdriverutility() {
		return webdriverutility.get();
	}

	/**
	 * This method is used to set the data
	 * @param webdriverutility the webdriverutility to set
	 */
	public static void setWebdriverutility(WebDriverUtility swebdriverutility) {
		webdriverutility.set(swebdriverutility);
	}
	
	public static ExtentTest getExtentTest() {
		return ExtentTest.get();
	}
	/**
	 * 
	 */
	public static void setExtentTest(ExtentTest sExtentTest) {
		ExtentTest.set(sExtentTest);
	}
	
}
