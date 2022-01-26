package com.griddynamics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class UpdatingBoardTest {
    public static final String API_KEY = PropertiesLoader.loadChosenProperty("trello.api.key");
    public static final String API_TOKEN = PropertiesLoader.loadChosenProperty("trello.api.token");
    public static final String API_URL = PropertiesLoader.loadChosenProperty("trello.api.url");
    private static String id;

    @BeforeMethod()
    @Parameters({"desiredBoardName"})
    public void createSampleBoard(String desiredBoardName) {
        Response response = given().headers("Content-Type", "application/json")
                .queryParam("name", desiredBoardName)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when().post(API_URL).then()
                .extract().response();
        JsonPath jsonEvaluator = response.jsonPath();
        id = jsonEvaluator.getString("id");
    }

    @Test
    @Parameters({"updatedName"})
    public void shouldUpdateBoardName(String updatedName) {
        given().queryParam("name", updatedName)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when().put(API_URL + id).then()
                .body("name", equalTo(updatedName));
    }

    @Test
    @Parameters({"closed"})
    public void shouldUpdateBoardClosedField(boolean closed) {
        given().queryParam("closed", closed)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when().put(API_URL + id).then()
                .body("closed", equalTo(true));
    }

    @Test
    @Parameters({"updatedDescription"})
    public void shouldUpdateBoardDescription(String updatedDescription) {
        given().queryParam("desc", updatedDescription)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when().put(API_URL + id).then()
                .body("desc", equalTo(updatedDescription));
    }

    @Test
    @Parameters({"updatedBackgroundColor"})
    public void shouldSetNewBackgroundColor(String updatedBackgroundColor) {
        Response response = RestAssured.given().header("Content-Type", "application/json")
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .queryParam("prefs/background", updatedBackgroundColor)
                .when().put(API_URL + id).then()
                .extract().response();
        JsonPath jsonEvaluator = response.jsonPath();
        assertTrue("green".equals(jsonEvaluator.getString("prefs.background")));
    }

    @Test
    @Parameters({"updatedBlue"})
    public void shouldSetLabelNameAsInteger(int updatedBlue) {
        Response response = RestAssured.given()
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .queryParam("labelNames/blue", updatedBlue)
                .when().put(API_URL + id).then()
                .extract().response();
        JsonPath jsonEvaluator = response.jsonPath();
        assertEquals(String.valueOf(123), jsonEvaluator.getString("labelNames.blue"));
    }

    //negative testing
    @Test
    @Parameters({"updatedPinned"})
    public void shouldIgnoreToSetPinnedBooleanFieldAsString(String updatedPinned) {
        given().queryParam("pinned", updatedPinned)
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when().put(API_URL + id).then()
                .body("pinned", equalTo(false));
    }

    @Test
    @Parameters({"updatedIsTemplate"})
    public void shouldNotAllowToSetIsTemplateBooleanFieldAsString(String updatedIsTemplate) {
        Response response = RestAssured.given()
                .queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .queryParam("prefs/isTemplate", updatedIsTemplate)
                .when().put(API_URL + id).then()
                .extract().response();
        assertEquals(400, response.getStatusCode());
    }


    @AfterMethod
    public void deleteBoard() {
        given().queryParam("key", API_KEY)
                .queryParam("token", API_TOKEN)
                .when().delete(API_URL + id);
    }


}
