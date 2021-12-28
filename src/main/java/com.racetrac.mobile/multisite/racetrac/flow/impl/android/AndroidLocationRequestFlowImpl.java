package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import io.qameta.allure.Step;
import lombok.extern.java.Log;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilAlertIsPresent;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilElementClickable;

@Profile(ANDROID)
@Component
public class AndroidLocationRequestFlowImpl extends BaseFlow implements LocationRequestFlow {
    @Step
    public void clickContinue() {
        try {
            getTurnOnLocationPage().waitUntilIsOpened();
            getTurnOnLocationPage().getContinueBtn().click();
        } catch (TimeoutException | NoSuchElementException e) {
            LOG.warn("Location page is not opened here, refreshing");
        }

        try {
            waitUntilAlertIsPresent();
            getDriver().switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            LOG.warn("unable to skip native location request");
        } catch (TimeoutException | StaleElementReferenceException e) {
            LOG.info("Got timeout excpetion while waiting for native location request window");
        }

    }

    @Step
    public void clickTurnOn() {
        try {
            getTurnOnLocationPage().waitUntilIsOpened();
            waitUntilElementClickable(getTurnOnLocationPage().getContinueBtn());
            getTurnOnLocationPage().getContinueBtn().click();
        } catch (TimeoutException | NoSuchElementException e) {
            LOG.warn("Location page is not opened here, refreshing");
        }

        try {
            waitUntilAlertIsPresent();
            getDriver().switchTo().alert().accept();
            waitUntilAlertIsPresent();
            getDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException | InvalidElementStateException e) {
            LOG.warn("unable to skip native location request");
        } catch (TimeoutException e) {
            LOG.info("Got timeout excpetion while waiting for native location request window");
        }
    }

    @Override
    public void clickOnlyThisTime() {
        getTurnOnLocationPage().waitUntilIsOpened();
        getTurnOnLocationPage().getContinueBtn().click();
        try {
            getDriver().switchTo().alert().accept();
            getDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException ignored) {

        }
    }

    @Override
    public boolean isLocationRequestPageOpened() {
        return getTurnOnLocationPage().waitUntilIsOpened();
    }

    @Override
    public void clickAllowButton() {
        try {
            getAllowLocationPermitView().waitUntilIsOpened();
            getAllowLocationPermitView().getAllowBtn().click();
        } catch (NoSuchElementException e) {
            LOG.info("Allow button is not appear on Location Permit view");
        }
    }
}
