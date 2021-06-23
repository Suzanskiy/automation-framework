package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeUP;

@Component
public class SignOutFlowImpl extends BaseFlow implements SignOutFlow {
    @Step
    @Override
    public void doSignOut() {
        getHomePage().waitUntilIsOpened();
        getHomePage().getIconSettings().click();
        getAccountSettingsPage().waitUntilIsOpened();
        swipeUP();
        getAccountSettingsPage().getSignOutBtn().click();
    }
}
