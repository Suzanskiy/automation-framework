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

@Profile(IOS)
@Component
public class iosLocationRequestFlowImpl extends BaseFlow implements LocationRequestFlow {
    @Step
    public void clickNotNow() {
        try {
            getTurnOnLocationPage().waitUntilIsOpened();
            getTurnOnLocationPage().getNotNowBtn().click();
            getDriver().switchTo().alert().dismiss();
        } catch (TimeoutException | NoSuchElementException | NoAlertPresentException e) {

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
