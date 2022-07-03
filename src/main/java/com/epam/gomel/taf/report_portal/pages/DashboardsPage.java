package com.epam.gomel.taf.report_portal.pages;

import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.SeleniumUI.getInstance;

public class DashboardsPage {
    private static final String DELETE_DASHBOARD_BUTTON_PATTERN = "//*[text()='%s']/following-sibling::*//*[contains(@class,'icon-delete')]";

    private final By addNewDashboardButton = By.xpath("//div[contains(@class,'addDashboardButton')]//button");
    private final By dashboardNameInput = By.xpath("//input[@placeholder='Enter dashboard name']");
    private final By addButton = By.xpath("//button[text()='Add']");
    private final By deleteButton = By.xpath("//button[text()='Delete']");

    public DashboardsPage clickAddDashboardButton() {
        getInstance().click(addNewDashboardButton);
        return this;
    }

    public DashboardsPage inputNewDashboardName(String name) {
        getInstance().clearAndType(dashboardNameInput, name);
        return this;
    }

    public DashboardsPage clickAddButton() {
        getInstance().click(addButton);
        return this;
    }

    public DashboardsPage clickDeleteButton() {
        getInstance().click(deleteButton);
        return this;
    }

    public DashboardsPage clickDeleteDashboardIconByName(String name) {
        getInstance().click(By.xpath(String.format(DELETE_DASHBOARD_BUTTON_PATTERN, name)));
        return this;
    }
}
