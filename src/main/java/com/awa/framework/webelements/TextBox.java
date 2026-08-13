package com.awa.framework.webelements;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TextBox {
    private final Locator locator;

    public TextBox(String accessibleName) {
        Page page = PlaywrightDriver.getPage();
        this.locator = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(accessibleName));
    }

    public TextBox(Locator locator) {
        this.locator = locator;
    }

    public void fill(String text) { locator.fill(text); }
    public String inputValue() { return locator.inputValue(); }
    public Locator locator() { return locator; }
}
