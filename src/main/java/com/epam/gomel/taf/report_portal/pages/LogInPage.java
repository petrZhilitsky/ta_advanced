package com.epam.gomel.taf.report_portal.pages;

import com.epam.gomel.taf.framework.factory.Constants;
import org.openqa.selenium.By;

public class LogInPage extends AbstractPage {
    private final By loginInput = By.xpath("//input[@placeholder='Login']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By confirmButton = By.xpath("//button[@type='submit' and text()='Login']");

    public LogInPage openPage() {
        uI.get(Constants.RP_URL_LOG_IN);
        return this;
    }

    public LogInPage inputLogin(String login) {
        uI.type(loginInput, login);
        return this;
    }

    public LogInPage inputPassword(String password) {
        uI.type(passwordInput, password);
        return this;
    }

    public LogInPage clickConfirm() {
        uI.click(confirmButton);
        return this;
    }
}
