package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsCatalogFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
            getRewardsCatalogPage().getRedeemBtn().click();
        } catch (NoSuchElementException e) {
            LOG.warn("Unable to click btn on reward catalog redeem");
        }
    }

    @Step
    @Override
    public void clickRedeemOnPopupBtn() {
        getEnoughRedeemPointsPopUp().waitUntilIsOpened();
        try {
            getEnoughRedeemPointsPopUp().getRedeemPopupBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Points screen not opened, skipping..");
        }
    }

    @Step
    @Override
    public boolean isUnclaimedRewardsIsDisplayed() {
        try {
            getRewardsCatalogPage().refresh();
            return getRewardsCatalogPage().getUnclaimedRewardsLabel().isDisplayed();
        } catch (NoSuchElementException e) {
            LOG.warn("Unclaimed Rewards Label is not displayed");
            return false;
        }
    }

    @Step
    @Override
    public boolean isQuantityOfPointsEnough() {
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
    public int availablePoints() {
        return Integer.parseInt(getRewardsCatalogPage().getRewardsCatalogNumberOfPoints().getAttribute("text"));
    }

    @Override
    public int rewardPrice() {
        String pointsText = getRewardsCatalogPage().getRewardPoints().getAttribute("text");
        return Integer.parseInt(pointsText.substring(0, pointsText.indexOf(' ')));
    }

    @Step
    @Override
    public void closeRewardsCatalog() {
        getRewardsCatalogPage().getRewardsCatalogBackBtn().click();
    }

    @Override
    public int getUnclaimedRewardsCounter() {
        return Integer.parseInt(getRewardsCatalogPage().getUnclaimedRewardsCounter().getAttribute("text"));
    }

  @Override
    public boolean isElementsOfRewardsCatalogDisplayed() {
        try {
            return getRewardsCatalogPage().waitUntilIsOpened();

        } catch (NoSuchElementException e) {
            LOG.warn("elements of Rewards catalog are not displayed");
            return false;
        }
    }

    @Override
    public boolean isSadSmilePopUpShown() {
        try {
            return getSadSmileRewardCatalogView().waitUntilIsOpened();
        } catch (NoSuchElementException e) {
            LOG.warn("Sad smile is not displayed");
            return false;
        }
    }

    @Override
    public void waitUntilSadSmilePopUpShown() {
        AppiumWaitingUtils.waitUntilElementClickable(getSadSmileRewardCatalogView().getOkSadSmileBtn());
    }

    @Step
        @Override
        public void navigateBack () {
            pressBackBtn();
        }
    }
