package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageObjects {

	WebDriver ldriver;
	
	public LoginPage_PageObjects(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	private WebElement txtEmail;

	@FindBy(how = How.ID, using = "Password")
	private WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logoutBtn;
	
	

	public void enterUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void enterPassword(String pword) {
		txtPassword.clear();
		txtPassword.sendKeys(pword);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
		
	}
	
	public void clickLogoutBtn() {
		logoutBtn.click();
	}
	
	
}
