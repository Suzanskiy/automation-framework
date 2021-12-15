package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FuelSavingsFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidFuelSavingsFlowImpl extends BaseFlow implements FuelSavingsFlow {

    @Step
    @Override
    public boolean isFuelSavingsPageOpened() {
        return getFuelSavingsPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean checkAllFuelSavingsElementsAreLoaded() {
        return getFuelSavingsPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean checkAllDebitCardElementsAreLoaded() {
        return getFuelSavingsDebitCardPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean checkAllVipElementsAreLoaded() {
        return getFuelSavingsVipPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean checkAllRewardsElementsAreLoaded() {
        return getFuelSavingsRewardsPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void navigateToFuelSavingsDebitCard() {
        getFuelSavingsPage().getDebitCardSavings().click();
    }

    @Step
    @Override
    public void navigateBackFromDebitCard() {
        getFuelSavingsDebitCardPage().getBackBtn().click();
    }

    @Step
    @Override
    public void navigateToFuelSavingsRewards() {
        getFuelSavingsPage().getRewardsSavings().click();
    }

    @Step
    @Override
    public void navigateBackFromRewards() {
        getFuelSavingsRewardsPage().getBackBtn().click();
    }

    @Step
    @Override
    public void navigateToFuelSavingsVip() {
        getFuelSavingsPage().getVipSavings().click();
    }

    @Step
    @Override
    public void navigateBackFromVip() {
        getFuelSavingsVipPage().getBackBtn().click();
    }

    @Step
    @Override
    public void navigateBackToWelcomePage() {
        getFuelSavingsPage().getBackBtn().click();
    }
}
