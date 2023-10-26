package pageObjectsInvestor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageInvestor {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@class='loginform-logo']")
	public WebElement logo;
	
	@FindBy(xpath = "//*[@id='email']")
	public WebElement emailField;
	
	@FindBy(xpath = "//*[@id='password']")
	public WebElement passwordField;
	
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement submitBtn;
	
	
	public SignInPageInvestor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateEmailField() {
		return emailField.isDisplayed();
	}
	
	public void signIn(String email,String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		submitBtn.click();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}

}
