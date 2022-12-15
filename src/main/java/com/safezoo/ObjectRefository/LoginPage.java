package com.safezoo.ObjectRefository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	
	@FindBy(id="username") private WebElement usernameTextField;
	@FindBy(id="password") private WebElement passwordTextField;
	@FindBy(xpath="//button[@id='form_submit']") private WebElement submitButton;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 * This method is used to do Login
	 */
	
	public void LoginDetailsusname(String username)
	{
		
		usernameTextField.sendKeys(username);
	}
	public void LoginDetailspaswd(String password)
	{
		
		passwordTextField.sendKeys(password);
		
	}
	public void LoginDetailssend()
	{
		
		submitButton.click();
	}
}
	
