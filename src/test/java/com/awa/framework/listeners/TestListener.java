package com.awa.framework.listeners;

import com.awa.framework.core.PlaywrightDriver;
import com.awa.framework.utilities.ConfigReader;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        String artifactName = result.getTestClass().getRealClass().getSimpleName() + "-" + result.getMethod().getMethodName();
        if (PlaywrightDriver.getPage() != null && ConfigReader.getBoolean("screenshot.on.failure", true)) {
            Reporter.log("Screenshot: " + PlaywrightDriver.screenshot(artifactName), true);
        }
    }
}
