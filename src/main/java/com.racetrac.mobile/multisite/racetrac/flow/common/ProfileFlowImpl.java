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

    @Step
    @Override
    public boolean isPasswordChangeScreenOpened() {
        return getEditPasswordPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void navigateToEmailChange() {
        getProfilePage().getEmailBtn().click();
    }

    @Step
    @Override
    public boolean isEmailChangeScreenOpened() {
        return getEditEmailPage().waitUntilIsOpened();
    }
}
