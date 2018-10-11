package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;
import util.Constants;

public class LaunchPage extends BasePage {

	public LaunchPage(WebDriver driver,ExtentTest test) {
		super(driver,test);
	}

	@FindBy(xpath=Constants.USERNAME_XPATH)
	public WebElement uName;
	
	@FindBy(xpath=Constants.PASSWORD_XPATH)
	public WebElement password;
	
	
	public void navigate(String website){
		test.log(LogStatus.INFO, "navigating to the website");
		driver.get(website);
	}
	
	
	public void doLogin(String userName, String password1) {

		uName.sendKeys(userName);
		password.sendKeys(password1+ Keys.RETURN);
//		boolean loginSuccess= true;
//		return loginSuccess;
		
		//or
		
		
		//do the reporting/assertion here
	}

}
