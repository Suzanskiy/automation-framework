package com.racetrac.mobile.framework.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static java.util.concurrent.TimeUnit.MINUTES;

public class AppiumDriverFactory {

    private static final Logger LOG = LoggerFactory.getLogger(AppiumDriverFactory.class);
    private static final int MAX_ATTEMPTS = 3;
    private static String defaultHub = AppiumConfiguration.getHubURL();
    public static int TESTS_RUN_COUNT = 0;
    public static int TESTS_FAILURES_COUNT = 0;

    public static void setDefaultHub(final String newDefaultHub) {
        defaultHub = newDefaultHub;
    }

    public static AppiumDriver getDriver(final String hub, final Capabilities capabilities) {
        return newAppiumDriver(hub, capabilities);
    }

    public static AppiumDriver getDriver(final Capabilities capabilities) {
        return getDriver(defaultHub, capabilities);
    }

    private static AppiumDriver newAppiumDriver(final String hub, final Capabilities capabilities) {
        final AppiumDriver driver = createRemoteDriver(hub, capabilities);
        return driver;
    }

    private static Runnable closeDriverRunnable(AppiumDriver appiumDriver) {
        return () -> {
            LOG.info("Closing driver ->" + appiumDriver);
            appiumDriver.quit();
            LOG.info("AppiumDriver was successfully closed");
        };
    }

    private static Runnable logRunResults() {
        return () -> {
            LOG.info("Log Report: Tests run: " + TESTS_RUN_COUNT + " Tests failed: " + TESTS_FAILURES_COUNT);
        };
    }

    private static AppiumDriver createRemoteDriver(final String hub, final Capabilities capabilities) {
        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(new SimpleRetryPolicy(MAX_ATTEMPTS, getCaughtExceptions()));
        FixedBackOffPolicy policy = new FixedBackOffPolicy();
        policy.setBackOffPeriod(MINUTES.toMillis(3));
        template.setBackOffPolicy(policy);
        return template.execute(ctx -> getAppiumDriver(hub, capabilities));
    }

    private static Map<Class<? extends Throwable>, Boolean> getCaughtExceptions() {
        Map<Class<? extends Throwable>, Boolean> retryableExceptions = new HashMap<>();
        retryableExceptions.put(SessionNotCreatedException.class, true);
        retryableExceptions.put(UnreachableBrowserException.class, true);
        return retryableExceptions;
    }

    private static AppiumDriver getAppiumDriver(String hub, Capabilities capabilities) {
        try {
            AppiumDriver driver;
            switch (AppiumConfiguration.getTestPlatform()) {
                case IOS: {
                    driver = new IOSDriver(getURL(hub), capabilities);
                    break;
                }
                case ANDROID: {
                    driver = new AndroidDriver(getURL(hub), capabilities);
                    break;
                }
                default: {
                    driver = new AppiumDriver(getURL(hub), capabilities);
                }
            }
            LOG.info("Remote Appium driver is created");
            return driver;
        } catch (final MalformedURLException e) {
            LOG.error(e.getMessage(), e);
            throw new UncheckedIOException(e);
        } catch (final SessionNotCreatedException | UnreachableBrowserException e) {
            LOG.warn(e.getMessage());
            throw e;
        }
    }

    private static URL getURL(String hub) throws MalformedURLException {
        return new URL(hub);
    }
}
