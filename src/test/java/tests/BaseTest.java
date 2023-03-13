package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utility.ReadConfig;

public class BaseTest {
	
	
	
	WebDriver driver;
	ReadConfig conf;
	LoginPage lp;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		conf = new ReadConfig();
		driver.get(conf.getApplicationURL());
		
		
		lp = new LoginPage(driver);
				
		
		driver.manage().window().maximize();
		
	}
	
	
	@AfterTest
	public void closeApp() throws Exception {
		
		System.out.println("closing the application");
		Thread.sleep(7000);
		driver.close();
		
		
	}
	
	

}
