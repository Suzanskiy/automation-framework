package com.racetrac.mobile.multisite.racetrac.flow;

public interface ProfileFlow extends NavigateFlow {
    boolean isProfilePageOpened();

    void navigateToPasswordChange();

    boolean isPasswordChangeScreenOpened();

    void navigateToEmailChange();

    boolean isEmailChangeScreenOpened();

    void clickOnBirthDayField();

    boolean isBirthdayFieldEditable();

    void enterBirthDate(String customerBirth);

    void waitUntilProfilePageOpened();
}