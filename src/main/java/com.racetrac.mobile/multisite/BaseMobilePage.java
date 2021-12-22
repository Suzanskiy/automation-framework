package com.racetrac.mobile.multisite;


import com.racetrac.mobile.framework.annotations.PageLoading;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.racetrac.mobile.framework.enums.Exceptions.NO_PAGE_LOADING;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

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
        Wait<WebDriver> wait = getWebDriverWait();

        final List<Field> annotatedElementsList = getMobileElementsNamesWithAnnotationPageLoading();

        final List<WebElement> webElements = convertFieldsToWebElements(annotatedElementsList);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    private Wait<WebDriver> getWebDriverWait() {
        return new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private List<WebElement> convertFieldsToWebElements(final List<Field> annotatedElementsList) {
        List<WebElement> webElements = new ArrayList<>();
        annotatedElementsList
                .stream()
                .parallel()
                .forEach(element -> {
                            final String methodName = getMethodNameByField(element);
                            MobileElement webElement = null;
                            try {
                                webElement = (MobileElement) invokeGetMethodOfElement(methodName);
                            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                                e.printStackTrace();
                            }
                            webElements.add(webElement);
                        }

                );
        return webElements;
    }

    private Object invokeGetMethodOfElement(final String methodName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return getClass().getMethod(methodName).invoke(this);
    }

    private String getMethodNameByField(final Field field) {
        return "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
    }


    /**
     * Returns names of private MobileElements with @PageLoading
     */
    private List<Field> getMobileElementsNamesWithAnnotationPageLoading() {
        final List<Field> objects = new ArrayList<>();
        objects.addAll(Arrays.asList(getClass().getSuperclass().getDeclaredFields()));
        objects.addAll(Arrays.asList(getClass().getDeclaredFields()));
        if (objects.size() == 0) {
            throw new RuntimeException(NO_PAGE_LOADING.message);
        } else {
            return objects.stream()
                    .filter(field -> field.getType().isAssignableFrom(MobileElement.class))
                    .filter(field -> field.isAnnotationPresent(PageLoading.class))
                    .collect(Collectors.toList());

        }
    }
}
