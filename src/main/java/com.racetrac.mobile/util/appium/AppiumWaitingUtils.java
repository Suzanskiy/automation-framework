package com.racetrac.mobile.util.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.racetrac.mobile.framework.constants.TimeoutConstants.LONG_TIMEOUT;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;


public class AppiumWaitingUtils {

    public static <T> T waitForCondition(final ExpectedCondition<T> userCondition) {
        return getAppiumDriverWait().until(userCondition);
    }

    public static <T> T waitForCondition(final ExpectedCondition<T> userCondition, final long timeout) {
        return getAppiumDriverWait(timeout).until(userCondition);
    }

    private static WebDriverWait getAppiumDriverWait(final long timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }

    private static WebDriverWait getAppiumDriverWait() {
        return getAppiumDriverWait(LONG_TIMEOUT);
    }

    public static void waitForMobileElementsToBeVisible(MobileElement... list) {
        waitForMobileElementsToBeVisible(Arrays.asList(list));
    }

    public static void waitForMobileElementsToBeVisible(List<MobileElement> list) {
        AppiumWaitingUtils.waitForCondition(new ExpectedCondition<List<MobileElement>>() {
            public List<MobileElement> apply(WebDriver driver) {
                Iterator var2 = list.iterator();

                WebElement element;
                do {
                    if (!var2.hasNext()) {
                        return list.size() > 0 ? list : null;
                    }

                    element = (WebElement) var2.next();
                } while (element.isDisplayed());

                return null;
            }

            public String toString() {
                return "visibility of all " + list;
            }
        });
    }

	public static Boolean waitUntilIsTrue(Action<Boolean> action) {
		return waitUntilIsTrue(action, LONG_TIMEOUT);
	}

	public static Boolean waitUntilIsTrue(Action<Boolean> action, boolean throwable) {
        return waitUntilIsTrue(action, LONG_TIMEOUT, throwable);
    }

	public static Boolean waitUntilIsTrue(Action<Boolean> action, final long timeout) {
		return waitUntilIsTrue(action, timeout, true);
	}

	public static Boolean waitUntilIsTrue(Action<Boolean> action, final long timeout, boolean throwable) {
		try {
			return AppiumWaitingUtils.waitForCondition(driver -> action.execute(), timeout);
		} catch (TimeoutException e) {
			if (throwable) {
				throw e;
			} else {
				return false;
			}
		}
	}

    public static void waitUntil(org.openqa.selenium.support.ui.ExpectedCondition<WebElement> conditions) {
        WebDriverWait wait = new WebDriverWait(getDriver(), LONG_TIMEOUT);
        wait.until(conditions);
    }
}
