package com.epam.gomel.taf.test;

import com.epam.gomel.taf.framework.bo.User;
import com.epam.gomel.taf.framework.factory.UserFactory;
import com.epam.gomel.taf.framework.ui.SelenideUI;
import com.epam.gomel.taf.framework.utils.TestListener;
import com.epam.gomel.taf.report_portal.service.SelenideService;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class, ReportPortalTestNGListener.class})
public class DashboardsTest {
    private User user = UserFactory.defaultUser();
    private SelenideService selenideService = new SelenideService();

    @BeforeClass
    public void logInUser() {
        selenideService.logIn(user);
    }

    @Test
    public void checkDashboardWidgetResize() {
        assertTrue(selenideService.isDashboardWidgetResizedAndMoved());
    }

    @AfterClass(alwaysRun = true)
    public void logoutAndCloseBrowser() {
        SelenideUI.getInstance().stopBrowser();
    }
}
