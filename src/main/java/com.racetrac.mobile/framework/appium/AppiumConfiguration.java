package com.racetrac.mobile.framework.appium;

import com.racetrac.mobile.framework.enums.Exceptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.logging.Level;

import static com.racetrac.mobile.framework.appium.Platform.valueOf;
import static io.appium.java_client.remote.MobileCapabilityType.ACCEPT_SSL_CERTS;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.LOGGING_PREFS;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;


public final class AppiumConfiguration {

    private static final String AUT_PACKAGE = "autPackage";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String HUB = "hub";
    private static final String BUNDLE_ID = "bundleId";

    private AppiumConfiguration() {
    }

    public static String getAutPackage() {
        return getFileProperty(AUT_PACKAGE);
    }

    public static Platform getTestPlatform() {
        return valueOf(getFileProperty(PLATFORM_NAME).toUpperCase());
    }

    public static String getDeviceName() {
        return getFileProperty(DEVICE_NAME);
    }

    public static String getAppPackage() {
        return getFileProperty(APP_PACKAGE);
    }

    public static String getAppActivity() {
        return getFileProperty(APP_ACTIVITY);
    }

    public static String getUDID() {
        return getFileProperty(UDID);
    }

    public static String getPlatformVersion() {
        return getFileProperty(PLATFORM_VERSION);
    }

    public static String getHubURL() {
        return getFileProperty(HUB);
    }

    public static String getBundleId() {
        return getFileProperty(BUNDLE_ID);
    }

    public static String getAppAbsolutePath() {

        File[] files = new File(getAutPackage())
                .listFiles((dir, name) -> name.toLowerCase().endsWith(getTestPlatform().extension));
        if (files == null || files.length == 0) {
            throw new IllegalArgumentException(String.format("%s; %s", Exceptions.UNCLEAR_TYPE.message,
                    new File(getAutPackage()).getAbsolutePath()));
        }
        return files[0].getAbsolutePath();
    }
    public static DesiredCapabilities getDesiredCapabilities() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(LOGGING_PREFS, setupLoggingPreferences());
        capabilities.setCapability(PLATFORM_NAME, getTestPlatform().platform);

        if (isNotBlank(getDeviceName())) {
            capabilities.setCapability(DEVICE_NAME, getDeviceName());
        } else {
            if (isNotBlank(getUDID())) {
                capabilities.setCapability(UDID, getUDID());
            } else {
                throw new IllegalArgumentException(Exceptions.WRONG_NAME.message);
            }
        }
      //  capabilities.setCapability("isHeadless", true);
        capabilities.setCapability("app", getAppAbsolutePath());

        switch (getTestPlatform()) {
            case ANDROID: {
                capabilities.setCapability(APP_PACKAGE, getAppPackage());
                capabilities.setCapability(APP_ACTIVITY, getAppActivity());
                capabilities.setCapability("avd", getDeviceName());
                capabilities.setCapability("avdLaunchTimeout", "150000");
                capabilities.setCapability("avdReadyTimeout", "150000");
                capabilities.setCapability("androidInstallTimeout", "150000");
                break;
            }
            case IOS: {
                capabilities.setCapability(PLATFORM_VERSION, getPlatformVersion());
                capabilities.setCapability(AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability(DEVICE_NAME, getDeviceName());
                capabilities.setCapability(BUNDLE_ID, getBundleId());
                break;
            }
            default: {
                throw new IllegalArgumentException(Exceptions.UNKNOWN_PLATFORM.message);
            }
        }
        return capabilities;
    }

    private static String getFileProperty(final String key) {
        return AppiumPropertiesHolder.getInstance().getProperty(key);
    }

    private static LoggingPreferences setupLoggingPreferences() {
        final LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.DRIVER, Level.ALL);
        return logPrefs;
    }
}
