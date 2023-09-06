package com.safezoo.ObjectRefository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.safezoo.genericUtility.WebDriverUtility;

public class Amazone{
	
	
	@FindBy(xpath="//select[@id='searchDropdownBox']") private WebElement select;

	
	
	public Amazone(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method is used to do Login
	 */
	
	public void getselect(WebElement list)
	{
		select.
		Select s=new Select(list);
		s.selectByIndex(0);
		return;
		
	}

}
	
