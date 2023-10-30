package testDeclarationInvestor;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import pageObjectsInvestor.HomePageInvestor;
import pageObjectsInvestor.SignUpPageInvestor;

public class SignUpPageInvestorTest extends Base {

	public SignUpPageInvestorTest() {
		super();
	}

	public WebDriver driver;

	@Test
	public void validateSignUpPage() throws InterruptedException {
		driver = init_browser(prop.getProperty("browser"), prop.getProperty("url"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);

		// click on Sign Up Button
		homePageInvestor.clickOnSignUpBtn();

		// validate Sign Up page
		SignUpPageInvestor signUpPageInvestor = new SignUpPageInvestor(driver);
		Thread.sleep(3000);

		signUpPageInvestor.enterEmail("uyftyfyy");

		Assert.assertTrue(signUpPageInvestor.validateSignUpPageLogo());
	}

}
