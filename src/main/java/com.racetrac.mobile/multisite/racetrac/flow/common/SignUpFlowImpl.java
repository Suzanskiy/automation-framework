package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignUpFlow;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class SignUpFlowImpl extends BaseFlow implements SignUpFlow {

    @Override
    public void openSignUpPage() {
        getHomePage().getSignUpBtn().click();
    }

    @Override
    public boolean isSignUpPageOpened() {
        return getSignUpPage().isOpened();
    }

    @Override
    public boolean isEmailConfirmationPageOpened() {
        return getEmailConfirmationPage().isOpened();
    }

    @Override
    public void enterCredentials(final CustomerDto customerDto) {
        getSignUpPage().getEmailInput().setValue(customerDto.getEmail());
        getSignUpPage().getPasswordInput().setValue(customerDto.getPassword());
        getSignUpPage().getPhoneInput().setValue(customerDto.getPhoneNumber());
        getSignUpPage().getBirthDayInput().setValue(customerDto.getBirthDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        getSignUpPage().getCreateAccountBtn().click();
    }
}
