package com.racetrac.mobile.util.device;

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
    }

    @Step
    public static void enableConnection() {
        androidDriver.setConnection(new ConnectionStateBuilder()
                .withWiFiEnabled()
                .withDataEnabled()
                .build());
    }

    private static boolean isConnectionEnabled() {
        return androidDriver.getConnection().isWiFiEnabled() && androidDriver.getConnection().isDataEnabled();
    }

    public static void reconnection() {
        if (!isConnectionEnabled()) {
            enableConnection();
        }
    }
}