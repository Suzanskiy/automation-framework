package com.racetrac.mobile.multisite.racetrac.flow;

public interface RewardsCatalogFlow extends NavigateFlow {

    void clickRedeemBtn();

    void clickRedeemOnPopupBtn();

    boolean isUnclaimedRewardsIsDisplayed();

    boolean isQuantityOfPointsEnough();

    boolean isRewardsCatalogPageOpened();

    int getAvailablePoints();

    int getRewardPrice();

    void closeRewardsCatalog();

    int getUnclaimedRewardsCounter();

    boolean isElementsOfRewardsCatalogDisplayed();

    boolean isSadSmilePopUpShown();

    void waitUntilSadSmilePopUpShown();
}