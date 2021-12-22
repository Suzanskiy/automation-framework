package com.racetrac.mobile.util.appium;

import com.racetrac.mobile.framework.appium.AppiumDriverProvider;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AppiumDriverUtils {

    public static AppiumDriver getDriver() {
        return AppiumDriverProvider.INSTANCE.getDriverInstance();
    }

    private static final SwipeScroll swipeScroll = new SwipeScroll(getDriver());

    public static void swipeUP() {
        swipeScroll.swipeScreen(SwipeScroll.Direction.UP);
    }


    public static void swipeDown() {
        swipeScroll.swipeScreen(SwipeScroll.Direction.DOWN);
    }

    public static void swipeRight() {
        swipeScroll.swipeScreen(SwipeScroll.Direction.RIGHT);
    }


    public static void pressBackBtn() {
        getDriver().navigate().back();
    }

}
