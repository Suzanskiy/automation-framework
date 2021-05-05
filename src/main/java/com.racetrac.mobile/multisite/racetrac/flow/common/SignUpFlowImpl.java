package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class SignUpFlowImpl extends BaseFlow implements SignUpFlow {
    private static final String BACKEND_DATE_PATTERN = "yyyy-MM-dd";
    public static final String MOBILE_DATE_PATTERN = "MM/dd/yyyy";

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
        getSignUpPage().getEmailInput().setValue(customerDto.getPersonalInfo().getEmail());
        enterPassword(customerDto);
        enterPhone(customerDto);
        enterBirthDay(customerDto);
        getSignUpPage().getCreateAccountBtn().click();
    }

    @Step
    private void enterBirthDay(final CustomerDto customerDto) {
        getSignUpPage().getBirthDayInput().setValue(LocalDate.parse(customerDto
                .getPersonalInfo().getBirthday(), DateTimeFormatter.ofPattern(BACKEND_DATE_PATTERN)
        ).format(DateTimeFormatter.ofPattern(MOBILE_DATE_PATTERN)));
    }

    @Step
    private void enterPhone(final CustomerDto customerDto) {
        getSignUpPage().getPhoneInput().setValue(customerDto.getPersonalInfo().getPhone());
    }

    @Step
    private void enterPassword(final CustomerDto customerDto) {
        getSignUpPage().getPasswordInput().clear();
        getSignUpPage().getPasswordInput().setValue(customerDto.getEmailAuth().getPassword());
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

    @Step
    @Override
    public void enterSpecificCredentials(final String fraudMail, final CustomerDto customerDto) {
        getSignUpPage().getEmailInput().setValue(fraudMail);
        enterPassword(customerDto);
        enterPhone(customerDto);
        enterBirthDay(customerDto);
        getSignUpPage().getCreateAccountBtn().click();
    }

    @Step
    @Override
    public boolean isFraudErrorMessageShown() {
        return getFraudErrorMessageView().isOpened();
    }
}
