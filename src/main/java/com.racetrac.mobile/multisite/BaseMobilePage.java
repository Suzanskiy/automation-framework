package com.racetrac.mobile.multisite;


import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.racetrac.mobile.framework.enums.Exceptions.NO_PAGE_LOADING;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

public abstract class BaseMobilePage implements MobilePage {

    private static final Logger LOG = LoggerFactory.getLogger(BaseMobilePage.class);
    final int timeout = 30;

    public BaseMobilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @Override
    public void refresh() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @Override
    public boolean waitUntilIsOpened() {
        return AppiumWaitingUtils.waitUntilIsTrue(this::isOpened, 10);
    }

    /**
     * checks if all necessary elements are displayed on the page
     *
     * @return true is all necessary elements are displayed
     */
    @Override
    public boolean isOpened() {
        return AppiumWaitingUtils.waitUntilIsTrue(this::checkAllElementsOfPage, timeout);
    }

    private boolean checkAllElementsOfPage() {
        LOG.info("Checking if page " + getClass().getSimpleName() + " is opened.");
        List<Field> annotatedItems = getMobileElementsNamesWithAnnotationPageLoading();
        List<Field> foundItems = new ArrayList<>();

        annotatedItems.stream().parallel().forEach(field ->
                {
                    try {
                        final String methodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);

                        final MobileElement element = (MobileElement) getClass().getMethod(methodName).invoke(this); // invoke getObject method
                        final boolean elementDisplayed = element.isDisplayed(); // check if displayed
                        LOG.info("Checking element: " + field.getName() + " ---------->>>>> " + "(" + elementDisplayed + ")");

                        if (elementDisplayed) {
                            foundItems.add(field);
                        }
                    } catch (final IllegalAccessException | InvocationTargetException | NoSuchElementException | StaleElementReferenceException | NoSuchMethodException e) {
                        LOG.info("---------->>>>> " + e.getMessage());
                    }
                }
        );
        return foundItems.size() == annotatedItems.size();
    }


    /**
     * Returns names of private MobileElements with @PageLoading
     */
    private List<Field> getMobileElementsNamesWithAnnotationPageLoading() {
        final List<Field> objects = Arrays.stream(getClass().getDeclaredFields()).filter(field -> field.getType().isAssignableFrom(MobileElement.class))
                .filter(field -> field.isAnnotationPresent(PageLoading.class)).collect(Collectors.toList());
        if (objects.size() == 0) {
            throw new RuntimeException(NO_PAGE_LOADING.message);
        } else {
            return objects;
        }
    }
}
