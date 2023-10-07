package com.checkit.TestingPyramid.ageVeryfication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AgeVerificationController {

    @GetMapping("/verify-age")
    public String verifyAge(@RequestParam Integer age) {

        if (age >= 18) {
            return "You are eligible. Your age is " + age + " years.";
        } else {
            return "You are not eligible. Your age is " + age + " years.";
        }
    }
}