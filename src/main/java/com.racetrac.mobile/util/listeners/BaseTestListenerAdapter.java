package com.racetrac.mobile.util.listeners;

import com.racetrac.mobile.framework.appium.AppiumDriverProvider;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.racetrac.mobile.util.attachments.Attachments.attachSourceCode;
import static com.racetrac.mobile.util.attachments.Attachments.saveScreenshotPNG;


public class BaseTestListenerAdapter extends TestListenerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTestListenerAdapter.class);

    @Override
    public void onTestSuccess(ITestResult tr) {
        LOG.info(tr.getMethod().getMethodName() + "() -- " + "SUCCESS");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        saveScreenshotPNG();
        if (tr.getThrowable() instanceof NoSuchElementException) {
            attachSourceCode();
        }
        super.onTestFailure(tr);
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        saveScreenshotPNG();
        super.onTestSkipped(tr);
    }

    @Override
    public void onStart(ITestContext testContext) {
        for (ITestNGMethod method : testContext.getAllTestMethods()) {
            method.setRetryAnalyzer(new IRetryAnalyzerImpl());
        }
        super.onStart(testContext);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
    }
}
