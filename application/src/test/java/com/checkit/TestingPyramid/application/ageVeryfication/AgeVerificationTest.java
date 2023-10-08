package com.checkit.TestingPyramid.application.ageVeryfication;

import com.checkit.TestingPyramid.ageVeryfication.AgeVerification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AgeVerificationTest {

    static Stream<AgeTestData> ageTestData() {
        return Stream.of(
                new AgeTestData(-5, false),
                new AgeTestData(0, false),
                new AgeTestData(17, false),
                new AgeTestData(18, true),
                new AgeTestData(25, true),
                new AgeTestData(99, true),
                new AgeTestData(199, true)
        );
    }

    @ParameterizedTest
    @MethodSource("ageTestData")
    void isValidAge(AgeTestData ageTestData) {
        Assertions.assertEquals(AgeVerification.isValidAge(ageTestData.age()), ageTestData.expectedResult());
    }

    @Test
    void ageVerificationResponsePositive() {
        int firstTrueResult = ageTestData()
                .filter(data -> data.expectedResult())
                .findFirst().orElseThrow().age();
        assertTrue(AgeVerification.AgeVerificationResponse(firstTrueResult).contains("are eligible"));
    }
    @Test
    void ageVerificationResponseNegative() {
        int firstTrueResult = ageTestData()
                .filter(data -> !data.expectedResult())
                .findFirst().orElseThrow().age();
        assertTrue(AgeVerification.AgeVerificationResponse(firstTrueResult).contains("are not eligible"));
    }

    record AgeTestData(int age, boolean expectedResult) {

    }
}