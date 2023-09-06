package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.safezoo.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridPractice
{
	@Test
	
	public void test() throws MalformedURLException {
		URL url=new URL("http://192.168.0.230:4444/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
	
	
	}
}
