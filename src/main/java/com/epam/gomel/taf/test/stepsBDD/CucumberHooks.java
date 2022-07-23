package com.epam.gomel.taf.test.stepsBDD;

import io.cucumber.java.After;

import static com.epam.gomel.taf.framework.ui.SeleniumUI.getInstance;

public class CucumberHooks {
    @After
    public void closeBrowser() {
        getInstance().stopBrowser();
    }
}
