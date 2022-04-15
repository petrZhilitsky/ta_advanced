package com.epam.gomel.taf.report_portal.pages;

import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.Browser.getInstance;

public class MainPage {
    private final By loginSuccessNotification = By.xpath("//div[@id='notification-root']//*[text()='Signed in successfully']");
    //navigation sidebar menu
    private final By linkDashboards = By.xpath("//a[@href='#default_personal/dashboard']");
    private final By linkLaunches = By.xpath("//a[@href='#default_personal/launches']");
    private final By linkFilters = By.xpath("//a[@href='#default_personal/filters']");
    private final By linkDebug = By.xpath("//a[@href='#default_personal/userdebug/all']");
    private final By linkMembers = By.xpath("//a[@href='#default_personal/members']");
    private final By linkSettings = By.xpath("//a[@href='#default_personal/settings']");

    public MainPage navigateDashboards() {
        getInstance().click(linkDashboards);
        return this;
    }

    public MainPage navigateLaunches() {
        getInstance().click(linkLaunches);
        return this;
    }

    public MainPage navigateFilters() {
        getInstance().click(linkFilters);
        return this;
    }

    public MainPage navigateDebug() {
        getInstance().click(linkDebug);
        return this;
    }

    public MainPage navigateMembers() {
        getInstance().click(linkMembers);
        return this;
    }

    public MainPage navigateSettings() {
        getInstance().click(linkSettings);
        return this;
    }

    public boolean isMainMenuItemsWorksCorrect() {
        navigateDashboards();
        boolean checkDashboardURL = getInstance().getCurrentUrl().contains("default_personal/dashboard");
        navigateLaunches();
        boolean checkLaunchesURL = getInstance().getCurrentUrl().contains("default_personal/launches/all");
        navigateFilters();
        boolean checkFiltersURL = getInstance().getCurrentUrl().contains("default_personal/filters");
        navigateDebug();
        boolean checkDebugURL = getInstance().getCurrentUrl().contains("default_personal/userdebug/all");
        navigateMembers();
        boolean checkMembersURL = getInstance().getCurrentUrl().contains("default_personal/members");
        navigateSettings();
        boolean checkSettingsURL = getInstance().getCurrentUrl().contains("default_personal/settings/general");

        return (checkDashboardURL && checkLaunchesURL && checkFiltersURL && checkDebugURL && checkMembersURL
                && checkSettingsURL);
    }

    public boolean logInCheck() {
        return getInstance().isVisible(loginSuccessNotification);
    }

}
