package com.orangehrm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.awa.framework.webelements.UIActions.click;

public class NavigationMenuPage extends BasePage {
    public Locator getMenuLocator(String menuName) {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(menuName));
    }

    public void clickMenu(String menuName) { click(getMenuLocator(menuName)); }
}
