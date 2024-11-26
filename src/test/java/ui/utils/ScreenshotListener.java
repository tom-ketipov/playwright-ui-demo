package ui.utils;

import com.microsoft.playwright.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.core.BaseTest;

import java.nio.file.Paths;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Page page = BaseTest.threadLocalPage.get();

            if (page != null) {
                String screenshotPath = "screenshots/" + result.getMethod().getMethodName() + "_failure.png";
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)));
                System.out.println("Screenshot captured for failed test: " + result.getMethod().getMethodName());
            } else {
                System.out.println("Page not found for screenshot.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}
