package testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseTest;
import pages.LandingPage;
import pages.LaunchPage;
import pages.ProfilePage;
import util.Constants;
import util.DataUtil;

public class ProfileTest extends BaseTest {

	String testCaseName = "ProfileTest";

	@Test(dataProvider = "getData")
	public void openProfile(Hashtable<String, String> data) {
		test = extent.startTest(testCaseName);

		if (!DataUtil.isTestExecutable(xls, testCaseName) || data.get(Constants.RUNMODE_XLS).equals("N")) {
			test.log(LogStatus.SKIP, "testcase runmode is N");
			throw new SkipException("testcase runmode is N");
		}

		init("chrome");
		test.log(LogStatus.INFO, "intiating launch page");
		LaunchPage LaunchP = new LaunchPage(driver, test);// empty object
		PageFactory.initElements(driver, LaunchP);
		LaunchP.navigate(Constants.WEBSITE_PROD_URL);// opening after creating object

		String uName = data.get("username");
		String password = data.get("password");

		LandingPage landingP = LaunchP.doLogin(uName, password);

		ProfilePage profileP = landingP.gotoProfilePage();

		profileP.verifyProfile();
		
		
		test.log(LogStatus.PASS, "Test Passed");

	}

	@AfterMethod
	public void quit() {

		extent.endTest(test);
		extent.flush();

		driver.quit();

	}

	@DataProvider
	public Object[][] getData() {

		return DataUtil.getData(xls, testCaseName);

	}

}
