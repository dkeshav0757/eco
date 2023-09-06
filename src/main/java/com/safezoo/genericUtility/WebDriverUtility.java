package com.safezoo.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	public static WebDriver sDriver;
	private  WebDriver driver;
	private Actions act;
	private FluentWait wait;
	private Robot r;
	//private  static WebDriver ddriver;
	/**
	 * This method is used to 
	 * launch browser based on browser key
	 * maximize the browser
	 * provide implicit wait
	 * launch application by using url
	 * @param browser
	 * @return
	 */

	public  WebDriver launchApplication(String browser,long timeout,String url)
	{
		
		if(browser.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("please eneter the valid browser name");
		}
		Options s = driver.manage();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		driver.get(url);
		//driver.initializeExplicitWait(timeout);
		
		return driver;
		
	
	}
	/**
	 * used for handle the disabled element
	 * @param driver
	 * @param Element
	 *
	 */
	
	public void handleDisabledElements()
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("document.getElementById('cnum').value=FeedNumber");
	}
	/**
	 * used for initialize the actions
	 * @param driver
	 * @param Element
	 * 
	 */
	public void initializeActions(WebDriver driver,WebElement element)
	{
		act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/** * used for initialize the actions
	 * @param driver
	 * @param Element
	 * 
	 */
	public void initializeActions1(WebDriver driver,WebElement element,WebElement element2)
	{
		act=new Actions(driver);
		act.dragAndDrop(element, element2).perform();
	}
	/** * used for initialize the actions
	 * @param driver
	 * @param Element
	 * 
	 */
	public void initializeActions2(WebDriver driver,WebElement element)
	{
		act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used for element to be clickable in gui and check for specific element for every 500 miliseconds
	 * @param driver
	 * @param Element
	 * @param pollingtime
	 */
	public void initializeExplicitWait(long timeout,By elemet)
	{
		wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.elementToBeClickable(elemet));
		
	}
	/**
	 * used for element to be clickable in gui and check for specific element for every 500 miliseconds
	 * @param driver
	 * @param Element
	 * @param pollingtime
	 */
	public void cutomWait(int duration,WebElement element,long PolingTime)
	{
		int count=0;
		while(count<duration)
		{
			element.click();
			try {
				Thread.sleep(PolingTime);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			break;
		}
		
		
	}
	public void Scripttimeout(WebDriver driver) {
	  driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
	}
	
	/**
	 * used for element to be clickable in gui and check for specific element for every 500 miliseconds
	 * @param driver
	 * @param Element
	 * @param pollingtime
	 * @return 
	 */
	public void wait_for_element_withcustomtimeout(WebDriver driver,WebElement Element,int pollingtime) {
			  wait= new FluentWait(driver);
			wait.pollingEvery(Duration.ofSeconds(pollingtime));
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			//return wait;
	}
	/**
	 * used for element to be clickable in gui and check for specific element for every 500 miliseconds
	 * @param driver
	 * @param Element
	 * @param pollingtime
	 */
	
	public void mouse_hover_onelement(WebDriver driver,WebElement Element) {
		Actions a=new Actions(driver);
		a.moveToElement(Element).perform();
		 
	}
		
		/**
		 * used to right click on the element
		 * @param driver
		 * @param Element
		 */
	 public void rightClickonElement(WebDriver driver,WebElement Element) 
	 {
	Actions a=new Actions(driver);
	a.contextClick(Element);
	 	}
	 /**
	  * this method is used to swich to frame based on index
	  * 
	  */
	 /**
	  * used to switch to any window based on the window title
	  * @param driver
	  * @param 
	  */
	 private void switchToWindow(WebDriver driver,String partialWindowTitle)
		{
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> it = set.iterator();
	
			while(it.hasNext())
			{
					String wID=it.next();
					driver.switchTo().window(wID);
					String curruntWindowTitle=driver.getTitle();
					if(curruntWindowTitle.contains(partialWindowTitle))
						break;
				}
			
			}
	 public void switchToFrame(WebDriver driver,int index) 
	 {
		 driver.switchTo().frame(index);
	 }
	 /**
	  * this method is used to swich to frame based on id/name atribute
	  * @param driver
	  * @param 
	  */
	 public void switchToFrame(WebDriver driver,String id_name_attribute) 
	 {
		 driver.switchTo().frame(id_name_attribute);
	 }
	 
	  /**
	  *
	  * @param driver
	  * @param x
	  * @param y
	  */
	 
	 public void moveby_offset(WebDriver driver,int x,int y) {
	  Actions a=new Actions(driver);
	  a.moveByOffset(x , y).click().perform();
	  }
	 /**
	  * used to select the value from the dropdown based on index
	  * @param
	  */
	 public void select(WebElement elemnt,int index) {
		  Select s=new Select(elemnt);
		  s.deselectByIndex(index);
	 }
	 
	 /**
	  * used to select the value from the dropdown based on valueavilable in GUI
	  * 
	  */
	 public void select(WebElement elemnt,String text) {
		  Select s=new Select(elemnt);
		  s.selectByVisibleText(text);
	 }
	 
	 
	 /**
	  * used to wait until the page loads completely
	  * @param driver
	  * @author keshav
	  */
	  public void page_loadtime(WebDriver driver) {
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  }
	  /**
	  * explicit wait condition for prescence of element located
	  * @param driver
	  * @author keshav
	  */
	  public void waitexpected_condition(WebDriver driver,String element) 
	  {
	  WebDriverWait wait=new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
	  }
	 
	  /**
	  * to select the values according to index
	  * @author shubham
	  */
	  public void select_byindex(WebElement Element, int index) 
	  {
	  Select s=new Select(Element);
	  s.selectByIndex(index);
	  }


	
	/**
	 * This method is used to accept the alert
	 * @param driver
	 * 
	 */
	public void acceptAlert()
	{
	
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to dismis the alert
	 * @param driver
	 */
	public void rejectAlert()
	{
	
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to fetch data from alert popup
	 * @param driver
	 * @return
	 */
	public String getTextAlert()
	{
		return driver.switchTo().alert().getText();
		
	}
	
	
	public String takeScreenshot(WebDriver staticDriver, String testCaseName) 
	{
		String fileName = testCaseName +"_"+new JavaUtility().getDateTime();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorshots+"+fileName+".png");
		
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return dest.getAbsolutePath();
	}
	/**
	 * pass enter key appetain in to browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * pass Tab key appetain in to browser
	 * @param driver
	 */
	
	public void passEscKey(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
	}
	/**
	 * This method is used to perform robot actions
	 * @param driver
	 */
	
	public void robotclass(WebDriver driver,long PolingTime)
	{
		
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_P);
		try {
			Thread.sleep(PolingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		
		r.keyRelease(KeyEvent.VK_ENTER);
		try {
			Thread.sleep(PolingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_H);
		r.keyPress(KeyEvent.VK_ENTER);
		
	
	}
	
	
}

