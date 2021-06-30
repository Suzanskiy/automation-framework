package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigateFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ProfileFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

@Profile(IOS)
@Component
public class iosProfileFlowImpl extends BaseFlow implements ProfileFlow, NavigateFlow {

    @Override
    public void navigateBack() {
        getProfilePage().getButtonBack().click();
    }

    @Step
    @Override
    public void navigateToPasswordChange() {
        getProfilePage().getEditPasswordBtn().click();
    }

    @Step
    @Override
    public boolean isPasswordChangeScreenOpened() {
        return getEditPasswordPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void navigateToEmailChange() {
        getProfilePage().getEditEmailBtn().click();
    }

    @Step
    @Override
    public boolean isEmailChangeScreenOpened() {
        return getEditEmailPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickOnBirthDayField() {
        getProfilePage().getBirthDay().click();
    }

    @Step
    @Override
    public void enterBirthDate(final String customerBirth) {
        getProfilePage().getBirthDay().setValue(customerBirth);
        pressBackBtn();
        getProfilePage().getButtonSave().click();
    }
}