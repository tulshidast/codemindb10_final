package testcases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.HomePage;
import utility.CommonUtils;

public class VerifyDropDopdownOptions extends BaseTest {

	HomePage homePage;

	@Test(description = "Verify dropdown options", enabled = true, groups = { "sanity" }, priority = 1)
	public void verifyDropdownOptions() {
		homePage = new HomePage(driver);
		WebElement getOlderNewsLetterDropdown = homePage.getOlderNewsLettersDropdown();
		List<String> expectedDropdownOptions = Arrays.asList("Older Newsletters", "doc 1", "doc 2", "doc 3", "doc 4");
		List<String> allDropdownOptions = CommonUtils.getAllOptionsFromDropdown(getOlderNewsLetterDropdown);
		verify.assertEquals(allDropdownOptions, expectedDropdownOptions, "Dropdown not having mentioned options");
		verify.assertAll();
	}

}
