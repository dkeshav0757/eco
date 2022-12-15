package com.safzoo.NormalTicket;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.safezoo.ObjectRefository.AdminPage;
import com.safezoo.ObjectRefository.HomePage;
import com.safezoo.ObjectRefository.LoginPage;
import com.safezoo.ObjectRefository.addNormalZooTicket;
import com.safezoo.ObjectRefository.commonPage;
import com.safezoo.genericUtility.BaseClass;
import com.safezoo.genericUtility.ExcelUtility;
import com.safezoo.genericUtility.FileUtility;
import com.safezoo.genericUtility.IConstuntPath;
import com.safezoo.genericUtility.JavaUtility;
import com.safezoo.genericUtility.PropertyFileKeys;
import com.safezoo.genericUtility.SheetName;
import com.safezoo.genericUtility.WebDriverUtility;

public class NormalTicketPrintTest extends BaseClass {

	@Test
	public void NormalTicketPrint(String[] args) throws AWTException, IOException {
		
		/** read test data */
		String VisitorName=excelutility.getDataFromExcel( SheetName.NORMALTICKET.ConverToString(),2,1);
		String NoOfAdults=excelutility.getDataFromExcel(SheetName.NORMALTICKET.ConverToString(),2,2);
		String NoOfChildrens=excelutility.getDataFromExcel(SheetName.NORMALTICKET.ConverToString(),2,3);
		
		/** step:2 enetr the ticket details */
		comonpage.NormalTicketDetails();
		addnormalzooticket.clickaddNormalZooTicket();
		addnormalzooticket.enterOnVisitorNameTextField(VisitorName);
		addnormalzooticket.enterNoOfAdultsTextField(NoOfAdults);
		addnormalzooticket.NoOfChildrensTextField(NoOfChildrens);
		addnormalzooticket.clickOnSubmitButton();
		webdriverUtility.acceptAlert();
		
		/** step:3  print the ticket*/
		comonpage.NormalTicketDetails();
		comonpage.clickonprintbutton();
		webdriverUtility.robotclass(driver, timeout);
		
		/** step6:Logout the admin */
		//comonpage.LogoutAction();


	}

}

