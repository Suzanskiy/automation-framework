package com.racetrac.mobile.util.device;

import com.racetrac.mobile.util.appium.Action;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.qameta.allure.Step;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

public class ConnectionUtils {
    static AndroidDriver androidDriver = (AndroidDriver) getDriver();

    @Step
    public static void disableConnection() {
        androidDriver.setConnection(new ConnectionStateBuilder()
                .withWiFiDisabled()
                .withDataDisabled()
                .build());

        Action action = () -> {
            while (androidDriver.getConnection().isWiFiEnabled()&&androidDriver.getConnection().isDataEnabled()) {
                return false;
            }
            return true;
        };
        AppiumWaitingUtils.waitUntilIsTrue(action);
    }

    @Step
    public static void enableConnection() {
        androidDriver.setConnection(new ConnectionStateBuilder()
                .withWiFiEnabled()
                .withDataEnabled()
                .build());

        Action action = () -> {
            while (!(androidDriver.getConnection().isWiFiEnabled()&&androidDriver.getConnection().isDataEnabled())) {
                return false;
            }
            return true;
        };
        AppiumWaitingUtils.waitUntilIsTrue(action);
    }
}