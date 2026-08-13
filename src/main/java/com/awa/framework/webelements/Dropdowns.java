package com.awa.framework.webelements;

import com.microsoft.playwright.Locator;

public class Dropdowns {
    private final Locator locator;

    public Dropdowns(Locator locator) { this.locator = locator; }
    public void selectByLabel(String label) { locator.selectOption(label); }
    public void click() { locator.click(); }
    public Locator locator() { return locator; }
}
