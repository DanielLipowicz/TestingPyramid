package com.checkit.TestingPyramid.isItAfterNoon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IsItAfterNoonController {

    AfterNoonPoliceman afterNoonPoliceman;

    IsItAfterNoonController(){
        this.afterNoonPoliceman=new AfterNoonPoliceman(new TimeProvider());
    }
    @GetMapping("/isItAfterNoon")
    public String isItAfterNoon() {
        return afterNoonPoliceman.isItAfterNoonMessage();
    }
}
