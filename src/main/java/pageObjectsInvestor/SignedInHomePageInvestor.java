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

	public SignedInHomePageInvestor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateSignedInHomePageInvestor() {
		return mainPanel.isDisplayed();
	}

}
