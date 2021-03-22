package com.racetrac.mobile.util.device;

import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

import static com.racetrac.mobile.util.device.DeviceStateUtils.androidDriver;
import static io.appium.java_client.android.nativekey.AndroidKey.ENTER;

public class KeyBoardClickerHelper {

    @Step
    public static void pressEnterKey() {
        androidDriver.pressKey(new KeyEvent(ENTER));
    }
}
