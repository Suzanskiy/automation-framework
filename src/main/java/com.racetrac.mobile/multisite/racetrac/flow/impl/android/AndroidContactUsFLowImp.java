package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.ContactUsFlow;
import com.racetrac.mobile.util.appium.AppiumWaitingUtils;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidContactUsFLowImp extends BaseFlow implements ContactUsFlow {
    @Step
    @Override
    public boolean isContactUsPageOpened() {
        AppiumWaitingUtils.waitUntilElementClickable(getContactUsPage().getCloseContactUsPageBtn());
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
        AppiumWaitingUtils.waitUntilElementClickable(getContactUsPage().getGeneralDropDownSubject());
        getContactUsPage().getGeneralDropDownSubject().click();
        getContactUsPage().getMessageField().click();
        getContactUsPage().getMessageField().setValue(message);  //no less than 10 symbols to get SEND button available
        getContactUsPage().getSendMessageBtn().click();
    }


}
