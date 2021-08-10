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

import static com.racetrac.mobile.framework.constants.TimeoutConstants.SHORT_TIMEOUT;
import static com.racetrac.mobile.framework.enums.Exceptions.NO_PAGE_LOADING;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeDown;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeUP;

public abstract class BaseMobilePage implements MobilePage {

    private static final Logger LOG = LoggerFactory.getLogger(BaseMobilePage.class);

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
        return AppiumWaitingUtils.waitUntilIsTrue(this::checkAllElementsOfPage, SHORT_TIMEOUT);
    }

    private List<Field> checkElementToBeVisible(List<Field> elements) {
        return elements
                .stream()
                .parallel()
                .filter(field -> {
                            MobileElement element = null;
                            final String methodName = getMethodNameByField(field);
                            try {
                                element = (MobileElement) invokeGetMethodOfElement(methodName); // invoke getObject method
                                //   LOG.info("Checking element: " + field.getName() + " ---------->>>>> " + "(" + element.isDisplayed() + ")");
                                return element.isDisplayed();
                            } catch (NoSuchElementException e) {
                                LOG.info("!!!! Element [ " + field.getName() + " ] on " + getClass().getSimpleName() + " not exists !!!! ");
                            } catch (IllegalAccessException | InvocationTargetException | StaleElementReferenceException | NoSuchMethodException e) {
                                LOG.info("---------->>>>> " + e.getMessage());
                            }
                            return false;
                        }
                )
                .collect(Collectors.toList());
    }

    private boolean checkAllElementsOfPage() {
        LOG.info("Checking if page " + getClass().getSimpleName() + " is opened.");
        List<Field> pageObjectFields = getMobileElementsNamesWithAnnotationPageLoading();

        List<Field> foundItems = checkElementToBeVisible(pageObjectFields);
        List<Field> notFoundItems = new ArrayList<>();

        final List<Field> finalFoundItems = foundItems;
        pageObjectFields.forEach(
                x -> {
                    if (!finalFoundItems.contains(x)) {
                        notFoundItems.add(x);
                    }
                }
        );

        if (notFoundItems.size() > 0) {
            swipeUP();
            foundItems.addAll(checkElementToBeVisible(notFoundItems));  // recheck
            swipeDown();
        }

        return foundItems.size() == pageObjectFields.size();
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
