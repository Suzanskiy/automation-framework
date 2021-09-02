package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

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

    @Override
    public boolean isHomePageOpenedAfterSignIn() {
        return getHomePage().waitUntilIsOpened();
    }

    @Override
    public boolean isHeroLevelHelpBtnDisplayed() {
        try {
            return getHomePage().getHeroLevelHelpBtn().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean isZeroPointsDescriptionDisplayed() {
        return getHomePage().getDescriptionTextWhenUserHasNoPoints().isDisplayed();
    }

    @Override
    public boolean isRewardsScreenFOrUserWithoutPointsDisplayed() {
        return getHomePage().getRewardsSectionScreenForUserWithoutPoints().isDisplayed();
    }

    @Override
    public int availablePoints() {
        return Integer.parseInt(getHomePage().getAvailablePoints().getAttribute("text"));
    }

    @Override
    public boolean isRedeemPointsBtnDisplayed() {
        return getHomePage().getRedeemPointsBtn().isDisplayed();
    }

    @Override
    public void clickOnRedeemPointsBtn() {
        getHomePage().getRedeemPointsBtn().click();
    }

    @Override
    public boolean isRewardsSectionForUserWithPointsDisplayed() {
        return isRedeemPointsBtnDisplayed() && isHeroLevelHelpBtnDisplayed();
    }

    @Step
    @Override
    public boolean isRedeemPointsIsDisplayed() {
        try {
            return getHomePage().getRedeemPointsBtn().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step
    @Override
    public void clickRedeemPointsBtn() {
        getHomePage().getRedeemPointsBtn().click();
    }
}
