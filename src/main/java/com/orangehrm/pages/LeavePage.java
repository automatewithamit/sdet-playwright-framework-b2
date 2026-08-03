package com.orangehrm.pages;

import com.awa.framework.webelements.Button;
import com.awa.framework.webelements.Calendar;

public class LeavePage extends BasePage {

    Button assignLeaveButton = new Button("Assign Leave");
    Button leaveListButton = new Button("Leave List");
    Calendar leaveCalendar = new Calendar("Leave Calendar");
    Button applyButton = new Button(Page.locator("button[type='submit']"));


    public void clickAssignLeaveButton() {
        assignLeaveButton.click();
    }
    public void clickLeaveListButton() {
        leaveListButton.click();
    }
    public void applyLeave() {
        clickAssignLeaveButton();
        leaveCalendar.selectDate("2024-06-15");
        applyButton.click();
    }
}
