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

public class RightClickDoubleClick {
	
WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		System.out.println("launching app");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
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
	public void rightLCickTest() throws Exception {
		
		
		Actions act = new Actions(driver);
		WebElement btnRightClick = driver.findElement(By.xpath("//span[contains(text(),'right')]"));
		WebElement deletebutton = driver.findElement(By.xpath("//span[contains(text(),'Del')]"));
		
		act.contextClick(btnRightClick).perform();
				
		
		deletebutton.click();
		
		Thread.sleep(2000);
		System.err.println("Right Click Alert Text: " +driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
	}
	
	
	@Test
	public void doubleLCickTest() throws Exception {
		
		
		Actions act = new Actions(driver);
		WebElement btnDoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Dou')]"));
		
		
		act.doubleClick(btnDoubleClick).perform();
				
		
		Thread.sleep(4000);
		System.err.println("Double Click Alert Text: " +driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(4000);
	}

}
