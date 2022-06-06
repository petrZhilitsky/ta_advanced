package com.epam.gomel.taf.test;

import com.epam.gomel.taf.framework.factory.UserFactory;
import com.epam.gomel.taf.framework.ui.Browser;
import com.epam.gomel.taf.report_portal.service.LaunchesService;
import com.epam.gomel.taf.report_portal.service.LogInService;
import com.epam.gomel.taf.report_portal.service.NavigationBarService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.testng.Assert.assertTrue;

public class LaunchesTest {
    private LaunchesService launchesService = new LaunchesService();

    @BeforeClass
    public static void logInUser() {
        new LogInService().logIn(UserFactory.defaultUser());
    }

    @Test
    public void checkLaunchesOverviewContainsAllCounters() {
        assertTrue(launchesService.isLaunchesOverviewContainsAllCounters(), "Some counters are absent on Launches overview");
    }

    @Test
    public void checkLaunchContainsAllCounters() {
        assertTrue(launchesService.isLaunchContainsAllCounters(), "Some counters are absent on Launch details");
    }

    @AfterClass
    public static void logoutAndCloseBrowser() {
        new NavigationBarService().logout(UserFactory.defaultUser().getLogin());
        Browser.getInstance().stopBrowser();
    }
}
