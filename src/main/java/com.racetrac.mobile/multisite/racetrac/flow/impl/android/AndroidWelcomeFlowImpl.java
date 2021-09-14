package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.List;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.*;

@Profile(ANDROID)
@Component
public class AndroidWelcomeFlowImpl extends BaseFlow implements WelcomeFlow {

    public static final Logger LOG = LoggerFactory.getLogger(AndroidWelcomeFlowImpl.class);

    @Override
    @Step
    public boolean isHomePageOpened() {
        try {
            getTurnOnLocationPage().waitUntilIsOpened();
            getTurnOnLocationPage().getNotNowBtn().click();
        } catch (TimeoutException | NoSuchElementException e) {
            LOG.warn("Cannot find Location page");
        }
        return getHomePage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isHomePageOpenedAfterSignIn() {
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

    @Step
    @Override
    public void swipeToCouponsDisplay() {
        swipeDownHard();
        swipeUP();
        getHomePage().waitUntilIsOpened();
        swipeDownHard();
        swipeUP();
    }

    @Step
    @Override
    public boolean isNoCouponDisplayDisplayed() {
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
        return getHomePage().getCouponsCarousel().size();
    }
}
