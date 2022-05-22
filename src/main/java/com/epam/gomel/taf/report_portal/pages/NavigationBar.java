package com.epam.gomel.taf.report_portal.pages;

import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.Browser.getInstance;

public class NavigationBar {
    //notifications
    private final By loginSuccessNotification = By.xpath("//div[@id='notification-root']//*[text()='Signed in successfully']");
    private final By logoutSuccessNotification = By.xpath("//div[@id='notification-root']//*[text()='You have been logged out']");
    private final By logoinFailNotification = By.xpath("//div[@id='notification-root']//*[contains(text(),'Bad credentials')]");
    //navigation sidebar menu
    private final By linkDashboards = By.xpath("//a[@href='#default_personal/dashboard']");
    private final By linkLaunches = By.xpath("//a[@href='#default_personal/launches']");
    private final By linkFilters = By.xpath("//a[@href='#default_personal/filters']");
    private final By linkDebug = By.xpath("//a[@href='#default_personal/userdebug/all']");
    private final By linkMembers = By.xpath("//a[@href='#default_personal/members']");
    private final By linkSettings = By.xpath("//a[@href='#default_personal/settings']");
    private final By userAvatar = By.xpath("//img[@alt='avatar']");
    private final By logoutButton = By.xpath("//div[text()='Logout']");

    public NavigationBar navigateDashboards() {
        getInstance().click(linkDashboards);
        return this;
    }

    public NavigationBar navigateLaunches() {
        getInstance().click(linkLaunches);
        return this;
    }

    public NavigationBar navigateFilters() {
        getInstance().click(linkFilters);
        return this;
    }

    public NavigationBar navigateDebug() {
        getInstance().click(linkDebug);
        return this;
    }

    public NavigationBar navigateMembers() {
        getInstance().click(linkMembers);
        return this;
    }

    public NavigationBar navigateSettings() {
        getInstance().click(linkSettings);
        return this;
    }

    public NavigationBar clickUserAvatar() {
        if (getInstance().isVisible(loginSuccessNotification)) {
            getInstance().click(loginSuccessNotification);
        }
        getInstance().click(userAvatar);
        return this;
    }

    public NavigationBar clickLogout() {
        getInstance().click(logoutButton);
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

    public boolean logOutCheck() {
        return getInstance().isVisible(logoutSuccessNotification);
    }

    public boolean logInFailCheck() {
        return getInstance().isVisible(logoinFailNotification);
    }
}
