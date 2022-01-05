package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ContactUsFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosContactUsFLowImp extends BaseFlow implements ContactUsFlow {
    @Step
    @Override
    public boolean isContactUsPageOpened() {
        return getContactUsPage().waitUntilIsOpened();
    }
    @Step
    @Override
    public boolean isTollFreeCallAvailable() {
        return Boolean.parseBoolean(getContactUsPage().getTollFreeCall().getAttribute("clickable"));
    }

    @Step
    @Override
    public void sendMessageToGeneralSubject(String message) {
        getContactUsPage().getSubjectsDropDown().click();
        getContactUsPage().getGeneralDropDownSubject().click();
        getContactUsPage().getMessageField().click();
        getContactUsPage().getMessageField().sendKeys(message);  //no less than 10 symbols to get SEND button available
        getContactUsPage().getSendMessageBtn().click();
    }


}
