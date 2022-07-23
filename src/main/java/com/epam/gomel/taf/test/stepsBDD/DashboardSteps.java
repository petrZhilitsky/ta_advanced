package com.epam.gomel.taf.test.stepsBDD;

import com.epam.gomel.taf.framework.factory.UserFactory;
import com.epam.gomel.taf.report_portal.pages.DashboardsPage;
import com.epam.gomel.taf.report_portal.pages.NavigationBar;
import com.epam.gomel.taf.report_portal.service.LogInService;
import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DashboardSteps {
    @Inject
    private DashboardSharedObject dashboardSharedObject = new DashboardSharedObject();

    NavigationBar navigationBar = new NavigationBar();
    DashboardsPage dashboardsPage = new DashboardsPage();

    @Given("^default user (?:is on|gets to|log in|logs in) (?:the app|app|report portal|RP app|RP)$")
    public void userLogsInApp() {
        new LogInService().logIn(UserFactory.defaultUser());
    }

    @Given("^default user (?:is on|gets to) Dashboards (?:page|screen)$")
    public void userGoesToDashboards() {
        navigationBar.navigateDashboards();
    }

    @When("^user clicks Add New Dashboard (?:button|element)$")
    public void userClicksAddDashboard() {
        dashboardsPage.clickAddDashboardButton();
    }

    @When("^user (?:inputs|types|enters) dashboard name '(.*)'$")
    public void userInputsDashboardName(String name) {
        dashboardSharedObject.setDashboardName(name);
        dashboardsPage.inputNewDashboardName(dashboardSharedObject.getDashboardName());
//        dashboardsPage.inputNewDashboardName(name);
    }

    @When("^user clicks Add (?:button|element)$")
    public void userClicksAddButton() {
        dashboardsPage.clickAddButton();
    }

    @Then("^Dashboard Added notification (?:appears|is shown)$")
    public void dashboardAddedNotificationAppears() {
        assertTrue(navigationBar.dashboardAddedCheck(), "Dashboard Added notification failed to appear");
    }

    @When("^user clicks Delete (?:icon|image|button) of dashboard$")
//    @When("^user clicks Delete (?:icon|image|button) of '(.*)' dashboard$")
//    public void userClicksDeleteDashboardByName(String name) {
    public void userClicksDeleteDashboardByName() {
        navigationBar.navigateDashboards();
        dashboardsPage.clickDeleteDashboardIconByName(dashboardSharedObject.getDashboardName());
//        dashboardsPage.clickDeleteDashboardIconByName(name);
    }

    @When("^user clicks Delete (?:button|element)$")
    public void userClicksDeleteButton() {
        dashboardsPage.clickDeleteButton();
    }

    @Then("^Dashboard Deleted notification (?:appears|is shown)$")
    public void dashboardDeletedNotificationAppears() {
        assertTrue(navigationBar.dashboardDeletedCheck(), "Dashboard Deleted notification failed to appear");
    }

    @When("^user clicks Edit (?:icon|image|button) of dashboard$")
    public void userClicksEditIcon() {
        dashboardsPage.clickEditDashboardIconByName("01_Dash");
    }

    @When("^user inputs (?:some|random|any) description$")
    public void userInputsDescription() {
        dashboardsPage.inputDashboardDescription(dashboardSharedObject.dashboardDescription);
    }

    @When("^user clicks Update (?:button|element)$")
    public void userClicksUpdateButton() {
        dashboardsPage.clickUpdateButton();
    }

    @Then("^dashboard has (?:updated|new|valid|current) description$")
    public void dashboardHasUpdatedDescription() {
        assertEquals(dashboardsPage.getDashboardDescriptionTextByName("01_Dash"), dashboardSharedObject.dashboardDescription);
    }
}
