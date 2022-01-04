package com.racetrac.mobile.multisite;

import com.racetrac.mobile.framework.annotations.PageLoading;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.getWebDriverWait;

public abstract class BaseMobilePage implements MobilePage {

  private static final Logger LOG = LoggerFactory.getLogger(BaseMobilePage.class);

  public BaseMobilePage() {
    PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
  }

  @Override
  public void refresh() {
    PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
  }
  /**
   * checks if all necessary elements are displayed on the page
   *
   * @return true is all necessary elements are displayed
   */
  @Override
  public boolean waitUntilIsOpened() {
    try {
      getWebDriverWait()
          .until(
              ExpectedConditions.visibilityOfAllElements(
                  getWebElementsNamesWithAnnotationPageLoading()));
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  private Object invokeGetMethodOfElement(final String methodName)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    return getClass().getMethod(methodName).invoke(this);
  }

  private String getMethodNameByField(final Field field) {
    return "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
  }

  /** Returns elements of private MobileElements with @PageLoading */
  private List<WebElement> getWebElementsNamesWithAnnotationPageLoading() {
    final List<WebElement> objects = new ArrayList<>();

    Arrays.stream(getClass().getDeclaredFields())
        .filter(field -> field.getType().isAssignableFrom(WebElement.class))
        .filter(field -> field.isAnnotationPresent(PageLoading.class))
        .forEach(
            field -> {
              try {
                final WebElement o =
                    (WebElement) invokeGetMethodOfElement(getMethodNameByField(field));
                objects.add(o);
              } catch (IllegalAccessException
                  | InvocationTargetException
                  | NoSuchMethodException e) {
                LOG.warn(e.toString());
              }
            });

    return objects;
  }
}
