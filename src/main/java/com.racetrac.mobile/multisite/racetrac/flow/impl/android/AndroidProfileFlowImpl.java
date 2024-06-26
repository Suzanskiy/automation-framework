package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.NavigateFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ProfileFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

@Profile(ANDROID)
@Component
public class AndroidProfileFlowImpl extends BaseFlow implements ProfileFlow, NavigateFlow {

    @Override
    public void navigateBack() {
        pressBackBtn();
    }

    @Override
    public boolean isProfilePageOpened() {
        AppiumWaitingUtils.waitUntilElementClickable(getProfilePage().getEditEmailBtn());
        return getProfilePage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void navigateToPasswordChange() {
        getProfilePage().getEditPasswordBtn().click();
    }

    @Step
    @Override
    public boolean isPasswordChangeScreenOpened() {
        return getEditPasswordPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void navigateToEmailChange() {
        getProfilePage().getEditEmailBtn().click();
    }

    @Step
    @Override
    public boolean isEmailChangeScreenOpened() {
        return getEditEmailPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickOnBirthDayField() {
        try {
            getProfilePage().getBirthDay().click();
        } catch (StaleElementReferenceException e) {
            LOG.warn("Birthday field is not shown");
        }
    }

    @Override
    public boolean isBirthdayFieldEditable() {
        final String attribute = getProfilePage().getBirthDay().getAttribute("enabled");
        if (attribute.equals("false")) {
            return false;
        }
        return true;
    }

    @Override
    public void enterBirthDate(final String customerBirth) {
        getProfilePage().getBirthDay().sendKeys(customerBirth);
        pressBackBtn();
        getProfilePage().getButtonSave().click();
    }

    @Override
    public void waitUntilProfilePageOpened() {
        try {
            AppiumWaitingUtils.waitUntilElementClickable(getProfilePage().getEditEmailBtn());
        } catch (StaleElementReferenceException e) {
            LOG.warn("edit_email_button is not clickable");
        }
    }
}