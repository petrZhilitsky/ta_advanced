package com.epam.gomel.taf.report_portal.pages;

import com.epam.gomel.taf.framework.factory.*;
import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.Browser.getInstance;

public class LogInPage {
    private final By loginInput = By.xpath("//input[@placeholder='Login']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By confirmButton = By.xpath("//button[@type='submit' and text()='Login']");

    public LogInPage openPage() {
        getInstance().get(Configuration.RP_URL_LOG_IN);
        return this;
    }

    public LogInPage inputLogin(String login) {
        getInstance().type(loginInput, login);
        return this;
    }

    public LogInPage inputPassword(String password) {
        getInstance().type(passwordInput, password);
        return this;
    }

    public LogInPage clickConfirm() {
        getInstance().click(confirmButton);
        return this;
    }
}
