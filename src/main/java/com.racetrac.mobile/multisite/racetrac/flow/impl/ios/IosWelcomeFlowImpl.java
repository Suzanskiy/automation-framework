package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.WelcomeFlow;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;

@Profile(IOS)
@Component
public class IosWelcomeFlowImpl extends BaseFlow implements WelcomeFlow {

    @Override
    @Step
    public boolean isHomePageOpened() {
        return getHomePage().waitUntilIsOpened();
    }

    @Override
    public boolean isHomePageOpenedAfterSignIn() {
        return isHomePageOpened();
    }
}