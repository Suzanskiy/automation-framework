package com.racetrac.mobile.framework.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import javaslang.control.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppiumDriverProvider {
    private static final Logger LOG = LoggerFactory.getLogger(AppiumDriverProvider.class);
    public static final AppiumDriverProvider INSTANCE = new AppiumDriverProvider();
    private ThreadLocal<AppiumDriver<MobileElement>> DRIVER = new ThreadLocal<>();

    private AppiumDriverProvider() {
    }

    public AppiumDriver<MobileElement> getDriverInstance() {
        return Option.of(DRIVER.get()).getOrElse(this::getAppiumDriver);
    }

    private AppiumDriver<MobileElement> getAppiumDriver() {
        DRIVER.set(AppiumDriverFactory.getDriver(AppiumConfiguration.getDesiredCapabilities()));
        LOG.info("WebDriver was created -> " + DRIVER.get());
        return DRIVER.get();
    }
}
