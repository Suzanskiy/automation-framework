package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.dto.CustomerDto;
import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.FacebookAuthFlow;
import com.racetrac.mobile.util.device.AlertUtil;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class iosFacebookAuthFlowImpl extends BaseFlow implements FacebookAuthFlow {

    @Override
    public void authorise(final CustomerDto customerDto) {
        AlertUtil.acceptAlert();
        getFacebookLoginPage().waitUntilIsOpened();
        getFacebookLoginPage().getEmailInput().clear();
        getFacebookLoginPage().getEmailInput().sendKeys(customerDto.getPersonalInfo().getEmail());
        getFacebookLoginPage().getPassInput().sendKeys(customerDto.getEmailAuth().getPassword());
        getFacebookLoginPage().getLoginBtn().click();
        getFacebookLoginStep2Page().waitUntilIsOpened();
        getFacebookLoginStep2Page().getContinueBtn().click();
    }
}
