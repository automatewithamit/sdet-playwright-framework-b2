package com.awa.framework.webelements;

import com.microsoft.playwright.Locator;

public class UIActions {
    private UIActions() {}

    public static void click(Locator locator, int timeout){
        locator.click(new Locator.ClickOptions().setTimeout(timeout));
        System.out.println("Clicked locator: " + locator);
    }

    public static void click(Locator locator){
        locator.click();
        System.out.println("Clicked locator: " + locator);
    }

    public static void fillTextBox(Locator locator, String text){
        locator.fill(text);
        System.out.println("Entered text into locator: " + locator);
    }
}
