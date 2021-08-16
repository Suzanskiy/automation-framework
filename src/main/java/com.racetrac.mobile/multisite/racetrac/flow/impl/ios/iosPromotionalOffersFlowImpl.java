package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.PromotionalOffersFlow;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
    public void chooseYesAlcohol() {
        //TODO IOS Impl
    }

    @Override
    public void chooseYesTobacco() {
        //TODO IOS Impl
    }

    @Override
    public void chooseYesLottery() {
        //TODO IOS Impl
    }

    @Override
    public void acceptPromotions() {
        //TODO IOS Impl
    }

    @Override
    public void clickSaveBtn() {
        //TODO IOS Impl
    }

    @Override
    public void clickNextBtn() {
        getPromotionalOffersPage().getNextBtn().click();
    }

    @Override
    public void skipPromotions() {
        try {
            getPromotionalOffersPage().waitUntilIsOpened();
            executeCLickProcedure();
        } catch (TimeoutException e) {
            LOG.warn("Time out exception on skipping promotions, refreshing");
            getPromotionalOffersPage().refresh();
        } catch (NoSuchElementException ex) {
            //ignore
        }

    }

    private void executeCLickProcedure() {
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

    @Override
    public void navigateBack() {
        getPromotionalOffersPage().getNavigateBackBtn().click();
    }
}