package com.racetrac.mobile.multisite.racetrac.flow;

public interface RewardsCatalogFlow extends NavigateFlow {

    void clickRedeemBtn();

    void clickRedeemPopupBtn();

    boolean isUnclaimedRewardsIsDisplayed();

    boolean isNumberOfPointsEnough();

}