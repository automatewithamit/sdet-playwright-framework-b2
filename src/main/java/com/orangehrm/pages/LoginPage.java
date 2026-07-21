package com.orangehrm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.orangehrm.locators.LoginPageLocators;

public class LoginPage extends BasePage {
    //WebElements on the Login Page
    //Methods to interact with the WebElements
//    Page page;
    public LoginPage(Page page) {
        super(page);
//        super(page);

        this.page = page;
    }
    Locator userNameTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"));
    Locator passwordTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
    Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));

    public void login(String username, String password) {
        //Code to perform login action
        //2. Navigate to Login Page
        userNameTextBox.fill(username);
        passwordTextBox.fill(password);
        loginButton.click();
    }
    public void navigateToLoginPage() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void login(String username, String password, boolean rememberMe) {
        //Code to perform login action with Remember Me option
        userNameTextBox.fill(username);
        passwordTextBox.fill(password);
        if (rememberMe) {
            page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Remember Me")).check();
        }
        loginButton.click();
    }


}
