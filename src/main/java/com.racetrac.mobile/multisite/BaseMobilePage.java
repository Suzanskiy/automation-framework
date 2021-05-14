package com.racetrac.mobile.multisite;


import com.racetrac.mobile.framework.annotations.PageLoading;
import com.racetrac.mobile.framework.appium.AppiumDriverProvider;
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

import static com.racetrac.mobile.framework.enums.Exceptions.NO_PAGE_LOADING;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

public abstract class BaseMobilePage implements MobilePage {

    private static final Logger LOG = LoggerFactory.getLogger(AppiumDriverProvider.class);

    public BaseMobilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @Override
    public void refresh() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @Override
    public boolean waitUntilIsOpened() {
        return AppiumWaitingUtils.waitUntilIsTrue(this::isOpened);
    }

    /**
     * checks if all necessary elements are displayed on the page
     *
     * @return true is all necessary elements are displayed
     */
    @Override
    public boolean isOpened() {
        LOG.info("Checking if page " + getClass().getSimpleName() + " is opened.");
        for (final String mobileElementName : getMobileElementsNamesWithAnnotationPageLoading()) {
            try {
                final String methodName = "get" + mobileElementName.substring(0, 1).toUpperCase() + mobileElementName.substring(1);
                LOG.info("Invoke method " + methodName + "()");
                final MobileElement element = (MobileElement) getClass().getMethod(methodName).invoke(this);
                final boolean elementDisplayed = element.isDisplayed();
                LOG.info("-----> (" + elementDisplayed + ")");

                if (!elementDisplayed) {
                    return false;
                }
            } catch (final IllegalAccessException | InvocationTargetException | NoSuchElementException | StaleElementReferenceException | NoSuchMethodException e) {
                LOG.info("-----> " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    // TODO There is another way to wait until all elements becomes ready. Need to be refactored asap

    /**
     * Returns names of private MobileElements with @PageLoading
     */
    private List<String> getMobileElementsNamesWithAnnotationPageLoading() {
        final Object[] objects = Arrays.stream(getClass().getDeclaredFields()).filter(field -> field.getType().isAssignableFrom(MobileElement.class))
                .filter(field -> field.isAnnotationPresent(PageLoading.class)).toArray();
        final List<String> list = new ArrayList<>();
        if (objects.length == 0) {
            throw new RuntimeException(NO_PAGE_LOADING.message);
        } else {
            for (final Object object : objects) {
                list.add(((Field) object).getName());
            }
        }
        LOG.info("Elements to be visible: " + list.toString());
        return list;
    }
}
