package com.safezoo.SearchTicket;
import java.io.IOException;
import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.safezoo.ObjectRefository.AdminPage;
import com.safezoo.ObjectRefository.HomePage;
import com.safezoo.ObjectRefository.LoginPage;
import com.safezoo.ObjectRefository.SearchNomalTicket;
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

		public class NormalTicketSearchTest extends BaseClass{

		public  void main(String[] args) throws IOException, InterruptedException {
			
			/** read the test data */
			String VisitorName=excelutility.getDataFromExcel( SheetName.SEARCH.ConverToString(),2,1);
			String NoOfAdults=excelutility.getDataFromExcel(SheetName.SEARCH.ConverToString(),2,2);
			String NoOfChildrens=excelutility.getDataFromExcel(SheetName.SEARCH.ConverToString(),2,3);
			String ExpectedName=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,4);
			
			/** step2:Enter the ticket details */
			comonpage.NormalTicketDetails();
			addnormalzooticket.clickaddNormalZooTicket();
			addnormalzooticket.enterOnVisitorNameTextField(VisitorName);
			addnormalzooticket.enterNoOfAdultsTextField(NoOfAdults);
			addnormalzooticket.NoOfChildrensTextField(NoOfChildrens);
			
			addnormalzooticket.clickOnSubmitButton();
			webdriverUtility.acceptAlert();
				String ExpectedNid=addnormalzooticket.getTextoNId();
				comonpage.clickonsearchModule();
				searchnormalticket.clickonSearchTicketsTab();
				searchnormalticket.SearchDataTextField(ExpectedNid);
				searchnormalticket.clicksearchButton();
				WebElement ActualNID = searchnormalticket.getNormalTicket(ExpectedNid);
				
				if(ActualNID.equals(ExpectedNid))
				{
					System.out.println("Ticket found---->Testcase pass");				}
				else
				{
					System.out.println("Ticket Notfound---->Testcase Fail");
				}
				
			}
		}

