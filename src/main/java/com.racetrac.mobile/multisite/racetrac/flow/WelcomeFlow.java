package com.racetrac.mobile.multisite.racetrac.flow;

public interface WelcomeFlow {
    boolean isHomePageOpened();

    boolean isHomePageOpenedAfterSignIn();

    boolean isHeroLevelHelpBtnDisplayed();

    boolean isZeroPointsDescriptionDisplayed();

    boolean isRewardsScreenFOrUserWithoutPointsDisplayed();

    int availablePoints();

    void clickOnRedeemPointsBtn();

    boolean isRewardsSectionForUserWithPointsDisplayed();

    boolean isRedeemPointsBtnDisplayed();

}