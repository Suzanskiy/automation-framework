package com.racetrac.mobile.multisite.racetrac.flow;

public interface ProfileFlow extends NavigateFlow {
    void navigateToPasswordChange();

    boolean isPasswordChangeScreenOpened();

    void navigateToEmailChange();

    boolean isEmailChangeScreenOpened();

    void clickOnBirthDayField();

    void enterBirthDate(String customerBirth);
}