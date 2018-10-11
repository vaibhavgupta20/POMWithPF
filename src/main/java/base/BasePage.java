package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import common.TopMenu;



public class BasePage {

	public WebDriver driver;
	public ExtentTest test;
	public TopMenu menu;

	public BasePage() {
	}

	public BasePage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test=test;
//		menu = new TopMenu(driver);
//		PageFactory.initElements(driver, menu);

	}

}
