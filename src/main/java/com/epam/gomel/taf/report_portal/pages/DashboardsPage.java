package com.epam.gomel.taf.report_portal.pages;

import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.SeleniumUI.getInstance;

public class DashboardsPage {
    private static final String DELETE_DASHBOARD_BUTTON_PATTERN = "//*[text()='%s']/following-sibling::*//*[contains(@class,'icon-delete')]";
    private static final String EDIT_DASHBOARD_BUTTON_PATTERN = "//*[text()='%s']/following-sibling::*//*[contains(@class,'icon-pencil')]";
    private static final String DASHBOARD_DESCRIPTION_PATTERN = "//*[text()='%s']/following-sibling::*[contains(@class,'dashboardTable__description')]";

    private final By addNewDashboardButton = By.xpath("//div[contains(@class,'addDashboardButton')]//button");
    private final By dashboardNameInput = By.xpath("//input[@placeholder='Enter dashboard name']");
    private final By dashboardDescriptionInput = By.xpath("//textarea[@placeholder='Enter dashboard description']");
    private final By addButton = By.xpath("//button[text()='Add']");
    private final By updateButton = By.xpath("//button[text()='Update']");
    private final By deleteButton = By.xpath("//button[text()='Delete']");

    public DashboardsPage clickAddDashboardButton() {
        getInstance().click(addNewDashboardButton);
        return this;
    }

    public DashboardsPage inputNewDashboardName(String name) {
        getInstance().clearAndType(dashboardNameInput, name);
        return this;
    }

    public DashboardsPage inputDashboardDescription(String description) {
        getInstance().clearAndType(dashboardDescriptionInput, description);
        return this;
    }

    public DashboardsPage clickAddButton() {
        getInstance().click(addButton);
        return this;
    }

    public DashboardsPage clickUpdateButton() {
        getInstance().click(updateButton);
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

    public DashboardsPage clickEditDashboardIconByName(String name) {
        getInstance().click(By.xpath(String.format(EDIT_DASHBOARD_BUTTON_PATTERN, name)));
        return this;
    }

    public String getDashboardDescriptionTextByName(String name) {
        return getInstance().getText(By.xpath(String.format(DASHBOARD_DESCRIPTION_PATTERN, name)));
    }
}
