package com.epam.gomel.taf.test;

import com.epam.gomel.taf.framework.bo.APIDashboard;
import com.epam.gomel.taf.framework.bo.APIWidget;
import com.epam.gomel.taf.framework.logger.Log;
import com.epam.gomel.taf.report_portal.api.APIRequests;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class APITest {
    @Test
    public void checkDashboardAndWidgetAPIActions() {
        SoftAssert softAssert = new SoftAssert();
        APIRequests apiRequests = new APIRequests();
        String dashboardName = randomAlphabetic(10);
        String widgetName = randomAlphabetic(10);

        // POST; Create dashboard
        Response dashboardPostResponse = apiRequests.createNewDashboardByName(dashboardName);
        softAssert.assertEquals(dashboardPostResponse.statusCode(), 201);

        // GET; Get dashboard
        int dashboardId = dashboardPostResponse.jsonPath().getInt("id");
        APIDashboard dashboard = apiRequests.getDashboardAsObjectById(dashboardId);
        softAssert.assertEquals(dashboard.getName(), dashboardName);

        // PUT; Modify dashboard
        Response dashboardPutResponse = apiRequests.updateDashboardDescription(dashboard, "Descr");
        softAssert.assertEquals(dashboardPutResponse.statusCode(), 200);

        // POST; Create widget
        Response widgetPostResponse = apiRequests.createNewWidgetByName(widgetName);
        softAssert.assertEquals(widgetPostResponse.statusCode(), 201);

        // GET; Get widget
        int widgetId = widgetPostResponse.jsonPath().getInt("id");
        APIWidget widget = apiRequests.getWidgetAsObjectById(widgetId);
        softAssert.assertEquals(widget.getName(), widgetName);

        // PUT; Add widget to dashboard
        Response widgetPutResponse1 = apiRequests.addWidgetToDashboardByIds(dashboardId, widgetId);
        softAssert.assertEquals(widgetPutResponse1.statusCode(), 200);

        // PUT; Modify widget
        Response widgetPutResponse2 = apiRequests.updateWidgetDescription(widget, "Descr");
        softAssert.assertEquals(widgetPutResponse2.statusCode(), 200);

        // DELETE; Delete widget
        Response widgetDeleteResponse = apiRequests.deleteWidgetById(dashboardId, widgetId);
        softAssert.assertEquals(widgetDeleteResponse.statusCode(), 200);

        // DELETE; Delete dashboard
        Response dashboardDeleteResponse = apiRequests.deleteDashboardById(dashboardId);
        softAssert.assertEquals(dashboardDeleteResponse.statusCode(), 200);

        softAssert.assertAll();
    }
}
