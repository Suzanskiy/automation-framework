package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignInFlow;
import com.racetrac.mobile.multisite.racetrac.flow.helper.PopupCloserFlow;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

@Component
public class SignInFlowImpl extends BaseFlow implements SignInFlow {
    @Autowired
    PopupCloserFlow popupCloserFlow;

    @Step
    @Override
    public void openLoginInPage() {
        getHomePage().getLoginBtn().click();
        getLoginPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public boolean isLoginPageOpened() {
        return getLoginPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void authorize(final CustomerDto customerDto) {
        try {
            getLoginPage().waitUntilIsOpened();
            getLoginPage().getEmailInput().sendKeys(customerDto.getPersonalInfo().getEmail());
            getLoginPage().getPasswordInput().clear();
            getLoginPage().getPasswordInput().sendKeys(customerDto.getEmailAuth().getPassword());
            getLoginPage().getLoginBtn().click();
        }
        catch (NoSuchElementException noSuchElementException){
            LOG.info(Arrays.toString(noSuchElementException.getStackTrace()));
        }
        popupCloserFlow.closePopups();
    }

    @Step
    @Override
    public void clickGotItBtn() {
        try {
            getCouponsView().waitUntilIsOpened();
            getCouponsView().getGotItBtn().click();
        } catch (NoSuchElementException | TimeoutException e) {
            LOG.warn("Unable to click got it btn, because it's not shown");
        }
    }
}
