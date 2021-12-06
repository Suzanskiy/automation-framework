package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.util.appium.SwipeScroll;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilElementClickable;
import static com.racetrac.mobile.util.appium.SwipeScroll.swipeUntilElementIsPresent;

@Profile(ANDROID)
@Component
public class AndroidWelcomeFlowImpl extends BaseFlow implements WelcomeFlow {

    public static final Logger LOG = LoggerFactory.getLogger(AndroidWelcomeFlowImpl.class);

    @Override
    @Step
    public boolean isHomePageOpened() {
        try {
            getTurnOnLocationPage().waitUntilIsOpened();
            getTurnOnLocationPage().getContinueBtn().click();
            waitUntilHomePageLoaded();
        } catch (TimeoutException | NoSuchElementException e) {
            LOG.warn("Cannot find Location page");
        }
        return getHomePage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isHomePageOpenedAfterSignIn() {
        waitUntilHomePageLoaded();
        return getHomePage().waitUntilIsOpened();
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
        return getHomePage().getDescriptionTextWhenUserHasNoPoints().isDisplayed();
    }

    @Step
    @Override
    public boolean isRewardsScreenFOrUserWithoutPointsDisplayed() {
        return getHomePage().getRewardsSectionScreenForUserWithoutPoints().isDisplayed();
    }

    @Step
    @Override
    public int availablePoints() {
        return Integer.parseInt(getHomePage().getAvailablePoints().getAttribute("text"));
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

    @Step
    @Override
    public boolean isRedeemPointsBtnDisplayedOnMainScreen() {
        return isRedeemPointsBtnDisplayed();
    }

    @Override
    public void swipeToCouponsSection() {
        swipeUntilElementIsPresent(SwipeScroll.Direction.DOWN, getHomePage().getPayWIthGiftCArdBtn()); //common element for options with and without coupons
    }

    @Step
    @Override
    public boolean isNoCouponsSectionDisplayed() {
        return getHomePage().getNoCouponsDisplay().isDisplayed();
    }

    @Step
    @Override
    public boolean isGiftToAFriendBtnClickable() {
        return Boolean.parseBoolean(getHomePage().getGiftToAFriendBtn().getAttribute("enabled"));
    }

    @Step
    @Override
    public boolean isViewAllCouponsBtnDisplayed() {
        try {
            return getHomePage().getViewAllCouponsBtn().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step
    @Override
    public int couponsCarouselQuantity() {
        swipeToCouponsSection();
        return getHomePage().getCouponsCarousel().size();
    }

    @Override
    public void waitUntilHomePageLoaded() {
        waitUntilElementClickable(getHomePage().getIconSettings());
    }

    @Override
    public boolean isFuelSavingsBtnDisplayed() {
        try {
            return getHomePage().getFuelSavingsBtn().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public void clickFuelSavingsBtn() {
        getHomePage().getFuelSavingsBtn().click();
    }

    @Override
    public void openVipSection() {
        getHomePage().getVipSection().click();
    }

}
