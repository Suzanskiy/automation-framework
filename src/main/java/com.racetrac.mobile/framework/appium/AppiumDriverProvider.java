package com.racetrac.mobile.framework.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import javaslang.control.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.racetrac.mobile.framework.appium.AppiumConfiguration.getTestPlatform;

public class AppiumDriverProvider {
    private static final Logger LOG = LoggerFactory.getLogger(AppiumDriverProvider.class);
    public static final AppiumDriverProvider INSTANCE = new AppiumDriverProvider();
    private ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();
    private static AppiumDriverLocalService appiumLocalService;

    private AppiumDriverProvider() {
    }

    public AppiumDriver getDriverInstance() {
        return Option.of(DRIVER.get()).getOrElse(this::getAppiumDriver);
    }

    private AppiumDriver getAppiumDriver() {
        DRIVER.set(AppiumDriverFactory.getDriver(AppiumConfiguration.getDesiredCapabilities()));
        LOG.info("WebDriver was created -> " + DRIVER.get());
        return DRIVER.get();
    }

    public static void startAppiumServer() {
        switch (getTestPlatform()) {
            case ANDROID:
                appiumLocalService = AppiumDriverLocalService.buildDefaultService();
                appiumLocalService.start();
                break;
            case IOS:
                final AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder().usingPort(4724);
                appiumLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
                appiumLocalService.start();
        }
    }

    public static void stopAppiumServer() {
        if (appiumLocalService.isRunning() && appiumLocalService != null) {
            appiumLocalService.stop();
        }
    }
}
