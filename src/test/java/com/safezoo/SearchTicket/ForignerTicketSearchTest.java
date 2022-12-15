package com.safezoo.SearchTicket;
import java.io.IOException;
import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.safezoo.ObjectRefository.AdminPage;
import com.safezoo.ObjectRefository.EditAnimalPage;
import com.safezoo.ObjectRefository.HomePage;
import com.safezoo.ObjectRefository.LoginPage;
import com.safezoo.ObjectRefository.MnageAnimals;
import com.safezoo.ObjectRefository.SearchForgnierTicket;
import com.safezoo.ObjectRefository.SearchNomalTicket;
import com.safezoo.ObjectRefository.addAnimal;
import com.safezoo.ObjectRefository.addForgnerZooTicket;
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
@Listeners(com.safezoo.genericUtility.ListnerImplimentationClass.class)
		public class ForignerTicketSearchTest  extends BaseClass{

		   @Test
			public  void SearchForignerTicket () throws InterruptedException
		   {
			
			   commonPage comonpage=new commonPage(driver);
			   addForgnerZooTicket	addforginerzooticket=new addForgnerZooTicket(driver);
			   SearchForgnierTicket searchforgnerticket=new SearchForgnierTicket(driver);
			   SearchNomalTicket searchnormalticket=new SearchNomalTicket(driver);
			
			/** read the test data */	
			String VisitorName=excelutility.getDataFromExcel( SheetName.SEARCHF.ConverToString(),2,1);
			String NoOfAdults=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,2);
			String NoOfChildrens=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,3);
			String ExpectedName=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,4);
			
			/** step2:Enter the ticket details */
			comonpage.clickForeignersTicketModule();
			addforginerzooticket.clickaddForgnerTicketsTab();
			addforginerzooticket.enterOnVisitorNameTextField(VisitorName);
			addforginerzooticket.enterNoOfAdultsTextField(NoOfAdults);
			addforginerzooticket.NoOfChildrensTextField(NoOfChildrens);
			addforginerzooticket.clickOnSubmitButton();
			webdriverUtility.acceptAlert();
			
			/** step3:	get the data from generated ticket */
				String ExpectedIdFid =addforginerzooticket.getTextoFId();
			    System.out.println(ExpectedIdFid);
				comonpage.clickonsearchModule();
				searchforgnerticket.clickSearchForgnerTicketsTab();
				searchforgnerticket.SearchDataTextField(ExpectedIdFid);
				searchforgnerticket.clickSearchButton();
				WebElement Actualticket = searchforgnerticket.gettextOfForignerTicket(ExpectedIdFid);
				String actualTicketid = Actualticket.getText();
				if(actualTicketid.equals(ExpectedIdFid))
				{
					System.out.println("Ticket found---->Testcase pass");
				}
				else
				{
					System.out.println("Ticket Notfound---->Testcase Fail");
				}

			}
		}

