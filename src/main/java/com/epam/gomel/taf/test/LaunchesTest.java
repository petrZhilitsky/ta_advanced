package com.epam.gomel.taf.test;

import com.epam.gomel.taf.framework.factory.UserFactory;
import com.epam.gomel.taf.framework.ui.Browser;
import com.epam.gomel.taf.report_portal.service.LaunchesService;
import com.epam.gomel.taf.report_portal.service.LogInService;
import com.epam.gomel.taf.report_portal.service.NavigationBarService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class LaunchesTest {
    private LaunchesService launchesService = new LaunchesService();
    private int number;

    public LaunchesTest(int number) {
        this.number = number;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        return Arrays.asList(data);
    }

    @BeforeClass
    public static void logInUser() {
        new LogInService().logIn(UserFactory.defaultUser());
    }

    @Test
    public void checkLaunchAndSuiteOverviewContainsAllCounters() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(launchesService.isLaunchesOverviewContainsAllCounters(number), "Some counters are absent on Launches overview");
        softAssert.assertTrue(launchesService.isLaunchContainsAllCounters(number), "Some counters are absent on Launch details");
        softAssert.assertAll();
    }

    @AfterClass
    public static void logoutAndCloseBrowser() {
        new NavigationBarService().logout(UserFactory.defaultUser().getLogin());
        Browser.getInstance().stopBrowser();
    }
}
