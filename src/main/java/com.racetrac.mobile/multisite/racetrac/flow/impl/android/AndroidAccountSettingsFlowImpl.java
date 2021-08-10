package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

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
    public void navigateBack() {
        pressBackBtn();
    }
}