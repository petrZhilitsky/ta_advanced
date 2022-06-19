package com.epam.gomel.taf.report_portal.pages.selenide;

import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.SelenideUI.getInstance;

public class NavigationBarSelenide {
    private final By linkDashboards = By.xpath("//a[@href='#default_personal/dashboard']");

    public NavigationBarSelenide navigateDashboards() {
        getInstance().click(linkDashboards);
        return this;
    }
}
