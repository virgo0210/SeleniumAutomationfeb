package testNGAnotationExample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NOPComApp_CrossBrowserTest {
	
	WebDriver driver;
	
	@Test
	public void login() throws Exception {
		
		System.out.println("login test case");
		
		//locator
		//ID
		Thread.sleep(4000);
		WebElement txt_Email = driver.findElement(By.id("Email"));
		
		
		//clear the value from input box
		txt_Email.clear();
		
		
		Thread.sleep(4000);
		//get the attribute value
		String EmailAttrbuteValue = txt_Email.getAttribute("data-val-required");
		System.out.println("Attrbute value of email input box are: " + EmailAttrbuteValue);		//Please enter your email
		
		txt_Email.sendKeys("admin@yourstore.com");									//get it from config file
		
		
		
		//ClassNAME
		//password
		Thread.sleep(4000);
		driver.findElement(By.className("password")).clear();
		Thread.sleep(4000);
		driver.findElement(By.className("password")).sendKeys("admin");
		
		
		
		//NAME
		//checkbox
		Thread.sleep(4000);
		driver.findElement(By.name("RememberMe")).click();
		
		
		String checkBoxType = driver.findElement(By.name("RememberMe")).getAttribute("type");					//checkbox
		System.out.println("CHeckbox type: " + checkBoxType);
		
		
		//LoginButton
		//TagName
		WebElement btn_Login = driver.findElement(By.tagName("button"));
		
		String actualLoginButtonText = btn_Login.getText();
		String expectedLoginButtonText = "Log in";
		System.out.println("text of Login button: " + actualLoginButtonText);
		
		//validation step
		
		
		
		
		//click on Login Button
		btn_Login.click();
		
		Thread.sleep(5000);
		
		
		
		String actualTitle =driver.getTitle();
		
		
		String actualURL =driver.getCurrentUrl();
		
		System.out.println("Application Title after Login: " + actualTitle);
		System.out.println("Application URL after Login: " + actualURL);
		
		
		
		
		//findElements
		
		
		String dashboardText = driver.findElements(By.tagName("h1")).get(1).getText();
		boolean isDashBoardPresent =  driver.findElements(By.tagName("h1")).get(1).isDisplayed();	
		
		//TagName
		//Dashboard
		
		//String dashboardText = driver.findElement(By.tagName("h1")).getText();
		Thread.sleep(5000);
		
		System.out.println("===================: " +dashboardText);
		
		
		//boolean isDashBoardPresent =  driver.findElement(By.tagName("h1")).isDisplayed();					///true
		System.out.println("is dashboard present on page after login: " + isDashBoardPresent);
		
		
		
		//Logout
		//Linktext/PartialLinktext
//		LinkText
//		PartialLinkText
		Thread.sleep(5000);
		//LinkText
		//driver.findElement(By.linkText("Logout")).click();
		
		
		//PartialLinkText
		//driver.findElement(By.partialLinkText("Logo")).click();
		
		driver.findElement(By.partialLinkText("ogo")).click();
		
		
		Thread.sleep(5000);
		System.out.println("Application Title after Logout: " + driver.getTitle());
		System.out.println("Application URL after Logout: " + driver.getCurrentUrl());
		
		
		
		
		//login again  
		
		Thread.sleep(5000);
		//XPATH
		//Login button
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		////*[@type='submit']
		
		
		//CSS 
		
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		
		Thread.sleep(5000);
		//PartialLinkText
		driver.findElement(By.partialLinkText("Logo")).click();
		
	}
	
	
	
	@Parameters("ibm_browser")
	@BeforeTest
	public void launchApp(String browser) {
		
		System.out.println("Execution on browser: " + browser);
		
		
		
		
		//String browser = "edge";
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.out.println("Execution on chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			
			System.out.println("Execution on Edge browser");
			driver = WebDriverManager.edgedriver().create();
			//driver = new EdgeDriver();
			
			
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
			
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			
			System.out.println("Execution on firefox browser");
			driver = WebDriverManager.firefoxdriver().create();
			
			
		}
		
		else {
			
			
			//default execution
			System.out.println("Execution on default ------ chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		
		//cross browser testing
//		//chrome browser
//		
//		
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		
		
		//edge browser
		
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
		
		
		
		
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void closeApp() throws Exception {
		
		
		Thread.sleep(5000);
		System.out.println("close app");
		driver.close();
		//driver.quit();
		
		
	}
	
	

}
