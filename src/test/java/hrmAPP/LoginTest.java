package hrmAPP;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
//Generated by Selenium IDE
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	private WebDriver driver;
	//private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		
		
		//ctrl+shift+O ------ autoimport/remove unusedimport
		
//		ReadConfig conf = new ReadConfig();
//		conf.getApplicationURL();
//		
		
		
		
		
		//driver
		
		
		//WebDriverManager
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		//webdriver.chrome.driver
		//webdriver.chrome.driver
		
		driver = new ChromeDriver();			//launch chrome browser
		
		js = (JavascriptExecutor) driver;
		//vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test1() throws Exception {
		
		//Selenium ---- REST API 
		//URL---- endPoint 
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  ///calling API --- get/post/put/delete
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("admin123222");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".oxd-button")).click();
		Thread.sleep(4000);
	}
}
