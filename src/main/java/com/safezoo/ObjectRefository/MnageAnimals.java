package com.safezoo.ObjectRefository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MnageAnimals {
	private WebDriver driver;
	@FindBy(xpath="//a[text()='Manage Animals']") private WebElement manageAnimalButton;
	@FindBy(xpath="//h4[contains(text(),'Admin')]") private WebElement AdminModule;
	@FindBy(xpath="//table/tbody/tr/td[2]") private List<WebElement> ManageanimalTable;
	String partialxpath="//table/tbody/tr/td[text()='%s']";
	
	 public WebElement gettextOfManageAnimals(String replacedata) {
			
			String xpath=String.format(partialxpath, replacedata);
			return driver.findElement(By.xpath(xpath));
	 }
	
	public MnageAnimals(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to click On manageAnimalButton
	 */
	
	public void clickOnmanageAnimalButton()
	{
		manageAnimalButton.click();
	}
	/**
	 * This method is used to clickOnAdminModule
	 */
	
	public void clickOnAdminModule()
	{
		AdminModule.click();
	}
	/**
	 * This method is used to click on ManageanimalTable
	 */
	public List<WebElement> ManageanimalTable()
	{
		List<WebElement> allAnimalName = ManageanimalTable;
		return (List<WebElement>) allAnimalName;
	}
	

}
