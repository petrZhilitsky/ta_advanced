package com.epam.gomel.taf.framework.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.epam.gomel.taf.framework.logger.Log.debug;
import static com.epam.gomel.taf.framework.logger.Log.error;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        debug("Start test " + iTestResult.getName());
        JiraService.updateIssueStatus("TAF-1", "In Progress");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        debug("Test " + iTestResult.getName() + " succeeded");
        JiraService.updateIssueStatus("TAF-1", "Done");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        error("Test " + iTestResult.getName() + " failed");
        JiraService.updateIssueStatus("TAF-1", "In Review");
        new ScreenshotUtils().takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        error("Test " + iTestResult.getName() + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        String testStarted = iTestContext.getName() + " started";
        debug(testStarted);
        SlackService.send(testStarted);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        String testFinished = iTestContext.getName() + " stopped";
        debug(testFinished);
        SlackService.send(testFinished);
    }
}
