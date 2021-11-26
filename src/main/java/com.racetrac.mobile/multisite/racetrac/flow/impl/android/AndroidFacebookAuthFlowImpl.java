package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FacebookAuthFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;

@Profile(ANDROID)
@Component
public class AndroidFacebookAuthFlowImpl extends BaseFlow implements FacebookAuthFlow {

    @Override
    public void authorise(final CustomerDto customerDto) {
        getFacebookLoginPage().waitUntilIsOpened();
        getFacebookLoginPage().getEmailInput().sendKeys(customerDto.getPersonalInfo().getEmail());
        getFacebookLoginPage().getPassInput().sendKeys(customerDto.getEmailAuth().getPassword());
        getFacebookLoginPage().getLoginBtn().click();
        getFacebookLoginStep2Page().waitUntilIsOpened();
        getFacebookLoginStep2Page().getContinueBtn().click();
    }
}
