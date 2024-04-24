package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtils {

	public static void selectValueFromDropdown(WebElement dropdownLocator, String optionToBeSelected) {

		Select select = new Select(dropdownLocator);
		select.selectByVisibleText(optionToBeSelected);

	}

	public static List<String> getAllOptionsFromDropdown(WebElement dropdownLocator) {

		Select select = new Select(dropdownLocator);
		List<WebElement> allOptions = select.getOptions();

		List<String> options = new ArrayList<String>();
		for (WebElement option : allOptions) {
			options.add(option.getText());
		}

		return options;

	}

	public static List<String> readExcel(String filePath, String sheetName) throws InvalidFormatException, IOException {

		File file = new File(filePath);
//		FileInputStream fileInputStream = new FileInputStream(file);

		List<String> userData = new ArrayList<String>();

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);

		XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

		int lastRowNum = xssfSheet.getLastRowNum();

		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow xssfRow = xssfSheet.getRow(i);

			int lastCellNum = xssfRow.getLastCellNum();
			for (int j = 0; j < lastCellNum; j++) {
				userData.add(xssfRow.getCell(j).toString());
			}
		}
		xssfWorkbook.close();
		return userData;

	}

	public static void takesScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file,
				new File("src/test/resources/screenshot/" + name + System.currentTimeMillis() + ".png"));

	}

	public static String readProperty(String key) {

		String value = null;
		try {
			File file = new File("src/test/resources/testdata.properties");
			FileInputStream fileInputStream = new FileInputStream(file);

			Properties properties = new Properties();
			properties.load(fileInputStream);
			value = properties.getProperty(key);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}

		return value;

	}

}
