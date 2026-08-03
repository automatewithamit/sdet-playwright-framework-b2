package com.yatra.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {
    static Playwright playwright;
    Browser browser;
    Page page;
    @BeforeSuite
    public void initializePlaywright() {
        //Code to initialize Playwright
        playwright = Playwright.create();
        System.out.println("Playwright Initialized");
    }


    @BeforeTest(description = "Login Tests")
    public void initializeAISearchData() {
        //Code to initialize AI Search Test Data
        System.out.println("Initializing AI Search Test Data");
    }

    @AfterTest
    public void cleanupAISearchData() {
        //Code to cleanup AI Search Test Data
        System.out.println("Cleaning up AI Search Test Data");
    }

    @BeforeMethod
    public void setup() {
        //Setup code to initialize Playwright and Browser
//        initializePlaywright();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context3 = browser.newContext();
        page = context3.newPage();
        System.out.println("Browser Launched");


    }
    @AfterMethod
    public void teardown() {
        //Teardown code to close Browser and Playwright
        System.out.println("Browser Closed");
    }
    @AfterSuite
    public void cleanupPlaywright() {
        //Code to cleanup Playwright
        browser.close();
        playwright.close();
        System.out.println("Playwright Closed");
    }
}
