package testDeclarationInvestor;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import pageObjectsInvestor.ChangePasswordInvestorPage;
import pageObjectsInvestor.HomePageInvestor;
import pageObjectsInvestor.SignInPageInvestor;
import pageObjectsInvestor.SignedInHomePageInvestor;

public class ChangePasswordInvestorTest extends Base {

	WebDriver driver;

	public ChangePasswordInvestorTest() {
		super();
	}

	@Test
	public void validateChangePasswordOptionVisibleOrNot() throws InterruptedException {
		driver = init_browser(prop.getProperty("browser"), prop.getProperty("url"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);

		// click on Sign In Btn
		homePageInvestor.clickOnSignInBtn();
		SignInPageInvestor signInPageInvestor = new SignInPageInvestor(driver);

		// enter valid email and password
		signInPageInvestor.signIn(prop.getProperty("email_Investor"), prop.getProperty("password_Investor"));

		// validate Change Password Option
		Thread.sleep(4000);
		SignedInHomePageInvestor signedInHomePageInvestor = new SignedInHomePageInvestor(driver);
		signedInHomePageInvestor.clickOnProfileIcon();
		Assert.assertTrue(signedInHomePageInvestor.validateChangePasswordIsVisibleOrNot());
	}

	@Test
	public void validateChangePasswordPage() throws InterruptedException {
		driver = init_browser(prop.getProperty("browser"), prop.getProperty("url"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);

		// click on Sign In Btn
		homePageInvestor.clickOnSignInBtn();
		SignInPageInvestor signInPageInvestor = new SignInPageInvestor(driver);

		// enter valid email and password
		signInPageInvestor.signIn(prop.getProperty("email_Investor"), prop.getProperty("password_Investor"));

		// click on profile Icon
		Thread.sleep(4000);
		SignedInHomePageInvestor signedInHomePageInvestor = new SignedInHomePageInvestor(driver);
		signedInHomePageInvestor.clickOnProfileIcon();

		// click on change password button
		signedInHomePageInvestor.clickOnChangePasswordButton();

		// validate email field is able to take input or not
		ChangePasswordInvestorPage changePasswordInvestorPage = new ChangePasswordInvestorPage(driver);
		changePasswordInvestorPage.enterDetailsInEmailField(prop.getProperty("email_Investor"));

		// validate change password page
		Assert.assertTrue(changePasswordInvestorPage.validateChangePasswordText());

		// validate send verification code buttom
		Thread.sleep(3000);
		Assert.assertTrue(changePasswordInvestorPage.validateSendVerificationCodeButton());
	}
}
