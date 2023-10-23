package com.checkit.TestingPyramid.isItAfterNoon;

import java.time.LocalDateTime;

public class TestTimeProvider implements TimeProviderInterface{

    LocalDateTime now;
    public TestTimeProvider(LocalDateTime now){
        this.now = now;
    }
    @Override
    public LocalDateTime now() {
        return now;
    }
}
