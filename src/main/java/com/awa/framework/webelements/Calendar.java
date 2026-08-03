package com.awa.framework.webelements;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.Date;

public class Calendar {
    protected Page Page;
    Locator locator;
    Locator dateLocator;

    public Calendar(String nameOfButton) {
        this.Page = PlaywrightDriver.getPage();
        this.locator = Page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(nameOfButton));
    }

    public void selectDate(String dateString) {
        Date date = new Date(dateString);

        // Implement the logic to select a date from the calendar
        // This is a placeholder implementation and should be replaced with actual logic
        System.out.println("Selecting date: " + date.toString());
        locator.click();
        dateLocator = Page.locator("//td[@data-date='" + date.getTime() + "']");
        dateLocator.click();
    }

    public void selectDate(int day, int month, int year) {
        // Implement the logic to select a date from the calendar
        // This is a placeholder implementation and should be replaced with actual logic
        System.out.println("Selecting date: " + day + "/" + month + "/" + year);
        locator.click();
        dateLocator = Page.locator("//td[@data-day='" + day + "'][@data-month='" + month + "'][@data-year='" + year + "']");
        dateLocator.click();
    }

}
