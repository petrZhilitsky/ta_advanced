package com.epam.gomel.taf.test;

import com.epam.gomel.taf.framework.bo.User;
import com.epam.gomel.taf.framework.factory.UserFactory;
import com.epam.gomel.taf.framework.utils.TestListener;
import com.epam.gomel.taf.report_portal.service.LogInService;
import com.epam.gomel.taf.report_portal.service.NavigationBarService;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.gomel.taf.report_portal.pages.AbstractPage.uI;
import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class, ReportPortalTestNGListener.class})
public class ReportPortalTest {
    private User user = UserFactory.defaultUser();
    private LogInService logInService = new LogInService();
    private NavigationBarService navigationBarService = new NavigationBarService();

    @BeforeClass
    public void logInUser() {
        logInService.logIn(user);
    }

    @Test
    public void checkNavigationMenuItems() {
        assertTrue(navigationBarService.isMainMenuItemsWorksCorrect(), "Main Menu items navigation failed");
    }

    @AfterClass(alwaysRun = true)
    public void logoutAndCloseBrowser() {
        navigationBarService.logout(user.getLogin());
        uI.stopBrowser();
    }
}
