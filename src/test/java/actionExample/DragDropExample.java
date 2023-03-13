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

public class DragDropExample {
	
WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		System.out.println("launching app");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
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
	public void dragDropTest() throws Exception {
		
		
		
		//switch to frame
		WebElement myFrame = driver.findElement(By.cssSelector("iframe[data-src*='photo']"));
		driver.switchTo().frame(myFrame);
		
		
		
		
		
		Actions act = new Actions(driver);
		WebElement img4 = driver.findElement(By.cssSelector("img[src*='tatras4']"));
		WebElement img3 = driver.findElement(By.cssSelector("img[src*='tatras3']"));
		
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		
		
		//app1
		act.dragAndDrop(img4, trash).perform();
				
		
		
		//app2
		//A convenience method that performs click-and-hold at the location of the source element, 
		//moves to the location of the target element, then releases the mouse.
		
		act.clickAndHold(img3).moveToElement(trash).release().perform();
		
	}

}
