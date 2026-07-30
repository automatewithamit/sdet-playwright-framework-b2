package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import org.testng.annotations.Test;

public class RecruitmentTests extends BaseTest{

    @Test(description = "Verify that the user cannot log in with invalid credentials.")
    public void invalidLoginTest() {
        //Test Steps
        //1. Open Browser
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login("Admin", "admin1234");

        //assert page.getByText("Invalid credentials").isVisible();


    }
    @Test(description = "Verify that the user cannot log in with invalid credentials.")
    public void invalidLoginTest1() {
        //Test Steps
        //1. Open Browser
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login("Admin", "admin1234");

        //assert page.getByText("Invalid credentials").isVisible();


    }


}
