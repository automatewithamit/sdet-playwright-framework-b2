package com.orangehrm.tests;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {

    }


    @BeforeTest(description = "Login Tests")
    public void initializeAISearchData() {
        //Code to initialize AI Search Test Data
        System.out.println("Initializing AI Search Test Data");
    }



    @BeforeMethod
    public void setup() {
        //Setup code to initialize Playwright and Browser
        PlaywrightDriver.getPage();
    }
    @AfterMethod
    public void teardown() {
        //Teardown code to close Browser and Playwright
        PlaywrightDriver.closeContext();

    }
    @AfterTest
    public void cleanupAISearchData() {
        //Code to cleanup AI Search Test Data
        System.out.println("Cleaning up AI Search Test Data");
    }
    @AfterSuite
    public void cleanupPlaywright() {
        //Code to cleanup Playwright
        PlaywrightDriver.closeBrowser();
        PlaywrightDriver.closePlaywright();
    }
}
