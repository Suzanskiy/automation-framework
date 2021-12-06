package com.racetrac.mobile.multisite.racetrac.flow.impl;

public interface FuelSavingsFlow {

    boolean isFuelSavingsPageOpened();

    boolean checkAllFuelSavingsElementsAreLoaded();

    boolean checkAllRewardsElementsAreLoaded();

    boolean checkAllVipElementsAreLoaded();

    boolean checkAllDebitCardElementsAreLoaded();

    void navigateToFuelSavingsDebitCard();

    void navigateToFuelSavingsRewards();

    void navigateToFuelSavingsVip();

    void navigateBackFromDebitCard();

    void navigateBackFromRewards();

    void navigateBackFromVip();

    void navigateBackToWelcomePage();
}
