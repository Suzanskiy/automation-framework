package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class LocationRequestFlow extends BaseFlow {
    @Step
    public void clickNotNow() {
        getTurnOnLocationPage().getNotNowBtn().click();
    }

    @Step
    public void clickTurnOn() {
        getTurnOnLocationPage().getTurnOnBtn().click();
    }
}
