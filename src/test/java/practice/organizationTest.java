package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.safezoo.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class organizationTest {

	public static void main(String[] args) {
		WebDriverUtility wb=new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		driver.findElement(By.xpath("//a[text()='Calendar']")).click();
		driver.findElement(By.xpath("//td/img[@title='Open Calendar...']")).click();
		WebElement element = driver.findElement(By.xpath("//td[@class='calHdr']/a/following-sibling::a/b"));
		String allMonthYear = driver.findElement(By.xpath("//td[@class='calHdr']/a/following-sibling::a/b")).getText();
		String Month = allMonthYear.split(" ")[0];
		String Year = allMonthYear.split(" ")[1];
		String ExpectedMonth ="December";
		String ExpectedYear = "2023";
		String day = "23";
		
		while(!(ExpectedMonth.equals(Month)&&ExpectedYear.equals(Year)))
		{
			driver.findElement(By.xpath("//img[@src='themes/images/small_right.gif']")).click();
			WebDriverWait wait1=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//td[@class='calHdr']//b"), allMonthYear));
			allMonthYear = driver.findElement(By.xpath("//td[@class='calHdr']/a/following-sibling::a/b")).getText();
			Month = allMonthYear.split(" ")[0];
			Year = allMonthYear.split(" ")[1];
				
		}
		driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
		
		

	}

}
