package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewPage extends BasePage {

	WebDriver driver;
	WebElement heading;

	public NewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public WebElement getHeading() {
		setHeading();
		return heading;
	}

	public void setHeading() {
		this.heading = driver.findElement(By.xpath("//h3[text()='New Window']"));
	}

}
