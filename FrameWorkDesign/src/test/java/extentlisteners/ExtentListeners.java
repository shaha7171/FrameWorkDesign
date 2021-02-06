package extentlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.TestBase;


public class ExtentListeners extends TestBase implements ITestListener {

	//ExtentReports,ExtentTest is defined in Batch1
	/*
	 * public static ExtentReports extent; public static ExtentTest test; public
	 * static WebDriver driver;
	 */
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case: "+ result.getMethod().getMethodName()+ " is passed.");

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case: "+ result.getMethod().getMethodName()+ " is fail.");
		test.log(Status.FAIL, result.getThrowable());
		//Attaching screenshots for the failed test case
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		String errorImage = "Extent_Report_"+d.toString().replace(":", "_").replace(" ", "_")+".jpeg";
		
		String screenShotpath = System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\Screenshots\\"+errorImage;
		
		File dest = new File(screenShotpath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShotpath, "Test case failure screenshot");
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		extent = ExtentManager.setupExtentReport();
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
