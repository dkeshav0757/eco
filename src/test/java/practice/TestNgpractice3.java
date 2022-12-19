package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.safezoo.genericUtility.ThreadSafe;
import com.safezoo.genericUtility.WebDriverUtility;

public class TestNgpractice3  {
	@Test (groups="sanity", alwaysRun=true)
	public void Test()
	{
		System.out.println(Thread.currentThread().getId()+ "tet4");
	
	}
	
	@Test (groups={"baseclass","sanity" },alwaysRun=true)
	public void Test1()
	{
		System.out.println(Thread.currentThread().getId()+ "test5");
		
	}
	@Test (groups="sanity", alwaysRun=true)
	public void Test2()
	{
		System.out.println(Thread.currentThread().getId()+"test6");
		
	}

}
