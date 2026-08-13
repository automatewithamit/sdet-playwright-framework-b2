package com.orangehrm.tests;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.testdata.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentTests extends BaseTest{
    @Test(description = "Verify invalid credentials are rejected.", dataProvider = "invalidLoginData", dataProviderClass = LoginDataProvider.class, groups = {"ui"})
    public void invalidLoginTest(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isInvalidCredentialsMessageVisible(), "Invalid credentials message should be visible");
    }
}
