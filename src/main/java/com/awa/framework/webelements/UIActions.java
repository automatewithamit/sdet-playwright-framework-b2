package com.awa.framework.webelements;

import com.microsoft.playwright.Locator;

public class UIActions {

    public static void click(Locator locator){
        locator.click();
        System.out.println("Locator : " + locator.toString() + "Clicked");
    }

    public static void fillTextBox(Locator locator, String text){
        System.out.println("Username " + text + "is being entered");
        locator.fill(text);
        System.out.println("Username " + text + "has been entered");
    }




}
