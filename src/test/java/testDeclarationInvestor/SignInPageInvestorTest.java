package testDeclarationInvestor;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import RetryAnalyzer.Retry;
import pageObjectsInvestor.HomePageInvestor;
import pageObjectsInvestor.SignInPageInvestor;
import pageObjectsInvestor.SignedInHomePageInvestor;

public class SignInPageInvestorTest extends Base{
	
	public SignInPageInvestorTest() {
		super();
	}

	public WebDriver driver;
	
	@Test(retryAnalyzer = Retry.class)
	public void validateSignInPage() throws InterruptedException {
		driver = init_browser(prop.getProperty("browser"), prop.getProperty("url"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);
		
		//click on Sign in Button
		homePageInvestor.clickOnSignInBtn();
		
		//validate Sign In Page
		Thread.sleep(5000);
		SignInPageInvestor signInPageInvestor = new SignInPageInvestor(driver);
		Assert.assertTrue(signInPageInvestor.validateEmailField());
		Assert.assertTrue(signInPageInvestor.validateLogo());
	}
	
	@Test
	public void validateSignInUsingValidCreds() throws InterruptedException {
		driver = init_browser(prop.getProperty("browser"), prop.getProperty("url"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);
		
		//click on Sign In Btn
		homePageInvestor.clickOnSignInBtn();
		SignInPageInvestor signInPageInvestor = new SignInPageInvestor(driver);
		
		//enter valid email and password
		signInPageInvestor.signIn(prop.getProperty("email_Investor"), prop.getProperty("password_Investor"));
		
		//validate Signed in HomePage
		Thread.sleep(4000);
		SignedInHomePageInvestor signedInHomePageInvestor= new SignedInHomePageInvestor(driver);
		Assert.assertTrue(signedInHomePageInvestor.validateSignedInHomePageInvestor());
	}
	
	
}
