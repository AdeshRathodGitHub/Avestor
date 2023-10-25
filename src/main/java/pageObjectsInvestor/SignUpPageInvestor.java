package pageObjectsInvestor;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageInvestor {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='email']")
	private WebElement emailOnSignUpPage;


	public SignUpPageInvestor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnEmailOnSignUpPage(String email) {
		emailOnSignUpPage.sendKeys(email);
	}


}
