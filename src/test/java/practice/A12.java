package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.safezoo.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A12
{
	public static void main(String[] args) {
		WebDriver driver = null;
		
		WebDriverUtility wu=new WebDriverUtility();
		wu.launchApplication("chrome", 20, "https://www.google.co.in/");
		wu.robotclass(driver, 20);
	}
}
