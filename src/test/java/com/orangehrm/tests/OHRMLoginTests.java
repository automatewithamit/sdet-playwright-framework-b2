package com.orangehrm.tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentPage;
import org.testng.annotations.Test;

public class OHRMLoginTests extends BaseTest {

    @Test(description = "Verify that the user can log in successfully with valid credentials.")
    public void validLoginTest() {
        //Test Steps

        LoginPage loginPage = new LoginPage(page);
        DashboardPage dashboardPage = new DashboardPage(page);
        loginPage.navigateToLoginPage();
        loginPage.login("Admin", "admin123");
        String dashboardPageURL =  dashboardPage.getDashboardTitle();

        System.out.println("Dashboard Page URL: " + dashboardPageURL);
        assert dashboardPageURL.contains("dashboard");


        dashboardPage.navigateTo("Admin");
        RecruitmentPage recruitmentPage = new RecruitmentPage(page);
        recruitmentPage.navigateTo("Dashboard");

        assert dashboardPageURL.contains("admin");

        System.out.println("Valid Login Test Executed");
    }

    @Test(description = "Verify that the user cannot log in with invalid credentials.")
    public void invalidLoginTest() {
        //Test Steps
        //1. Open Browser
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage();
        loginPage.login("Admin", "admin1234");

        assert page.getByText("Invalid credentials").isVisible();


    }
}
