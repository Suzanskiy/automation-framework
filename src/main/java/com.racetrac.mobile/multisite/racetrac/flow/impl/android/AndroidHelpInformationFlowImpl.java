package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.HelpInformationFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

@Profile(ANDROID)
@Component
public class AndroidHelpInformationFlowImpl extends BaseFlow implements HelpInformationFlow {
    @Step
    @Override
    public boolean isHelpInformationPageOpened() {
        AppiumWaitingUtils.waitUntilElementClickable(getHelpInformationPage().getBackBtn());
        return getHelpInformationPage().waitUntilIsOpened();
    }
    @Step
    @Override
    public void navigateToContactUs() {
        Point contactLinkPoint = getHelpInformationPage().getContactUsLink().getCenter();
        int elementWidth = getHelpInformationPage().getContactUsLink().getSize().width;
        tapByCoordinates(contactLinkPoint.getX() + elementWidth/4, contactLinkPoint.getY());
    }
    @Step
    @Override
    public boolean isContactUsDisplayed() {
        try {
            return getHelpInformationPage().getContactUsLink().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private static void tapByCoordinates(int x, int y) {
        new TouchAction(getDriver())
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }
}
