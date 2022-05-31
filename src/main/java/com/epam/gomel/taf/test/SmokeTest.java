package com.epam.gomel.taf.test;

import com.epam.gomel.taf.framework.bo.User;
import com.epam.gomel.taf.framework.factory.UserFactory;
import com.epam.gomel.taf.framework.ui.SeleniumUI;
import com.epam.gomel.taf.framework.utils.TestListener;
import com.epam.gomel.taf.report_portal.service.LogInService;
import com.epam.gomel.taf.report_portal.service.NavigationBarService;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.epam.gomel.taf.report_portal.pages.AbstractPage.uI;
import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class, ReportPortalTestNGListener.class})
public class SmokeTest {
    private User user = UserFactory.defaultUser();
    private User admin = UserFactory.admin();
    private User wrongUser = UserFactory.wrongUser();
    private LogInService logInService = new LogInService();
    private NavigationBarService navigationBarService = new NavigationBarService();

    @Test(dataProvider = "users")
    public void checkUserLoggedIn(User testUser) {
        SoftAssert softAssert = new SoftAssert();
        logInService.logIn(testUser);
        softAssert.assertTrue(navigationBarService.isLoggedIn(testUser.getLogin()), "User logging in failed");
        navigationBarService.logout(testUser.getLogin());
        softAssert.assertTrue(logInService.isLoggedOut(testUser.getLogin()), "User logging out failed");
        softAssert.assertAll();
    }

    @Test
    public void checkWrongUserLoggedIn() {
        logInService.logIn(wrongUser);
        assertTrue(logInService.isLogInFailed(wrongUser.getLogin()), "User logging in failed");
    }

    @AfterClass(alwaysRun = true)
    public void logoutAndCloseBrowser() {
        uI.stopBrowser();
    }

    @DataProvider(name = "users")
    public Object[][] dataProvider() {
        return new Object[][]{{user}, {admin}};
    }
}
