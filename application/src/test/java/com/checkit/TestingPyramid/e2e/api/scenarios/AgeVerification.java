package com.checkit.TestingPyramid.e2e.api.scenarios;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;

public class AgeVerification {

    @Test
    public void testVerifyAgeEndpointWithAge15() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured
                .when()
                .get("/api/verify-age?age=15")
                .then().log().all()
                .statusCode(200)
                .body(containsString("are not eligible"));
    }

    private record AgeTestData(int age, String message) {
    }
}
