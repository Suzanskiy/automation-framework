package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.stereotype.Component;

@Component
public class LocationRequestFlowImpl extends BaseFlow implements LocationRequestFlow {
    @Step
    public void clickNotNow() {
        try {
            getTurnOnLocationPage().getNotNowBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Location page is not opened here, It might create a problem soon");
        }
    }

    @Step
    public void clickTurnOn() {
        getTurnOnLocationPage().getTurnOnBtn().click();
    }

    @Override
    public boolean isLocationRequestOpened() {
        return getTurnOnLocationPage().isOpened();
    }
}
