package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosRewardsPopUpFlowImpl extends BaseFlow implements RewardsPopupFlow {
    @Override
    public boolean isRewardPopupPageOpened() {
        return getRewardsPopupPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickGotItBtn() {
        getRewardsPopupPage().waitUntilIsOpened();
        try {
            getRewardsPopupPage().getGotItBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Unable to click got it btn on Rewards pop up");
        }
    }

    @Override
    public boolean isGotItBtnDisplayed() {
        return false;
    }

    @Step
    @Override
    public boolean isRedeemPopUpBtnDisplayed() {
        return false;
    }
}
