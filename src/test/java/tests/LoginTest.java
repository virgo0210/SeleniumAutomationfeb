package tests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	

	
	
	@Test
	public void verifyLoginLogoutFeature() throws Exception {
		
		
		//valdiate application title before login
		lp.verifyApplicationTitle("Your store. Login");
		
		
//		lp.enterEmail(conf.getUserName());
//		lp.enterPassword(conf.getPassword());
//		lp.clickRemmberMe();
//		lp.clickLoginButton();
		
		
		lp.login(conf.getUserName(), conf.getPassword());
		
		
		//valdiate application title after login
		lp.verifyApplicationTitle("Dashboard / nopCommerce administration");
		
		
	}
	
	

}
