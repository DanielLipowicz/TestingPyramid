package com.checkit.TestingPyramid.application.isItAfterNoon;

import com.checkit.TestingPyramid.isItAfterNoon.AfterNoonPoliceman;
import com.checkit.TestingPyramid.isItAfterNoon.TestTimeProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class AfterNoonPolicemanTest {
    AfterNoonPoliceman afterNoonPoliceman;
    static LocalDateTime dateBeforeNoon;
    static LocalDateTime dateAfterNoon;

    @BeforeAll
    public static void setup() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        dateBeforeNoon = LocalDateTime.parse("2023-10-23 11:59:00", formatter);
        dateAfterNoon = LocalDateTime.parse("2023-10-23 12:01:00", formatter);
    }

    @Test
    public void shouldReturnFalseBeforeNoon() {
        afterNoonPoliceman = new AfterNoonPoliceman(new TestTimeProvider(dateBeforeNoon));
        assertFalse(afterNoonPoliceman.isItAfterNoon());
    }

    @Test
    public void shouldReturnTrueAfterNoon() {
        afterNoonPoliceman = new AfterNoonPoliceman(new TestTimeProvider(dateAfterNoon));
        assertTrue(afterNoonPoliceman.isItAfterNoon());
    }
}