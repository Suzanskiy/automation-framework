package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface SignUpFlow {
    void openSignUpPage();

    boolean isSignUpPageOpened();

    boolean isEmailConfirmationPageOpened();

    void enterCredentials(CustomerDto customerDto);

    void returnBackToSignUp();

    void clickCreateAccountBtn();

    boolean isErrorMessageShown();

    void closeErrorMessage();

    String getErrorMessageText();

    void enterSpecificCredentials(String fraudMail, CustomerDto customerDto);

    boolean isFraudErrorMessageShown();
}