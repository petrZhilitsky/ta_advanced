package com.epam.gomel.taf.report_portal.pages;

import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.SeleniumUI.getInstance;

public class NavigationBar extends AbstractPage {
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
        uI.click(linkDashboards);
        return this;
    }

    public NavigationBar navigateLaunches() {
        uI.click(linkLaunches);
        return this;
    }

    public NavigationBar navigateFilters() {
        uI.click(linkFilters);
        return this;
    }

    public NavigationBar navigateDebug() {
        uI.click(linkDebug);
        return this;
    }

    public NavigationBar navigateMembers() {
        uI.click(linkMembers);
        return this;
    }

    public NavigationBar navigateSettings() {
        uI.click(linkSettings);
        return this;
    }

    public NavigationBar clickUserAvatar() {
        if (uI.isVisible(loginSuccessNotification)) {
            uI.click(loginSuccessNotification);
        }
        uI.click(userAvatar);
        return this;
    }

    public NavigationBar clickLogout() {
        uI.click(logoutButton);
        return this;
    }

    public boolean isMainMenuItemsWorksCorrect() {
        navigateDashboards();
        boolean checkDashboardURL = uI.getCurrentUrl().contains("default_personal/dashboard");
        navigateLaunches();
        boolean checkLaunchesURL = uI.getCurrentUrl().contains("default_personal/launches/all");
        navigateFilters();
        boolean checkFiltersURL = uI.getCurrentUrl().contains("default_personal/filters");
        navigateDebug();
        boolean checkDebugURL = uI.getCurrentUrl().contains("default_personal/userdebug/all");
        navigateMembers();
        boolean checkMembersURL = uI.getCurrentUrl().contains("default_personal/members");
        navigateSettings();
        boolean checkSettingsURL = uI.getCurrentUrl().contains("default_personal/settings/general");

        return (checkDashboardURL && checkLaunchesURL && checkFiltersURL && checkDebugURL && checkMembersURL
                && checkSettingsURL);
    }

    public boolean logInCheck() {
        return uI.isVisible(loginSuccessNotification);
    }

    public boolean logOutCheck() {
        return uI.isVisible(logoutSuccessNotification);
    }

    public boolean logInFailCheck() {
        return uI.isVisible(logoinFailNotification);
    }
}
