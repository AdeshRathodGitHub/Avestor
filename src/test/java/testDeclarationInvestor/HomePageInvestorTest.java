package testDeclarationInvestor;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import RetryAnalyzer.Retry;
import pageObjectsInvestor.HomePageInvestor;


public class HomePageInvestorTest extends Base{

	public HomePageInvestorTest() {
		super();
	}

	public WebDriver driver;

	@Test(retryAnalyzer =Retry.class)
	public void validateLogoVisibleOrNot() {
		driver= init_browser(prop.getProperty("browser"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);
		Assert.assertTrue(homePageInvestor.validateLogo());
		System.out.println("logo is visible");
		System.out.println("tc validateLogoVisibleOrNot passed");
	}
}
