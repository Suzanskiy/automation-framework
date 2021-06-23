package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ProfileFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class ProfileFlowImpl extends BaseFlow implements ProfileFlow {

    @Step
    @Override
    public void navigateToPasswordChange() {
        getProfilePage().getPasswordBtn().click();
    }

    @Override
    public boolean isPasswordChangeScreenOpened() {
        return getEditPasswordPage().waitUntilIsOpened();
    }
}
