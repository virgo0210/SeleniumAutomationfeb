package actionExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_WishList {
	
WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		System.out.println("launching app");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	

	
	@AfterTest
	public void teardown() throws Exception {

		
		
		System.out.println("closing app");
		Thread.sleep(5000);
		driver.close();
		
	}
	
	@Test
	public void login() throws Exception {
		
		
		Actions act = new Actions(driver);
		WebElement SignIn = driver.findElement(By.xpath("//span[contains(text(),'Hello, s')]"));
		
		WebElement CreateWishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish')]"));
		
		//call perform at the end
		//mouse hover operation
		//selenium ----- method chaining ---- build required -----
		
		
//		//app1
//		act.moveToElement(SignIn).perform();
//		act.moveToElement(CreateWishList).perform();
//		act.click().perform();
//		
//		
//		//app2
//		act.moveToElement(SignIn).moveToElement(CreateWishList).click().build().perform();
//		
//		
//		//app3
//		act.moveToElement(SignIn).moveToElement(CreateWishList).click().perform();
		
		
		//app4
		act.moveToElement(SignIn).click(CreateWishList).perform();
				
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Wish"));
	}

}
