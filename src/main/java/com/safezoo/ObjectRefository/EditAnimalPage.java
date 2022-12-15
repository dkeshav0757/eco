package com.safezoo.ObjectRefository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAnimalPage {
	
	
	@FindBy(xpath="//input[@id='aname']") private WebElement editanimalName;
	@FindBy(xpath="//input[@id='desc']") private WebElement AnimalDiscrip ;
	@FindBy(xpath="//button[text()='Update']") private WebElement SubmitButton ;
	@FindBy(xpath="//table/tbody/tr/td[5]/a[text()='Edit']") private WebElement EditlButton ;
	
	public EditAnimalPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnEditButton()
	{
		EditlButton.click();
		
	}
	/**
	 * This method is used to click On EditAnimal
	 */
	public void clickOneditanimalName(String AnimalName)
	{
		editanimalName.sendKeys(AnimalName);
		
	}
	/**
	 * This method is used to click On updateButton
	 */
	public void clickOnAnimalDiscripn(String descrtiption)
	{
		AnimalDiscrip.sendKeys(descrtiption);
		
	}
	public void clickOnSubmitButton()
	{
		SubmitButton.click();
		
	}
}
