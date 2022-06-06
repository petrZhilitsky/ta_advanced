package com.epam.gomel.taf.report_portal.service;

import com.epam.gomel.taf.report_portal.pages.LaunchesPage;
import com.epam.gomel.taf.report_portal.pages.NavigationBar;

import static com.epam.gomel.taf.framework.logger.Log.debug;

public class LaunchesService {
    public boolean isLaunchesOverviewContainsAllCounters() {
        debug("Checking test launch counters on Launches overview");
        new NavigationBar().navigateLaunches();
        return new LaunchesPage().isCountersVisibleByRow(1);
    }

    public boolean isLaunchContainsAllCounters() {
        debug("Checking test launch counters on Launch details");
        new NavigationBar().navigateLaunches();
        return new LaunchesPage()
                .clickLaunchTitleByRow(1)
                .launchTitleBreadcrumbShouldBeVisible()
                .isCountersVisibleByRow(1);
    }
}
