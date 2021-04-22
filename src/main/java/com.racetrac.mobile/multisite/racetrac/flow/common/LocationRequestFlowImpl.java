package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.LocationRequestFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class LocationRequestFlowImpl extends BaseFlow implements LocationRequestFlow {
    @Step
    public void clickNotNow() {
        getTurnOnLocationPage().getNotNowBtn().click();
    }

    @Step
    public void clickTurnOn() {
        getTurnOnLocationPage().getTurnOnBtn().click();
    }
}
