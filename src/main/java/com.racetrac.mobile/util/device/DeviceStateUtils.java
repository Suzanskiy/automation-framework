package com.racetrac.mobile.util.device;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;


public class DeviceStateUtils {
    static AndroidDriver androidDriver = (AndroidDriver) getDriver();

    @Step
    public static void lockDevice() {
        androidDriver.lockDevice();
    }

    @Step
    public static void unlockDevice() {
        androidDriver.unlockDevice();
    }

    @Step
    public static void hideKeyboard() {
        androidDriver.hideKeyboard();
    }

    @Step
    public static void pressEnter() {
        KeyEvent keyEvent = new KeyEvent();
        androidDriver.pressKey(keyEvent.withKey(AndroidKey.ENTER));
    }
}
