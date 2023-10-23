package pageObjectsInvestor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageInvestor {

WebDriver driver;

	@FindBy(xpath="//*[@class='loginform-logo']")
	private WebElement logo;

	@FindBy(xpath="//span[@class='default-signin-text']/parent::a")
	private WebElement signInBtn;

	public HomePageInvestor(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}

}
