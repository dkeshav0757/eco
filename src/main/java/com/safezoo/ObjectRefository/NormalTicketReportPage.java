package com.safezoo.ObjectRefository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.safezoo.genericUtility.ExcelUtility;
import com.safezoo.genericUtility.IConstuntPath;
import com.safezoo.genericUtility.SheetName;

public class NormalTicketReportPage {
	private WebDriver driver;
	@FindBy(xpath="//span[text()='Reports']") private WebElement Reportbutton;
	@FindBy(xpath="//a[text()='Normal People Report']") private WebElement normalpeoplereportbutton;
	@FindBy(id="fromdate") private WebElement Fromdate;
	@FindBy(id="todate") private WebElement Todate;
	@FindBy(id="//button[text()='Submit']") private WebElement submitbutton;
	
	String partialxpath="//td[text()='%s']/following-sibling::td";
	
	
	/**
	 * used to initilize the elements
	 * @param driver
	 */
	public NormalTicketReportPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 
	public WebElement getreportOfNormalTicket(String replacedata) {
			
			String xpath=String.format(partialxpath, replacedata);
			return driver.findElement(By.xpath(xpath));
		}
	/**
	 * This method is used to click on AddAnimal Module
	 */
	public void clickReportbutton()
	{
		ExcelUtility excelutility=new ExcelUtility();
		
		excelutility.openExcel(IConstuntPath.EXCEL_PATH);
		String fdate=excelutility.getDataFromExcel( SheetName.ANIMAL.ConverToString(),2,1);
		String tdate=excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,2);
		
		Reportbutton.click();
		normalpeoplereportbutton.click();
		Fromdate.sendKeys(fdate);
		Todate.sendKeys(tdate);
		submitbutton.click();
	}
	

}
