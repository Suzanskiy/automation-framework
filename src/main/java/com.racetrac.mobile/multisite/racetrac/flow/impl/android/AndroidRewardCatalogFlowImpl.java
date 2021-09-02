package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsCatalogFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

@Profile(ANDROID)
@Component
public class AndroidRewardCatalogFlowImpl extends BaseFlow implements RewardsCatalogFlow {

    private static final int MINIMUM_SPENT_AMOUNT = 60;

    @Step
    @Override
    public void clickRedeemBtn() {
        try {
            getRewardsPopupPage().refresh();
            getRewardsCatalogPage().getRedeemBtn().click();
        } catch (Exception e) {
            LOG.warn("Unable to click btn on reward catalog redeem");
        }
    }

    @Step
    @Override
    public void clickRedeemPopupBtn() {
        try {
            getRewardsCatalogPage().refresh();
            getRewardsCatalogPage().getRedeemPopupBtn().click();
            getRewardsCatalogPage().waitUntilIsOpened();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Points screen not opened, skipping..");
        }
    }

    @Step
    @Override
    public boolean isUnclaimedRewardsIsDisplayed() {
        try {
//            getRewardsCatalogPage().refresh();
//            getRewardsCatalogPage().waitUntilIsOpened();
            return getRewardsCatalogPage().getUnclaimedRewardsLabel().isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.warn("Unclaimed Rewards Label is not displayed");
            return false;
        }
    }

    @Step
    @Override
    public boolean isNumberOfPointsEnough() {
        try {
            int totalPointsOnAccount = Integer.parseInt(getRewardsCatalogPage().getRewardsCatalogNumberOfPoints().getText());
            if (totalPointsOnAccount >= MINIMUM_SPENT_AMOUNT) {
                return true;
            }
        } catch (NoSuchElementException e) {
            LOG.warn("The number of points is not enough to make redeem");
        }
        return false;
    }

    @Step
    @Override
    public boolean isRewardsCatalogPageOpened() {
        return getRewardsCatalogPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void navigateBack() {
        pressBackBtn();
    }
}
