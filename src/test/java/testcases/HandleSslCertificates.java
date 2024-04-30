package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleSslCertificates {

	@Test

	public void sslCertificateHandling() {

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.close();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://expired.badssl.com/");

		// comment added 
		Assert.assertEquals(driver.getTitle(), "expired.badssl.com");

		driver.findElement(By.cssSelector("#as"));
	}

}
