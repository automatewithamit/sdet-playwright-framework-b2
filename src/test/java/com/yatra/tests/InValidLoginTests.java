package com.yatra.tests;

import org.testng.annotations.Test;

public class InValidLoginTests extends BaseTest {

    @Test(description = "Verify that the user cannot log in with invalid credentials.")
    public void invalidLoginTest() {
        //Test Steps
        //1. Open Browser

        page.navigate("https://www.yatra.com");
        //2. Navigate to Login Page
        //3. Enter Invalid Credentials
        //4. Click on Login Button
        //5. Verify Error Message
        //6. Close Browser
        System.out.println("Invalid Login Test Executed");

    }
}
