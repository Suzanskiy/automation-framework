package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

@Profile(ANDROID)
@Component
public class AndroidPromotionalOffersFlowImpl extends BaseFlow implements PromotionalOffersFlow {

    @Override
    public void chooseNoAlcohol() {
        getPromotionalOffersPage().getNoAlcohol().click();
    }

    @Override
    public void chooseNoTobacco() {
        getPromotionalOffersPage().getNoTobacco().click();
    }

    @Override
    public void chooseNoLottery() {
        getPromotionalOffersPage().getNoLottery().click();
    }

    @Override
    public void clickNextBtn() {
        getPromotionalOffersPage().getNextBtn().click();
    }

    @Override
    public void skipPromotions() {
        chooseNoAlcohol();
        chooseNoTobacco();
        chooseNoLottery();
        clickNextBtn();
    }

    @Override
    public boolean isPromotionalOffersScreenOpened() {
        return getPromotionalOffersPage().waitUntilIsOpened();
    }

    @Override
    public void skipIOSPromotions() {
        LOG.debug("Promotions not showing on Android");
    }

    @Override
    public void navigateBack() {
        pressBackBtn();
    }
}