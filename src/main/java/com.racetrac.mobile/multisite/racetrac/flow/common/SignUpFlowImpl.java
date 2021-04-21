package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class SignUpFlowImpl extends BaseFlow implements SignUpFlow {
    @Step
    @Override
    public void openSignUpPage() {
        getHomePage().getSignUpBtn().click();
    }

    @Step
    @Override
    public boolean isSignUpPageOpened() {
        return getSignUpPage().isOpened();
    }

    @Step
    @Override
    public boolean isEmailConfirmationPageOpened() {
        return getEmailConfirmationPage().isOpened();
    }

    @Step(value = "Prepare user and enter credentials")
    @Override
    public void enterCredentials(final CustomerDto customerDto) {
        getSignUpPage().getEmailInput().setValue(customerDto.getEmail());
        getSignUpPage().getPasswordInput().setValue(customerDto.getPassword());
        getSignUpPage().getPhoneInput().setValue(customerDto.getPhoneNumber());
        getSignUpPage().getBirthDayInput().setValue(customerDto.getBirthDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        getSignUpPage().getCreateAccountBtn().click();
    }

    @Step
    @Override
    public void returnBackToSignUp() {
        getEmailConfirmationPage().getRetryEmailBtn().click();
    }

    @Step
    @Override
    public void clickCreateAccountBtn() {
        getSignUpPage().getCreateAccountBtn().click();
    }

    @Step
    @Override
    public boolean isErrorMessageShown() {
        return getErrorMessageVIew().isOpened();
    }

    @Step
    @Override
    public void closeErrorMessage() {
        getErrorMessageVIew().getOkButton().click();
    }

    @Step
    @Override
    public String getErrorMessageText() {
        return getErrorMessageVIew().getErrorMessage().getText();
    }
}
