package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.AccountSettingsFlow;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class AccountSettingsFlowImpl extends BaseFlow implements AccountSettingsFlow {
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

    @Step
    @Override
    public void navigateToAccountSettings() {
        getHomePage().getIconSettings().click();
    }

    @Override
    public void closeAccountSettingsScreen() {
        getAccountSettingsPage().getNavBarCloseBtn().click();
    }
}
