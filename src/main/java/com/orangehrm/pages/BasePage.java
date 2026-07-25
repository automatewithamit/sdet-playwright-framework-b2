package com.orangehrm.pages;

import com.microsoft.playwright.Page;

public class BasePage {
//    protected Page page;
//    public BasePage(Page page) {
//            this.page = page;
//    }
    public void navigateTo(String menu) {
        NavigationMenuPage navigationMenuPage = new NavigationMenuPage();
        navigationMenuPage.clickMenu(menu);
    }
}
