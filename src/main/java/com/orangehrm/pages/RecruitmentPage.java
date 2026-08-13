package com.orangehrm.pages;

import com.microsoft.playwright.options.AriaRole;

public class RecruitmentPage extends BasePage{
    public boolean isLoaded() {
        return page.getByRole(AriaRole.HEADING, new com.microsoft.playwright.Page.GetByRoleOptions().setName("Recruitment")).isVisible();
    }
}
