package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BecomeFuelVipFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidBecomeFuelVipFlowImpl extends BaseFlow implements BecomeFuelVipFlow {
    @Step
    @Override
    public void clickNotRightNow() {
        try {
            getBecomeFuelVipPage().waitUntilIsOpened();
            getBecomeFuelVipPage().getNotRightNowBtn().click();
        } catch (NoSuchElementException| TimeoutException e) {
        LOG.warn("Unable to click NOT RIGHT NOW on Become Fuel VIP page");
        }
    }

    @Step
    @Override
    public void clickLearnMoreBtn() {
        getBecomeFuelVipPage().getLearnMoreBtn().click();
        handleBrowserOpening();
    }

    @Step
    @Override
    public void clickGetStartedBtn() {
        getBecomeFuelVipPage().getGetStartedBtn().click();
        handleBrowserOpening();
    }

    @Step
    @Override
    public void clickNotRightNowBtn() {
        getBecomeFuelVipPage().getNotRightNowBtn().click();
    }

    @Step
    @Override
    public boolean checkAllElementsIsLoaded() {
        return getBecomeFuelVipPage().waitUntilIsOpened();
    }

    @Override
    public void waitUntilBecomeFuelVipLoaded() {
        try {
            AppiumWaitingUtils.waitUntilElementClickable(getBecomeFuelVipPage().getGetStartedBtn());
        }catch (StaleElementReferenceException e){
            LOG.warn("BecomeFuelVipPage is not loaded");
        }

    }

    private void handleBrowserOpening() {
        try {
            getChromeAcceptTermsPage().waitUntilIsOpened();
            getChromeAcceptTermsPage().getTermsAcceptBtn().click();
            getTurnOnSyncNowPage().waitUntilIsOpened();
            getTurnOnSyncNowPage().getNoThanksBtn().click();
        } catch (TimeoutException|NoSuchElementException e) {
            LOG.debug("Chrome not showed first run page. Its ok");
        }
    }
}
