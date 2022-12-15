package com.safezoo.ObjectRefository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']/ul/li/a[text()='Admin']") private WebElement AdminButton;
	
	public AdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to click On AdminButton
	 */
	public void clickOnAdminButton()
	{
		AdminButton.click();
	}

}
