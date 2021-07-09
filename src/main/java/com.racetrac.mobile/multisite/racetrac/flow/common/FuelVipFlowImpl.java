package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FuelVipFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.springframework.stereotype.Component;

@Component
public class FuelVipFlowImpl extends BaseFlow implements FuelVipFlow {

    @Step
    @Override
    public void navigateToFuelVipSection() {
        getHomePage().getVipSection().click();
        getFuelVipPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickLearnMoreNoSubscription() {
        getFuelVipPage().getNotMemberLearMoreBtn().click();
        handleBrowserOpening();
    }

    @Step
    @Override
    public void handleBrowserOpening() {
        try {
            getChromeAcceptTermsPage().waitUntilIsOpened();
            getChromeAcceptTermsPage().getTermsAcceptBtn().click();
            getTurnOnSyncNowPage().waitUntilIsOpened();
            getTurnOnSyncNowPage().getNoThanksBtn().click();
        } catch (TimeoutException e) {
            LOG.debug("Chrome not showed first run page. Its ok");
        }
    }

    @Step
    @Override
    public void clickVipProgramDetails() {
        getFuelVipPage().getFuelVIPProgramDetailsSection().click();
        handleBrowserOpening();
    }
}
