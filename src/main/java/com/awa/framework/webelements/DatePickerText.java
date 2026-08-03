package com.awa.framework.webelements;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DatePickerText {
    protected com.microsoft.playwright.Page Page;
    Locator locator;
    Locator dateLocator;

    public DatePickerText(String nameOfButton) {
        this.Page = PlaywrightDriver.getPage();
        this.locator = Page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(nameOfButton));
    }
}
