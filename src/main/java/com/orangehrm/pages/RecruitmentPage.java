package com.orangehrm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class RecruitmentPage extends BasePage{
//    Page page;
    public RecruitmentPage(Page page) {
        super(page);

        this.page = page;
    }

    Locator candidateAddBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("Add")));

    public void addCandidate(){
        candidateAddBtn.click();

    }



}
