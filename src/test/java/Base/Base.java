package Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

import utils.Utilities;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;


	public  Base() {
	    prop = new Properties();
		File propFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\Config.properties");

		dataProp=new Properties();
		File dataPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\testData\\testData.properties");

		try {
		FileInputStream fis2= new FileInputStream(dataPropFile);
		dataProp.load(fis2);
		}catch(Throwable e) {
			e.printStackTrace();
		}


		try {
		FileInputStream fis= new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver init_browser(String browserName, String Url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(Url);
		return driver;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
