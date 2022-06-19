package com.epam.gomel.taf.report_portal.pages.selenide;

import com.epam.gomel.taf.framework.factory.Constants;
import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.SelenideUI.getInstance;

public class LogInPageSelenide {
    private final By loginInput = By.xpath("//input[@placeholder='Login']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By confirmButton = By.xpath("//button[@type='submit' and text()='Login']");

    public LogInPageSelenide openPage() {
        getInstance().get(Constants.RP_URL_LOG_IN);
        return this;
    }

    public LogInPageSelenide inputLogin(String login) {
        getInstance().type(loginInput, login);
        return this;
    }

    public LogInPageSelenide inputPassword(String password) {
        getInstance().type(passwordInput, password);
        return this;
    }

    public LogInPageSelenide clickConfirm() {
        getInstance().click(confirmButton);
        return this;
    }
}
