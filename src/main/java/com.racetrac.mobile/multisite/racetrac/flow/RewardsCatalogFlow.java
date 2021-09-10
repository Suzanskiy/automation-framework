package com.racetrac.mobile.multisite.racetrac.flow;

public interface RewardsCatalogFlow extends NavigateFlow {

    void clickRedeemBtn();

    void clickRedeemOnPopupBtn();

    boolean isUnclaimedRewardsIsDisplayed();

    boolean isQuantityOfPointsEnough();

    boolean isRewardsCatalogPageOpened();

    int availablePoints();

    int rewardPrice();

    void closeRewardsCatalog();

    int getUnclaimedRewardsCounter();

    boolean isElementsOfRewardsCatalogDisplayed();

    boolean isSadSmilePopUpShown();
}