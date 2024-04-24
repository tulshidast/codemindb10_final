package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {

	WebDriver driver;

	@Given("launch application")
	public void launch_application() throws Throwable {
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	@And("enter username")
	public void setUserName() {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Admin");
	}

	@And("enter password")
	public void setPassword() {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
	}

	@When("click on submit btn")
	public void clickOnSubmitBtn() {
		//
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}

	@Then("verify user is logged in successfully")
	public void verifyUserLoggedIn() {
		Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText(),
				"Login Successfully");

	}

}
