package practice;

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
import com.safezoo.ObjectRefository.NormalTicketReportPage;
import com.safezoo.ObjectRefository.addAnimal;
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
			public class NormalTicketReport extends BaseClass {
			
			@Test
			public void AddAnimal() {
			
				
			/** read the test data*/
			String fdate = "08-12-2022";
			String tdate = "14-12-2022";		
			
			/** Step2:click on animal Details module and click on add animal module*/
			NormalTicketReportPage ntr=new NormalTicketReportPage(driver);
			commonPage comonpage=new commonPage(driver);
			addAnimal addanimal=new addAnimal(driver);
			ntr.clickReportbutton();
			ntr.getreportOfNormalTicket(tdate);
	
			}
			
		/**	@DataProvider
			public String[][] getData()
			{
				
				ExcelUtility excelutility=new ExcelUtility();
				excelutility.openExcel(IConstuntPath.EXCEL_PATH);
				String[][] arr = excelutility.getDataFromExcel("logindata");
				return arr;
				
			}
			*/
			
	}
				
			

