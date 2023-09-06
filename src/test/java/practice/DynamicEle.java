package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicEle {

	public static void main (String[] args)
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://rmgtestingserver:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	WebDriverWait wait=new WebDriverWait(driver,10);
	
	driver.findElement(By.xpath("//tbody/tr/td[@class='tabUnSelected']//a[text()='Organizations']")).click();
	String page = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText();
	int pagenumber = Integer.parseInt(page.split("")[1]);
	boolean count = false;
	String expectedOrgName = "org7";
	for(int j=0;j<pagenumber;j++)
	{
		List<WebElement> listorg = driver.findElements(By.xpath(""));
		System.out.println("helo");
		for(int i=0;i<listorg.size();i++)
		{
			String ActualOrgName = listorg.get(i).getText();
			System.out.println(ActualOrgName);
			if(ActualOrgName.equals(expectedOrgName))
			{
				driver.findElement(By.xpath("")).click();
				count=true;
				break;
		    }
			
		}
	
		if(count) break;
		driver.findElement(By.xpath("")).click();
		WebElement statusbar = driver.findElement(By.xpath(""));
		wait.until(ExpectedConditions.invisibilityOf(statusbar));
	}
	
	}
	
}


