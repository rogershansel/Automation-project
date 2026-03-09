package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import base.BaseTest;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getReporter();

    public void onStart(ITestContext context) {}

    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
    }

    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {

        ExtentTest test = ExtentTestManager.getTest();
        test.fail(result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        if (driver != null) {
            String base64Screenshot = ScreenshotUtil.captureScreenshotAsBase64(driver);
            if (base64Screenshot != null) {
                test.fail("Screenshot on failure: ",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
        }
    }

    public void onFinish(ITestContext context) {

        extent.flush();
    }
}