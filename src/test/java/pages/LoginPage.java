package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}

	// Identification

//	By txtEmail = By.id("Email");
//	By txtPass = By.name("Password");
//	By chkRem = By.xpath("//input[@name='RememberMe']");
//	By btnLogin = By.tagName("button");
//	By btnLogout = By.partialLinkText("ogout");
	
	
	
	
	@FindBy(id = "Email")
	WebElement txt_Email;
	
	@FindBy(name = "Password")
	WebElement txt_Pass;
	
	@FindBy(xpath = "//input[@name='RememberMe']")
	WebElement chk_Rem;
	
	@FindBy(tagName  = "button")
	WebElement btn_Login;
	
	@FindBy(partialLinkText = "ogout")
	WebElement btn_Logout;
	
	
	

	// Actions/Methods

	public void enterEmail(String email) {
		// this.driver is null
		txt_Email.clear();
		txt_Email.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		txt_Pass.clear();
		txt_Pass.sendKeys(pwd);
	}

	public void clickRemmberMe() {

		chk_Rem.click();
	}

	public void clickLoginButton() throws Exception {

		btn_Login.click();
		Thread.sleep(3000);
	}

	public void clickLogoutButton() {

		btn_Logout.click();
	}
	
	public void verifyApplicationTitle(String expectedValue) throws InterruptedException {

		Thread.sleep(4000);
		Assert.assertEquals(driver.getTitle(), expectedValue);
	}
	
	
	public void login(String email, String pass) {
		
		enterEmail(email);
		enterPassword(pass);
		clickRemmberMe();
		clickLogoutButton();
		
		
	}

}
