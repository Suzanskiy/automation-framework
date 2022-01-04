package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import com.racetrac.mobile.util.appium.SwipeScroll;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;
import static com.racetrac.mobile.util.appium.SwipeScroll.swipeToElement;

@Profile(ANDROID)
@Component
public class AndroidAccountSettingsFlowImpl extends BaseFlow implements AccountSettingsFlow {

    @Step
    @Override
    public boolean isAccountSettingsScreenOpened() {
        return getAccountSettingsPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isAccountSettingsAuthorisedUserScreenOpened() {
        try {
            AppiumWaitingUtils.waitUntilElementClickable(getAccountSettingsPageAuthorised().getProfile());
        } catch (StaleElementReferenceException e) {
            LOG.warn("Cannot find some element of the Account settings page");
        }
        return getAccountSettingsPageAuthorised().waitUntilIsOpened();
    }

    @Override
    public boolean isProfileScreenOpened() {
        try {
            AppiumWaitingUtils.waitUntilElementClickable(getProfilePage().getEditEmailBtn());
        } catch (StaleElementReferenceException e) {
            LOG.warn("Cannot find element of the profile page");
        }
        ;
        return getProfilePage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void navigateToAccountSettings() {
        getHomePage().getIconSettings().click();
    }

    @Override
    public void closeAccountSettingsScreen() {
        getAccountSettingsPage().getNavBarCloseBtn().click();
    }

    @Override
    public void navigateToProfile() {
        getAccountSettingsPageAuthorised().getProfile().click();
    }

    @Override
    public void navigateToPromotionalSettings() {
        getAccountSettingsPageAuthorised().getPromotionalSettings().click();
    }

    @Step
    @Override
    public boolean isReceiveEmailsDisplayed() {
        try {
            return getAccountSettingsPageAuthorised().getReceiveEmailsSwitchBtn().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public boolean receiveEmailsSwitcherPosition() {
        return Boolean.parseBoolean(getAccountSettingsPageAuthorised().
                getReceiveEmailsSwitchBtn().getAttribute("checked"));
    }

    @Override
    public void waitUntilAccountSettingsAuthorizedOpen() {
        AppiumWaitingUtils.waitUntilElementClickable(getAccountSettingsPageAuthorised().getProfile());
    }

    @Override
    public void navigateToHelpSection() {
        boolean elementIsDisplayed = false;
        try {
            elementIsDisplayed = getAccountSettingsPage().getHelpCategory().isDisplayed();
        } catch (NoSuchElementException e) {
            elementIsDisplayed = false;
        }
        if (!elementIsDisplayed) {
            swipeToElement(SwipeScroll.Direction.UP, getAccountSettingsPage().getHelpCategory());
        }
        getAccountSettingsPage().getHelpCategory().click();
    }

    @Override
    public String getLifeTimePointsAmount() {
        return getAccountSettingsPageAuthorised().getLifetimePointsValue().getText();
    }

    @Override
    public void navigateBack() {
        pressBackBtn();
    }
}
