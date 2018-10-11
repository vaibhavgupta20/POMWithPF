package common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu {

	@FindBy(xpath="")
	public WebElement name;

	WebDriver driver;

	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}

}
