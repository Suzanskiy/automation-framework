package com.racetrac.mobile.multisite.racetrac.util.impl;

import com.racetrac.mobile.multisite.racetrac.flow.BaseFlow;
import com.racetrac.mobile.multisite.racetrac.util.ChromeBrowserHandler;
import io.qameta.allure.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.racetrac.mobile.framework.constants.PlatformsConstants.IOS;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.getDriver;
import static com.racetrac.mobile.util.appium.AppiumDriverUtils.swipeDown;

@Profile(IOS)
@Component
public class iOSBrowserHandler extends BaseFlow implements ChromeBrowserHandler {

    public static final String FUEL_VIP_REDIRECT_DESIRED_URL_NO_SUBSCRIPTION = "https://punwebappqa.azurewebsites.net/Rewards/RaceTrac-Rewards-Vip?utm_source=app&utm_campaign=vip&utm_medium=VIPtab";
    private static final String IOS_FUEL_VIP_REDIRECT_DESIRED_URL_ACTIVE_SUBSCRIPTION = "https://punwebappqa.azurewebsites.net/Rewards/Account/VipMembership?utm_source=app&utm_campaign=vip";
    public static final String BUNDLE_ID = "com.racetrac.QA.ams";

    @Override
    public void prepareBrowser() throws IOException {
        LOG.debug("Not needed in iOS");
    }

    @Step
    @Override
    public String getUrl() {
        getSafariBrowserPage().waitUntilIsOpened();
        getSafariBrowserPage().getUrl().click();
        getSafariBrowserPage().refresh();
        getSafariBrowserPage().waitUntilIsOpened();
        return getSafariBrowserPage().getUrl().getAttribute("value");
    }

    @Step
    @Override
    public void returnBackToApp() {
        getDriver().activateApp(BUNDLE_ID);
    }

    @Override
    public String getDesiredRedirectUrlNoSubscription() {
        return FUEL_VIP_REDIRECT_DESIRED_URL_NO_SUBSCRIPTION;
    }

    @Override
    public String getDesiredRedirectUrlActiveSubscription() {
        return IOS_FUEL_VIP_REDIRECT_DESIRED_URL_ACTIVE_SUBSCRIPTION;
    }
}
