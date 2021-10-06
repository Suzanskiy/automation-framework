package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
@Profile(ANDROID)
@Component
public class AndroidLocationRequestFlowImpl extends BaseFlow implements LocationRequestFlow {
    @Step
    public void clickNotNow() {
        try {
            getTurnOnLocationPage().waitUntilIsOpened();
            getTurnOnLocationPage().getNotNowBtn().click();
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {

            LOG.warn("Location page is not opened here, refreshing");
        }
    }

    @Step
    public void clickTurnOn() {
        getTurnOnLocationPage().getTurnOnBtn().click();
    }

    @Override
    public boolean isLocationRequestOpened() {
        return getTurnOnLocationPage().waitUntilIsOpened();
    }
}
