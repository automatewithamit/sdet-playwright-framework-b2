package com.awa.framework.core;

import com.awa.framework.utilities.ConfigReader;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RecordVideoSize;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PlaywrightDriver {
    private static final ThreadLocal<Playwright> threadLocalPlaywright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
    private static final ThreadLocal<APIRequestContext> threadLocalAPIRequestContext = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    private PlaywrightDriver() {}

    public static Playwright getPlaywright() {
        if (threadLocalPlaywright.get() == null) {
            threadLocalPlaywright.set(Playwright.create());
            System.out.println("Playwright Initialized");
        }
        return threadLocalPlaywright.get();
    }

    public static Browser getBrowser() {
        if (threadLocalBrowser.get() == null) {
            String browserName = ConfigReader.getProperty("browser", "chromium").toLowerCase();
            boolean headless = ConfigReader.getBoolean("headless", true);
            int slowMo = ConfigReader.getInt("slowMo", 0);
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(slowMo);
            Browser browser = switch (browserName) {
                case "firefox" -> getPlaywright().firefox().launch(launchOptions);
                case "webkit" -> getPlaywright().webkit().launch(launchOptions);
                case "chrome" -> getPlaywright().chromium().launch(launchOptions.setChannel("chrome"));
                case "edge", "msedge" -> getPlaywright().chromium().launch(launchOptions.setChannel("msedge"));
                default -> getPlaywright().chromium().launch(launchOptions);
            };
            threadLocalBrowser.set(browser);
            System.out.println("Browser Launched: " + browserName);
        }
        return threadLocalBrowser.get();
    }

    public static APIRequestContext getApiContext(String baseUrl) {
        if (threadLocalAPIRequestContext.get() == null) {
            threadLocalAPIRequestContext.set(getPlaywright().request().newContext(new APIRequest.NewContextOptions().setBaseURL(baseUrl)));
        }
        return threadLocalAPIRequestContext.get();
    }

    public static Page initializeContextAndPage() {
        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setViewportSize(ConfigReader.getInt("viewport.width", 1280), ConfigReader.getInt("viewport.height", 720));
        if (ConfigReader.getBoolean("video.enabled", false)) {
            options.setRecordVideoDir(Paths.get(ConfigReader.getProperty("artifacts.dir", "target/artifacts"), "videos"))
                    .setRecordVideoSize(new RecordVideoSize(1280, 720));
        }
        BrowserContext currentContext = getBrowser().newContext(options);
        threadLocalContext.set(currentContext);
        if (ConfigReader.getBoolean("trace.enabled", true)) {
            currentContext.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
        }
        Page newPage = currentContext.newPage();
        threadLocalPage.set(newPage);
        return newPage;
    }

    public static Page getPage() { return threadLocalPage.get(); }
    public static BrowserContext getContext(){ return threadLocalContext.get(); }

    public static Path screenshot(String testName) {
        Path path = Paths.get(ConfigReader.getProperty("artifacts.dir", "target/artifacts"), "screenshots", testName + ".png");
        createParentDirectory(path);
        getPage().screenshot(new Page.ScreenshotOptions().setPath(path).setFullPage(true));
        return path;
    }

    public static Path stopTrace(String testName) {
        Path path = Paths.get(ConfigReader.getProperty("artifacts.dir", "target/artifacts"), "traces", testName + ".zip");
        if (getContext() != null && ConfigReader.getBoolean("trace.enabled", true)) {
            createParentDirectory(path);
            getContext().tracing().stop(new Tracing.StopOptions().setPath(path));
        }
        return path;
    }

    private static void createParentDirectory(Path path) {
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            throw new RuntimeException("Failed to create artifact directory: " + path.getParent(), e);
        }
    }

    public static void closeApiContext() {
        if (threadLocalAPIRequestContext.get() != null) {
            threadLocalAPIRequestContext.get().dispose();
            threadLocalAPIRequestContext.remove();
        }
    }

    public static void closeBrowser() {
        if (threadLocalBrowser.get() != null) {
            threadLocalBrowser.get().close();
            threadLocalBrowser.remove();
        }
    }

    public static void closeContext() {
        if (threadLocalContext.get() != null) {
            threadLocalContext.get().close();
        }
        threadLocalContext.remove();
        threadLocalPage.remove();
    }

    public static void closePlaywright() {
        if (threadLocalPlaywright.get() != null) {
            threadLocalPlaywright.get().close();
            threadLocalPlaywright.remove();
        }
    }
}
