package com.racetrac.mobile.multisite.racetrac.flow.impl.android;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.DeppLinksProvider;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.ANDROID;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@Profile(ANDROID)
@Component
public class AndroidDeepLinksProviderImpl extends BaseFlow implements DeppLinksProvider {

    @Step
    @Override
    public void openDeepLink(String link) {
        getDriver().closeApp();
        getDriver().get(link);
    }
}
