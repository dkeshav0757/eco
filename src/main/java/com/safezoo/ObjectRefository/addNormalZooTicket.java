package com.safezoo.ObjectRefository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addNormalZooTicket {
		
		@FindBy(linkText="Add Ticket") private WebElement addTicketsTab;
		@FindBy(id="visitorname") private WebElement VisitorNameTextField;
		@FindBy(id="noadult") private WebElement NoOfAdultsTextField;
		@FindBy(id="nochildren") private WebElement NoOfChildrensTextField;
		@FindBy(name="submit") private WebElement SubmitButton;
		@FindBy(xpath="//h4[contains(text(),'Ticket ID:')]") private WebElement NidIdText;
		
		
		public addNormalZooTicket (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		/**
		 * This method is used to click on addNormalZooTicket
		 */
		public void clickaddNormalZooTicket()
		{
			addTicketsTab.click();
		}
		/**
		 * This method is used to enter VisitorName TextField
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
		 * This method is used to No Of ChildrensTextField
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
		 * This method is used to click On Submit Button
		 */
		public String getTextoNId() {
			String Nid = NidIdText.getText();
			String Str[]=Nid.split(" ");
			Nid=Str[2];
			return Nid;
		}
	}


