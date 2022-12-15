package com.safezoo.ObjectRefository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageType {
	@FindBy(xpath="//span[contains(text(),'Manage Type Ticket')]") private WebElement manageanimalType;
	@FindBy(xpath="//td[text()='Foreigner Adult']/following-sibling::td/following-sibling::td/a[text()='Edit']") private WebElement edditbutton;
	@FindBy(name="tprice") private WebElement eneterforignerTicketprice;
	@FindBy(xpath="//button[text()='Update']") private WebElement savebutton;
	
	/**
	 * used to initilize the elements
	 * @param driver
	 */
	public ManageType(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method is used to click on AddAnimal Module
	 */
	public void manageAnimalType()
	{
		manageanimalType.click();
	}
	/**
	 * This method is used to enterAnimalName
	 */
	
	public void Edditbutton()
	{
		edditbutton.click();
	}
	/**
	 * This method is used to addImage
	 */
	
	public void eneterforignerTicketprice(String price)
	{
		eneterforignerTicketprice.sendKeys(price);
	}
	/**
	 * This method is used to enterCageNumbe
	 */
	
	public void Savebutton()
	{
		savebutton.click();
	}

	

}
