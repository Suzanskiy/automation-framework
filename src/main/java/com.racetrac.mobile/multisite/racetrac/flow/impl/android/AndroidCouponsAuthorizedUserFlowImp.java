package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.CouponsAuthorizedUserFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidCouponsAuthorizedUserFlowImp extends BaseFlow implements CouponsAuthorizedUserFlow {

    @Step
    @Override
    public boolean isCouponsPageAuthorizedUserOpen() {
        return getCouponsAuthorizedUserPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickOnGiftItBtn() {
        getCouponsAuthorizedUserPage().getGiftItBtn().click();
        getCouponsAuthorizedUserPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void selectAvailableCoupon() {
        getCouponsAuthorizedUserPage().getAvailableCoupon().click();
    }

    @Step
    @Override
    public void pressBackBtn() {
        getCouponsAuthorizedUserPage().getBackBtn().click();
    }

}
