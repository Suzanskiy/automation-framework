package com.racetrac.mobile.multisite.racetrac.flow;

public interface PointsAndLevelsFlow {
    void clickGotItBtn();

    void clickOnHeroLevelHelpBtn();

    void clickOnDetailsBtn();

    void clickOnCloseDetailsBtn();

    void clickOnHowItWorksSectionBtn();

    void clickOnCloseActivityBtn();

    boolean isPointsAndLevelsPageOpened();

    boolean isPointsAndTiersSectionIsOpened();

    boolean isHowItWorksSectionIsOpened();

    boolean isTierExpirationDetailsDisplayed();
}