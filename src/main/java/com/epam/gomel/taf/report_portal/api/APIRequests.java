package com.epam.gomel.taf.report_portal.api;

import com.epam.gomel.taf.framework.bo.APIDashboard;
import com.epam.gomel.taf.framework.bo.APIWidget;
import com.epam.gomel.taf.framework.factory.Constants;
import io.restassured.response.Response;

import static com.epam.gomel.taf.framework.logger.Log.debug;
import static io.restassured.RestAssured.given;

public class APIRequests {
    protected static final String CONTENT_TYPE = "application/json";
    protected static final String URL = "http://localhost:8080/api/v1/default_personal";

    public Response createNewDashboardByName(String name) {
        debug("Adding new '" + name + "' dashboard");
        String requestBody = "{\n" +
                             "\"name\": \"" + name + "\"\n" +
                             "}";
        String postUrl = URL + "/dashboard/";
        return given()
                .contentType(CONTENT_TYPE)
                .auth()
                .oauth2(Constants.API_TOKEN)
                .body(requestBody)
                .when()
                .post(postUrl)
                .then()
                .extract()
                .response();
    }

    public Response createNewWidgetByName(String name) {
        debug("Adding new '" + name + "' widget");
        String requestBody = "{\n" +
                             "\"contentParameters\": {\"itemsCount\": 50},\n" +
                             "\"filterIds\": [2],\n" +
                             "\"name\": \"" + name + "\",\n" +
                             "\"widgetType\": \"launchesDurationChart\"\n" +
                             "}";
        String postUrl = URL + "/widget/";
        return given()
                .contentType(CONTENT_TYPE)
                .auth()
                .oauth2(Constants.API_TOKEN)
                .body(requestBody)
                .when()
                .post(postUrl)
                .then()
                .extract()
                .response();
    }

    public APIDashboard getDashboardAsObjectById(int id) {
        debug("Getting dashboard, ID = " + id);
        String getUrl = URL + "/dashboard/" + id;
        return given()
                .auth()
                .oauth2(Constants.API_TOKEN)
                .when()
                .get(getUrl)
                .as(APIDashboard.class);
    }

    public APIWidget getWidgetAsObjectById(int id) {
        debug("Getting dashboard, ID = " + id);
        String getUrl = URL + "/widget/" + id;
        return given()
                .auth()
                .oauth2(Constants.API_TOKEN)
                .when()
                .get(getUrl)
                .as(APIWidget.class);
    }

    public Response updateDashboardDescription(APIDashboard dashboard, String description) {
        debug("Updating dashboard description, ID = " + dashboard.getId());
        String requestBodyPUT = "{\n" +
                                "\"name\": \"" + dashboard.getName() + "\",\n" +
                                "\"description\": \"" + description + "\"\n" +
                                "}";
        String putUrl = URL + "/dashboard/" + dashboard.getId();
        return given()
                .contentType(CONTENT_TYPE)
                .auth()
                .oauth2(Constants.API_TOKEN)
                .body(requestBodyPUT)
                .when()
                .put(putUrl)
                .then()
                .extract()
                .response();
    }

    public Response addWidgetToDashboardByIds(int dashboardId, int widgetId) {
        debug("Adding widget ID = " + widgetId + " to dashboard ID = " + dashboardId);
        String requestBodyPUT = "{\n" +
                                "\"addWidget\": {\"widgetId\": " + widgetId + "}\n" +
                                "}";
        String putUrl = URL + "/dashboard/" + dashboardId + "/add";
        return given()
                .contentType(CONTENT_TYPE)
                .auth()
                .oauth2(Constants.API_TOKEN)
                .body(requestBodyPUT)
                .when()
                .put(putUrl)
                .then()
                .extract()
                .response();
    }

    public Response updateWidgetDescription(APIWidget widget, String description) {
        debug("Updating widget description, ID = " + widget.getId());
        String requestBodyPUT = "{\n" +
                                "\"name\": \"" + widget.getName() + "\",\n" +
                                "\"widgetType\": \"" + widget.getWidgetType() + "\",\n" +
                                "\"description\": \"" + description + "\",\n" +
                                "\"contentParameters\": {\"itemsCount\": 50}\n" +
                                "}";
        String putUrl = URL + "/widget/" + widget.getId();
        return given()
                .contentType(CONTENT_TYPE)
                .auth()
                .oauth2(Constants.API_TOKEN)
                .body(requestBodyPUT)
                .when()
                .put(putUrl)
                .then()
                .extract()
                .response();
    }

    public Response deleteDashboardById(int id) {
        debug("Deleting dashboard, ID = " + id);
        String deleteUrl = URL + "/dashboard/" + id;
        return given()
                .auth()
                .oauth2(Constants.API_TOKEN)
                .when()
                .delete(deleteUrl)
                .then()
                .extract()
                .response();
    }

    public Response deleteWidgetById(int dashboardId, int widgetId) {
        debug("Deleting widget, ID = " + widgetId);
        String deleteUrl = URL + "/dashboard/" + dashboardId + "/" + widgetId;
        return given()
                .auth()
                .oauth2(Constants.API_TOKEN)
                .when()
                .delete(deleteUrl)
                .then()
                .extract()
                .response();
    }
}
