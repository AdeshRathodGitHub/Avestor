package pageObjectsInvestor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageInvestor {

	WebDriver driver;

	@FindBy(xpath = "//*[@class='loginform-logo']")
	private WebElement logo;

	@FindBy(xpath = "//span[@class='default-signin-text']/parent::a")
	private WebElement signInBtn;

	@FindBy(xpath = "//*[contains(text(),'Please use your funds login page to access your account.')]")
	private WebElement defaultPageText;

	@FindBy(xpath = "//*[@class='img-fluid avestorabslogo']/parent::a")
	private WebElement poweredBy;

	@FindBy(xpath = "//div[@class='col-md-6 loginSideImgWrap']/img")
	WebElement banner;

	@FindBy(xpath = "//div[@class='hero-content-first']")
	WebElement fundingPageText;

	public HomePageInvestor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateLogo() {
		return logo.isDisplayed();
	}

	public void clickOnSignInBtn() {
		signInBtn.click();
	}

	public boolean validateFundingPageText() {
		return fundingPageText.isDisplayed();
	}

	public boolean validateDefaultPageText() {
		return defaultPageText.isDisplayed();
	}

	public void clickOnPoweredBy() {
		poweredBy.click();
	}

}
