package pageObjectsInvestor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordInvestorPage {

	public WebDriver driver;

	@FindBy(xpath = "//h1[@role='heading']")
	WebElement changePasswordPageText;

	@FindBy(xpath = "//*[@id='email']")
	WebElement emailField;

	@FindBy(xpath = "//*[@class='sendCode']")
	WebElement sendVerificationCodeButton;

	public ChangePasswordInvestorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateChangePasswordText() {
		return changePasswordPageText.isDisplayed();
	}

	public boolean validateSendVerificationCodeButton() {
		return sendVerificationCodeButton.isDisplayed();
	}

	public void enterDetailsInEmailField(String email) {
		emailField.sendKeys(email);
	}

}
