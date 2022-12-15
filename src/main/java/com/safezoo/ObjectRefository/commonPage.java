package com.safezoo.ObjectRefository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class commonPage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Animals Details']") private WebElement AnimalDetailsTab;
	@FindBy(xpath="//span[text()='Normal Ticket']") private WebElement NormalTicketTab;
	@FindBy(id="form_submit") private WebElement ForignTicketTab;
	@FindBy(xpath="//span[text()='Foreigners Ticket']") private WebElement ForeignersTicketModule ;
	@FindBy(xpath="//h4[contains(text(),'Admin')] ") private WebElement adminModule ;
	@FindBy(linkText="Log Out") private WebElement LogoutButton ;
	@FindBy(linkText="Log Out") private WebElement printbutton ;
	@FindBy(linkText="Log Out") private WebElement cprintbutton ;
	@FindBy(xpath="//a[contains(text(),'Solutions')]") private WebElement solution ;
	@FindBy(xpath="//span[text()='Search']") private WebElement searchModule;
	@FindBy(linkText="Back Home!!") private WebElement homePageTab;
	
	//private String partialxpath= "//h4[@class='header-title']/../div/table/tbody/tr/td[.='\" +' %s'"
		//	+ "     + \"']/following-sibling::td[.='\" + '%%s' + \"']/following-sibling::td/a[.='Delete']";
	
	/**
	 * This method is used to clickOnAdminButton
	 */
	/**public WebElement stringToWebElement(String replaceData,String replaceData1)
	{
		String xpath1=String.format(partialxpath, replaceData,replaceData1);
		//String xpath2=String.format(partialxpath, replaceData1);
		
		return driver.findElement(By.xpath(xpath1));
		}
	*/
	
	/**
	 * This method is used to click On AdminButton
	 */
	public commonPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	/**
	 * This method is used to click On AnimalDetails
	 */
	public void clickOnAnimalDetails()
	{
		AnimalDetailsTab.click();
	}
	/**
	 * This method is used to click On NormalTicket Details
	 */
	public void NormalTicketDetails()
	{
		NormalTicketTab.click();
	}
	/**
	 * This method is used to click On ForignTicket
	 */
	public void ForignTicket()
	{
		ForignTicketTab.click();
	}
	/**
	 * This method is used to click on ForeignersTicket Module
	 */
	public void clickForeignersTicketModule() {
		ForeignersTicketModule.click();
		
	}
	/**
	 * This method is used to click on admin Module
	 */
	public void LogoutActionAdmin() {
		adminModule.click();
	}
	public void LogoutActionLog() {
		LogoutButton.click();
	}
	public void LogoutActionHomepg() {
		homePageTab.click();
	}
	
	/**
	 * This method is used to click On print button
	 */

	public  WebElement printbutton() {
		WebElement element = printbutton;
		return element;
	}
	/**
	 * This method is used to click on print button
	 */
	public  void clickonprintbutton() {
		cprintbutton.click();
	}
	/**
	 * This method is used to click on search Module
	 */
	public  void clickonsearchModule() {
		searchModule.click();
	}

}
