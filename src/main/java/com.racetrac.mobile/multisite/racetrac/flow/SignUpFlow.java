package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface SignUpFlow {
    void openSignUpSelectorPage();

    void enterCredentials(CustomerDto customerDto);

    void clickCreateAccountBtn();

    void selectSignUpWithEmail();

    void closeErrorMessage();

    void enterSpecificCredentials(String fraudMail, CustomerDto customerDto);

    void clickGetStartedBtn();

    boolean isSignUpSelectorPageOpened();

    boolean isSignUpPageOpened();

    boolean isFistBumpPageOpened();

    boolean isFraudErrorMessageShown();

    boolean isErrorMessageShown();

    String getErrorMessageText();

}