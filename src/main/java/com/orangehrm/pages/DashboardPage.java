package com.orangehrm.pages;

import com.awa.framework.core.PlaywrightDriver;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.orangehrm.locators.DashboardPageLocators;

public class DashboardPage extends BasePage {

//    public DashboardPage(Page page) {
//        super(page);
//    }



//    public void clickAdminMenu() {
//        adminMenu.click();
//    }
//    public void clickRecruitmentMenu() {
//        recruitmentMenu.click();
//    }
//    public void clickPIMMenu() {
//        pimMenu.click();
//    }
//    public void clickPerformanceMenu() {
//        performanceMenu.click();
//    }



    public String getDashboardTitle() {
        return PlaywrightDriver.getPage().url();
    }



}
