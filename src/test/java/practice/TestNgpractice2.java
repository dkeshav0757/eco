package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.safezoo.genericUtility.ThreadSafe;
import com.safezoo.genericUtility.WebDriverUtility;

public class TestNgpractice2  extends TestBaseClass {
	@Test (groups="sanity", alwaysRun=true)
	public void Test()
	{
		System.out.println(Thread.currentThread().getId()+ "test1");
		//Assert.fail();
	}
	
	@Test (groups={"baseclass","sanity" },alwaysRun=true)
	public void Test1()
	{
		System.out.println(Thread.currentThread().getId()+ "test2");
	
	}
	@Test 
	public void Test2()
	{
		System.out.println(Thread.currentThread().getId()+"test3doubt");
	}

}
