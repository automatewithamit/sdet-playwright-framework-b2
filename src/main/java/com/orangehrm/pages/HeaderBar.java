package com.orangehrm.pages;

public class HeaderBar extends BasePage {
    public boolean isUserMenuVisible() { return page.locator(".oxd-userdropdown").isVisible(); }
}
