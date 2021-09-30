package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.RewardsCatalogFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosRewardCatalogFlowImpl extends BaseFlow implements RewardsCatalogFlow {

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
            getRewardsCatalogPage().waitUntilIsOpened();
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
        return Integer.parseInt(getRewardsCatalogPage().getRewardsCatalogNumberOfPoints().getAttribute("value"));
    }

    @Override
    public int rewardPrice() {
        return Integer.parseInt(getRewardsCatalogPage().getRewardPoints().getAttribute("value").substring(0, 3));
    }

    @Step
    @Override
    public void closeRewardsCatalog() {
        getRewardsCatalogPage().getCloseBtn().click();
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
        return getSadSmileRewardCatalogView().waitUntilIsOpened();
    }

    @Step
    @Override
    public void navigateBack() {
        getRewardsCatalogPage().getCloseBtn().click();
    }
}