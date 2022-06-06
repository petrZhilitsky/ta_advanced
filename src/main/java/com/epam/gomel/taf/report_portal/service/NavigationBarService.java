package com.epam.gomel.taf.report_portal.service;

import com.epam.gomel.taf.report_portal.pages.NavigationBar;

import static com.epam.gomel.taf.framework.logger.Log.debug;

public class NavigationBarService {
    public void logout(String user) {
        debug("Logging out user " + user);
        new NavigationBar()
                .clickUserAvatar()
                .clickLogout();
    }

    public boolean isLoggedIn(String login) {
        debug("Checking user '" + login + "' logged in");
        return new NavigationBar().logInCheck();
    }

    public boolean isMainMenuItemsWorksCorrect() {
        debug("Checking main menu items");
        return new NavigationBar().isMainMenuItemsWorksCorrect();
    }
}
