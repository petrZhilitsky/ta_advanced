package com.epam.gomel.taf.report_portal.service;

import com.epam.gomel.taf.framework.logger.Log;
import com.epam.gomel.taf.report_portal.pages.MainPage;

public class MainService {
    public boolean isLoggedIn(String login) {
        Log.debug("Checking user '" + login + "' logged in");
        return new MainPage().logInCheck();
    }

    public boolean isMainMenuItemsWorksCorrect() {
        Log.debug("Checking main menu items");
        return new MainPage().isMainMenuItemsWorksCorrect();
    }
}
