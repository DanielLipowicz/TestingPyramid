package com.checkit.TestingPyramid.isItAfterNoon;

import java.time.LocalDateTime;

public class TimeProvider implements TimeProviderInterface{
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
