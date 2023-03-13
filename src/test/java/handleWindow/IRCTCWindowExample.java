package handleWindow;

import java.util.Set;
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

public class IRCTCWindowExample {
	
WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		
		System.out.println("launching app");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	

	
	@AfterTest
	public void teardown() throws Exception {

		
		
		System.out.println("closing app");
		Thread.sleep(5000);
		//driver.close();				//close current focus window
		driver.quit();  			//close all instance
		
	}
	
	
	
	@Test
	public void handleWindowsTest() throws Exception {
		
		
		String paranetWindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + paranetWindow);
		
		System.out.println("how many window are opened : " + driver.getWindowHandles().size());
		//driver.getWindowHandles();
		
		
		System.out.println("=============================================");
		
		
		//click on Hotel window
		driver.findElement(By.linkText("HOTELS")).click();
		
		
		
		
		Set<String>  allWindow =  driver.getWindowHandles();
		
		System.out.println("how many window are opened after clicking on hotel link : " + allWindow.size());
		
		String mainWindow = (String) allWindow.toArray()[0];
		String hotelWindow = (String) allWindow.toArray()[1];
		
		System.out.println("main window: " + mainWindow);
		System.out.println("hotel window: " + hotelWindow);
		
		
		
		Thread.sleep(5000);
		driver.switchTo().window(hotelWindow);
		
		
		System.out.println("application title on hotel window: " + driver.getTitle());
		
		
		//click on Login link on hotel window
		driver.findElement(By.linkText("Login")).click();
				
		
		
		Thread.sleep(5000);
		driver.switchTo().window(mainWindow);
		
		//click on ContactUS link on main window
		driver.findElement(By.partialLinkText("CONTACT US")).click();
		
		Thread.sleep(5000);
		
		
		
		driver.switchTo().window(hotelWindow);
		
		Thread.sleep(5000);
		
		
	}

}
