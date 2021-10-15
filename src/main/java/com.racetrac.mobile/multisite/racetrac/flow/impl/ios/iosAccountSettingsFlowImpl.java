package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Component
@Profile(IOS)
public class iosAccountSettingsFlowImpl extends BaseFlow implements AccountSettingsFlow {
    @Step
    @Override
    public boolean isAccountSettingsScreenOpened() {
        return getAccountSettingsPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isAccountSettingsAuthorisedUserScreenOpened() {
        return getAccountSettingsPageAuthorised().waitUntilIsOpened();
    }

    @Override
    public boolean isProfileScreenOpened() {
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
        final String value = getAccountSettingsPageAuthorised().
                getReceiveEmailsSwitchBtn().getAttribute("value");
        return !value.contains("0"); // 0 - turned off, 1 - turned on
    }

    @Override
    public void waitUntilAccountSettingsAuthorizedOpen() {

    }

    @Override
    public void navigateToHelpSection() {

    }

    @Override
    public void navigateBack() {
        try {
            getAccountSettingsPage().getNavBarCloseBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Can't navigate back");
        }
    }
}
