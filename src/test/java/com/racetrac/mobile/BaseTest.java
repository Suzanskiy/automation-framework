package com.racetrac.mobile;


import com.racetrac.mobile.framework.CustomContextInitializer;
import com.racetrac.mobile.framework.config.MobileContextConfig;
import com.racetrac.mobile.multisite.racetrac.data.TestData;
import com.racetrac.mobile.util.listeners.BaseTestListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Arrays;

import static com.racetrac.mobile.framework.appium.AppiumDriverProvider.startAppiumServer;
import static com.racetrac.mobile.framework.appium.AppiumDriverProvider.stopAppiumServer;
import static com.racetrac.mobile.util.allure.AllureEnvironmentUtils.copyEnvPropToAllureResults;
import static com.racetrac.mobile.util.allure.AllureEnvironmentUtils.createEnvironmentProperties;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;


@ContextConfiguration(classes = MobileContextConfig.class, initializers = CustomContextInitializer.class)
@Listeners({BaseTestListenerAdapter.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @Autowired
    protected TestData testData;

    @BeforeClass(alwaysRun = true, dependsOnMethods = {"springTestContextBeforeTestClass"})
    @Override
    protected void springTestContextPrepareTestInstance() throws Exception {
        startAppiumServer();
        super.springTestContextPrepareTestInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void launch() {
        LOG.info("Launch application");
        getDriver().launchApp();
    }

    @AfterMethod(alwaysRun = true)
    public void quite() {
        LOG.info("Close application");
        getDriver().closeApp();
    }

    @AfterClass
    public void afterClass() {
        stopAppiumServer();
    }

    @BeforeMethod(alwaysRun = true)
    void a1loggingBefore(ITestResult iTestResult) {
        LOG.info(iTestResult.getMethod().getMethodName() + " is running");
    }

    @AfterMethod(alwaysRun = true)
    public void loggingAfter(ITestResult iTestResult) {
        LOG.info(commonAfterTestMethod(iTestResult).toString());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        createEnvironmentProperties();
        copyEnvPropToAllureResults();
    }

    /**
     * Print a log message when a test case is completed.  Including whether it passed or failed.  If the test
     * failed also print the exception that caused the failure.
     *
     * @param itr The TestNG ITestResult object that contains information about the test case
     */
    private static StringBuilder commonAfterTestMethod(ITestResult itr) {
        String methodName = itr.getMethod().getMethodName();
        Object[] params = itr.getParameters();
        StringBuilder msg = new StringBuilder("Finished " + methodName + "(" +
                Arrays.toString(params).replace("[", "").replace("]", "") +
                ") test - ");
        switch (itr.getStatus()) {
            case ITestResult.SUCCESS: {
                msg.append("passed.");
                break;
            }
            case ITestResult.SKIP: {
                msg.append("skipped.");
                break;
            }
            case ITestResult.FAILURE:
            case ITestResult.CREATED: {
                msg.append("FAILED");
                Throwable itrThrowable = itr.getThrowable();
                if (itrThrowable != null) {
                    String nl = System.getProperty("line.separator");
                    msg.append(nl);
                    msg.append("    ");
                    msg.append(itrThrowable.toString());
                    // If it's not a thread timeout, include the stack trace too
                    if (!(itrThrowable instanceof org.testng.internal.thread.ThreadTimeoutException)) {
                        for (StackTraceElement e : itrThrowable.getStackTrace()) {
                            msg.append(nl);
                            msg.append("    ");
                            msg.append(e.toString());
                        }
                    }
                }
                break;
            }
        }
        return msg;
    }
}