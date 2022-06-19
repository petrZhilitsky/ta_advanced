package com.epam.gomel.taf.report_portal.service;

import com.epam.gomel.taf.framework.bo.User;
import com.epam.gomel.taf.framework.logger.Log;
import com.epam.gomel.taf.report_portal.pages.selenide.DashboardsPageSelenide;
import com.epam.gomel.taf.report_portal.pages.selenide.LogInPageSelenide;
import com.epam.gomel.taf.report_portal.pages.selenide.NavigationBarSelenide;

public class SelenideService {
    NavigationBarSelenide navigationBarSelenide = new NavigationBarSelenide();
    DashboardsPageSelenide dashboardsPageSelenide = new DashboardsPageSelenide();

    public void logIn(User user) {
        Log.debug("Logging in user " + user.toString());
        new LogInPageSelenide()
                .openPage()
                .inputLogin(user.getLogin())
                .inputPassword(user.getPassword())
                .clickConfirm();
    }

    public boolean isDashboardWidgetResizedAndMoved() {
        Log.debug("Resizing widget ");
        String widgetToChange = "example_1";
        String otherWidget = "default_1";

        navigationBarSelenide.navigateDashboards();
        dashboardsPageSelenide.clickDashboardTitleByRow(1);

        String firstWidgetInitialStyle = dashboardsPageSelenide.getWidgetStyleValueByName(widgetToChange);
        String firstWidgetInitialContentWidth = dashboardsPageSelenide.getWidgetContentStyleValue(widgetToChange);
        String secondWidgetInitialStyle = dashboardsPageSelenide.getWidgetStyleValueByName(otherWidget);

        dashboardsPageSelenide.clickWidgetArrowAndResizeByName(widgetToChange, 600);

        String firstWidgetChangedStyle = dashboardsPageSelenide.getWidgetStyleValueByName(widgetToChange);
        String firstWidgetChangedContentWidth = dashboardsPageSelenide.getWidgetContentStyleValue(widgetToChange);
        String secondWidgetChangedStyle = dashboardsPageSelenide.getWidgetStyleValueByName(otherWidget);

        boolean isWidgetSizeChanged = !firstWidgetInitialStyle.equals(firstWidgetChangedStyle);
        boolean isWidgetContentWidthChanged = !firstWidgetInitialContentWidth.equals(firstWidgetChangedContentWidth);
        boolean isOtherWidgetMoved = !secondWidgetInitialStyle.equals(secondWidgetChangedStyle);

        dashboardsPageSelenide.clickWidgetArrowAndResizeByName(widgetToChange, -600);

        return isWidgetSizeChanged && isWidgetContentWidthChanged && isOtherWidgetMoved;
    }


}
