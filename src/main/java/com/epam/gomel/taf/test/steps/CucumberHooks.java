package com.epam.gomel.taf.test.steps;

import com.epam.gomel.taf.framework.factory.UserFactory;
import com.epam.gomel.taf.report_portal.service.LogInService;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.epam.gomel.taf.framework.ui.SeleniumUI.getInstance;

public class CucumberHooks {
    @Before
    public void openStore() {
        new LogInService().logIn(UserFactory.defaultUser());
    }

    @After
    public void closeBrowser() {
        getInstance().stopBrowser();
    }
}
