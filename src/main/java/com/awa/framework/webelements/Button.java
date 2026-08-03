package com.awa.framework.webelements;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Button {
    protected Page Page;
    Locator locator;
    public Button(String nameOfButton) {
        this.Page = PlaywrightDriver.getPage();
        this.locator = Page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(nameOfButton));
    }

    public Button(Locator locator) {
        this.Page = PlaywrightDriver.getPage();
        this.locator = locator;
    }

    public  void click (int timeout){
        locator.click(new Locator.ClickOptions().setTimeout(timeout));
        System.out.println("Locator : " + locator.toString() + "Clicked");
    }
    public  void click(){
        locator.click();
        System.out.println("Locator : " + locator.toString() + "Clicked");
    }

}
