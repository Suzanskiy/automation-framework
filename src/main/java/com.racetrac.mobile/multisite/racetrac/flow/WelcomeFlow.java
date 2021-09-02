package com.racetrac.mobile.multisite.racetrac.flow;

public interface WelcomeFlow {
    boolean isHomePageOpened();

    boolean isHomePageOpenedAfterSignIn();

    boolean isHeroLevelHelpBtnDisplayed();

    boolean isZeroPointsDescriptionDisplayed();

    boolean isRewardsScreenFOrUserWithoutPointsDisplayed();

    int availablePoints();

    boolean isRedeemPointsBtnDisplayed();

    void clickOnRedeemPointsBtn();

    boolean isRewardsSectionForUserWithPointsDisplayed();
    boolean isRedeemPointsIsDisplayed();

    void clickRedeemPointsBtn();
}