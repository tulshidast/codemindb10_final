package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	WebDriver driver;
	WebElement olderNewsLettersDropdown;
	WebElement multiSelectDropdown;
	WebElement orageCheckbox;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public WebElement getOlderNewsLettersDropdown() {
		setOlderNewsLettersDropdown();
		return olderNewsLettersDropdown;
	}

	public void setOlderNewsLettersDropdown() {
		this.olderNewsLettersDropdown = driver.findElement(By.cssSelector("select#drop1"));
	}

	public WebElement getMultiSelectDropdown() {
		setMultiSelectDropdown();
		return multiSelectDropdown;
	}

	public void setMultiSelectDropdown() {
		this.multiSelectDropdown = driver.findElement(By.cssSelector("select#multiselect1"));
	}

	public WebElement getOrageCheckbox() {
		setOrageCheckbox();
		return orageCheckbox;
	}

	public void setOrageCheckbox() {
		this.orageCheckbox = driver.findElement(By.cssSelector("#checkbox1"));
	}

}
