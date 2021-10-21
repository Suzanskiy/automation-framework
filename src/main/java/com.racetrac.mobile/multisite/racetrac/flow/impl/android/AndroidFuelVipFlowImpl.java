package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FuelVipFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidFuelVipFlowImpl extends BaseFlow implements FuelVipFlow {

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
    private void handleBrowserOpening() {
        try {
            getChromeAcceptTermsPage().waitUntilIsOpened();
            getChromeAcceptTermsPage().getTermsAcceptBtn().click();
            getTurnOnSyncNowPage().waitUntilIsOpened();
            getTurnOnSyncNowPage().getNoThanksBtn().click();
        } catch (TimeoutException | NoSuchElementException e) {
            LOG.debug("Chrome not showed first run page. Its ok");
        }
    }

    @Step
    @Override
    public void clickVipProgramDetails() {
        getFuelVipPage().getFuelVIPProgramDetailsSection().click();
        handleBrowserOpening();
    }

    @Override
    public boolean isFuelVipPageDisplayed() {
        return getFuelVipPage().waitUntilIsOpened();
    }

}
