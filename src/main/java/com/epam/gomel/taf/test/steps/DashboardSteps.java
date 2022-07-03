package com.epam.gomel.taf.test.steps;

import com.epam.gomel.taf.report_portal.pages.DashboardsPage;
import com.epam.gomel.taf.report_portal.pages.NavigationBar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertTrue;

public class DashboardSteps {
    NavigationBar navigationBar = new NavigationBar();
    DashboardsPage dashboardsPage = new DashboardsPage();

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
        dashboardsPage.inputNewDashboardName(name);
    }

    @When("^user clicks Add (?:button|element)$")
    public void userClicksAddButton() {
        dashboardsPage.clickAddButton();
    }

    @Then("^Dashboard Added notification (?:appears|is shown)$")
    public void dashboardAddedNotificationAppears() {
        assertTrue(navigationBar.dashboardAddedCheck(), "Dashboard Added notification failed to appear");
    }

    @When("^user clicks Delete (?:icon|image|button) of '(.*)' dashboard$")
    public void userClicksDeleteDashboardByName(String name) {
        dashboardsPage.clickDeleteDashboardIconByName(name);
    }

    @When("^user clicks Delete (?:button|element)$")
    public void userClicksDeleteButton() {
        dashboardsPage.clickDeleteButton();
    }

    @Then("^Dashboard Deleted notification (?:appears|is shown)$")
    public void dashboardDeletedNotificationAppears() {
        assertTrue(navigationBar.dashboardDeletedCheck(), "Dashboard Deleted notification failed to appear");
    }
}
