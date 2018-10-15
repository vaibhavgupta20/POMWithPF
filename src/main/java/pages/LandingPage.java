package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BasePage;
import util.Constants;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	
	@FindBy(xpath = Constants.PROFILE_XPATH)
	public WebElement profileLink;
	
	
	public ProfilePage gotoProfilePage() {
		
		test.log(LogStatus.INFO	, "clicking on profile link");
		profileLink.click();
		ProfilePage profilePage = new ProfilePage(driver, test);
		PageFactory.initElements(driver, profilePage);
		return profilePage;
		
		
		
	}
	
	

}
