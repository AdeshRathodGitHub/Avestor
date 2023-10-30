package pageObjectsInvestor;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignedInHomePageInvestor {

	WebDriver driver;

	@FindBy(xpath = "//*[@class='main-panel']")
	public WebElement mainPanel;
	
	@FindBy(xpath = "(//a[@role='menuitem'])[1]")
	public WebElement profileIcon;
	
	@FindBy(xpath = "//li//a//*[contains(text(),'Change Password')]")
	public WebElement changePassword;
	
	public SignedInHomePageInvestor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateSignedInHomePageInvestor() {
		return mainPanel.isDisplayed();
	}
	
	public void clickOnProfileIcon() {
		profileIcon.click();
	}

	public boolean validateChangePasswordIsVisibleOrNot() {
		return  changePassword.isDisplayed();
	}
	
	public void clickOnChangePasswordButton() {
		changePassword.click();
	}
}
