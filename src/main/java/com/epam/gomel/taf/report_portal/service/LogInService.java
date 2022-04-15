package com.epam.gomel.taf.report_portal.service;

import com.epam.gomel.taf.framework.bo.*;
import com.epam.gomel.taf.framework.logger.Log;
import com.epam.gomel.taf.report_portal.pages.LogInPage;

public class LogInService {
    public void logIn(User user) {
        Log.debug("Logging in user " + user.toString());
        new LogInPage()
                .openPage()
                .inputLogin(user.getLogin())
                .inputPassword(user.getPassword())
                .clickConfirm();
    }
}
