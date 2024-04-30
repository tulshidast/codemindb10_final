package testcases;

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

		driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");

		Assert.assertEquals(driver.getTitle(), "expired.badssl.com");

		driver.quit();
	}

}
