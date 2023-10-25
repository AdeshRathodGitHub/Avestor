package testDeclarationInvestor;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import RetryAnalyzer.Retry;
import pageObjectsInvestor.HomePageInvestor;

public class HomePageInvestorTest extends Base {

	public HomePageInvestorTest() {
		super();
	}

	public WebDriver driver;

	@Test(retryAnalyzer = Retry.class)
	public void validateLogoVisibleOrNot() {
		driver = init_browser(prop.getProperty("browser"), prop.getProperty("url"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);
		Assert.assertTrue(homePageInvestor.validateLogo());
		System.out.println("logo is visible");
		System.out.println("tc validateLogoVisibleOrNot passed");
	}

	@Test(retryAnalyzer = Retry.class)
	public void validateUrlWithoutSlug() {
		driver = init_browser(prop.getProperty("browser"), prop.getProperty("url_without_slug"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);

		// validate Default Page
		Assert.assertTrue(homePageInvestor.validateDefaultPageText());
	}

	@Test(retryAnalyzer = Retry.class)
	public void validateRedirectingToFundWebsiteAfterClickingOnPoweredByButton() throws InterruptedException {
		driver = init_browser(prop.getProperty("browser"), prop.getProperty("url"));
		HomePageInvestor homePageInvestor = new HomePageInvestor(driver);

		String parent = driver.getWindowHandle();

		// click on Powered By button
		homePageInvestor.clickOnPoweredBy();

		// Should redirect to fund website
		Thread.sleep(3000);

		Set<String> title = driver.getWindowHandles();
		Iterator<String> itr = title.iterator();
		while (itr.hasNext()) {
			String childWindw = itr.next();
			if (!parent.equals(childWindw)) {
				driver.switchTo().window(childWindw);
				Assert.assertTrue(homePageInvestor.validateFundingPageText());
			}
		}
	}

}
