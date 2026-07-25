package com.awa.framework.core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightDriver {
    //Single Responsibility
    //S - SRP -> Single Responsibility Principle: This class has a single responsibility of managing Playwright, Browser, and Page instances.
    //O - OCP -> Open/Closed Principle: This class is open for extension but closed for modification. You can extend its functionality without modifying the existing code.
    //L - LSP -> Liskov Substitution Principle: This class can be used in place of any other class that manages Playwright, Browser, and Page instances without affecting the correctness of the program.
    //I - ISP -> Interface Segregation Principle: This class does not force any client to depend on methods it does not use. It provides only the necessary methods for managing Playwright, Browser, and Page instances.
    //D - DIP -> Dependency Inversion Principle: This class depends on abstractions (Playwright, Browser, Page) rather than concrete implementations. It can be easily modified to use different implementations of these abstractions without changing the code that uses this class.


    //This class is responsible for initializing Playwright, Browser, and Page instances
    static Playwright playwright;
    static Browser browser;
    static Page page;

    public static Playwright getPlaywright() {
        playwright = Playwright.create();
        System.out.println("Playwright Initialized");
        return playwright;
    }
    public static void getBrowser() {
        if (playwright == null) {
            getPlaywright();
        }
        //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        System.out.println("Browser Launched");
    }

    public static Page getPage() {
        if (browser == null) {
            getBrowser();
        }
        if (page == null) {
            page = browser.newContext().newPage();
            System.out.println("New Page Created");
        }
        return page;
    }
    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
            System.out.println("Browser Closed");
        }
    }
    public static void closeContext() {
        if (page != null) {
            page.context().close();
            System.out.println("Context Closed");
        }
    }

    public static void closePlaywright() {
        if (playwright != null) {
            playwright.close();
            System.out.println("Playwright Closed");
        }
    }
}
