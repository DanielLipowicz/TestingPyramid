package com.checkit.TestingPyramid.e2e.api.scenarios;

import io.restassured.RestAssured;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsString;

public class AgeVerification {

    static Stream<AgeTestData> ageTestData() {
        return Stream.of(
                new AgeTestData(-5, "are not eligible"),
                new AgeTestData(0, "are not eligible"),
                new AgeTestData(17, "are not eligible"),
                new AgeTestData(18, "are eligible"),
                new AgeTestData(25, "are eligible"),
                new AgeTestData(99, "are eligible"),
                new AgeTestData(199, "are eligible")
        );
    }

    @ParameterizedTest
    @MethodSource("ageTestData")
    public void testVerifyAgeEndpointWithAge15(AgeTestData ageTestData) {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured
                .when()
                .get("/api/verify-age?age=".concat(String.valueOf(ageTestData.age)))
                .then().log().all()
                .statusCode(200)
                .body(containsString(ageTestData.message));
    }

    private record AgeTestData(int age, String message) {
    }
}
