package com.safezoo.AddAnimal;

		import java.io.File;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.safezoo.ObjectRefository.AdminPage;
import com.safezoo.ObjectRefository.EditAnimalPage;
import com.safezoo.ObjectRefository.HomePage;
import com.safezoo.ObjectRefository.LoginPage;
import com.safezoo.ObjectRefository.MnageAnimals;
import com.safezoo.ObjectRefository.addAnimal;
import com.safezoo.ObjectRefository.commonPage;
import com.safezoo.genericUtility.BaseClass;
import com.safezoo.genericUtility.ExcelUtility;
import com.safezoo.genericUtility.FileUtility;
import com.safezoo.genericUtility.IConstuntPath;
import com.safezoo.genericUtility.JavaUtility;
import com.safezoo.genericUtility.ListnerImplimentationClass;
import com.safezoo.genericUtility.PropertyFileKeys;
import com.safezoo.genericUtility.SheetName;
import com.safezoo.genericUtility.WebDriverUtility;
@Listeners(com.safezoo.genericUtility.ListnerImplimentationClass.class)
			public class AddAnimalDetailsTest extends BaseClass {
			
			@Test
			public void AddAnimal() {
			
				ListnerImplimentationClass lic=new ListnerImplimentationClass();
			/** read the test data*/
			String AnimalName=excelutility.getDataFromExcel( SheetName.ANIMAL.ConverToString(),2,1);
			String CageNumber=excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,2);
			String FeedNumber=excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,3);
			String Breed=excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,4);
			String Description = excelutility.getDataFromExcel(SheetName.ANIMAL.ConverToString(),2,4);
			
			/** Step2:click on animal Details module and click on add animal module*/
			commonPage comonpage=new commonPage(driver);
			addAnimal addanimal=new addAnimal(driver);
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
		Assert.fail();
		editanimal.clickOnEditButton();
			System.out.println("animal added sucessfully added--->Testcase pass");
		
			/** step: Edit the animal details*/
			editanimal.clickOneditanimalName(AnimalName);
			editanimal.clickOnAnimalDiscripn(Description);
			editanimal.clickOnSubmitButton();
			webdriverUtility.acceptAlert();
			softAssert.assertAll();
			}
			
		@DataProvider
			public String[][] getData()
			{
				
				ExcelUtility excelutility=new ExcelUtility();
				excelutility.openExcel(IConstuntPath.EXCEL_PATH);
				String[][] arr = excelutility.getDataFromExcel(SheetName.LOGINGDATA.ConverToString());
				return arr;
				
			}
			
			
	}
				
			

