package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeUP;
import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntilElementClickable;

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

    @Step
    @Override
    public boolean isRedeemPointsBtnDisplayedOnMainScreen() {
        return !isRedeemPointsBtnDisplayed(); //such button on ios exists and marked as visible, but it seems like appium bug
    }

    @Step
    @Override
    public void swipeToCouponsSection() {
        swipeUP();
        swipeUP();
    }

    @Step
    @Override
    public boolean isNoCouponsSectionDisplayed() {
        return getHomePage().getNoCouponsDisplay().isEnabled();
    }

    @Step
    @Override
    public boolean isGiftToAFriendBtnClickable() {
        try {
            Boolean.parseBoolean(getHomePage().getGiftToAFriendBtn().getAttribute("enabled"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Step
    @Override
    public boolean isViewAllCouponsBtnDisplayed() {
        getHomePage().refresh();
        try {
            return getHomePage().getViewAllCouponsBtn().isEnabled();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step
    @Override
    public int couponsCarouselQuantity() {
        return getHomePage().getCouponsCarousel().size();
    }

    @Override
    public void waitUntilHomePageLoaded() {
        waitUntilElementClickable(getHomePage().getIconSettings());
    }

    @Step
    @Override
    public boolean isFuelSavingsBtnDisplayed(){
        return false;
    }

    @Step
    @Override
    public void clickFuelSavingsBtn(){}

    @Step
    @Override
    public void openVipSection(){}
}