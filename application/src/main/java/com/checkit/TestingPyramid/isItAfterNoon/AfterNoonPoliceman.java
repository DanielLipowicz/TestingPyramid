package com.checkit.TestingPyramid.isItAfterNoon;

import java.time.LocalDateTime;


public class AfterNoonPoliceman {
    TimeProviderInterface timeProvider;

    public AfterNoonPoliceman(TimeProviderInterface timeProvider) {
        this.timeProvider = timeProvider;
    }

    public boolean isItAfterNoon() {
        LocalDateTime currentTime = timeProvider.now();
        return currentTime.getHour() >= 12;
    }

    public String isItAfterNoonMessage() {
        if (isItAfterNoon()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
