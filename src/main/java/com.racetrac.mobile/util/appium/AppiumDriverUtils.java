package com.racetrac.mobile.util.appium;

import com.racetrac.mobile.framework.appium.AppiumDriverProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.time.Duration;

public class AppiumDriverUtils {

    public static AppiumDriver<MobileElement> getDriver() {
        return AppiumDriverProvider.INSTANCE.getDriverInstance();
    }

    private static final SwipeScroll swipeScroll = new SwipeScroll(getDriver());

    public static void runAppInBackground(final Duration duration) {
        getDriver().runAppInBackground(duration);
    }

    public static void swipeUP() {
        swipeScroll.swipeScreen(SwipeScroll.Direction.UP);
    }

    public static void swipeUPGently() {
        swipeScroll.swipeGently(SwipeScroll.Direction.UP);
    }

    public static void swipeDown() {
        swipeScroll.swipeScreen(SwipeScroll.Direction.DOWN);
    }

    public static void swipeRightHard(){
        swipeScroll.swipeScreenHard(SwipeScroll.Direction.RIGHT);
    }

    public static void swipeDownHard(){
        swipeScroll.swipeScreenHard(SwipeScroll.Direction.DOWN);
    }


    public static void swipeDownGently() {
        swipeScroll.swipeGently(SwipeScroll.Direction.DOWN);
    }

    public static void closeApp() {
        getDriver().closeApp();
    }

    public static void launchApp() {
        getDriver().launchApp();
    }

    public static void pressBackBtn() {
        getDriver().navigate().back();
    }

}
