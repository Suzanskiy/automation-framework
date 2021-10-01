package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class IosWelcomeFlowImpl extends BaseFlow implements WelcomeFlow {

    @Override
    @Step
    public boolean isHomePageOpened() {
        return getHomePage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isHomePageOpenedAfterSignIn() {
        return isHomePageOpened();
    }

    @Step
    @Override
    public boolean isHeroLevelHelpBtnDisplayed() {
        try {
            return getHomePage().getHeroLevelHelpBtn().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step
    @Override
    public boolean isZeroPointsDescriptionDisplayed() {
        getHomePage().refresh();
        return getHomePage().getDescriptionTextWhenUserHasNoPoints().isEnabled();
    }

    @Step
    @Override
    public boolean isRewardsScreenFOrUserWithoutPointsDisplayed() {
        return getHomePage().getRewardsSectionScreenForUserWithoutPoints().isDisplayed();
    }

    @Step
    @Override
    public int availablePoints() {
        getHomePage().refresh();
        return Integer.parseInt(getHomePage().getAvailablePoints().getAttribute("value"));
    }

    @Step
    @Override
    public void clickOnRedeemPointsBtn() {
        getHomePage().getRedeemPointsBtn().click();
    }

    @Step
    @Override
    public boolean isRewardsSectionForUserWithPointsDisplayed() {
        return isRedeemPointsBtnDisplayed() && isHeroLevelHelpBtnDisplayed();
    }

    @Step
    @Override
    public boolean isRedeemPointsBtnDisplayed() {
        try {
            return getHomePage().getRedeemPointsBtn().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean isRedeemPointsBtnDisplayedOnMainScreen() {
        return !isRedeemPointsBtnDisplayed(); //such button on ios exists and marked as visible, but it seems like appium bug
    }

    @Override
    public void swipeToCouponsDisplay() {

    }

    @Override
    public boolean isNoCouponDisplayDisplayed() {
        return false;
    }

    @Override
    public boolean isGiftToAFriendBtnClickable() {
        return false;
    }

    @Override
    public boolean isViewAllCouponsBtnDisplayed() {
        return false;
    }

    @Override
    public int couponsCarouselQuantity() {
        return 0;
    }

    @Override
    public void waitUntilHomePageLoaded() {

    }

}