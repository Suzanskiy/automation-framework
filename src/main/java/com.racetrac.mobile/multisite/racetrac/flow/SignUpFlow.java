package com.racetrac.mobile.multisite.racetrac.flow;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;

public interface SignUpFlow {
    void openSignUpSelectorPage();

    void enterCredentials(CustomerDto var1);

    void enterCredentialsWithoutEmailReceive(CustomerDto var1);

    void clickOnReceiveEmailBtn();

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

    void waitUntilFraudErrorMessageShown();

    void waitUntilErrorMessageShown();

    void selectSignUpWithFacebook();

    boolean isJoinRacetracRewardScreenOpened();

    void fillJoinRacetracRewardsScreen(CustomerDto customerDto);
}