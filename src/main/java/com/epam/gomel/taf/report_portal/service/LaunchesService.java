package com.epam.gomel.taf.report_portal.service;

import com.epam.gomel.taf.report_portal.pages.LaunchesPage;
import com.epam.gomel.taf.report_portal.pages.NavigationBar;

import static com.epam.gomel.taf.framework.logger.Log.debug;

public class LaunchesService {
    public boolean isLaunchesOverviewContainsAllCounters(int row) {
        debug("Checking test launch " + row + " counters on Launches overview");
        new NavigationBar().navigateLaunches();
        return new LaunchesPage().isCountersVisibleByRow(row);
    }

    public boolean isLaunchContainsAllCounters(int row) {
        debug("Checking test launch counters on Launch details " + row);
        new NavigationBar().navigateLaunches();
        return new LaunchesPage()
                .clickLaunchTitleByRow(row)
                .launchTitleBreadcrumbShouldBeVisible()
                .isCountersVisibleByRow(1);
    }
}
