package com.safezoo.ObjectRefository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchForgnierTicket {
	private WebDriver driver;
	

	
	@FindBy(linkText="Foreigner Ticket Search") private WebElement ForgnerTicketsSearchTab;
	@FindBy(id="searchdata") private WebElement SearchdataTextField;
	@FindBy(name="search") private WebElement searchButton;
	String partialxpath="//td[text()='%s']";
		
	 public SearchForgnierTicket(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}	
     public WebElement gettextOfForignerTicket(String replacedata) {
		
		String xpath=String.format(partialxpath, replacedata);
		return driver.findElement(By.xpath(xpath));
	}
		
     
    
		/**
		 * @keshav k
		 * This method is used to click On SearchForgnerTickets Tab
		 */
		
		public void clickSearchForgnerTicketsTab()
		{
			ForgnerTicketsSearchTab.click();
		}
		/**
		 * This method is used to click On SearchData TextField
		 */
		public void SearchDataTextField(String Fid)
		{
			SearchdataTextField.sendKeys(Fid);
		}
		/**
		 * This method is used to click On SearchButton
		 */
		public void clickSearchButton()
		{
			searchButton.click();
		}
		/**
		 * This method is used to get Text Of ForignerTicket
		 */

		/**public String getTextOfForignerTicket() {
			String ActualName = gettextOfForignerTicket.getText();
			return ActualName;
			
		}
		*/
	}
	

