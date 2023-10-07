package com.checkit.TestingPyramid.ageVeryfication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AgeVerificationController {

    @GetMapping("/verify-age")
    public String verifyAge(@RequestParam Integer age) {
        return AgeVerification.AgeVerificationResponse(age);
    }
}