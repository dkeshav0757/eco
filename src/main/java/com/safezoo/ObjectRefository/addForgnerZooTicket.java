package com.safezoo.ObjectRefository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addForgnerZooTicket {
	
	

	
	@FindBy(linkText="Add Ticket") private WebElement addForgnerTicketsTab;
	@FindBy(id="visitorname") private WebElement VisitorNameTextField;
	@FindBy(id="noadult") private WebElement NoOfAdultsTextField;
	@FindBy(id="nochildren") private WebElement NoOfChildrensTextField;
	@FindBy(name="submit") private WebElement SubmitButton;
	@FindBy(xpath="//h4[contains(text(),'Ticket ID:')]") private WebElement IdText;	
		
		public addForgnerZooTicket(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		/**
		 * This method is used to clickaddForgnerTicketsTab
		 */
		public void clickaddForgnerTicketsTab()
		{
			addForgnerTicketsTab.click();
		}
		/**
		 * This method is used to enterOnVisitorNameTextField
		 */
		public void enterOnVisitorNameTextField(String VisitorName)
		{
			VisitorNameTextField.sendKeys(VisitorName);
		}
		/**
		 * This method is used to enter No Of Adults TextField
		 */
		public void enterNoOfAdultsTextField(String NoOfAdults)
		{
			NoOfAdultsTextField.sendKeys(NoOfAdults);
		}
		/**
		 * This method is used to click addForgner TicketsTab
		 */

		public void NoOfChildrensTextField(String NoOfChildrens ) {
			NoOfChildrensTextField.sendKeys(NoOfChildrens);
			
		}
		/**
		 * This method is used to click On SubmitButton
		 */
		public void clickOnSubmitButton() {
			SubmitButton.click();
			
		}
		/**
		 * This method is used to getTextoFId
		 */
		public String getTextoFId() {
			String Fid = IdText.getText();
			String Str[]=Fid.split(" ");
			Fid=Str[2];
			return Fid;
		}
	}


	


