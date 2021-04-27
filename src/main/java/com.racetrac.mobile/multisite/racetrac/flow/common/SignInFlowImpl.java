package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class SignInFlowImpl extends BaseFlow implements SignInFlow {

    @Step
    @Override
    public void openLoginInPage() {
        getHomePage().getLoginBtn().click();
    }

    @Override
    public boolean isLoginPageOpened() {
        return getLoginPage().isOpened();
    }

    @Override
    public void authorize(final CustomerDto customerDto) {
        getLoginPage().getEmailInput().setValue(customerDto.getPersonalInfo().getEmail());
        getLoginPage().getPasswordInput().clear();
        getLoginPage().getPasswordInput().setValue(customerDto.getEmailAuth().getPassword());
        getLoginPage().getLoginBtn().click();
    }
}
