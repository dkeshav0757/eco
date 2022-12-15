package com.safezoo.ManageTicketType;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.safezoo.ObjectRefository.EditAnimalPage;
import com.safezoo.ObjectRefository.ManageType;
import com.safezoo.ObjectRefository.MnageAnimals;
import com.safezoo.ObjectRefository.SearchForgnierTicket;
import com.safezoo.ObjectRefository.SearchNomalTicket;
import com.safezoo.ObjectRefository.addAnimal;
import com.safezoo.ObjectRefository.addForgnerZooTicket;
import com.safezoo.ObjectRefository.commonPage;
import com.safezoo.genericUtility.BaseClass;
import com.safezoo.genericUtility.IConstuntPath;
import com.safezoo.genericUtility.SheetName;
		@Listeners(com.safezoo.genericUtility.ListnerImplimentationClass.class)
			public class ManageTypeTicket extends BaseClass {
			
			@Test
			public void AddAnimal() throws InterruptedException {
			
				
			/** read the test data*/
			String AnimalName=excelutility.getDataFromExcel( SheetName.ANIMAL.ConverToString(),2,1);
			String CageNumber=excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,2);
			String FeedNumber=excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,3);
			String Breed=excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,4);
			String Description = excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,4);
			String VisitorName=excelutility.getDataFromExcel( SheetName.SEARCHF.ConverToString(),2,1);
			String NoOfAdults=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,2);
			String NoOfChildrens=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,3);
			String ExpectedName=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,4);
			String price=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,5);
			
			/** Step2:click on animal Details module and click on add animal module*/
			commonPage comonpage=new commonPage(driver);
			addAnimal addanimal=new addAnimal(driver);
			addForgnerZooTicket	addforginerzooticket=new addForgnerZooTicket(driver);
			SearchForgnierTicket searchforgnerticket=new SearchForgnierTicket(driver);
			SearchNomalTicket searchnormalticket=new SearchNomalTicket(driver);
			comonpage.clickOnAnimalDetails();
			addanimal.clickOnAddAnimal();
		
			/** Step2:Eneter Animal datails */
			addanimal.enterAnimalName(AnimalName);
			File f1=new File(IConstuntPath.IMAGE_PATH);
			String absolutepath = f1.getAbsolutePath();
			addanimal.addImage(absolutepath);
			addanimal.enterCageNumber(CageNumber);
			addanimal.eneterFeedNumber(FeedNumber);
			addanimal.eneterBreedName(Breed);
			addanimal.eneterDiscription(Description);
			addanimal.clickOnsubmitButton();
			webdriverUtility.acceptAlert();
			
			/**step3:click on manage animal */
			MnageAnimals manageanimals=new MnageAnimals(driver);
			comonpage.clickOnAnimalDetails();
			manageanimals.clickOnmanageAnimalButton();
			EditAnimalPage editanimal=new EditAnimalPage(driver);
		    String ActualCageNo = manageanimals.gettextOfManageAnimals(CageNumber).getText();
			String ExpectecageNo =CageNumber;
	
			 /**step4:verify that animal is added or not */
			SoftAssert softAssert=new SoftAssert(); 
		   softAssert.assertEquals(ActualCageNo, ExpectecageNo);
		   //Assert.fail();
		   editanimal.clickOnEditButton();
			System.out.println("animal added sucessfully added--->Testcase pass");
			/** step: Edit the animal details*/
			editanimal.clickOneditanimalName(AnimalName);
			editanimal.clickOnAnimalDiscripn(Description);
			editanimal.clickOnSubmitButton();
			webdriverUtility.acceptAlert();
			Thread.sleep(10000);
			ManageType managetype=new ManageType(driver);
			managetype.manageAnimalType();
			managetype.Edditbutton();
			managetype.eneterforignerTicketprice(price);
			managetype.Savebutton();
			webdriverUtility.acceptAlert();
			
			/** step6: Logout the Action */
			//comonpage.LogoutAction();
			softAssert.assertAll();
			}
			
	}
				
			

