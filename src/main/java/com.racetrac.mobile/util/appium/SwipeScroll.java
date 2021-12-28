package com.racetrac.mobile.util.appium;

import io.appium.java_client.AppiumDriver;
import lombok.AllArgsConstructor;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static com.racetrac.mobile.framework.appium.AppiumConfiguration.getTestPlatform;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@AllArgsConstructor
public class SwipeScroll {
    private static final SwipeScroll swipeScroll = new SwipeScroll(getDriver());

    final int ANIMATION_TIME = 400; // ms
    final int PRESS_TIME = 200; // ms

    AppiumDriver appiumDriver;

    /**
     * Performs swipe from the center of screen
     *
     * @param pointOptionStart pointOptionEnd
     **/

    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'");
        Dimension dims = appiumDriver.manage().window().getSize();

        Map<String, Object> args = new HashMap<>();
        switch (dir) {
            case DOWN:
                args.put("direction", "up");
                args.put("top", dims.height/2);

                break;
            case UP:
                args.put("top", 5);
                args.put("direction", "down");
                break;
            case LEFT:
                args.put("direction", "left");
                break;
            case RIGHT:
                args.put("direction", "right");
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        switch (getTestPlatform()) {
            case ANDROID:
                args.put("percent", 100);
                args.put("left", 100);
                args.put("height", 500);
                args.put("width", 200);
                getDriver().executeScript("mobile: scrollGesture", args);
                break;
            case IOS:
                getDriver().executeScript("mobile: scroll", args);
                break;

        }
    }

    public static void swipeToElement(SwipeScroll.Direction direction, WebElement element) {
        int stopper = 0;
        int maxSwipes = 5;
        boolean elementIsDisplayed = false;
        do {
            swipeScroll.swipeScreen(direction);
            try {
                elementIsDisplayed = element.isDisplayed();
            } catch (NoSuchElementException e) {
                elementIsDisplayed = false;
            }
        } while (!elementIsDisplayed && stopper++ < maxSwipes);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
