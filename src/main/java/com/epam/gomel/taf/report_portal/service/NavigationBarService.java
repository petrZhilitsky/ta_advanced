package com.epam.gomel.taf.report_portal.service;

import com.epam.gomel.taf.framework.logger.Log;
import com.epam.gomel.taf.report_portal.pages.NavigationBar;

public class NavigationBarService {
    public void logout(String user) {
        Log.debug("Logging out user " + user);
        new NavigationBar()
                .clickUserAvatar()
                .clickLogout();
    }

    public boolean isLoggedIn(String login) {
        Log.debug("Checking user '" + login + "' logged in");
        return new NavigationBar().logInCheck();
    }

    public boolean isMainMenuItemsWorksCorrect() {
        Log.debug("Checking main menu items");
        return new NavigationBar().isMainMenuItemsWorksCorrect();
    }
}
