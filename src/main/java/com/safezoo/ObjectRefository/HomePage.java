package com.safezoo.ObjectRefository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText="Back Home!!") private WebElement homePageTab;
	
	
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	/**
	 * This method is used to click home PageTab
	 */
	
	public void clickhomePageTab()
	{
		homePageTab.click();
	}

}
