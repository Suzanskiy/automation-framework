package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.CheckoutBtnFLow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidCheckoutBtnFlowImpl extends BaseFlow implements CheckoutBtnFLow {
    @Step
    @Override
    public boolean isCheckoutBtnDisplayed() {
        return getCheckoutBtnView().waitUntilIsOpened();
    }
    @Step
    @Override
    public int getCheckoutBtnCounter() {
        return Integer.parseInt(getCheckoutBtnView().getCheckoutCounter().getAttribute("text"));
    }
    @Step
    @Override
    public void clickOnCheckoutBtn() {
        getCheckoutBtnView().getCheckoutBtn().click();
    }
}
