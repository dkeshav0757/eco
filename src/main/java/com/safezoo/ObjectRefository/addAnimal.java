package com.safezoo.ObjectRefository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addAnimal {
	@FindBy(xpath="//a[text()='Add Animals']") private WebElement AddAnimalButton;
	@FindBy(id="aname") private WebElement animalnameTextField;
	@FindBy(id="image") private WebElement addImageTextField;
	@FindBy(id="cnum") private WebElement cageNumberTextField;
	@FindBy(id="fnum") private WebElement feedNumberTextField;
	@FindBy(id="breed") private WebElement breedNameTextField;
	@FindBy(id="desc") private WebElement DiscripttionTextFiled;
	@FindBy(xpath="//button[@name='submit']") private WebElement submitButton;
	
	/**
	 * used to initilize the elements
	 * @param driver
	 */
	public addAnimal(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method is used to click on AddAnimal Module
	 */
	public void clickOnAddAnimal()
	{
		AddAnimalButton.click();
	}
	/**
	 * This method is used to enterAnimalName
	 */
	
	public void enterAnimalName(String AnimalName)
	{
		animalnameTextField.sendKeys(AnimalName);
	}
	/**
	 * This method is used to addImage
	 */
	
	public void addImage(String absolutepath)
	{
		addImageTextField.sendKeys(absolutepath);
	}
	/**
	 * This method is used to enterCageNumbe
	 */
	
	public void enterCageNumber(String CageNumber)
	{
		cageNumberTextField.sendKeys(CageNumber);
	}
	/**
	 * This method is used to enter FeedNumber
	 */
	public void eneterFeedNumber(String FeedNumber)
	{
		feedNumberTextField.sendKeys( FeedNumber);
	}
	/**
	 * This method is used to enter BreedName
	 */
	public void eneterBreedName(String Breed)
	{
		breedNameTextField.sendKeys(Breed);
	}
	/**
	 * This method is used to enter Description
	 */
	
	public void eneterDiscription(String Description)
	{
		DiscripttionTextFiled.sendKeys(Description);
	}
	/**
	 * This method is used to click On submitButton
	 */
	public void clickOnsubmitButton()
	{
		submitButton.click();
	}
	

}
