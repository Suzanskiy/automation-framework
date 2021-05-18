package com.racetrac.mobile.multisite.racetrac.flow;

public interface ForgotPassFlow {
    void clickForgotPassBtn();

    void enterEmail(String email);

    void clickResetPassBtn();

    void clickDoneBtn();

    String getForgotPasswordCompleteTxt();

    boolean isForgotPassPageOpened();

    boolean isResetPasswordBtnDisabled();
}