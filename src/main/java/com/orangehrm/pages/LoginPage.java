package com.orangehrm.pages;

import com.awa.framework.core.PlaywrightDriver;
import com.awa.framework.webelements.UIActions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.orangehrm.locators.LoginPageLocators;

import static com.awa.framework.webelements.UIActions.*;

public class LoginPage extends BasePage {
    //WebElements on the Login Page
    //Methods to interact with the WebElements

//    public LoginPage(Page page) {
//        super(page);
//    }
    Locator userNameTextBox = Page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"));
    Locator passwordTextBox = Page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
    Locator loginButton = Page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));

    public void login(String username, String password) {
        //Code to perform login action
        //2. Navigate to Login Page
        fillTextBox(userNameTextBox,username);
        fillTextBox(passwordTextBox,password);
        click(loginButton);
    }


    public void navigateToLoginPage() {
        PlaywrightDriver.getPage().navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void login(String username, String password, boolean rememberMe) {
        //Code to perform login action with Remember Me option
        fillTextBox(userNameTextBox,username);
        fillTextBox(passwordTextBox,password);
        if (rememberMe) {
            PlaywrightDriver.getPage().getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Remember Me")).check();
        }
        click(loginButton);
    }





}
