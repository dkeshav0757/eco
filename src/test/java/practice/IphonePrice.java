package practice;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.safezoo.ObjectRefository.commonPage;
import com.safezoo.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IphonePrice {

	public static void main (String[] args) throws InterruptedException, AWTException, IOException
	{
		//String Str[]=Fid.split(" ");
		//Fid=Str[2];
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.vtiger.com/");
	
	WebDriverUtility wbu=new WebDriverUtility();
	commonPage cm=new commonPage(driver);
//	WebElement elemnt = driver.findElement(By.xpath("//a[contains(text(),'Solutions')]"));
	//WebElement elemnt = cm.mouseoverOnsolution();
	//wbu.mouse_hover_onelement(driver, elemnt) ;
	String parant = "CRM Software: Customer Relationship Management | Vtiger CRM";
	//wbu.robotclass(driver);
	
	//WebElement element = driver.findElement(By.id("zoom-in-button"));
	
	//Thread.sleep(10000);
	//WebDriverWait wait = new WebDriverWait(driver,10);
	//wait.until(ExpectedConditions(element));
	
			
		}
	
	
}
