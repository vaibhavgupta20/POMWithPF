package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;
import util.Constants;

public class LaunchPage extends BasePage {

	public LaunchPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	@FindBy(xpath = Constants.USERNAME_XPATH)
	public WebElement uName;

	@FindBy(xpath = Constants.PASSWORD_XPATH)
	public WebElement password;

	public void navigate(String website) {
		test.log(LogStatus.INFO, "navigating to the website");
		driver.get(website);
	}

	public LandingPage doLogin(String userName, String password1) {

		uName.sendKeys(userName);
		password.sendKeys(password1 + Keys.RETURN);

		boolean result = isElementPresent(Constants.PROFILE_XPATH);

		if (result) {
			//login success
			test.log(LogStatus.INFO, "Login Successful");
			LandingPage landingPage = new LandingPage(driver, test);
			PageFactory.initElements(driver, landingPage);
			return landingPage;
			
			
		}else {
			//login failed
			reportFailure("Login Unsuccessful");
			return null;
		}
		
	}

}
