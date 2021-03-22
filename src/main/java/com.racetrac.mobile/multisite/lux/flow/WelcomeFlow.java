package com.racetrac.mobile.multisite.lux.flow;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.util.appium.AppiumWaitingUtils.waitUntil;


@Component
public class WelcomeFlow extends BaseFlow {


    @Step
    public boolean isSkipButtonDisplayedAndEnabled() {
        return getWelcomePage().getSkipBtn().isDisplayed()
                & getWelcomePage().getSkipBtn().isEnabled();
    }


    @Step
    public void clickSkipForNow() {
        waitUntil(ExpectedConditions.elementToBeClickable(getWelcomePage().getSkipBtn()));
        getWelcomePage().getSkipBtn().click();
    }

    @Step
    public void clickContinueBtn() {
        getWelcomePage().getContinueBtn().click();
    }

    @Step
    public void setEmail(String email) {
        getWelcomePage().getEmailInput().setValue(email);
    }
}