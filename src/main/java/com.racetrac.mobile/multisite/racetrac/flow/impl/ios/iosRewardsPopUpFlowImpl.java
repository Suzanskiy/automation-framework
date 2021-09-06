package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsPopupFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosRewardsPopUpFlowImpl extends BaseFlow implements RewardsPopupFlow {
    @Step
    @Override
    public boolean isRewardPopupPageOpened() {
        return getRewardsPopupPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickGotItBtn() {
        try {
            getRewardsPopupPage().waitUntilIsOpened();
            getRewardsPopupPage().getGotItBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Unable to click got it btn on Rewards pop up");
        }
    }

    @Step
    @Override
    public boolean isGotItBtnDisplayed() {
        return getRewardsPopupPage().getGotItBtn().isDisplayed();
    }

    @Step
    @Override
    public boolean isRedeemPopUpBtnDisplayed() {
        return getRewardsPopupPage().getRedeemBtn().isDisplayed();
    }
    @Step
    @Override
    public boolean isTutorialArrowDisplayed() {
        return getRewardsPopupPage().getTutorialPopUpArrow().isDisplayed();
    }
    @Step
    @Override
    public boolean isRewardsPopUpTutorialMessageDisplayed() {
        return getRewardsPopupPage().getRewardsPopUpTutorialMessage().isDisplayed();
    }
    @Step
    @Override
    public boolean isRedeemPopUpHintDisplayed() {
        return isRewardsPopUpTutorialMessageDisplayed() && isRedeemPopUpBtnDisplayed() &&
                isGotItBtnDisplayed() && isTutorialArrowDisplayed();
    }
    @Step
    @Override
    public void waitUntilMessageAvailable() {
        LOG.info("skipped");
    }

}