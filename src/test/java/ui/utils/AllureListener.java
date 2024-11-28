package ui.utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.core.BaseTest;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

public class AllureListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        // Called when the test is starting
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Called when the test passes
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Page page = BaseTest.threadLocalPage.get();

            if (page != null) {
                // Capture screenshot on failure
                String screenshotPath = "screenshots/" + result.getMethod().getMethodName() + "_failure.png";
                byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));

                // Attach screenshot to Allure report
                Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(screenshotBytes));

                System.out.println("Screenshot captured for failed test: " + result.getMethod().getMethodName());
            } else {
                System.out.println("Page not found for screenshot.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Called when the test is skipped
    }

    @Override
    public void onStart(ITestContext context) {
        // Called before any tests start
    }

    @Override
    public void onFinish(ITestContext context) {
        // Called after all tests have finished
    }
}
