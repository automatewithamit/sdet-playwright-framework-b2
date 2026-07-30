package com.orangehrm.pages;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    protected Page Page;
    public BasePage() {
            this.Page = PlaywrightDriver.getPage();
    }
    public void navigateTo(String menu) {
        NavigationMenuPage navigationMenuPage = new NavigationMenuPage();
        navigationMenuPage.clickMenu(menu);
    }

}
