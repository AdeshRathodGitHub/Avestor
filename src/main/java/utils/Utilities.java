package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=10;

	public  static String captureScreenShot(WebDriver driver,String testName) {
   	 File srcScreenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destPath=System.getProperty("user.dir")+"\\ScreenShot\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot, new File(destPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destPath;
    }

}
