package com.racetrac.mobile.multisite.racetrac.flow.impl.ios;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.DeppLinksProvider;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static com.racetrac.mobile.util.device.AlertUtil.acceptAlert;

@Profile(IOS)
@Component
public class iosDeepLinksProviderImpl extends BaseFlow implements DeppLinksProvider {

    @Step
    @Override
    public void openDeepLink(String link) {
        acceptAlert();
        getDriver().get(link);
    }
}
