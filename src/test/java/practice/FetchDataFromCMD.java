package practice;

import org.testng.annotations.Test;

public class FetchDataFromCMD {
	@Test
	public void test()
	{
			String url = System.getProperty("url");
			String username = System.getProperty("username");
			String password = System.getProperty("password");
			System.out.println("url of website"+ url );
			System.out.println("username of application " + username );
			System.out.println("password of application" + password );
		
	}

}
