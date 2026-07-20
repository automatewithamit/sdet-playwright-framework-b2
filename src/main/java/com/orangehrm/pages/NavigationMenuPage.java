package com.orangehrm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NavigationMenuPage {
    Page page;
    public NavigationMenuPage(Page page) {
        this.page = page;
    }
    public Locator getMenuLocator(String menuName) {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(menuName));
    }

    public void clickMenu(String menuName) {
        getMenuLocator(menuName).click();
    }
}
