package testNGAnotationExample;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonExampleFailedTest {
	
	
	@BeforeTest
	public void launchApp() {
		
		System.out.println("launch application");
		
	}
	
	@AfterTest
	public void closeApp() {
		
		System.out.println("closing application");
		
	}
	
	

	
	@Test(priority = 1)
	public void login() {
		
		System.out.println("login test case");
		
	}
	
	@Test(priority = 4)
	public void logout() {
		
		System.out.println("logout test case");
		
	}
	
	
	@Test(priority = 2)
	public void addItems() {
		
		System.out.println("addItems test case");
		
	}
	
	@Test(priority = 3)
	public void payment() {
		
		System.out.println("payment test case");
		Assert.assertTrue(false);
	}
	
	@Test(priority = 3)
	public void cancelOrder() {
		
		System.out.println("cancelOrder test case");
		Assert.assertTrue(false);
		
	}

}
