package com.epam.gomel.taf.report_portal.pages;

import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.Browser.getInstance;

public class LaunchesPage {
    private static final String EXECUTE_STATISTICS_COUNTER_CELL_PATTERN = "(//div[contains(@class,'launchSuiteGrid__%s')])[%d]//a";
    private static final String DEFECT_STATISTICS_COUNTER_CELL_PATTERN = "(//div[contains(@class,'launchSuiteGrid__%s')])[%d]//div[contains(@class,'total')]";
    private static final String LAUNCH_TITLE_CELL_PATTERN = "(//div[contains(@class,'launchSuiteGrid__name')])[%d]//a";

    private final By launchTitleBreadcrumb = By.xpath("(//span[contains(@class,'breadcrumb__link-item')])[2]");

    public LaunchesPage clickLaunchTitleByRow(int row) {
        getInstance().click(By.xpath(String.format(LAUNCH_TITLE_CELL_PATTERN, row)));
        return this;
    }

    public LaunchesPage launchTitleBreadcrumbShouldBeVisible() {
        getInstance().waitForVisibilityOfElement(launchTitleBreadcrumb);
        return this;
    }

    public boolean executionStatisticsCounterCheckByNameAndRow(String name, int row) {
        return getInstance().isVisible(By.xpath(String.format(EXECUTE_STATISTICS_COUNTER_CELL_PATTERN, name, row)));
    }

    public boolean defectStatisticsCounterCheckByNameAndRow(String name, int row) {
        return getInstance().isVisible(By.xpath(String.format(DEFECT_STATISTICS_COUNTER_CELL_PATTERN, name, row)));
    }

    public boolean isCountersVisibleByRow(int row) {
        boolean checkTotalCount = executionStatisticsCounterCheckByNameAndRow("total", row);
        boolean checkPassedCount = executionStatisticsCounterCheckByNameAndRow("passed", row);
        boolean checkFailedCount = executionStatisticsCounterCheckByNameAndRow("failed", row);
        boolean checkTSkippedCount = executionStatisticsCounterCheckByNameAndRow("skipped", row);
        boolean checkProductBugCount = defectStatisticsCounterCheckByNameAndRow("pb", row);
        boolean checkAutoBugCount = defectStatisticsCounterCheckByNameAndRow("ab", row);
        boolean checkSystemIssueCount = defectStatisticsCounterCheckByNameAndRow("si", row);
        boolean checkToInvestigateCount = defectStatisticsCounterCheckByNameAndRow("ti", row);

        return (checkTotalCount && checkPassedCount && checkFailedCount && checkTSkippedCount && checkProductBugCount
                && checkAutoBugCount && checkSystemIssueCount && checkToInvestigateCount);
    }
}
