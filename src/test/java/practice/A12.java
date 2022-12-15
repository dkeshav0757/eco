package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A12
{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(null);
		String s="keshav";
		String s1="kishore";
		String s2="kishan";
		String[] str = s.split(",");
		
		StringBuilder sb=new StringBuilder();
		sb.append(s).append(s1).append(s2);
		System.out.println(sb);
	}
}
