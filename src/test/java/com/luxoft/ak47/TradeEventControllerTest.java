package com.luxoft.ak47;

import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasXPath;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

class TradeEventControllerTest {

    @Test
    void tradeEvent() {
        RestAssured
                .given()
                .when().get("/tradeEvent/123")
                .then().statusCode(200);
    }

    @Test
    void doesCurrencyHave3CapitalLetters() {
        String currency = when().get("/tradeEvent/xxx").then()
                .statusCode(200).extract().xmlPath().getString("tradeEvent.currency");

                Assertions.assertThat(currency).isUpperCase();
                Assertions.assertThat(currency).hasSize(3);
        }

    @Test
    void isTradeLocationPresentForObs() {
        when().get("/tradeEvent/OBS-12").then()
                .body("tradeEvent.tradeLocation", equalTo("HKG"));
    }

    @Test
    void name() {
    }

    //test that currency should have 3 uppercase characters
    //controller should return random currency from a list

    @Test
    void shouldGet404OnNonExistingPage() {
        when().get("/nonExisting").then().statusCode(404);
    }

    @Test
    void shouldReturnTradesWithIdAndVersion() {
        String id= "sampleId";
        when().get("/tradeEvent/{id}", id).then()
                .statusCode(200)
                .body("tradeEvent.version", equalTo("0"))
                .body("tradeEvent.id", equalTo(id))
                .body(not(hasXPath("/tradeEvent/tradeLocation")));
    }

    @Test
    void shouldHaveTradeLocationIfFromObs() {
        when().get("/tradeEvent/OBS-123")
                .then()
                .body(hasXPath("/tradeEvent/tradeLocation"));

    }
}