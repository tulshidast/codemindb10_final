package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerImpl implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		Reporter.log("Test case started " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test case success " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test case failed " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
