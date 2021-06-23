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
    public void openSignUpSelectorPage() {
        getHomePage().getSignUpBtn().click();
    }

    @Step
    @Override
    public boolean isSignUpPageOpened() {
        return getSignUpPage().isOpened();
    }

    @Step
    @Override
    public boolean isFistBumpPageOpened() {
        return getFistBumpPage().isOpened();
    }

    @Step(value = "Prepare user and enter credentials")
    @Override
    public void enterCredentials(final CustomerDto customerDto) {
        enterEmail(customerDto.getPersonalInfo().getEmail());
        enterPassword(customerDto.getEmailAuth().getPassword());
        enterPhone(customerDto.getPersonalInfo().getPhone());
        enterBirthDay(customerDto.getPersonalInfo().getBirthday());
        chooseNoRewardCard();
        getSignUpPage().getCreateAccountBtn().click();
    }

    @Step
    private void chooseNoRewardCard() {
        try {
            getSignUpPage().getNoCardButton().click();
        }catch (Exception e)
        {
            LOG.warn("Not Implemented on IOS");
            // FIXME: 14.06.2021 Remove try block when ios will be ready
        }
    }

    @Step
    private void enterEmail(final String email) {
        getSignUpPage().getEmailInput().clear();
        getSignUpPage().getEmailInput().setValue(email);
    }


    @Step
    private void enterBirthDay(final String birthday) {
        getSignUpPage().getBirthDayInput().setValue(LocalDate.parse(birthday, DateTimeFormatter.ofPattern(BACKEND_DATE_PATTERN)
        ).format(DateTimeFormatter.ofPattern(MOBILE_DATE_PATTERN)));
    }

    @Step
    private void enterPhone(String phone) {
        getSignUpPage().getPhoneInput().clear();
        getSignUpPage().getPhoneInput().setValue(phone);
    }

    @Step
    private void enterPassword(final String password) {
        getSignUpPage().getPasswordInput().clear();
        getSignUpPage().getPasswordInput().setValue(password);
    }


    @Step
    @Override
    public void clickCreateAccountBtn() {
        getSignUpPage().getCreateAccountBtn().click();
    }

    @Override
    public void selectSignUpWithEmail() {
        getSignUpSelectorPage().getSignUpWithEmailBtn().click();
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
        String pass = customerDto.getEmailAuth().getPassword();
        String phone = customerDto.getPersonalInfo().getPhone();
        String birth = customerDto.getPersonalInfo().getBirthday();

        enterEmail(fraudMail);
        enterPassword(pass);
        enterPhone(phone);
        enterBirthDay(birth);
        chooseNoRewardCard();
        getSignUpPage().getCreateAccountBtn().click();
    }

    @Step
    @Override
    public boolean isFraudErrorMessageShown() {
        return getFraudErrorMessageView().isOpened();
    }

    @Override
    public void clickGetStartedBtn() {
        getFistBumpPage().getGetStartedBtn().click();
    }

    @Step
    @Override
    public boolean isSignUpSelectorPageOpened() {
        return getSignUpSelectorPage().isOpened();
    }
}
