package pageObjectsInvestor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageInvestor {

	WebDriver driver;

	@FindBy(xpath = "//*[@class='signupform-logo']")
	WebElement signUpPageLogo;

	@FindBy(xpath = "//*[@id='email']")
	WebElement emailField;

	public SignUpPageInvestor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateSignUpPageLogo() {
		return signUpPageLogo.isDisplayed();
	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

}
