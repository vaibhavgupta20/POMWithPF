package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.TopMenu;
import util.Constants;

public class BasePage {

	public WebDriver driver;
	public ExtentTest test;
	public TopMenu menu;

	public BasePage() {
	}

	public BasePage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
//		menu = new TopMenu(driver);
//		PageFactory.initElements(driver, menu);

	}

	public boolean isElementPresent(String locator) {
		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0) {
			// element doesn't exist
			return false;
		} else {
			// element exists
			return true;
		}
	}

	public void reportFailure(String failureMessage) {

		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}

	public void takeScreenShot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = Constants.REPORTS_PATH + "screenshots//" + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	}

}
