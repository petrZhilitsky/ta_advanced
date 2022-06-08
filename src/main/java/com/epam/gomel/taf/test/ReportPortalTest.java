package com.epam.gomel.taf.test;

import com.epam.gomel.taf.framework.bo.User;
import com.epam.gomel.taf.framework.factory.UserFactory;
import com.epam.gomel.taf.framework.ui.Browser;
import com.epam.gomel.taf.framework.utils.TestListener;
import com.epam.gomel.taf.report_portal.service.LogInService;
import com.epam.gomel.taf.report_portal.service.MainService;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class, ReportPortalTestNGListener.class})
public class ReportPortalTest {
    private User user = UserFactory.defaultUser();
    private LogInService logInService = new LogInService();
    private MainService mainService = new MainService();

    @BeforeClass
    public void logInUser() {
        logInService.logIn(user);
    }

    @Test
    public void checkLoggedInReportPortal() {
        assertTrue(mainService.isLoggedIn(user.getLogin()), "User logging in failed");
    }

    @Test
    public void checkNavigationMenuItems() {
        assertTrue(mainService.isMainMenuItemsWorksCorrect(), "Main Menu items navigation failed");
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        Browser.getInstance().stopBrowser();
    }
}
