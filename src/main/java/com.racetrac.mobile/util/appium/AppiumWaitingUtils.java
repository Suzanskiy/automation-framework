package com.racetrac.mobile.util.appium;

import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.racetrac.mobile.framework.constants.TimeoutConstants.LONG_TIMEOUT;
import static com.racetrac.mobile.framework.constants.TimeoutConstants.SHORT_TIMEOUT;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

public class AppiumWaitingUtils {

  public static <T> T waitForCondition(final ExpectedCondition<T> userCondition) {
    return getAppiumDriverWait().until(userCondition);
  }

  public static <T> T waitForCondition(
      final ExpectedCondition<T> userCondition, final long timeout) {
    return getAppiumDriverWait(timeout).until(userCondition);
  }

  public static WebDriverWait getAppiumDriverWait(final long timeout) {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
  }

  public static Wait<WebDriver> getWebDriverWait() {
    return new FluentWait<WebDriver>(getDriver())
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class);
  }

  public static WebDriverWait getAppiumDriverWait() {
    return getAppiumDriverWait(SHORT_TIMEOUT);
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

  public static Boolean waitUntilIsTrue(
      Action<Boolean> action, final long timeout, boolean throwable) {
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

  public static void waitUntilElementClickable(WebElement element) {
    getAppiumDriverWait().until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitUntilAlertIsPresent() {
    getAppiumDriverWait().until(ExpectedConditions.alertIsPresent());
  }
}
