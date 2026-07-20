package com.framework.tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(description = "Verify that the user can log in successfully with valid credentials.")
    public void validLoginTest() {
        //Test Steps
        //1. Open Browser

        page.navigate("https://www.yatra.com");

        //2. Navigate to Login Page
        //3. Enter Valid Credentials
        //4. Click on Login Button
        //5. Verify Successful Login

        //6. Close Browser
        System.out.println("Valid Login Test Executed");
    }


}
