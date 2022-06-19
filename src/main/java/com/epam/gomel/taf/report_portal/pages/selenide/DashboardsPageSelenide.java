package com.epam.gomel.taf.report_portal.pages.selenide;

import org.openqa.selenium.By;

import static com.epam.gomel.taf.framework.ui.SelenideUI.getInstance;

public class DashboardsPageSelenide {
    private static final String DASHBOARD_TITLE_CELL_PATTERN = "(//a[contains(@class,'dashboardTable__name')])[%d]";
    private static final String WIDGET_PATTERN = "//div[text()='%s']/ancestor::div[contains(@class,'react-grid-item')]";

    public DashboardsPageSelenide clickDashboardTitleByRow(int row) {
        getInstance().click(By.xpath(String.format(DASHBOARD_TITLE_CELL_PATTERN, row)));
        return this;
    }

    public DashboardsPageSelenide clickWidgetArrowAndResizeByName(String name, int xOffset) {
        getInstance().dragAndDrop(By.xpath(String.format(WIDGET_PATTERN, name) + "//span[contains(@class,'resizable-handle')]"), xOffset, 0);
        return this;
    }

    public String getWidgetStyleValueByName(String name) {
        return getInstance().getElementAttribute(By.xpath(String.format(WIDGET_PATTERN, name)), "style");
    }

    public String getWidgetContentStyleValue(String name) {
        return getInstance().getElementAttribute(By.xpath(String.format(WIDGET_PATTERN, name) + "//*[@style='overflow: hidden;']"), "width");
    }
}
