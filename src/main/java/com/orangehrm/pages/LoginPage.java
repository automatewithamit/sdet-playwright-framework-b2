package com.orangehrm.pages;

import com.awa.framework.core.PlaywrightDriver;
import com.awa.framework.utilities.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.orangehrm.locators.LoginPageLocators;

import static com.awa.framework.webelements.UIActions.click;
import static com.awa.framework.webelements.UIActions.fillTextBox;

public class LoginPage extends BasePage {
    private Locator userNameTextBox() { return page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(LoginPageLocators.USERNAME)); }
    private Locator passwordTextBox() { return page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(LoginPageLocators.PASSWORD)); }
    private Locator loginButton() { return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(LoginPageLocators.LOGIN)); }

    public DashboardPage login(String username, String password) {
        fillTextBox(userNameTextBox(), username);
        fillTextBox(passwordTextBox(), password);
        click(loginButton());
        return new DashboardPage();
    }

    public void navigateToLoginPage() {
        PlaywrightDriver.getPage().navigate(ConfigReader.getProperty("ui.baseurl"));
    }

    public DashboardPage login(String username, String password, boolean rememberMe) {
        fillTextBox(userNameTextBox(), username);
        fillTextBox(passwordTextBox(), password);
        if (rememberMe) {
            page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Remember Me")).check();
        }
        click(loginButton());
        return new DashboardPage();
    }

    public boolean isInvalidCredentialsMessageVisible() {
        return page.getByText(LoginPageLocators.INVALID_CREDENTIALS).isVisible();
    }
}
