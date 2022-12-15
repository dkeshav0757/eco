package practice;

		import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.safezoo.ObjectRefository.AdminPage;
import com.safezoo.ObjectRefository.HomePage;
import com.safezoo.ObjectRefository.LoginPage;
import com.safezoo.ObjectRefository.MnageAnimals;
import com.safezoo.ObjectRefository.SearchForgnierTicket;
import com.safezoo.ObjectRefository.addAnimal;
import com.safezoo.ObjectRefository.addForgnerZooTicket;
import com.safezoo.ObjectRefository.addNormalZooTicket;
import com.safezoo.ObjectRefository.commonPage;
import com.safezoo.genericUtility.ExcelUtility;
import com.safezoo.genericUtility.FileUtility;
import com.safezoo.genericUtility.IConstuntPath;
import com.safezoo.genericUtility.JavaUtility;
import com.safezoo.genericUtility.PropertyFileKeys;
import com.safezoo.genericUtility.SheetName;
import com.safezoo.genericUtility.WebDriverUtility;

		public class manageTicketTypeAndEditAnimals {
			

				public static void main(String []args) throws IOException, InterruptedException {
				
				JavaUtility javautility=new JavaUtility();
				ExcelUtility excelutility=new ExcelUtility();
				FileUtility fileUtility = new FileUtility();
				WebDriverUtility webdriverUtility=new WebDriverUtility();
				
				fileUtility.openPropertyFile(IConstuntPath.PROPERTY_FILE_PATH);
				String browser=fileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
				String url=fileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString());
				String username=fileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.convertToString());
				String password=fileUtility.getDataFromPropertyFile(PropertyFileKeys.PASSWORD.convertToString());
				String randomNumberLimit = fileUtility.getDataFromPropertyFile(PropertyFileKeys.RANDOMNMBERLIMIT.convertToString());
				long timeout = (Long)javautility.stringToAnyDataType(fileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString()),"long");
				int randomNumber = javautility.getRandomNumber((Integer)javautility.stringToAnyDataType(randomNumberLimit,"int"));
				
				excelutility.openExcel(IConstuntPath.EXCEL_PATH);	
				String VisitorName=excelutility.getDataFromExcel( SheetName.SEARCHF.ConverToString(),2,1);
				String NoOfAdults=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,2);
				String NoOfChildrens=excelutility.getDataFromExcel(SheetName.SEARCHF.ConverToString(),2,3);
			
				WebDriver driver=webdriverUtility.launchApplication(browser,timeout,url);
				 
				//WebDriverWait wait = new WebDriverWait(driver,(Long) timeout);
				String AnimalName="Donkey3";
				//objects 
				addAnimal addanimal=new addAnimal(driver);
				MnageAnimals manageanimals=new MnageAnimals(driver);
				LoginPage loginpage=new LoginPage(driver);
				commonPage comonpage=new commonPage(driver);
				AdminPage adminpage=new AdminPage(driver);
				addForgnerZooTicket addforginerzooticket=new addForgnerZooTicket(driver);
				HomePage homepage=new HomePage(driver);
				addNormalZooTicket addnormalticket=new addNormalZooTicket(driver);
				SearchForgnierTicket searchforgnerticket=new SearchForgnierTicket(driver );
				
				driver.get(url);
				adminpage.clickOnAdminButton();
		//		loginpage.logindetails(username, password);
				
				comonpage.clickForeignersTicketModule();
				addforginerzooticket.clickaddForgnerTicketsTab();
				addforginerzooticket.enterOnVisitorNameTextField(VisitorName);
				addforginerzooticket.enterNoOfAdultsTextField(NoOfAdults);
				addforginerzooticket.NoOfChildrensTextField(NoOfChildrens);
				addforginerzooticket.clickOnSubmitButton();
				webdriverUtility.acceptAlert();
				  String createdTicketId = driver.findElement(By.xpath("//h4[@class='header-title']")).getText().split(" ")[2];
				  driver.findElement(By.xpath("//div[@class='nav-btn pull-left']")).click();
				  driver.findElement(By.xpath("//span[.='Normal Ticket']")).click();
				  driver.findElement(By.linkText("Manage Ticket")).click();
				  String actualTicketId = driver.findElement(By.xpath("//h4[@class='header-title']/../div/table/tbody/tr/td[2]"))
				    .getText();
				  if (actualTicketId.equals(createdTicketId)) {
				   driver.findElement(By.xpath("//h4[@class='header-title']/../div/table/tbody/tr/td[.='" + actualTicketId
				     + "']/following-sibling::td[.='" + VisitorName + "']/following-sibling::td/a[.='Delete']")).click();
				   System.out.println("Normal ticket has been deleted successfully (PASSED)");
				  } else {
				   System.out.println("Normal ticket has not been deleted (FAILED)");
				  }
				
				  webdriverUtility.acceptAlert();
				  webdriverUtility.acceptAlert();
					String Fid =addforginerzooticket.getTextoFId();
					//String Str[]=Fid.split(" ");
					//Fid=Str[2];
						
					driver.findElement(By.linkText("Search")).click();
					searchforgnerticket.clickSearchForgnerTicketsTab();
					searchforgnerticket.SearchDataTextField(Fid);
					searchforgnerticket.clickSearchButton();
					String ExpectedID ="View";
					//String ActualID = searchforgnerticket.getTextOfForignerTicket();
					//System.out.println(ActualID);
					//if(ActualID.equals(ExpectedID))
					{
						System.out.println("Ticket found---->Testcase pass");
					}
				//	else
					{
						System.out.println("Ticket Notfound---->Testcase Fail");
					}
	
			}

		}


