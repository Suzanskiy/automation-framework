package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.CouponsPopUpFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosCouponsPopUpFlowImpl extends BaseFlow implements CouponsPopUpFlow {

    @Step
    @Override
    public boolean isCouponsPopUpDisplayed() {
        return getCouponsPopUpPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickOnCouponsPopUpGotItBtn() {
        getCouponsPopUpPage().waitUntilIsOpened();
        getCouponsPopUpPage().getGotItBtn().click();
    }
}
