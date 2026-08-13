package com.yatra.tests;

import com.awa.framework.core.PlaywrightDriver;
import com.microsoft.playwright.Page;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected Page page;

    @BeforeClass(alwaysRun = true)
    public void initializePlaywright() {
        PlaywrightDriver.getPlaywright();
        PlaywrightDriver.getBrowser();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        page = PlaywrightDriver.initializeContextAndPage();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        PlaywrightDriver.stopTrace(result.getTestClass().getRealClass().getSimpleName() + "-" + result.getMethod().getMethodName());
        PlaywrightDriver.closeContext();
    }

    @AfterClass(alwaysRun = true)
    public void cleanupPlaywright() {
        PlaywrightDriver.closeBrowser();
        PlaywrightDriver.closePlaywright();
    }
}
