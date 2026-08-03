package com.orangehrm.pages;

import com.awa.framework.core.PlaywrightDriver;
import com.awa.framework.webelements.Button;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.orangehrm.locators.DashboardPageLocators;

public class DashboardPage extends BasePage {
    Button assignLeaveButton = new Button("Assign Leave");
    Button leaveListButton = new Button("Leave List");


    public void clickAssignLeaveButton() {
        assignLeaveButton.click();
    }
    public void clickLeaveListButton() {
        leaveListButton.click();
    }

    public String getDashboardTitle() {
        return PlaywrightDriver.getPage().url();
    }



}
