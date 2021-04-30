package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.SignOutFlow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeUP;

@Component
public class SignOutFlowImpl extends BaseFlow implements SignOutFlow {

    @Override
    public void doSignOut() {
        getHomePage().getIconSettings().click();
        getAccountPage().waitUntilIsOpened();
        swipeUP();
        getAccountPage().getSignOutBtn().click();
    }
}
