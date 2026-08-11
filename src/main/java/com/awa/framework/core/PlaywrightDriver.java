package com.awa.framework.core;

import com.microsoft.playwright.*;

public class PlaywrightDriver {
    //Single Responsibility
    //S - SRP -> Single Responsibility Principle: This class has a single responsibility of managing Playwright, Browser, and Page instances.
    //O - OCP -> Open/Closed Principle: This class is open for extension but closed for modification. You can extend its functionality without modifying the existing code.
    //L - LSP -> Liskov Substitution Principle: This class can be used in place of any other class that manages Playwright, Browser, and Page instances without affecting the correctness of the program.
    //I - ISP -> Interface Segregation Principle: This class does not force any client to depend on methods it does not use. It provides only the necessary methods for managing Playwright, Browser, and Page instances.
    //D - DIP -> Dependency Inversion Principle: This class depends on abstractions (Playwright, Browser, Page) rather than concrete implementations. It can be easily modified to use different implementations of these abstractions without changing the code that uses this class.


    //This class is responsible for initializing Playwright, Browser, and Page instances
    //static Playwright playwright;
    //static Browser browser;
    private static final ThreadLocal<Playwright> threadLocalPlaywright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
    private static final ThreadLocal<APIRequestContext> threadLocalAPIRequestContext = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();


    public static Playwright getPlaywright() {
        Playwright playwright = Playwright.create();
        threadLocalPlaywright.set(playwright);
        System.out.println("Playwright Initialized");
        return playwright;
    }

    public static void getBrowser() {
//        if (threadLocalPlaywright.get() == null) {
//            getPlaywright();
//        }
        if (threadLocalBrowser.get() == null) {
            //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Browser browser = threadLocalPlaywright.get().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
            threadLocalBrowser.set(browser);
        }
        System.out.println("Browser Launched");

    }

    public static APIRequestContext getApiContext(String baseUrl) {
        if (threadLocalAPIRequestContext.get() == null) {
            APIRequestContext apiRequestContext = getPlaywright().request().newContext(new APIRequest.NewContextOptions().setBaseURL(baseUrl));
            threadLocalAPIRequestContext.set(apiRequestContext);
        }
        System.out.println("New API Context Created");
        return threadLocalAPIRequestContext.get();
    }

    public static void initializeContextAndPage() {
        //getBrowser();
        BrowserContext currentContext = threadLocalBrowser.get().newContext();
        threadLocalContext.set(currentContext);

        System.out.println("New Context Created");
        Page newPage = currentContext.newPage();
        threadLocalPage.set(newPage);

        System.out.println("New Page Created");

    }

    public static void initializeContextAndPage1() {
        //getBrowser();
        BrowserContext currentContext = threadLocalBrowser.get().newContext();
        threadLocalContext.set(currentContext);

        System.out.println("New Context Created");
        Page newPage = currentContext.newPage();
        threadLocalPage.set(newPage);

        System.out.println("New Page Created");

    }

//    public void initiallizePage() {
//
//        initiallizeContext();
//        if (page == null) {
//            BrowserContext context = threadLocalContext.get();
//            threadLocalPage.set(context.newPage());
//            System.out.println("New Page Created");
//        }
//    }

    public static Page getPage() {
        return threadLocalPage.get();
    }
    public BrowserContext getContext(){
        return threadLocalContext.get();
    }

    public static void closeBrowser() {
        if (threadLocalBrowser.get() != null) {
            threadLocalBrowser.get().close();
            threadLocalBrowser.remove();
            System.out.println("Browser Closed");
        }
    }

    public static void closeContext() {
        BrowserContext currentContext = threadLocalContext.get();

        if (currentContext != null) {
            currentContext.close();
            System.out.println("Context Closed");
        }
        threadLocalContext.remove();
        threadLocalPage.remove();
    }

    public static void closePlaywright() {
        if (threadLocalPlaywright.get() != null) {
            threadLocalPlaywright.get().close();
            threadLocalPlaywright.remove();
            System.out.println("Playwright Closed");
        }
    }
}
