package com.awa.framework.webelements;

import com.microsoft.playwright.Locator;

public class UIActions {

    public static void click(Locator locator, int timeout){
        locator.click(new Locator.ClickOptions().setTimeout(timeout));
        System.out.println("Locator : " + locator.toString() + "Clicked");
    }
    public static void click(Locator locator){
        locator.click();
        System.out.println("Locator : " + locator.toString() + "Clicked");
    }

    public static void fillTextBox(Locator locator, String text){
        try{
        System.out.println("Username " + text + "is being entered");
        locator.fill(text);
        System.out.println("Username " + text + "has been entered");
        }
        catch (Exception e){
            System.out.println("Username " + text + "has not been entered");
        }
    }




}
