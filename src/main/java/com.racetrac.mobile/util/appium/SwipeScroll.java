package com.racetrac.mobile.util.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.AllArgsConstructor;
import org.openqa.selenium.Dimension;

import java.time.Duration;

@AllArgsConstructor
public class SwipeScroll {

    final int ANIMATION_TIME = 400; // ms
    final int PRESS_TIME = 200; // ms

    AppiumDriver appiumDriver;

    /**
     * Performs swipe from the center of screen
     *
     * @param pointOptionStart pointOptionEnd
     **/

    public void swipeScreen(PointOption pointOptionStart, PointOption pointOptionEnd) {
        // execute swipe using TouchAction
        try {
            new TouchAction<>(appiumDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
        }

    }

    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'");
        int edgeBorder = 5;

        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        swipeScreen(pointOptionStart, pointOptionEnd);
    }

    public void swipeGently(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'");
        int edgeBorder = 20;

        PointOption pointOptionStart, pointOptionEnd;
        // init screen variables
        Dimension dims = appiumDriver.manage().window().getSize();
        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.width / 2 + edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, dims.width / 2 - edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(dims.height / 2 - edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.height / 2, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        swipeScreen(pointOptionStart, pointOptionEnd);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
