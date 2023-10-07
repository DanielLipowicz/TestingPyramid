package com.checkit.TestingPyramid.ageVeryfication;

public class AgeVerification {
    public static boolean isValidAge(int age){
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }
    public static String AgeVerificationResponse(int age){
        if (isValidAge(age)) {
            return "You are eligible. Your age is " + age + " years.";
        } else {
            return "You are not eligible. Your age is " + age + " years.";
        }
    }
}
