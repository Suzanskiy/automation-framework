package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosPromotionalOffersFlowImpl extends BaseFlow implements PromotionalOffersFlow {

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
        getPromotionalOffersPage().waitUntilIsOpened();
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
        skipPromotions();
    }
}