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

    boolean isRedeemPointsBtnDisplayedOnMainScreen();

    void swipeToCouponsSection();

    boolean isNoCouponsSectionDisplayed();

    boolean isGiftToAFriendBtnClickable();

    boolean isViewAllCouponsBtnDisplayed();

    int couponsCarouselQuantity();

    void waitUntilHomePageLoaded();

    boolean isFuelSavingsBtnDisplayed();

    void clickFuelSavingsBtn();

    void openVipSection();
}