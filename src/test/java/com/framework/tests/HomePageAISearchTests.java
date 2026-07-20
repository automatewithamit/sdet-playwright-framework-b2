package com.framework.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class HomePageAISearchTests extends BaseTest {

    //Home Page AI Search Test Cases
    //1. Valid Search Test
    //2. Invalid Search Test
    @Test(description = "Verify that the AI search functionality works correctly with valid search queries.")
    public void validSearchTest() {
        //Step 1: Setting up the test data,variables, and any necessary preconditions.

        //Test Steps
        //1. Open Browser


        page.navigate("https://www.yatra.com/");

        Locator departureCity = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("From"));
        departureCity.fill("New Delhi");
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("New Delhi, India")).click();


        Locator arrivalCity = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("To"));


        //Step 2 : Actual Test Steps

        //2. Navigate to Home Page
        //3. Enter Valid Search Query
        //4. Click on Search Button
        //5. Verify Search Results

        //Step 3: Clean up any test data or reset the application state if necessary.
        //6. Close Browser
        System.out.println("Valid Search Test Executed");
    }
    @Test(description = "Verify that the AI search functionality handles invalid search queries gracefully.")
    public void invalidSearchTest() {
        //initializeAISearchData();
        //Test Steps
        //1. Open Browser

        page.navigate("https://www.yatra.com");
        //2. Navigate to Home Page
        //3. Enter Invalid Search Query
        //4. Click on Search Button
        //5. Verify Error Message or No Results Found
        //6. Close Browser
        System.out.println("Invalid Search Test Executed");
    }


}
