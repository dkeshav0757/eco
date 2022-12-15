package com.safezoo.ObjectRefository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchNomalTicket {
	private  WebDriver driver;
	

	
	@FindBy(linkText="Normal Ticket Search") private WebElement NormalTicketsSearchTab;
	@FindBy(id="searchdata") private WebElement SearchdataTextField;
	@FindBy(name="search") private WebElement searchButton;
	@FindBy(linkText="View") private WebElement NoOfChildrensTextField;
//	@FindBy(xpath="//a[text()='View']") private WebElement gettextOfNormalTicket;
		String partialxpath="//td[text()='%s']";
		
		public SearchNomalTicket(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		public WebElement getNormalTicket(String replacedata)
		{
			 String xpath = String.format(partialxpath, replacedata);
			 return driver.findElement(By.xpath(xpath));
		}
		/**
		 * This method is used to click On SearchTicketsTab
		 */
		public void clickonSearchTicketsTab()
		{
			NormalTicketsSearchTab.click();
		}
		/**
		 * This method is used to click On SearchDataTextField
		 */
		public void SearchDataTextField(String GID)
		{
			SearchdataTextField.sendKeys(GID);
		}
		/**
		 * This method is used to click On searchButton
		 */
		public void clicksearchButton()
		{
			searchButton.click();
		}
		/**
		 * This method is used to enter No OfChildrens TextField
		 */

		public void NoOfChildrensTextField(String NoOfChildrens ) {
			NoOfChildrensTextField.sendKeys(NoOfChildrens);
			
		}
		/**
		 * This method is used to  get Text Of NormalTicket
		 */
	//	public String  getTextOfNID() {
		//	String ActualName = gettextOfNormalTicket.getText();
		//	return ActualName;
}