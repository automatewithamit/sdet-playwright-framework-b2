package com.orangehrm.pages;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NavigationMenuPage extends BasePage {

//    public NavigationMenuPage(Page page) {
//        super(page);
//    }
    public Locator getMenuLocator(String menuName) {
        return Page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(menuName));
    }

    public void clickMenu(String menuName) {
        getMenuLocator(menuName).click();
    }
}
