package qvident.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static ebay.helpers.ScreenShotHelper.makeScreenshot;

public class OnFailListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            makeScreenshot("Failure screenshot");
        } catch (IOException e) {
            throw new RuntimeException("[AUT-ERROR] The screenshot on complete failure of test" +
                    " wasn't made, but should be :: ", e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            makeScreenshot("Skipped methods screenshot");
        } catch (IOException e) {
            throw new RuntimeException("[AUT-ERROR] The screenshot on skipped test or method " +
                    " wasn't made, but should be :: ", e);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        try {
            makeScreenshot("Failure screenshot");
        } catch (IOException e) {
            throw new RuntimeException("[AUT-ERROR] The screenshot wasn't made, but should be :: ", e);
        }
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}