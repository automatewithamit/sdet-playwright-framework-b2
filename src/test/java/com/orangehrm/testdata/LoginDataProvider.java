package com.orangehrm.testdata;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        return new Object[][]{{"Admin", "admin123"}};
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][]{{"Admin", "admin1234"}, {"invalidUser", "admin123"}};
    }
}
