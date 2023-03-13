package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class LoginPage_old {

	WebDriver driver;

	public LoginPage_old(WebDriver driver) {

		this.driver = driver;

	}

	// Identification

	By txtEmail = By.id("Email");
	By txtPass = By.name("Password");
	By chkRem = By.xpath("//input[@name='RememberMe']");
	By btnLogin = By.tagName("button");
	By btnLogout = By.partialLinkText("ogout");

	// Actions/Methods

	public void enterEmail(String email) {
		// this.driver is null
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);
	}

	public void enterPassword(String pwd) {
		driver.findElement(txtPass).clear();
		driver.findElement(txtPass).sendKeys(pwd);
	}

	public void clickRemmberMe() {

		driver.findElement(chkRem).click();
	}

	public void clickLoginButton() throws Exception {

		driver.findElement(btnLogin).click();
		Thread.sleep(3000);
	}

	public void clickLogoutButton() {

		driver.findElement(btnLogout).click();
	}
	
	public void verifyApplicationTitle(String expectedValue) throws InterruptedException {

		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(), expectedValue);
	}

}
