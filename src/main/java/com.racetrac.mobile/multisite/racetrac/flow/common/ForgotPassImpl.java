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

    @Override
    public boolean isForgotPassPageOpened() {
        return getForgotPassPage().isOpened();
    }

    @Override
    public boolean isResetPasswordBtnDisabled() {
        return !getForgotPassPage().getResetPassBtn().isEnabled();
    }

    @Override
    public String getForgotPasswordCompleteTxt() {
        return getForgotPassPage().getCompleteMsg().getText();
    }

    @Override
    public void clickDoneBtn() {
        getForgotPassPage().getDoneBtn().click();
    }
}
