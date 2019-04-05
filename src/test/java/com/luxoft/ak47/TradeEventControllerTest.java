package com.luxoft.ak47;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

class TradeEventControllerTest {

    @Test
    void tradeEvent() {
        RestAssured
                .given()
                .when().get("/tradeEvent")
                .then().statusCode(200);
    }
    @Test
    void shouldGet404OnNonExistingPage() {
        when().get("/nonExisting").then().statusCode(404);
    }

    @Test
    void shouldReturnTradesWithVersion0() {
        when().get("/tradeEvent").then()
                .statusCode(200)
                .body("tradeEvent.version", equalTo("0"));
    }
}