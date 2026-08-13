package com.orangehrm.tests;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentPage;
import com.orangehrm.testdata.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OHRMLoginTests extends BaseTest {
    @Test(description = "Verify successful login with valid credentials.", dataProvider = "validLoginData", dataProviderClass = LoginDataProvider.class, groups = {"ui", "smoke"})
    public void validLoginTest(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);

        Assert.assertTrue(dashboardPage.currentUrl().contains("/dashboard"), "Dashboard URL should contain /dashboard");
        Assert.assertTrue(dashboardPage.isLoaded(), "Dashboard heading should be visible");

        dashboardPage.navigateTo("Recruitment");
        Assert.assertTrue(new RecruitmentPage().isLoaded(), "Recruitment page should be visible");
    }
}
