package com.racetrac.mobile.multisite.racetrac.flow.common;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.flow.DeppLinksProvider;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;

@Component
public class DeepLinksProviderImpl extends BaseFlow implements DeppLinksProvider {

    @Step
    @Override
    public void openDeepLink(String link) {
        getDriver().get(link);
    }
}
