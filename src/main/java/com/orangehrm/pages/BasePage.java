package com.orangehrm.pages;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;
    protected Page Page;

    public BasePage() {
        this.page = PlaywrightDriver.getPage();
        this.Page = this.page;
    }

    public void navigateTo(String menu) { new NavigationMenuPage().clickMenu(menu); }

    public String currentUrl() { return page.url(); }
}
