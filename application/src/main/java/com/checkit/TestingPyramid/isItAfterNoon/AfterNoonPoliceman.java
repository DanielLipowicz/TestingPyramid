package com.checkit.TestingPyramid.isItAfterNoon;

import java.time.LocalDateTime;

public class AfterNoonPoliceman {
    public static String isItAfterNoon() {
        LocalDateTime currentTime =LocalDateTime.now();
        if(currentTime.getHour()>12){
            return "yes";
        }else{
            return "no";
        }
    }
}
