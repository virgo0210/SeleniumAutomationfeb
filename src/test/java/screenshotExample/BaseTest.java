package screenshotExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		System.out.println("launching app");
		
		
		//chormeOption
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless");
				
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
	}
	

	
	@AfterTest
	public void teardown() throws Exception {
		
		System.out.println("closing app");
		Thread.sleep(5000);
		driver.close();
		
	}
	
	
	
	
}
