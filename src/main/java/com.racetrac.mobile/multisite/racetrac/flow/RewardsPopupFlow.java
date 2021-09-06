package com.racetrac.mobile.multisite.racetrac.flow;

public interface RewardsPopupFlow {

    boolean isRewardPopupPageOpened();

    void clickGotItBtn();

    boolean isGotItBtnDisplayed();

    boolean isRedeemPopUpBtnDisplayed();

    boolean isTutorialArrowDisplayed();

    boolean isRewardsPopUpTutorialMessageDisplayed();

    boolean isRedeemPopUpHintDisplayed();

    void waitUntilMessageAvailable();

}