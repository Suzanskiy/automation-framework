package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.EditEmailFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.pressBackBtn;

@Component
@Profile(ANDROID)
public class AndroidEditEmailFlowImpl extends BaseFlow implements EditEmailFlow {
    @Override
    public CustomerDto editEmail(final CustomerDto customerDto, final String email) {
        getEditEmailPage().getNewEmailField().sendKeys(email);
        getEditEmailPage().getChangeEmailBtn().click();
        customerDto.getPersonalInfo().setEmail(email);
        return customerDto;
    }

    @Override
    public boolean IsUpdatedEmailPageDisplayed() {
        return getUpdatedEmailPage().waitUntilIsOpened();
    }

    @Override
    public void navigateBack() {
        pressBackBtn();
    }
}
