package com.epam.gomel.taf.framework.utils;

import com.epam.gomel.taf.framework.logger.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.debug("Start test " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.debug("Test " + iTestResult.getName() + " succeeded");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.error("Test " + iTestResult.getName() + " failed");
        new ScreenshotUtils().takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.error("Test " + iTestResult.getName() + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.debug(iTestContext.getName() + " started");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.debug(iTestContext.getName() + " stopped");
    }
}
