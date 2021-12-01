package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilAlertIsPresent;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilElementClickable;

@Profile(IOS)
@Component
public class iosLocationRequestFlowImpl extends BaseFlow implements LocationRequestFlow {
    @Step
    public void clickContinue() {
        try {
            getTurnOnLocationPage().waitUntilIsOpened();
            waitUntilElementClickable(getTurnOnLocationPage().getContinueBtn());
            getTurnOnLocationPage().getContinueBtn().click();
        } catch (TimeoutException | NoSuchElementException e) {
            LOG.warn("Location page is not opened here, refreshing");
            return;
        }

        try {
            waitUntilAlertIsPresent();
            getDriver().switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            LOG.warn("unable to skip native location request");
        } catch (TimeoutException e) {
            LOG.info("Got timeout excpetion while waiting for native location request window");
        }

    }

    @Step
    public void clickTurnOn() {
        getTurnOnLocationPage().getTurnOnBtn().click();
    }

    @Override
    public void clickOnlyThisTime() {

    }

    @Override
    public boolean isLocationRequestOpened() {
        return getTurnOnLocationPage().waitUntilIsOpened();
    }

    @Override
    public void clickAllowButton() {

    }
}
