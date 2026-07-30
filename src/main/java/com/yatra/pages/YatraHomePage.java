package com.yatra.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.orangehrm.pages.BasePage;
import static com.awa.framework.webelements.UIActions.*;

import static com.awa.framework.webelements.UIActions.click;

public class YatraHomePage extends BasePage {

    Locator departure = Page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    Locator arrival = Page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));

    public void selectDeparture(String departureCity){
            click(departure);
            fillTextBox(departure,departureCity);
            click(departure);
    }
    public void selectArrival(String arrivalCity){
        click(arrival);
        fillTextBox(departure,arrivalCity);
        click(arrival);
    }

}
