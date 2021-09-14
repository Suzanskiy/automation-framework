package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.UserNotFoundForGiftPopUpFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidUserNotFoundForGiftPopUpFlowImpl extends BaseFlow implements UserNotFoundForGiftPopUpFlow {

    @Step
    @Override
    public boolean isUserNotFoundForGiftPopUpPageOpened() {
        return getUserNotFoundForGiftPopUpPage().waitUntilIsOpened();
    }

    @Step
    @Override
    public void clickOnUserNotFoundPopUpOkBtn() {
        getUserNotFoundForGiftPopUpPage().getOkBtn().click();
    }
}
