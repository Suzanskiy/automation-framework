package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ForgotPassFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class ForgotPassImpl extends BaseFlow implements ForgotPassFlow {
    @Step
    @Override
    public void clickForgotPassBtn() {
        getLoginPage().getForgotPassBtn().click();
    }

    @Step
    @Override
    public void enterEmail(final String email) {
        getForgotPassPage().getEmailInput().clear();
        getForgotPassPage().getEmailInput().setValue(email);
    }

    @Step
    @Override
    public void clickResetPassBtn() {
        getForgotPassPage().getResetPassBtn().click();
    }

    @Step
    @Override
    public boolean isForgotPassPageOpened() {
        return getForgotPassPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isResetPasswordBtnDisabled() {
        return !getForgotPassPage().getResetPassBtn().isEnabled();
    }

    @Override
    public boolean isCompleteMessageShown() {
        getForgotPassPage().waitUntilIsOpened();
        return getForgotPassPage().getCompleteMsg().isDisplayed();
    }

    @Step
    @Override
    public String getForgotPasswordCompleteTxt() {
        return getForgotPassPage().getCompleteMsg().getText();
    }

    @Step
    @Override
    public void clickDoneBtn() {
        getForgotPassPage().getDoneBtn().click();
    }
}
