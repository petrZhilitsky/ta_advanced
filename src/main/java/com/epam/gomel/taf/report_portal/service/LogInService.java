package com.epam.gomel.taf.report_portal.service;

import com.epam.gomel.taf.framework.bo.*;
import com.epam.gomel.taf.report_portal.pages.LogInPage;
import com.epam.gomel.taf.report_portal.pages.NavigationBar;

import static com.epam.gomel.taf.framework.logger.Log.debug;

public class LogInService {
    public void logIn(User user) {
        debug("Logging in user " + user.toString());
        new LogInPage()
                .openPage()
                .inputLogin(user.getLogin())
                .inputPassword(user.getPassword())
                .clickConfirm();
    }

    public boolean isLogInFailed(String login) {
        debug("Checking user '" + login + "' failed to log in");
        return new NavigationBar().logInFailCheck();
    }

    public boolean isLoggedOut(String login) {
        debug("Checking user '" + login + "' logged out");
        return new NavigationBar().logOutCheck();
    }
}
