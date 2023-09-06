//write a script to open the actitime link in new window?
package practice;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.safezoo.ObjectRefository.Amazone;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazoneListBox {
	 //List<WebElement> Allheadings;
		@Test
		public void Test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	
	
				driver.get("https://www.amazon.in/your-account");
			    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			    String parent = driver.getWindowHandle();
			    Amazone a=new Amazone(driver);
			   // a.getselect(list);
			    

	
	}
	
}






