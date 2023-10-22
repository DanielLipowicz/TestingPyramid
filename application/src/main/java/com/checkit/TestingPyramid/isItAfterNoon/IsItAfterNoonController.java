package com.checkit.TestingPyramid.isItAfterNoon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IsItAfterNoonController {
    @GetMapping("/isItAfterNoon")
    public String isItAfterNoon() {
        return AfterNoonPoliceman.isItAfterNoon();
    }
}
