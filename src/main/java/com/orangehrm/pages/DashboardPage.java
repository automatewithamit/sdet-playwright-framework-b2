package com.orangehrm.pages;

import com.awa.framework.webelements.Button;
import com.orangehrm.locators.DashboardPageLocators;

public class DashboardPage extends BasePage {
    private final Button assignLeaveButton = new Button(DashboardPageLocators.ASSIGN_LEAVE);
    private final Button leaveListButton = new Button(DashboardPageLocators.LEAVE_LIST);

    public void clickAssignLeaveButton() { assignLeaveButton.click(); }
    public void clickLeaveListButton() { leaveListButton.click(); }
    public String getDashboardTitle() { return currentUrl(); }
    public boolean isLoaded() { return page.getByRole(com.microsoft.playwright.options.AriaRole.HEADING, new com.microsoft.playwright.Page.GetByRoleOptions().setName(DashboardPageLocators.DASHBOARD_HEADING)).isVisible(); }
}
