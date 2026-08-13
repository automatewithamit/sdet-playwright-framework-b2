package com.orangehrm.tests;

import com.awa.framework.core.PlaywrightDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        PlaywrightDriver.getPlaywright();
        PlaywrightDriver.getBrowser();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        PlaywrightDriver.initializeContextAndPage();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        PlaywrightDriver.stopTrace(result.getTestClass().getRealClass().getSimpleName() + "-" + result.getMethod().getMethodName());
        PlaywrightDriver.closeContext();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        PlaywrightDriver.closeBrowser();
        PlaywrightDriver.closePlaywright();
    }
}
